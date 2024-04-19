package c.a.p.e.a;

import c.a.j;
/* compiled from: ObservableObserveOn.java */
/* loaded from: classes.dex */
public final class l<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final c.a.j f1505c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f1506d;
    final int e;

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends c.a.p.d.b<T> implements c.a.i<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1507b;

        /* renamed from: c  reason: collision with root package name */
        final j.b f1508c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f1509d;
        final int e;
        c.a.p.c.c<T> f;
        c.a.m.b g;
        Throwable h;
        volatile boolean i;
        volatile boolean j;
        int k;
        boolean l;

        a(c.a.i<? super T> iVar, j.b bVar, boolean z, int i) {
            this.f1507b = iVar;
            this.f1508c = bVar;
            this.f1509d = z;
            this.e = i;
        }

        boolean a(boolean z, boolean z2, c.a.i<? super T> iVar) {
            if (this.j) {
                this.f.clear();
                return true;
            } else if (z) {
                Throwable th = this.h;
                if (this.f1509d) {
                    if (z2) {
                        if (th != null) {
                            iVar.onError(th);
                        } else {
                            iVar.onComplete();
                        }
                        this.f1508c.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.f.clear();
                    iVar.onError(th);
                    this.f1508c.dispose();
                    return true;
                } else if (z2) {
                    iVar.onComplete();
                    this.f1508c.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            int i = 1;
            while (!this.j) {
                boolean z = this.i;
                Throwable th = this.h;
                if (!this.f1509d && z && th != null) {
                    this.f1507b.onError(th);
                    this.f1508c.dispose();
                    return;
                }
                this.f1507b.onNext(null);
                if (z) {
                    Throwable th2 = this.h;
                    if (th2 != null) {
                        this.f1507b.onError(th2);
                    } else {
                        this.f1507b.onComplete();
                    }
                    this.f1508c.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        void c() {
            c.a.p.c.c<T> cVar = this.f;
            c.a.i<? super T> iVar = this.f1507b;
            int i = 1;
            while (!a(this.i, cVar.isEmpty(), iVar)) {
                while (true) {
                    boolean z = this.i;
                    try {
                        Object obj = (T) cVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, iVar)) {
                            return;
                        }
                        if (z2) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            iVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        c.a.n.b.b(th);
                        this.g.dispose();
                        cVar.clear();
                        iVar.onError(th);
                        this.f1508c.dispose();
                        return;
                    }
                }
            }
        }

        @Override // c.a.p.c.c
        public void clear() {
            this.f.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                this.f1508c.b(this);
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.j) {
                return;
            }
            this.j = true;
            this.g.dispose();
            this.f1508c.dispose();
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        @Override // c.a.p.c.c
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            d();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.i) {
                c.a.s.a.m(th);
                return;
            }
            this.h = th;
            this.i = true;
            d();
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.k != 2) {
                this.f.offer(t);
            }
            d();
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.g, bVar)) {
                this.g = bVar;
                if (bVar instanceof c.a.p.c.a) {
                    c.a.p.c.a aVar = (c.a.p.c.a) bVar;
                    int requestFusion = aVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.f = aVar;
                        this.i = true;
                        this.f1507b.onSubscribe(this);
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.k = requestFusion;
                        this.f = aVar;
                        this.f1507b.onSubscribe(this);
                        return;
                    }
                }
                this.f = new c.a.p.f.a(this.e);
                this.f1507b.onSubscribe(this);
            }
        }

        @Override // c.a.p.c.c
        public T poll() throws Exception {
            return this.f.poll();
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.l = true;
                return 2;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.l) {
                b();
            } else {
                c();
            }
        }
    }

    public l(c.a.h<T> hVar, c.a.j jVar, boolean z, int i) {
        super(hVar);
        this.f1505c = jVar;
        this.f1506d = z;
        this.e = i;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        c.a.j jVar = this.f1505c;
        if (jVar instanceof c.a.p.g.k) {
            this.f1474b.a(iVar);
            return;
        }
        this.f1474b.a(new a(iVar, jVar.a(), this.f1506d, this.e));
    }
}
