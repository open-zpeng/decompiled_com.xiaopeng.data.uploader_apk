package a.a.d.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.f;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
/* compiled from: AppCompatResources.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f359a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0016a>> f360b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f361c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatResources.java */
    /* renamed from: a.a.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f362a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f363b;

        C0016a(ColorStateList colorStateList, Configuration configuration) {
            this.f362a = colorStateList;
            this.f363b = configuration;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f361c) {
            WeakHashMap<Context, SparseArray<C0016a>> weakHashMap = f360b;
            SparseArray<C0016a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i, new C0016a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i) {
        C0016a c0016a;
        synchronized (f361c) {
            SparseArray<C0016a> sparseArray = f360b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0016a = sparseArray.get(i)) != null) {
                if (c0016a.f363b.equals(context.getResources().getConfiguration())) {
                    return c0016a.f362a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList b2 = b(context, i);
        if (b2 != null) {
            return b2;
        }
        ColorStateList f = f(context, i);
        if (f != null) {
            a(context, i, f);
            return f;
        }
        return a.a.c.a.a.a(context, i);
    }

    public static Drawable d(Context context, int i) {
        return f.n().p(context, i);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f359a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList f(Context context, int i) {
        if (g(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return a.a.c.a.c.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean g(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue e = e();
        resources.getValue(i, e, true);
        int i2 = e.type;
        return i2 >= 28 && i2 <= 31;
    }
}
