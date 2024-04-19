package c.a.p.e.a;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableConcatMap.java */
/* loaded from: classes.dex */
public final class b<T, U> extends c.a.p.e.a.a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.f<? super T, ? extends c.a.h<? extends U>> f1475c;

    /* renamed from: d  reason: collision with root package name */
    final int f1476d;
    final c.a.p.h.c e;

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes.dex */
    static final class a<T, R> extends AtomicInteger implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super R> f1477b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.o.f<? super T, ? extends c.a.h<? extends R>> f1478c;

        /* renamed from: d  reason: collision with root package name */
        final int f1479d;
        final c.a.p.h.b e = new c.a.p.h.b();
        final C0062a<R> f;
        final boolean g;
        c.a.p.c.c<T> h;
        c.a.m.b i;
        volatile boolean j;
        volatile boolean k;
        volatile boolean l;
        int m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: c.a.p.e.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0062a<R> extends AtomicReference<c.a.m.b> implements c.a.i<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: b  reason: collision with root package name */
            final c.a.i<? super R> f1480b;

            /* renamed from: c  reason: collision with root package name */
            final a<?, R> f1481c;

            C0062a(c.a.i<? super R> iVar, a<?, R> aVar) {
                this.f1480b = iVar;
                this.f1481c = aVar;
            }

            void a() {
                c.a.p.a.c.dispose(this);
            }

            @Override // c.a.i
            public void onComplete() {
                a<?, R> aVar = this.f1481c;
                aVar.j = false;
                aVar.a();
            }

            @Override // c.a.i
            public void onError(Throwable th) {
                a<?, R> aVar = this.f1481c;
                if (aVar.e.a(th)) {
                    if (!aVar.g) {
                        aVar.i.dispose();
                    }
                    aVar.j = false;
                    aVar.a();
                    return;
                }
                c.a.s.a.m(th);
            }

            @Override // c.a.i
            public void onNext(R r) {
                this.f1480b.onNext(r);
            }

            @Override // c.a.i
            public void onSubscribe(c.a.m.b bVar) {
                c.a.p.a.c.replace(this, bVar);
            }
        }

        a(c.a.i<? super R> iVar, c.a.o.f<? super T, ? extends c.a.h<? extends R>> fVar, int i, boolean z) {
            this.f1477b = iVar;
            this.f1478c = fVar;
            this.f1479d = i;
            this.g = z;
            this.f = new C0062a<>(iVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            c.a.i<? super R> iVar = this.f1477b;
            c.a.p.c.c<T> cVar = this.h;
            c.a.p.h.b bVar = this.e;
            while (true) {
                if (!this.j) {
                    if (this.l) {
                        cVar.clear();
                        return;
                    } else if (!this.g && bVar.get() != null) {
                        cVar.clear();
                        this.l = true;
                        iVar.onError(bVar.b());
                        return;
                    } else {
                        boolean z = this.k;
                        try {
                            T poll = cVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.l = true;
                                Throwable b2 = bVar.b();
                                if (b2 != null) {
                                    iVar.onError(b2);
                                    return;
                                } else {
                                    iVar.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    c.a.h hVar = (c.a.h) c.a.p.b.b.d(this.f1478c.apply(poll), "The mapper returned a null ObservableSource");
                                    if (hVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) hVar).call();
                                            if (obj != 0 && !this.l) {
                                                iVar.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            c.a.n.b.b(th);
                                            bVar.a(th);
                                        }
                                    } else {
                                        this.j = true;
                                        hVar.a(this.f);
                                    }
                                } catch (Throwable th2) {
                                    c.a.n.b.b(th2);
                                    this.l = true;
                                    this.i.dispose();
                                    cVar.clear();
                                    bVar.a(th2);
                                    iVar.onError(bVar.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            c.a.n.b.b(th3);
                            this.l = true;
                            this.i.dispose();
                            bVar.a(th3);
                            iVar.onError(bVar.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            this.l = true;
            this.i.dispose();
            this.f.a();
        }

        @Override // c.a.i
        public void onComplete() {
            this.k = true;
            a();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.e.a(th)) {
                this.k = true;
                a();
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.m == 0) {
                this.h.offer(t);
            }
            a();
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.i, bVar)) {
                this.i = bVar;
                if (bVar instanceof c.a.p.c.a) {
                    c.a.p.c.a aVar = (c.a.p.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.h = aVar;
                        this.k = true;
                        this.f1477b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.h = aVar;
                        this.f1477b.onSubscribe(this);
                        return;
                    }
                }
                this.h = new c.a.p.f.a(this.f1479d);
                this.f1477b.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: c.a.p.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0063b<T, U> extends AtomicInteger implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super U> f1482b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.o.f<? super T, ? extends c.a.h<? extends U>> f1483c;

        /* renamed from: d  reason: collision with root package name */
        final a<U> f1484d;
        final int e;
        c.a.p.c.c<T> f;
        c.a.m.b g;
        volatile boolean h;
        volatile boolean i;
        volatile boolean j;
        int k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: c.a.p.e.a.b$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> extends AtomicReference<c.a.m.b> implements c.a.i<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: b  reason: collision with root package name */
            final c.a.i<? super U> f1485b;

            /* renamed from: c  reason: collision with root package name */
            final C0063b<?, ?> f1486c;

            a(c.a.i<? super U> iVar, C0063b<?, ?> c0063b) {
                this.f1485b = iVar;
                this.f1486c = c0063b;
            }

            void a() {
                c.a.p.a.c.dispose(this);
            }

            @Override // c.a.i
            public void onComplete() {
                this.f1486c.b();
            }

            @Override // c.a.i
            public void onError(Throwable th) {
                this.f1486c.dispose();
                this.f1485b.onError(th);
            }

            @Override // c.a.i
            public void onNext(U u) {
                this.f1485b.onNext(u);
            }

            @Override // c.a.i
            public void onSubscribe(c.a.m.b bVar) {
                c.a.p.a.c.set(this, bVar);
            }
        }

        C0063b(c.a.i<? super U> iVar, c.a.o.f<? super T, ? extends c.a.h<? extends U>> fVar, int i) {
            this.f1482b = iVar;
            this.f1483c = fVar;
            this.e = i;
            this.f1484d = new a<>(iVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.i) {
                if (!this.h) {
                    boolean z = this.j;
                    try {
                        T poll = this.f.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.i = true;
                            this.f1482b.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                c.a.h hVar = (c.a.h) c.a.p.b.b.d(this.f1483c.apply(poll), "The mapper returned a null ObservableSource");
                                this.h = true;
                                hVar.a(this.f1484d);
                            } catch (Throwable th) {
                                c.a.n.b.b(th);
                                dispose();
                                this.f.clear();
                                this.f1482b.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        c.a.n.b.b(th2);
                        dispose();
                        this.f.clear();
                        this.f1482b.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f.clear();
        }

        void b() {
            this.h = false;
            a();
        }

        @Override // c.a.m.b
        public void dispose() {
            this.i = true;
            this.f1484d.a();
            this.g.dispose();
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.j) {
                return;
            }
            this.j = true;
            a();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.j) {
                c.a.s.a.m(th);
                return;
            }
            this.j = true;
            dispose();
            this.f1482b.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.j) {
                return;
            }
            if (this.k == 0) {
                this.f.offer(t);
            }
            a();
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.g, bVar)) {
                this.g = bVar;
                if (bVar instanceof c.a.p.c.a) {
                    c.a.p.c.a aVar = (c.a.p.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.f = aVar;
                        this.j = true;
                        this.f1482b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.k = requestFusion;
                        this.f = aVar;
                        this.f1482b.onSubscribe(this);
                        return;
                    }
                }
                this.f = new c.a.p.f.a(this.e);
                this.f1482b.onSubscribe(this);
            }
        }
    }

    public b(c.a.h<T> hVar, c.a.o.f<? super T, ? extends c.a.h<? extends U>> fVar, int i, c.a.p.h.c cVar) {
        super(hVar);
        this.f1475c = fVar;
        this.e = cVar;
        this.f1476d = Math.max(8, i);
    }

    @Override // c.a.e
    public void w(c.a.i<? super U> iVar) {
        if (p.a(this.f1474b, iVar, this.f1475c)) {
            return;
        }
        if (this.e == c.a.p.h.c.IMMEDIATE) {
            this.f1474b.a(new C0063b(new c.a.r.a(iVar), this.f1475c, this.f1476d));
        } else {
            this.f1474b.a(new a(iVar, this.f1475c, this.f1476d, this.e == c.a.p.h.c.END));
        }
    }
}
