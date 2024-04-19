package c.a.p.e.a;

import c.a.j;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes.dex */
public final class s<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f1543c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f1544d;
    final c.a.j e;
    final c.a.h<? extends T> f;

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class a<T> implements c.a.i<T> {

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1545b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<c.a.m.b> f1546c;

        a(c.a.i<? super T> iVar, AtomicReference<c.a.m.b> atomicReference) {
            this.f1545b = iVar;
            this.f1546c = atomicReference;
        }

        @Override // c.a.i
        public void onComplete() {
            this.f1545b.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            this.f1545b.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1545b.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.replace(this.f1546c, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicReference<c.a.m.b> implements c.a.i<T>, c.a.m.b, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1547b;

        /* renamed from: c  reason: collision with root package name */
        final long f1548c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f1549d;
        final j.b e;
        final c.a.p.a.f f = new c.a.p.a.f();
        final AtomicLong g = new AtomicLong();
        final AtomicReference<c.a.m.b> h = new AtomicReference<>();
        c.a.h<? extends T> i;

        b(c.a.i<? super T> iVar, long j, TimeUnit timeUnit, j.b bVar, c.a.h<? extends T> hVar) {
            this.f1547b = iVar;
            this.f1548c = j;
            this.f1549d = timeUnit;
            this.e = bVar;
            this.i = hVar;
        }

        @Override // c.a.p.e.a.s.d
        public void a(long j) {
            if (this.g.compareAndSet(j, Long.MAX_VALUE)) {
                c.a.p.a.c.dispose(this.h);
                c.a.h<? extends T> hVar = this.i;
                this.i = null;
                hVar.a(new a(this.f1547b, this));
                this.e.dispose();
            }
        }

        void b(long j) {
            this.f.b(this.e.c(new e(j, this), this.f1548c, this.f1549d));
        }

        @Override // c.a.m.b
        public void dispose() {
            c.a.p.a.c.dispose(this.h);
            c.a.p.a.c.dispose(this);
            this.e.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.f1547b.onComplete();
                this.e.dispose();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.f1547b.onError(th);
                this.e.dispose();
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            long j = this.g.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.g.compareAndSet(j, j2)) {
                    this.f.get().dispose();
                    this.f1547b.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this.h, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class c<T> extends AtomicLong implements c.a.i<T>, c.a.m.b, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1550b;

        /* renamed from: c  reason: collision with root package name */
        final long f1551c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f1552d;
        final j.b e;
        final c.a.p.a.f f = new c.a.p.a.f();
        final AtomicReference<c.a.m.b> g = new AtomicReference<>();

        c(c.a.i<? super T> iVar, long j, TimeUnit timeUnit, j.b bVar) {
            this.f1550b = iVar;
            this.f1551c = j;
            this.f1552d = timeUnit;
            this.e = bVar;
        }

        @Override // c.a.p.e.a.s.d
        public void a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                c.a.p.a.c.dispose(this.g);
                this.f1550b.onError(new TimeoutException());
                this.e.dispose();
            }
        }

        void b(long j) {
            this.f.b(this.e.c(new e(j, this), this.f1551c, this.f1552d));
        }

        @Override // c.a.m.b
        public void dispose() {
            c.a.p.a.c.dispose(this.g);
            this.e.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.f1550b.onComplete();
                this.e.dispose();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.f1550b.onError(th);
                this.e.dispose();
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.f.get().dispose();
                    this.f1550b.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this.g, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final d f1553b;

        /* renamed from: c  reason: collision with root package name */
        final long f1554c;

        e(long j, d dVar) {
            this.f1554c = j;
            this.f1553b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1553b.a(this.f1554c);
        }
    }

    public s(c.a.e<T> eVar, long j, TimeUnit timeUnit, c.a.j jVar, c.a.h<? extends T> hVar) {
        super(eVar);
        this.f1543c = j;
        this.f1544d = timeUnit;
        this.e = jVar;
        this.f = hVar;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        if (this.f == null) {
            c cVar = new c(iVar, this.f1543c, this.f1544d, this.e.a());
            iVar.onSubscribe(cVar);
            cVar.b(0L);
            this.f1474b.a(cVar);
            return;
        }
        b bVar = new b(iVar, this.f1543c, this.f1544d, this.e.a(), this.f);
        iVar.onSubscribe(bVar);
        bVar.b(0L);
        this.f1474b.a(bVar);
    }
}
