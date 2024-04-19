package c.a.p.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableCreate.java */
/* loaded from: classes.dex */
public final class c<T> extends c.a.e<T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.g<T> f1487b;

    /* compiled from: ObservableCreate.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<c.a.m.b> implements c.a.f<T>, c.a.m.b {
        private static final long serialVersionUID = -3434801548987643227L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1488b;

        a(c.a.i<? super T> iVar) {
            this.f1488b = iVar;
        }

        @Override // c.a.f
        public void a(c.a.o.d dVar) {
            c(new c.a.p.a.a(dVar));
        }

        @Override // c.a.f
        public boolean b() {
            return c.a.p.a.c.isDisposed(get());
        }

        public void c(c.a.m.b bVar) {
            c.a.p.a.c.set(this, bVar);
        }

        public boolean d(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (b()) {
                return false;
            }
            try {
                this.f1488b.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            c.a.p.a.c.dispose(this);
        }

        @Override // c.a.b
        public void onError(Throwable th) {
            if (d(th)) {
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.b
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (b()) {
            } else {
                this.f1488b.onNext(t);
            }
        }
    }

    public c(c.a.g<T> gVar) {
        this.f1487b = gVar;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.onSubscribe(aVar);
        try {
            this.f1487b.subscribe(aVar);
        } catch (Throwable th) {
            c.a.n.b.b(th);
            aVar.onError(th);
        }
    }
}
