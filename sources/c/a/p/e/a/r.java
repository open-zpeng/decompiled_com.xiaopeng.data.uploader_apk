package c.a.p.e.a;
/* compiled from: ObservableTake.java */
/* loaded from: classes.dex */
public final class r<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f1539c;

    /* compiled from: ObservableTake.java */
    /* loaded from: classes.dex */
    static final class a<T> implements c.a.i<T>, c.a.m.b {

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1540b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1541c;

        /* renamed from: d  reason: collision with root package name */
        c.a.m.b f1542d;
        long e;

        a(c.a.i<? super T> iVar, long j) {
            this.f1540b = iVar;
            this.e = j;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1542d.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.f1541c) {
                return;
            }
            this.f1541c = true;
            this.f1542d.dispose();
            this.f1540b.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.f1541c) {
                c.a.s.a.m(th);
                return;
            }
            this.f1541c = true;
            this.f1542d.dispose();
            this.f1540b.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.f1541c) {
                return;
            }
            long j = this.e;
            long j2 = j - 1;
            this.e = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.f1540b.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.f1542d, bVar)) {
                this.f1542d = bVar;
                if (this.e == 0) {
                    this.f1541c = true;
                    bVar.dispose();
                    c.a.p.a.d.complete(this.f1540b);
                    return;
                }
                this.f1540b.onSubscribe(this);
            }
        }
    }

    public r(c.a.h<T> hVar, long j) {
        super(hVar);
        this.f1539c = j;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        this.f1474b.a(new a(iVar, this.f1539c));
    }
}
