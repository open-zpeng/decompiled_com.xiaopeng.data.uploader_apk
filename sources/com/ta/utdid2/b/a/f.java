package com.ta.utdid2.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
/* compiled from: NetworkUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static ConnectivityManager f1819a;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1820d = {4, 7, 2, 1};

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m57a(Context context) {
        ConnectivityManager a2 = a(context);
        if (a2 != null) {
            try {
                NetworkInfo activeNetworkInfo = a2.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception e) {
                Log.e("NetworkUtils", e.toString());
                return false;
            }
        }
        Log.e("NetworkUtils", "connManager is null!");
        return false;
    }

    public static boolean b(Context context) {
        ConnectivityManager a2 = a(context);
        if (a2 != null) {
            try {
                NetworkInfo activeNetworkInfo = a2.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (d.e) {
                        Log.d("NetworkUtils", "subType:" + subtype + ": name:" + activeNetworkInfo.getSubtypeName());
                    }
                    for (int i : f1820d) {
                        if (i == subtype) {
                            return true;
                        }
                    }
                } else {
                    Log.e("NetworkUtils", "networkInfo is null!");
                }
            } catch (Exception e) {
                Log.e("NetworkUtils", e.toString());
            }
        } else {
            Log.e("NetworkUtils", "connManager is null!");
        }
        return false;
    }

    public static ConnectivityManager a(Context context) {
        if (context == null) {
            Log.e("NetworkUtils", "context is null!");
            return null;
        }
        if (f1819a == null) {
            f1819a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f1819a;
    }
}
