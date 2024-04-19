package com.xiaopeng.data.uploader;

import android.app.Application;
import com.xiaopeng.lib.utils.info.DeviceInfoUtils;
/* loaded from: classes.dex */
public class App extends Application {

    /* renamed from: b  reason: collision with root package name */
    private static App f1863b;

    /* renamed from: c  reason: collision with root package name */
    private com.xiaopeng.data.uploader.system.a f1864c;

    /* renamed from: d  reason: collision with root package name */
    private com.xiaopeng.data.uploader.b.e.a f1865d;

    private String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DataUploaderApp");
        stringBuffer.append(": \t");
        stringBuffer.append("commitID :");
        stringBuffer.append("956f0098e7b50fe4450e00929b9d79a21f7eaf7b");
        stringBuffer.append("\t");
        stringBuffer.append("RELEASE_TIME :");
        stringBuffer.append("20230725-123502");
        stringBuffer.append("\t");
        stringBuffer.append("CarModel :");
        stringBuffer.append("D55");
        stringBuffer.append("\t");
        stringBuffer.append("isInternaltion:");
        stringBuffer.append(DeviceInfoUtils.isInternationalVer());
        return stringBuffer.toString();
    }

    public static App c() {
        return f1863b;
    }

    public com.xiaopeng.data.uploader.system.a b() {
        return this.f1864c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
        if ("Q8".equals(android.car.Car.getXpCduType()) != false) goto L23;
     */
    @Override // android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate() {
        /*
            r5 = this;
            java.lang.Class<com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry> r0 = com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry.class
            super.onCreate()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "Q1"
            java.lang.String r4 = android.car.Car.getXpCduType()     // Catch: java.lang.Exception -> L21
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L21
            if (r3 != 0) goto L1f
            java.lang.String r3 = "Q8"
            java.lang.String r4 = android.car.Car.getXpCduType()     // Catch: java.lang.Exception -> L21
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L21
            if (r3 == 0) goto L25
        L1f:
            r2 = r1
            goto L25
        L21:
            r3 = move-exception
            r3.printStackTrace()
        L25:
            if (r2 == 0) goto L2f
            com.xiaopeng.data.uploader.c.b r2 = new com.xiaopeng.data.uploader.c.b
            r2.<init>(r5)
            r2.a()
        L2f:
            java.lang.String r2 = r5.a()
            java.lang.String r3 = "DataUploaderApp"
            com.xiaopeng.lib.utils.LogUtils.i(r3, r2)
            com.xiaopeng.data.uploader.App.f1863b = r5
            java.lang.Class<b.d.a.a> r2 = b.d.a.a.class
            b.d.a.a r4 = new b.d.a.a
            r4.<init>(r5)
            com.xiaopeng.lib.framework.module.Module.register(r2, r4)
            com.xiaopeng.lib.http.HttpsUtils.init(r5, r1)     // Catch: java.lang.SecurityException -> L48
            goto L4e
        L48:
            r1 = move-exception
            java.lang.String r2 = "security exception in HttpsUtils.init(), continue"
            com.xiaopeng.lib.utils.LogUtils.w(r3, r2, r1)
        L4e:
            com.activeandroid.ActiveAndroid.initialize(r5)     // Catch: java.lang.Exception -> L52
            goto L57
        L52:
            java.lang.String r1 = "init ActiveAndroid failed"
            com.xiaopeng.lib.utils.LogUtils.d(r3, r1)
        L57:
            com.xiaopeng.data.uploader.system.a r1 = new com.xiaopeng.data.uploader.system.a
            r1.<init>()
            r5.f1864c = r1
            com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry r1 = new com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry
            r1.<init>()
            com.xiaopeng.lib.framework.module.Module.register(r0, r1)
            com.xiaopeng.lib.framework.module.IModuleEntry r0 = com.xiaopeng.lib.framework.module.Module.get(r0)
            java.lang.Class<com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp> r1 = com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp.class
            java.lang.Object r0 = r0.get(r1)
            com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp r0 = (com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp) r0
            com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig r0 = r0.config()
            com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig r0 = r0.applicationContext(r5)
            com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig r0 = r0.enableTrafficStats()
            com.xiaopeng.lib.framework.netchannelmodule.common.TrafficeStaFlagInterceptor r1 = new com.xiaopeng.lib.framework.netchannelmodule.common.TrafficeStaFlagInterceptor
            r1.<init>()
            com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig r0 = r0.addInterceptor(r1)
            r0.apply()
            com.xiaopeng.data.uploader.b.e.b r0 = new com.xiaopeng.data.uploader.b.e.b
            r0.<init>()
            r5.f1865d = r0
            r0.init()
            com.xiaopeng.data.uploader.b.d.a r0 = com.xiaopeng.data.uploader.b.d.a.d()
            r0.e(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.data.uploader.App.onCreate():void");
    }
}
