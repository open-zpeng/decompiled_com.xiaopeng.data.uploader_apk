package b.c.a.l;

import android.util.Log;
/* compiled from: OkLogger.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1211a = true;

    public static void a(Throwable th) {
        if (!f1211a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void b(String str, String str2) {
        if (f1211a) {
            Log.v(str, str2);
        }
    }
}
