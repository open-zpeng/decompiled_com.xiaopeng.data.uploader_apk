package com.xiaopeng.lib.framework.locationmodule.provider;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.UserHandle;
import com.xiaopeng.lib.framework.locationmodule.LocationImpl;
import com.xiaopeng.lib.framework.locationmodule.provider.LocationService;
/* loaded from: classes.dex */
public final class ServiceProvider {
    public static final String SERVICE_NAME = LocationService.class.getName();
    private static final String TAG = "ServiceProvider";
    private boolean mBoundService;
    private LocationService.LocationServiceImpl mLocationService;
    private InternalServiceConnection mServiceConnection;

    /* loaded from: classes.dex */
    private static final class Holder {
        private static final ServiceProvider INSTANCE = new ServiceProvider();

        private Holder() {
        }
    }

    /* loaded from: classes.dex */
    private final class InternalServiceConnection implements ServiceConnection {
        private InternalServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServiceProvider.this.mLocationService = (LocationService.LocationServiceImpl) iBinder;
            ServiceProvider.this.mBoundService = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ServiceProvider.this.mLocationService = null;
            ServiceProvider.this.mBoundService = false;
        }
    }

    public static ServiceProvider getInstance() {
        return Holder.INSTANCE;
    }

    public void publishLocation(LocationImpl locationImpl) {
        locationImpl.seal();
        this.mLocationService.publishLocation(locationImpl);
    }

    public void startService(Context context) {
        ComponentName componentName;
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setComponent(new ComponentName(context.getPackageName(), SERVICE_NAME));
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                componentName = context.startForegroundService(intent);
            } else {
                componentName = context.startServiceAsUser(intent, UserHandle.CURRENT_OR_SELF);
            }
        } catch (Exception e) {
            e.printStackTrace();
            componentName = null;
        }
        if (componentName != null) {
            context.bindService(intent, this.mServiceConnection, 1);
            return;
        }
        throw new RuntimeException("Failed to launch " + SERVICE_NAME);
    }

    public boolean started() {
        return this.mBoundService;
    }

    private ServiceProvider() {
        this.mServiceConnection = new InternalServiceConnection();
    }
}
