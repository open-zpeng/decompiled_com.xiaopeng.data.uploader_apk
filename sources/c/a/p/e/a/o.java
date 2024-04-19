package c.a.p.e.a;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes.dex */
public final class o<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.h<? super Throwable> f1527c;

    /* renamed from: d  reason: collision with root package name */
    final long f1528d;

    /* compiled from: ObservableRetryPredicate.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicInteger implements c.a.i<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1529b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.p.a.f f1530c;

        /* renamed from: d  reason: collision with root package name */
        final c.a.h<? extends T> f1531d;
        final c.a.o.h<? super Throwable> e;
        long f;

        a(c.a.i<? super T> iVar, long j, c.a.o.h<? super Throwable> hVar, c.a.p.a.f fVar, c.a.h<? extends T> hVar2) {
            this.f1529b = iVar;
            this.f1530c = fVar;
            this.f1531d = hVar2;
            this.e = hVar;
            this.f = j;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f1530c.a()) {
                    this.f1531d.a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // c.a.i
        public void onComplete() {
            this.f1529b.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            long j = this.f;
            if (j != Long.MAX_VALUE) {
                this.f = j - 1;
            }
            if (j == 0) {
                this.f1529b.onError(th);
                return;
            }
            try {
                if (!this.e.test(th)) {
                    this.f1529b.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                c.a.n.b.b(th2);
                this.f1529b.onError(new c.a.n.a(th, th2));
            }
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1529b.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            this.f1530c.c(bVar);
        }
    }

    public o(c.a.e<T> eVar, long j, c.a.o.h<? super Throwable> hVar) {
        super(eVar);
        this.f1527c = hVar;
        this.f1528d = j;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        c.a.p.a.f fVar = new c.a.p.a.f();
        iVar.onSubscribe(fVar);
        new a(iVar, this.f1528d, this.f1527c, fVar, this.f1474b).a();
    }
}
