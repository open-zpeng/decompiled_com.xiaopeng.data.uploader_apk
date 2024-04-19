package c.a.p.d;

import c.a.i;
/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes.dex */
public final class d<T> implements i<T>, c.a.m.b {

    /* renamed from: b  reason: collision with root package name */
    final i<? super T> f1468b;

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.e<? super c.a.m.b> f1469c;

    /* renamed from: d  reason: collision with root package name */
    final c.a.o.a f1470d;
    c.a.m.b e;

    public d(i<? super T> iVar, c.a.o.e<? super c.a.m.b> eVar, c.a.o.a aVar) {
        this.f1468b = iVar;
        this.f1469c = eVar;
        this.f1470d = aVar;
    }

    @Override // c.a.m.b
    public void dispose() {
        try {
            this.f1470d.run();
        } catch (Throwable th) {
            c.a.n.b.b(th);
            c.a.s.a.m(th);
        }
        this.e.dispose();
    }

    @Override // c.a.i
    public void onComplete() {
        if (this.e != c.a.p.a.c.DISPOSED) {
            this.f1468b.onComplete();
        }
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (this.e != c.a.p.a.c.DISPOSED) {
            this.f1468b.onError(th);
        } else {
            c.a.s.a.m(th);
        }
    }

    @Override // c.a.i
    public void onNext(T t) {
        this.f1468b.onNext(t);
    }

    @Override // c.a.i
    public void onSubscribe(c.a.m.b bVar) {
        try {
            this.f1469c.accept(bVar);
            if (c.a.p.a.c.validate(this.e, bVar)) {
                this.e = bVar;
                this.f1468b.onSubscribe(this);
            }
        } catch (Throwable th) {
            c.a.n.b.b(th);
            bVar.dispose();
            this.e = c.a.p.a.c.DISPOSED;
            c.a.p.a.d.error(th, this.f1468b);
        }
    }
}
