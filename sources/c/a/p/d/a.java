package c.a.p.d;

import c.a.i;
/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes.dex */
public abstract class a<T, R> implements i<T>, c.a.p.c.a<R> {

    /* renamed from: b  reason: collision with root package name */
    protected final i<? super R> f1465b;

    /* renamed from: c  reason: collision with root package name */
    protected c.a.m.b f1466c;

    /* renamed from: d  reason: collision with root package name */
    protected c.a.p.c.a<T> f1467d;
    protected boolean e;
    protected int f;

    public a(i<? super R> iVar) {
        this.f1465b = iVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th) {
        c.a.n.b.b(th);
        this.f1466c.dispose();
        onError(th);
    }

    @Override // c.a.p.c.c
    public void clear() {
        this.f1467d.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i) {
        c.a.p.c.a<T> aVar = this.f1467d;
        if (aVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = aVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f = requestFusion;
        }
        return requestFusion;
    }

    @Override // c.a.m.b
    public void dispose() {
        this.f1466c.dispose();
    }

    @Override // c.a.p.c.c
    public boolean isEmpty() {
        return this.f1467d.isEmpty();
    }

    @Override // c.a.p.c.c
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // c.a.i
    public void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f1465b.onComplete();
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (this.e) {
            c.a.s.a.m(th);
            return;
        }
        this.e = true;
        this.f1465b.onError(th);
    }

    @Override // c.a.i
    public final void onSubscribe(c.a.m.b bVar) {
        if (c.a.p.a.c.validate(this.f1466c, bVar)) {
            this.f1466c = bVar;
            if (bVar instanceof c.a.p.c.a) {
                this.f1467d = (c.a.p.c.a) bVar;
            }
            if (b()) {
                this.f1465b.onSubscribe(this);
                a();
            }
        }
    }
}
