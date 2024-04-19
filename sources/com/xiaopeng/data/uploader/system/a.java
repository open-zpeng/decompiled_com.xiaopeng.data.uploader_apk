package com.xiaopeng.data.uploader.system;

import android.car.Car;
import android.car.hardware.tbox.CarTboxManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.lib.utils.LogUtils;
/* compiled from: CarApiManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private CarTboxManager f1909a;

    /* renamed from: b  reason: collision with root package name */
    private Car f1910b;

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f1911c = new ServiceConnectionC0087a();

    /* compiled from: CarApiManager.java */
    /* renamed from: com.xiaopeng.data.uploader.system.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ServiceConnectionC0087a implements ServiceConnection {
        ServiceConnectionC0087a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a aVar = a.this;
                aVar.f1909a = (CarTboxManager) aVar.f1910b.getCarManager("xp_tbox");
                LogUtils.d("CarApiManager", "onServiceConnected");
            } catch (Exception e) {
                LogUtils.e("CarApiManager", "onServiceConnected error!", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.d("CarApiManager", "onServiceDisconnected");
            a.this.e();
        }
    }

    public a() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Car createCar = Car.createCar(App.c(), this.f1911c);
        this.f1910b = createCar;
        createCar.connect();
    }

    public CarTboxManager d() {
        return this.f1909a;
    }
}
