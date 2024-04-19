package com.xiaopeng.data.uploader.b.e;

import android.car.hardware.tbox.CarTboxManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.GsonBuilder;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.data.uploader.model.DriveModel;
import com.xiaopeng.lib.framework.locationmodule.LocationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer;
import com.xiaopeng.lib.utils.LogUtils;
/* compiled from: TboxMessageChannelImpl.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private GsonBuilder f1891a;

    /* renamed from: b  reason: collision with root package name */
    private com.xiaopeng.data.uploader.d.a f1892b;

    /* renamed from: c  reason: collision with root package name */
    private int f1893c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1894d = 0;
    private long e = 0;
    private int f = 60;

    private void f(String str) {
        if (System.currentTimeMillis() - this.e > this.f * IError.ERR_SERVICE_DISCONNECTED) {
            Log.i("TboxMessageChannelImpl", "sendLocationInfo to Tbox:\t" + str);
            this.e = System.currentTimeMillis();
        }
    }

    @Override // com.xiaopeng.data.uploader.b.e.a
    public void a(String str) {
        if (this.f1894d == 0) {
            Log.i("TboxMessageChannelImpl", "sendDriveDrInfoToTbox" + str);
        }
        if (this.f1894d >= 20) {
            this.f1894d = 0;
        }
        this.f1894d++;
        if (TextUtils.isEmpty(str)) {
            if (this.f1893c == 0) {
                Log.i("TboxMessageChannelImpl", "drive model data is empty ");
            }
            if (this.f1893c >= 10) {
                this.f1893c = 0;
            }
            this.f1893c++;
            return;
        }
        try {
            CarTboxManager d2 = App.c().b().d();
            if (d2 != null) {
                f(str);
                d2.sendLocationInfo(str);
            } else {
                Log.i("TboxMessageChannelImpl", "manager is null");
            }
        } catch (Exception e) {
            LogUtils.w("TboxMessageChannelImpl", "call sendLocationInfo error! driveJson value:\t" + str);
            LogUtils.e("TboxMessageChannelImpl", "CarTBoxManager: sendLocationInfo error! Exception: " + e.getMessage());
        }
    }

    @Override // com.xiaopeng.data.uploader.b.e.a
    public String b() {
        DriveModel c2 = c();
        return c2 != null ? e().create().toJson(c2) : "";
    }

    public DriveModel c() {
        ILocation d2 = d();
        DriveModel driveModel = null;
        if (d2 == null) {
            return null;
        }
        try {
            DriveModel driveModel2 = new DriveModel();
            try {
                driveModel2.speed = d2.speed();
                driveModel2.coordType = 2;
                driveModel2.angle = d2.angle();
                driveModel2.coorValid = 1;
                driveModel2.longitude = d2.longitude();
                driveModel2.latitude = d2.latitude();
                return driveModel2;
            } catch (Exception e) {
                e = e;
                driveModel = driveModel2;
                e.printStackTrace();
                return driveModel;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public ILocation d() {
        try {
            return ((ILocationConsumer) Module.get(LocationModuleEntry.class).get(ILocationConsumer.class)).getLocation();
        } catch (Exception e) {
            LogUtils.e("TboxMessageChannelImpl", "Failed to get location, exception:" + e);
            e.printStackTrace();
            return null;
        }
    }

    public GsonBuilder e() {
        if (this.f1891a == null) {
            this.f1891a = new GsonBuilder();
        }
        return this.f1891a;
    }

    @Override // com.xiaopeng.data.uploader.b.e.a
    public void init() {
        Log.i("TboxMessageChannelImpl", "init");
        com.xiaopeng.data.uploader.d.a aVar = new com.xiaopeng.data.uploader.d.a();
        this.f1892b = aVar;
        aVar.b(this);
        this.f1892b.a();
    }
}
