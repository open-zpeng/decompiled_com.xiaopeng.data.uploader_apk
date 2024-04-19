package c.a.p.e.a;
/* compiled from: ObservableMap.java */
/* loaded from: classes.dex */
public final class k<T, U> extends c.a.p.e.a.a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.f<? super T, ? extends U> f1504c;

    /* compiled from: ObservableMap.java */
    /* loaded from: classes.dex */
    static final class a<T, U> extends c.a.p.d.a<T, U> {
        final c.a.o.f<? super T, ? extends U> g;

        a(c.a.i<? super U> iVar, c.a.o.f<? super T, ? extends U> fVar) {
            super(iVar);
            this.g = fVar;
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.e) {
                return;
            }
            if (this.f != 0) {
                this.f1465b.onNext(null);
                return;
            }
            try {
                this.f1465b.onNext(c.a.p.b.b.d(this.g.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // c.a.p.c.c
        public U poll() throws Exception {
            T poll = this.f1467d.poll();
            if (poll != null) {
                return (U) c.a.p.b.b.d(this.g.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public k(c.a.h<T> hVar, c.a.o.f<? super T, ? extends U> fVar) {
        super(hVar);
        this.f1504c = fVar;
    }

    @Override // c.a.e
    public void w(c.a.i<? super U> iVar) {
        this.f1474b.a(new a(iVar, this.f1504c));
    }
}
