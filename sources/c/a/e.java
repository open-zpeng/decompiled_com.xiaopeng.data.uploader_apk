package c.a;

import c.a.p.e.a.l;
import c.a.p.e.a.m;
import c.a.p.e.a.o;
import c.a.p.e.a.q;
import c.a.p.e.a.r;
import c.a.p.e.a.s;
import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* loaded from: classes.dex */
public abstract class e<T> implements h<T> {
    private e<T> A(long j, TimeUnit timeUnit, h<? extends T> hVar, j jVar) {
        c.a.p.b.b.d(timeUnit, "timeUnit is null");
        c.a.p.b.b.d(jVar, "scheduler is null");
        return c.a.s.a.j(new s(this, j, timeUnit, jVar, hVar));
    }

    public static <T> e<T> B(h<T> hVar) {
        c.a.p.b.b.d(hVar, "source is null");
        if (hVar instanceof e) {
            return c.a.s.a.j((e) hVar);
        }
        return c.a.s.a.j(new c.a.p.e.a.i(hVar));
    }

    public static int b() {
        return c.a();
    }

    public static <T> e<T> c(h<? extends T>... hVarArr) {
        if (hVarArr.length == 0) {
            return i();
        }
        if (hVarArr.length == 1) {
            return B(hVarArr[0]);
        }
        return c.a.s.a.j(new c.a.p.e.a.b(k(hVarArr), c.a.p.b.a.b(), b(), c.a.p.h.c.BOUNDARY));
    }

    public static <T> e<T> d(g<T> gVar) {
        c.a.p.b.b.d(gVar, "source is null");
        return c.a.s.a.j(new c.a.p.e.a.c(gVar));
    }

    private e<T> f(c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.a aVar2) {
        c.a.p.b.b.d(eVar, "onNext is null");
        c.a.p.b.b.d(eVar2, "onError is null");
        c.a.p.b.b.d(aVar, "onComplete is null");
        c.a.p.b.b.d(aVar2, "onAfterTerminate is null");
        return c.a.s.a.j(new c.a.p.e.a.d(this, eVar, eVar2, aVar, aVar2));
    }

    public static <T> e<T> i() {
        return c.a.s.a.j(c.a.p.e.a.f.f1496b);
    }

    public static <T> e<T> k(T... tArr) {
        c.a.p.b.b.d(tArr, "items is null");
        if (tArr.length == 0) {
            return i();
        }
        if (tArr.length == 1) {
            return l(tArr[0]);
        }
        return c.a.s.a.j(new c.a.p.e.a.h(tArr));
    }

    public static <T> e<T> l(T t) {
        c.a.p.b.b.d(t, "The item is null");
        return c.a.s.a.j(new c.a.p.e.a.j(t));
    }

    @Override // c.a.h
    public final void a(i<? super T> iVar) {
        c.a.p.b.b.d(iVar, "observer is null");
        try {
            i<? super T> p = c.a.s.a.p(this, iVar);
            c.a.p.b.b.d(p, "Plugin returned null Observer");
            w(p);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            c.a.n.b.b(th);
            c.a.s.a.m(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final e<T> e(c.a.o.a aVar) {
        return g(c.a.p.b.a.a(), aVar);
    }

    public final e<T> g(c.a.o.e<? super c.a.m.b> eVar, c.a.o.a aVar) {
        c.a.p.b.b.d(eVar, "onSubscribe is null");
        c.a.p.b.b.d(aVar, "onDispose is null");
        return c.a.s.a.j(new c.a.p.e.a.e(this, eVar, aVar));
    }

    public final e<T> h(c.a.o.e<? super T> eVar) {
        c.a.o.e<? super Throwable> a2 = c.a.p.b.a.a();
        c.a.o.a aVar = c.a.p.b.a.f1462c;
        return f(eVar, a2, aVar, aVar);
    }

    public final e<T> j(c.a.o.h<? super T> hVar) {
        c.a.p.b.b.d(hVar, "predicate is null");
        return c.a.s.a.j(new c.a.p.e.a.g(this, hVar));
    }

    public final <R> e<R> m(c.a.o.f<? super T, ? extends R> fVar) {
        c.a.p.b.b.d(fVar, "mapper is null");
        return c.a.s.a.j(new c.a.p.e.a.k(this, fVar));
    }

    public final e<T> n(j jVar) {
        return o(jVar, false, b());
    }

    public final e<T> o(j jVar, boolean z, int i) {
        c.a.p.b.b.d(jVar, "scheduler is null");
        c.a.p.b.b.e(i, "bufferSize");
        return c.a.s.a.j(new l(this, jVar, z, i));
    }

    public final c.a.q.a<T> p() {
        return m.E(this);
    }

    public final e<T> q(long j, c.a.o.h<? super Throwable> hVar) {
        if (j >= 0) {
            c.a.p.b.b.d(hVar, "predicate is null");
            return c.a.s.a.j(new o(this, j, hVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final e<T> r(c.a.o.h<? super Throwable> hVar) {
        return q(Long.MAX_VALUE, hVar);
    }

    public final e<T> s() {
        return p().D();
    }

    public final e<T> t(T t) {
        c.a.p.b.b.d(t, "item is null");
        return c(l(t), this);
    }

    public final c.a.m.b u(c.a.o.e<? super T> eVar) {
        return v(eVar, c.a.p.b.a.f, c.a.p.b.a.f1462c, c.a.p.b.a.a());
    }

    public final c.a.m.b v(c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.e<? super c.a.m.b> eVar3) {
        c.a.p.b.b.d(eVar, "onNext is null");
        c.a.p.b.b.d(eVar2, "onError is null");
        c.a.p.b.b.d(aVar, "onComplete is null");
        c.a.p.b.b.d(eVar3, "onSubscribe is null");
        c.a.p.d.e eVar4 = new c.a.p.d.e(eVar, eVar2, aVar, eVar3);
        a(eVar4);
        return eVar4;
    }

    protected abstract void w(i<? super T> iVar);

    public final e<T> x(j jVar) {
        c.a.p.b.b.d(jVar, "scheduler is null");
        return c.a.s.a.j(new q(this, jVar));
    }

    public final e<T> y(long j) {
        if (j >= 0) {
            return c.a.s.a.j(new r(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final e<T> z(long j, TimeUnit timeUnit) {
        return A(j, timeUnit, null, c.a.t.a.a());
    }
}
