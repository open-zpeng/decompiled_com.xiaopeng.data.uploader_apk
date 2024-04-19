package com.xiaopeng.data.uploader.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
/* compiled from: KeepAliveHelper.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ServiceConnectionC0084b f1895a = new ServiceConnectionC0084b();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1896b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KeepAliveHelper.java */
    /* renamed from: com.xiaopeng.data.uploader.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class ServiceConnectionC0084b implements ServiceConnection {
        private ServiceConnectionC0084b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("DataUploadKL", "Bound to keep alive service.");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("KeepAlive", "Unbound to keep alive service, connect again!");
            b.this.a();
        }
    }

    public b(Context context) {
        this.f1896b = context;
    }

    public void a() {
        Intent intent = new Intent("com.xiaopeng.bughunter.system.KeepAliveService");
        intent.setPackage(this.f1896b.getPackageName());
        intent.setClassName("com.xiaopeng.bughunter", "com.xiaopeng.bughunter.system.KeepAliveService");
        this.f1896b.bindService(intent, this.f1895a, 4);
    }
}
