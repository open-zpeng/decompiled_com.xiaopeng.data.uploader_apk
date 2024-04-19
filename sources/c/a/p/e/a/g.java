package c.a.p.e.a;
/* compiled from: ObservableFilter.java */
/* loaded from: classes.dex */
public final class g<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.h<? super T> f1497c;

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes.dex */
    static final class a<T> extends c.a.p.d.a<T, T> {
        final c.a.o.h<? super T> g;

        a(c.a.i<? super T> iVar, c.a.o.h<? super T> hVar) {
            super(iVar);
            this.g = hVar;
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.f == 0) {
                try {
                    if (this.g.test(t)) {
                        this.f1465b.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.f1465b.onNext(null);
        }

        @Override // c.a.p.c.c
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f1467d.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.g.test(poll));
            return poll;
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public g(c.a.h<T> hVar, c.a.o.h<? super T> hVar2) {
        super(hVar);
        this.f1497c = hVar2;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        this.f1474b.a(new a(iVar, this.f1497c));
    }
}
