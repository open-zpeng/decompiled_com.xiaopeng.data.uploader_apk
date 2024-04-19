package c.a.p.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableRefCount.java */
/* loaded from: classes.dex */
public final class n<T> extends c.a.e<T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.q.a<T> f1518b;

    /* renamed from: c  reason: collision with root package name */
    final int f1519c;

    /* renamed from: d  reason: collision with root package name */
    final long f1520d;
    final TimeUnit e;
    final c.a.j f;
    a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<c.a.m.b> implements Runnable, c.a.o.e<c.a.m.b> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: b  reason: collision with root package name */
        final n<?> f1521b;

        /* renamed from: c  reason: collision with root package name */
        c.a.m.b f1522c;

        /* renamed from: d  reason: collision with root package name */
        long f1523d;
        boolean e;

        a(n<?> nVar) {
            this.f1521b = nVar;
        }

        @Override // c.a.o.e
        /* renamed from: a */
        public void accept(c.a.m.b bVar) throws Exception {
            c.a.p.a.c.replace(this, bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1521b.E(this);
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicBoolean implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1524b;

        /* renamed from: c  reason: collision with root package name */
        final n<T> f1525c;

        /* renamed from: d  reason: collision with root package name */
        final a f1526d;
        c.a.m.b e;

        b(c.a.i<? super T> iVar, n<T> nVar, a aVar) {
            this.f1524b = iVar;
            this.f1525c = nVar;
            this.f1526d = aVar;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.e.dispose();
            if (compareAndSet(false, true)) {
                this.f1525c.C(this.f1526d);
            }
        }

        @Override // c.a.i
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f1525c.D(this.f1526d);
                this.f1524b.onComplete();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f1525c.D(this.f1526d);
                this.f1524b.onError(th);
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1524b.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.e, bVar)) {
                this.e = bVar;
                this.f1524b.onSubscribe(this);
            }
        }
    }

    public n(c.a.q.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, c.a.t.a.c());
    }

    void C(a aVar) {
        synchronized (this) {
            if (this.g == null) {
                return;
            }
            long j = aVar.f1523d - 1;
            aVar.f1523d = j;
            if (j == 0 && aVar.e) {
                if (this.f1520d == 0) {
                    E(aVar);
                    return;
                }
                c.a.p.a.f fVar = new c.a.p.a.f();
                aVar.f1522c = fVar;
                fVar.b(this.f.c(aVar, this.f1520d, this.e));
            }
        }
    }

    void D(a aVar) {
        synchronized (this) {
            if (this.g != null) {
                this.g = null;
                c.a.m.b bVar = aVar.f1522c;
                if (bVar != null) {
                    bVar.dispose();
                }
                c.a.q.a<T> aVar2 = this.f1518b;
                if (aVar2 instanceof c.a.m.b) {
                    ((c.a.m.b) aVar2).dispose();
                }
            }
        }
    }

    void E(a aVar) {
        synchronized (this) {
            if (aVar.f1523d == 0 && aVar == this.g) {
                this.g = null;
                c.a.p.a.c.dispose(aVar);
                c.a.q.a<T> aVar2 = this.f1518b;
                if (aVar2 instanceof c.a.m.b) {
                    ((c.a.m.b) aVar2).dispose();
                }
            }
        }
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        a aVar;
        boolean z;
        c.a.m.b bVar;
        synchronized (this) {
            aVar = this.g;
            if (aVar == null) {
                aVar = new a(this);
                this.g = aVar;
            }
            long j = aVar.f1523d;
            if (j == 0 && (bVar = aVar.f1522c) != null) {
                bVar.dispose();
            }
            long j2 = j + 1;
            aVar.f1523d = j2;
            z = true;
            if (aVar.e || j2 != this.f1519c) {
                z = false;
            } else {
                aVar.e = true;
            }
        }
        this.f1518b.a(new b(iVar, this, aVar));
        if (z) {
            this.f1518b.C(aVar);
        }
    }

    public n(c.a.q.a<T> aVar, int i, long j, TimeUnit timeUnit, c.a.j jVar) {
        this.f1518b = aVar;
        this.f1519c = i;
        this.f1520d = j;
        this.e = timeUnit;
        this.f = jVar;
    }
}
