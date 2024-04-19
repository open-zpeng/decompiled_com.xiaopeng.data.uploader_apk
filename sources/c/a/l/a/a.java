package c.a.l.a;

import c.a.j;
import c.a.n.b;
import c.a.o.f;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f<Callable<j>, j> f1441a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile f<j, j> f1442b;

    static <T, R> R a(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static j b(f<Callable<j>, j> fVar, Callable<j> callable) {
        j jVar = (j) a(fVar, callable);
        Objects.requireNonNull(jVar, "Scheduler Callable returned null");
        return jVar;
    }

    static j c(Callable<j> callable) {
        try {
            j call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static j d(Callable<j> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        f<Callable<j>, j> fVar = f1441a;
        if (fVar == null) {
            return c(callable);
        }
        return b(fVar, callable);
    }

    public static j e(j jVar) {
        Objects.requireNonNull(jVar, "scheduler == null");
        f<j, j> fVar = f1442b;
        return fVar == null ? jVar : (j) a(fVar, jVar);
    }
}
