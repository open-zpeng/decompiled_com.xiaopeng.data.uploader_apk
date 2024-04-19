package b.b.a.a;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: AppMonitorService.java */
/* loaded from: classes.dex */
public class c extends Service {

    /* renamed from: b  reason: collision with root package name */
    d f916b = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f916b == null) {
            this.f916b = new e(getApplication());
        }
        return (IBinder) this.f916b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        d dVar = this.f916b;
        if (dVar != null) {
            try {
                dVar.G();
            } catch (RemoteException unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        d dVar = this.f916b;
        if (dVar != null) {
            try {
                dVar.G();
            } catch (RemoteException unused) {
            }
        }
        super.onLowMemory();
    }
}
