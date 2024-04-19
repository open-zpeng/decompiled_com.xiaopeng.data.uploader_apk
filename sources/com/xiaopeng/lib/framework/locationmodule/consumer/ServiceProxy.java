package com.xiaopeng.lib.framework.locationmodule.consumer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import com.xiaopeng.lib.framework.locationmodule.ILocationServiceCallback;
import com.xiaopeng.lib.framework.locationmodule.ILocationServiceInterface;
import com.xiaopeng.lib.framework.locationmodule.LocationImpl;
import com.xiaopeng.lib.framework.locationmodule.LocationServiceException;
import com.xiaopeng.lib.framework.locationmodule.common.ConstDef;
import com.xiaopeng.lib.framework.locationmodule.common.Debug;
import com.xiaopeng.lib.framework.locationmodule.provider.ServiceProvider;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.IStateEvent;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes.dex */
public class ServiceProxy {
    private static final int DELAY_TO_BIND_SERVICE = 5000;
    private static final int DELAY_TO_POST_LAST_LOCATION = 3000;
    private static final String REMOTE_APP_PACKAGE = "com.xiaopeng.montecarlo";
    private static final String TAG = "LocationModule.Consumer.ServiceProxy";
    private final String mAssignedRemotePackageName;
    private Context mContext;
    private ILocation mCurrentDrLocation;
    private final Persistence mPersistence;
    private final Runnable mPostLastLocationTask;
    private ILocationServiceInterface mRemoteLocationService;
    private volatile boolean mBoundService = false;
    private InternalServiceConnection mServiceConnection = new InternalServiceConnection();
    private ILocationServiceCallback mCallback = new ILocationServiceCallback.Stub() { // from class: com.xiaopeng.lib.framework.locationmodule.consumer.ServiceProxy.1
        @Override // com.xiaopeng.lib.framework.locationmodule.ILocationServiceCallback
        public void locationChanged(LocationImpl locationImpl) {
            EventBus.getDefault().post(new LocationChangedEvent().location(locationImpl));
            ServiceProxy.this.updateCurrentLocation(locationImpl);
            ServiceProxy.this.mPersistence.updateLastTime();
            ServiceProxy.this.mPersistence.write(locationImpl);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class InternalServiceConnection implements ServiceConnection {
        private InternalServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServiceProxy.this.mRemoteLocationService = ILocationServiceInterface.Stub.asInterface(iBinder);
            ServiceProxy.this.mBoundService = true;
            EventBus.getDefault().post(new ServiceStateEvent().type(IStateEvent.TYPE.BOUND));
            ServiceProxy.this.clearPostingTask();
            LogUtils.d(ServiceProxy.TAG, "Location service was connected! Last location update time: " + ServiceProxy.this.mPersistence.getLastUpdateTime());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ServiceProxy.this.mRemoteLocationService = null;
            ServiceProxy.this.mBoundService = false;
            EventBus.getDefault().post(new ServiceStateEvent().type(IStateEvent.TYPE.UNBOUND));
            ServiceProxy.this.checkAndStartBindingWithDelay(5000);
            LogUtils.d(ServiceProxy.TAG, "Location service was disconnected!");
        }
    }

    public ServiceProxy(Context context, String str) {
        this.mContext = context;
        this.mAssignedRemotePackageName = str == null ? REMOTE_APP_PACKAGE : str;
        Persistence persistence = new Persistence(context);
        this.mPersistence = persistence;
        updateCurrentLocation(persistence.read());
        Runnable runnable = new Runnable() { // from class: com.xiaopeng.lib.framework.locationmodule.consumer.ServiceProxy.2
            @Override // java.lang.Runnable
            public void run() {
                if (ServiceProxy.this.mCurrentDrLocation != null) {
                    EventBus.getDefault().post(new LocationChangedEvent().location(ServiceProxy.this.mCurrentDrLocation));
                }
            }
        };
        this.mPostLastLocationTask = runnable;
        ThreadUtils.postDelayed(0, runnable, 3000L);
        startBindingTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindToLocationServiceInternal() {
        Debug.assertion(!this.mBoundService);
        if (this.mBoundService) {
            return;
        }
        LogUtils.d(TAG, "Try to bind location service.");
        String str = ServiceProvider.SERVICE_NAME;
        Intent intent = new Intent(str);
        intent.setPackage(this.mAssignedRemotePackageName);
        intent.putExtra(ConstDef.KEY_CLIENT_PKG, this.mContext.getPackageName());
        intent.putExtra(ConstDef.KEY_CLIENT_PID, Process.myPid());
        intent.setClassName(this.mAssignedRemotePackageName, str);
        boolean z = false;
        try {
            z = this.mContext.bindServiceAsUser(intent, this.mServiceConnection, 1073741824, UserHandle.CURRENT_OR_SELF);
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkAndStartBindingWithDelay(z ? 20000 : 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndStartBindingWithDelay(int i) {
        if (this.mBoundService) {
            return;
        }
        LogUtils.d(TAG, "Try to bind location service...");
        ThreadUtils.postDelayed(0, new Runnable() { // from class: com.xiaopeng.lib.framework.locationmodule.consumer.ServiceProxy.3
            @Override // java.lang.Runnable
            public void run() {
                ServiceProxy.this.bindToLocationServiceInternal();
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPostingTask() {
        ThreadUtils.removeRunnable(this.mPostLastLocationTask);
    }

    private void startBindingTask() {
        if (this.mBoundService) {
            return;
        }
        bindToLocationServiceInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentLocation(ILocation iLocation) {
        if (iLocation == null || ILocation.Category.DR_LOCATION != iLocation.category()) {
            return;
        }
        this.mCurrentDrLocation = iLocation;
    }

    public void bindToLocationService() {
        startBindingTask();
    }

    public boolean connected() {
        return this.mBoundService;
    }

    public ILocation getLastDrLocation() {
        return this.mCurrentDrLocation;
    }

    public void subscribe(ILocation.Category category) throws ILocationServiceException {
        if (this.mBoundService) {
            try {
                this.mRemoteLocationService.subscribe(this.mCallback, category.ordinal());
                LogUtils.d(TAG, "client [" + this.mContext.getPackageName() + " ] subscribe location type: " + category.ordinal());
                return;
            } catch (RemoteException e) {
                e.printStackTrace();
                throw new LocationServiceException(6);
            }
        }
        throw new LocationServiceException(4);
    }

    public void unsubscribe() throws ILocationServiceException {
        if (this.mBoundService) {
            try {
                this.mRemoteLocationService.unsubscribe(this.mCallback);
                LogUtils.d(TAG, "client [ " + this.mContext.getPackageName() + " ] unsubscribe location");
                return;
            } catch (RemoteException e) {
                e.printStackTrace();
                return;
            }
        }
        throw new LocationServiceException(4);
    }
}
