package a.a.c.b;

import a.a.c.a.c.c;
import a.a.c.a.c.f;
import a.a.c.e.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final h f211a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.a.c.g.d<String, Typeface> f212b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            f211a = new g();
        } else if (i >= 26) {
            f211a = new f();
        } else if (i >= 24 && e.j()) {
            f211a = new e();
        } else if (i >= 21) {
            f211a = new d();
        } else {
            f211a = new h();
        }
        f212b = new a.a.c.g.d<>(16);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        return f211a.b(context, cancellationSignal, fVarArr, i);
    }

    public static Typeface b(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            a2 = a.a.c.e.b.g(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = f211a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.b(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            f212b.e(d(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface c(Context context, Resources resources, int i, String str, int i2) {
        Typeface d2 = f211a.d(context, resources, i, str, i2);
        if (d2 != null) {
            f212b.e(d(resources, i, i2), d2);
        }
        return d2;
    }

    private static String d(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface e(Resources resources, int i, int i2) {
        return f212b.d(d(resources, i, i2));
    }
}
