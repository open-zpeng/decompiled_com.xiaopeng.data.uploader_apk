package com.xiaopeng.lib.framework.locationmodule.provider;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.locationmodule.ILocationServiceCallback;
import com.xiaopeng.lib.framework.locationmodule.ILocationServiceInterface;
import com.xiaopeng.lib.framework.locationmodule.LocationImpl;
import com.xiaopeng.lib.framework.locationmodule.R;
import com.xiaopeng.lib.framework.locationmodule.common.ConstDef;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public final class LocationService extends Service {
    private static final int INTERVAL_MS_OF_MAKE_UPDATE_LOG = 60000;
    private static final int INTERVAL_MS_OF_OUTPUT_UPDATE_LOG = 120000;
    private static final String TAG = "LocationService";
    private static volatile long sLastMakeLogTime = -1;
    private static volatile long sLastTimeOutputUpdateLog = -1;
    private boolean mHasCreateNtf = false;
    private static ArrayList<String> sUpdateLogList = new ArrayList<>();
    private static CallbackList sCallbacks = new CallbackList();

    /* loaded from: classes.dex */
    public static class LocationServiceImpl extends ILocationServiceInterface.Stub {
        public void publishLocation(LocationImpl locationImpl) {
            LocationService.sCallbacks.publishLocation(locationImpl);
            LocationService.checkAndOutputUpdateLog();
        }

        @Override // com.xiaopeng.lib.framework.locationmodule.ILocationServiceInterface
        public void subscribe(ILocationServiceCallback iLocationServiceCallback, int i) {
            LocationService.sCallbacks.register(Binder.getCallingPid(), iLocationServiceCallback, i);
        }

        @Override // com.xiaopeng.lib.framework.locationmodule.ILocationServiceInterface
        public void unsubscribe(ILocationServiceCallback iLocationServiceCallback) {
            LocationService.sCallbacks.unregister(Binder.getCallingPid(), iLocationServiceCallback);
        }
    }

    /* loaded from: classes.dex */
    private static final class ServiceImplHolder {
        private static final LocationServiceImpl INSTANCE = new LocationServiceImpl();

        private ServiceImplHolder() {
        }
    }

    private static void checkAndMakeUpdateLog(final long j) {
        if (j - sLastMakeLogTime < 60000) {
            return;
        }
        sLastMakeLogTime = j;
        ThreadUtils.postBackground(new Runnable() { // from class: com.xiaopeng.lib.framework.locationmodule.provider.LocationService.1
            @Override // java.lang.Runnable
            public void run() {
                String makeLocationUpdateLog = LocationService.makeLocationUpdateLog(j, "location history");
                synchronized (LocationService.sUpdateLogList) {
                    LocationService.sUpdateLogList.add(makeLocationUpdateLog);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkAndOutputUpdateLog() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (sLastTimeOutputUpdateLog == -1) {
            sLastTimeOutputUpdateLog = currentTimeMillis;
        }
        if (currentTimeMillis - sLastTimeOutputUpdateLog < 120000) {
            checkAndMakeUpdateLog(currentTimeMillis);
            return;
        }
        sLastMakeLogTime = currentTimeMillis;
        sLastTimeOutputUpdateLog = currentTimeMillis;
        ThreadUtils.postBackground(new Runnable() { // from class: com.xiaopeng.lib.framework.locationmodule.provider.LocationService.2
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                synchronized (LocationService.sUpdateLogList) {
                    if (LocationService.sUpdateLogList.size() > 0) {
                        sb.append("<<<< logs of location updated in past time:\n");
                    }
                    Iterator it = LocationService.sUpdateLogList.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append("\n");
                    }
                    LocationService.sUpdateLogList.clear();
                }
                LogUtils.i(LocationService.TAG, sb.toString());
                LogUtils.i(LocationService.TAG, LocationService.makeLocationUpdateLog(currentTimeMillis, "location last"));
            }
        });
    }

    private void createNotificationIfNeed() {
        if (Build.VERSION.SDK_INT < 26 || this.mHasCreateNtf) {
            return;
        }
        createNotificationOnForeground();
    }

    private void createNotificationOnForeground() {
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("xp_location_service", "Xmart Location Service", 3));
        startForeground(1, new Notification.Builder(this, "xp_location_service").setContentTitle("Xmart Location Service").setContentText("Location Service is running").setCategory("service").setSmallIcon(R.mipmap.location_service_ntf_icon).build());
        this.mHasCreateNtf = true;
    }

    private String getClientPackageName(Intent intent) {
        String stringExtra = intent.getStringExtra(ConstDef.KEY_CLIENT_PKG);
        if (TextUtils.isEmpty(stringExtra)) {
            String str = intent.getPackage();
            return str == null ? BuildInfoUtils.UNKNOWN : str;
        }
        return stringExtra;
    }

    private int getClientPid(Intent intent) {
        return intent.getIntExtra(ConstDef.KEY_CLIENT_PID, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String makeLocationUpdateLog(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" update time: ");
        sb.append(j);
        sb.append("  subscribed clients (pid/pkg): [ ");
        for (Map.Entry<Integer, IBinder> entry : sCallbacks.getSubscribedClientMap().entrySet()) {
            Integer key = entry.getKey();
            sb.append(key);
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            sb.append(sCallbacks.findBindingClientPkgName(key));
            sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    private void onClientBind(Intent intent, String str) {
        String clientPackageName = getClientPackageName(intent);
        int clientPid = getClientPid(intent);
        if (!TextUtils.isEmpty(clientPackageName) && !clientPackageName.equals(getPackageName())) {
            sCallbacks.onBind(clientPid, clientPackageName);
        }
        LogUtils.d(TAG, "LocationService is " + str + " --> " + clientPackageName);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        onClientBind(intent, "onBind");
        return ServiceImplHolder.INSTANCE;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.d(TAG, "LocationService is creating...");
        createNotificationIfNeed();
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtils.d(TAG, "LocationService is onDestroy...");
        sCallbacks.clearSubscribedCallback();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        onClientBind(intent, "onRebind");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        LogUtils.d(TAG, "LocationService is onStartCommand...");
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        String clientPackageName = getClientPackageName(intent);
        sCallbacks.onUnbind(clientPackageName);
        LogUtils.d(TAG, "LocationService is onUnbind --> " + clientPackageName);
        return super.onUnbind(intent);
    }
}
