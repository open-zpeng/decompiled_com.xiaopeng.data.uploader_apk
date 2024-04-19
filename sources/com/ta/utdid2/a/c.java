package com.ta.utdid2.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.ta.utdid2.b.a.d;
import com.ta.utdid2.b.a.h;
import com.ta.utdid2.b.a.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: AidStorageController.java */
/* loaded from: classes.dex */
public class c {
    private static final String TAG = "com.ta.utdid2.a.c";

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f1804a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Long> f1805b = new ConcurrentHashMap();

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return;
        }
        String c2 = c(str, str3);
        long currentTimeMillis = System.currentTimeMillis();
        f1804a.put(c2, str2);
        f1805b.put(c2, Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0);
        if (Build.VERSION.SDK_INT >= 9) {
            h.a(sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(c2), str2));
            h.a(sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(c2), currentTimeMillis));
            return;
        }
        sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(c2), str2).commit();
        sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(c2), currentTimeMillis).commit();
    }

    private static String c(String str, String str2) {
        String encodeToString;
        if (Build.VERSION.SDK_INT >= 8) {
            encodeToString = com.ta.utdid2.b.a.c.encodeToString(str.concat(str2).getBytes(), 2);
        } else {
            encodeToString = com.ta.utdid2.b.a.b.encodeToString(str.concat(str2).getBytes(), 2);
        }
        if (d.e) {
            String str3 = TAG;
            Log.d(str3, "encodedName:" + encodeToString);
        }
        return encodeToString;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m55a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return "";
        }
        String c2 = c(str, str2);
        String str3 = f1804a.get(c2);
        if (d.e) {
            String str4 = TAG;
            Log.d(str4, "cache AID:" + str3);
        }
        if (i.m58a(str3)) {
            String string = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getString("EvQwnbilKezpOJey".concat(c2), "");
            f1804a.put(c2, string);
            return string;
        }
        return str3;
    }

    public static long a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return 0L;
        }
        String c2 = c(str, str2);
        Long valueOf = Long.valueOf(f1805b.containsKey(c2) ? f1805b.get(c2).longValue() : 0L);
        if (d.e) {
            String str3 = TAG;
            Log.d(str3, "cache AIDGenTime:" + valueOf);
        }
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getLong("rKrMJgyAEbVtSQGi".concat(c2), 0L));
            f1805b.put(c2, valueOf);
        }
        return valueOf.longValue();
    }
}
