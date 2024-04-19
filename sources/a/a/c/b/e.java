package a.a.c.b;

import a.a.c.a.c.c;
import a.a.c.e.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f213a;

    /* renamed from: b  reason: collision with root package name */
    private static final Constructor f214b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f215c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f216d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f214b = constructor;
        f213a = cls;
        f215c = method2;
        f216d = method;
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f215c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(f213a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f216d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean j() {
        Method method = f215c;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return f214b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // a.a.c.b.h
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0003c[] a2;
        Object k = k();
        for (c.C0003c c0003c : bVar.a()) {
            ByteBuffer b2 = i.b(context, resources, c0003c.b());
            if (b2 == null || !h(k, b2, c0003c.c(), c0003c.e(), c0003c.f())) {
                return null;
            }
        }
        return i(k);
    }

    @Override // a.a.c.b.h
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        Object k = k();
        a.a.c.g.h hVar = new a.a.c.g.h();
        for (b.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) hVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = i.f(context, cancellationSignal, c2);
                hVar.put(c2, byteBuffer);
            }
            if (!h(k, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        return Typeface.create(i(k), i);
    }
}
