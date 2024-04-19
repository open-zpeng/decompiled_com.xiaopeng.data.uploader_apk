package c.a.s;

import c.a.i;
import c.a.j;
import c.a.n.c;
import c.a.o.b;
import c.a.o.e;
import c.a.o.f;
import c.a.p.h.d;
import java.util.concurrent.Callable;
/* compiled from: RxJavaPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile e<? super Throwable> f1629a;

    /* renamed from: b  reason: collision with root package name */
    static volatile f<? super Runnable, ? extends Runnable> f1630b;

    /* renamed from: c  reason: collision with root package name */
    static volatile f<? super Callable<j>, ? extends j> f1631c;

    /* renamed from: d  reason: collision with root package name */
    static volatile f<? super Callable<j>, ? extends j> f1632d;
    static volatile f<? super Callable<j>, ? extends j> e;
    static volatile f<? super Callable<j>, ? extends j> f;
    static volatile f<? super j, ? extends j> g;
    static volatile f<? super j, ? extends j> h;
    static volatile f<? super c.a.e, ? extends c.a.e> i;
    static volatile f<? super c.a.q.a, ? extends c.a.q.a> j;
    static volatile b<? super c.a.e, ? super i, ? extends i> k;

    static <T, U, R> R a(b<T, U, R> bVar, T t, U u) {
        try {
            return bVar.a(t, u);
        } catch (Throwable th) {
            throw d.c(th);
        }
    }

    static <T, R> R b(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            throw d.c(th);
        }
    }

    static j c(f<? super Callable<j>, ? extends j> fVar, Callable<j> callable) {
        return (j) c.a.p.b.b.d(b(fVar, callable), "Scheduler Callable result can't be null");
    }

    static j d(Callable<j> callable) {
        try {
            return (j) c.a.p.b.b.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw d.c(th);
        }
    }

    public static j e(Callable<j> callable) {
        c.a.p.b.b.d(callable, "Scheduler Callable can't be null");
        f<? super Callable<j>, ? extends j> fVar = f1631c;
        if (fVar == null) {
            return d(callable);
        }
        return c(fVar, callable);
    }

    public static j f(Callable<j> callable) {
        c.a.p.b.b.d(callable, "Scheduler Callable can't be null");
        f<? super Callable<j>, ? extends j> fVar = e;
        if (fVar == null) {
            return d(callable);
        }
        return c(fVar, callable);
    }

    public static j g(Callable<j> callable) {
        c.a.p.b.b.d(callable, "Scheduler Callable can't be null");
        f<? super Callable<j>, ? extends j> fVar = f;
        if (fVar == null) {
            return d(callable);
        }
        return c(fVar, callable);
    }

    public static j h(Callable<j> callable) {
        c.a.p.b.b.d(callable, "Scheduler Callable can't be null");
        f<? super Callable<j>, ? extends j> fVar = f1632d;
        if (fVar == null) {
            return d(callable);
        }
        return c(fVar, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof c.a.n.a);
    }

    public static <T> c.a.e<T> j(c.a.e<T> eVar) {
        f<? super c.a.e, ? extends c.a.e> fVar = i;
        return fVar != null ? (c.a.e) b(fVar, eVar) : eVar;
    }

    public static <T> c.a.q.a<T> k(c.a.q.a<T> aVar) {
        f<? super c.a.q.a, ? extends c.a.q.a> fVar = j;
        return fVar != null ? (c.a.q.a) b(fVar, aVar) : aVar;
    }

    public static j l(j jVar) {
        f<? super j, ? extends j> fVar = g;
        return fVar == null ? jVar : (j) b(fVar, jVar);
    }

    public static void m(Throwable th) {
        e<? super Throwable> eVar = f1629a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new c.a.n.e(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                q(th2);
            }
        }
        th.printStackTrace();
        q(th);
    }

    public static j n(j jVar) {
        f<? super j, ? extends j> fVar = h;
        return fVar == null ? jVar : (j) b(fVar, jVar);
    }

    public static Runnable o(Runnable runnable) {
        c.a.p.b.b.d(runnable, "run is null");
        f<? super Runnable, ? extends Runnable> fVar = f1630b;
        return fVar == null ? runnable : (Runnable) b(fVar, runnable);
    }

    public static <T> i<? super T> p(c.a.e<T> eVar, i<? super T> iVar) {
        b<? super c.a.e, ? super i, ? extends i> bVar = k;
        return bVar != null ? (i) a(bVar, eVar, iVar) : iVar;
    }

    static void q(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
