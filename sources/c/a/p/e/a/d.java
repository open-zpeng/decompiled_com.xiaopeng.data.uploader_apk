package c.a.p.e.a;
/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes.dex */
public final class d<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.e<? super T> f1489c;

    /* renamed from: d  reason: collision with root package name */
    final c.a.o.e<? super Throwable> f1490d;
    final c.a.o.a e;
    final c.a.o.a f;

    /* compiled from: ObservableDoOnEach.java */
    /* loaded from: classes.dex */
    static final class a<T> implements c.a.i<T>, c.a.m.b {

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1491b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.o.e<? super T> f1492c;

        /* renamed from: d  reason: collision with root package name */
        final c.a.o.e<? super Throwable> f1493d;
        final c.a.o.a e;
        final c.a.o.a f;
        c.a.m.b g;
        boolean h;

        a(c.a.i<? super T> iVar, c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.a aVar2) {
            this.f1491b = iVar;
            this.f1492c = eVar;
            this.f1493d = eVar2;
            this.e = aVar;
            this.f = aVar2;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.g.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.h) {
                return;
            }
            try {
                this.e.run();
                this.h = true;
                this.f1491b.onComplete();
                try {
                    this.f.run();
                } catch (Throwable th) {
                    c.a.n.b.b(th);
                    c.a.s.a.m(th);
                }
            } catch (Throwable th2) {
                c.a.n.b.b(th2);
                onError(th2);
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.h) {
                c.a.s.a.m(th);
                return;
            }
            this.h = true;
            try {
                this.f1493d.accept(th);
            } catch (Throwable th2) {
                c.a.n.b.b(th2);
                th = new c.a.n.a(th, th2);
            }
            this.f1491b.onError(th);
            try {
                this.f.run();
            } catch (Throwable th3) {
                c.a.n.b.b(th3);
                c.a.s.a.m(th3);
            }
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            try {
                this.f1492c.accept(t);
                this.f1491b.onNext(t);
            } catch (Throwable th) {
                c.a.n.b.b(th);
                this.g.dispose();
                onError(th);
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.g, bVar)) {
                this.g = bVar;
                this.f1491b.onSubscribe(this);
            }
        }
    }

    public d(c.a.h<T> hVar, c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.a aVar2) {
        super(hVar);
        this.f1489c = eVar;
        this.f1490d = eVar2;
        this.e = aVar;
        this.f = aVar2;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        this.f1474b.a(new a(iVar, this.f1489c, this.f1490d, this.e, this.f));
    }
}
