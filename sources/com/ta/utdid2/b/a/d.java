package com.ta.utdid2.b.a;

import java.lang.reflect.Method;
/* compiled from: DebugUtils.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f1817a;

    /* renamed from: a  reason: collision with other field name */
    private static Method f111a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1818b;
    public static boolean e;

    static {
        e = getInt("alidebug", 0) == 1;
        f1817a = null;
        f111a = null;
        f1818b = null;
    }

    private static void a() {
        try {
            if (f1817a == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f1817a = cls;
                f111a = cls.getDeclaredMethod("get", String.class);
                f1818b = f1817a.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int getInt(String str, int i) {
        a();
        try {
            return ((Integer) f1818b.invoke(f1817a, str, Integer.valueOf(i))).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }
}
