package c.a.p.e.a;

import c.a.p.e.a.p;
import java.util.concurrent.Callable;
/* compiled from: ObservableJust.java */
/* loaded from: classes.dex */
public final class j<T> extends c.a.e<T> implements Callable {

    /* renamed from: b  reason: collision with root package name */
    private final T f1503b;

    public j(T t) {
        this.f1503b = t;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.f1503b;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        p.a aVar = new p.a(iVar, this.f1503b);
        iVar.onSubscribe(aVar);
        aVar.run();
    }
}
