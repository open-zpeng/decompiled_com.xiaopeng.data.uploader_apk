package com.xiaopeng.data.uploader.c;

import android.car.Car;
import android.util.Log;
/* compiled from: DeviceHelper.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a() {
        boolean z = true;
        try {
            z = true ^ Car.getVersionInCountryCode().contains("ZH");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("netChannel", "isInternationVersion :\t" + z);
        return z;
    }
}
