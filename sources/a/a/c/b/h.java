package a.a.c.b;

import a.a.c.a.c.c;
import a.a.c.e.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public class a implements c<b.f> {
        a() {
        }

        @Override // a.a.c.b.h.c
        /* renamed from: c */
        public int a(b.f fVar) {
            return fVar.d();
        }

        @Override // a.a.c.b.h.c
        /* renamed from: d */
        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public class b implements c<c.C0003c> {
        b() {
        }

        @Override // a.a.c.b.h.c
        /* renamed from: c */
        public int a(c.C0003c c0003c) {
            return c0003c.e();
        }

        @Override // a.a.c.b.h.c
        /* renamed from: d */
        public boolean b(c.C0003c c0003c) {
            return c0003c.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    private c.C0003c e(c.b bVar, int i) {
        return (c.C0003c) f(bVar.a(), i, new b());
    }

    private static <T> T f(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0003c e = e(bVar, i);
        if (e == null) {
            return null;
        }
        return a.a.c.b.c.c(context, resources, e.b(), e.a(), i);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(g(fVarArr, i).c());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface c2 = c(context, inputStream);
            i.a(inputStream);
            return c2;
        } catch (IOException unused2) {
            i.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            i.a(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface c(Context context, InputStream inputStream) {
        File e = i.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (i.d(e, inputStream)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File e = i.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (i.c(e, resources, i)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.f g(b.f[] fVarArr, int i) {
        return (b.f) f(fVarArr, i, new a());
    }
}
