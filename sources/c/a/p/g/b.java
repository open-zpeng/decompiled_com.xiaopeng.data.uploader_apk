package c.a.p.g;

import c.a.j;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* loaded from: classes.dex */
public final class b extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    static final C0064b f1561b;

    /* renamed from: c  reason: collision with root package name */
    static final f f1562c;

    /* renamed from: d  reason: collision with root package name */
    static final int f1563d = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c e;
    final ThreadFactory f;
    final AtomicReference<C0064b> g;

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends j.b {

        /* renamed from: b  reason: collision with root package name */
        private final c.a.p.a.e f1564b;

        /* renamed from: c  reason: collision with root package name */
        private final c.a.m.a f1565c;

        /* renamed from: d  reason: collision with root package name */
        private final c.a.p.a.e f1566d;
        private final c e;
        volatile boolean f;

        a(c cVar) {
            this.e = cVar;
            c.a.p.a.e eVar = new c.a.p.a.e();
            this.f1564b = eVar;
            c.a.m.a aVar = new c.a.m.a();
            this.f1565c = aVar;
            c.a.p.a.e eVar2 = new c.a.p.a.e();
            this.f1566d = eVar2;
            eVar2.c(eVar);
            eVar2.c(aVar);
        }

        @Override // c.a.j.b
        public c.a.m.b b(Runnable runnable) {
            if (this.f) {
                return c.a.p.a.d.INSTANCE;
            }
            return this.e.d(runnable, 0L, TimeUnit.MILLISECONDS, this.f1564b);
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f) {
                return c.a.p.a.d.INSTANCE;
            }
            return this.e.d(runnable, j, timeUnit, this.f1565c);
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.f1566d.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: c.a.p.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0064b {

        /* renamed from: a  reason: collision with root package name */
        final int f1567a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f1568b;

        /* renamed from: c  reason: collision with root package name */
        long f1569c;

        C0064b(int i, ThreadFactory threadFactory) {
            this.f1567a = i;
            this.f1568b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f1568b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f1567a;
            if (i == 0) {
                return b.e;
            }
            c[] cVarArr = this.f1568b;
            long j = this.f1569c;
            this.f1569c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f1568b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new f("RxComputationShutdown"));
        e = cVar;
        cVar.dispose();
        f fVar = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f1562c = fVar;
        C0064b c0064b = new C0064b(0, fVar);
        f1561b = c0064b;
        c0064b.b();
    }

    public b() {
        this(f1562c);
    }

    static int d(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // c.a.j
    public j.b a() {
        return new a(this.g.get().a());
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().e(runnable, j, timeUnit);
    }

    public void e() {
        C0064b c0064b = new C0064b(f1563d, this.f);
        if (this.g.compareAndSet(f1561b, c0064b)) {
            return;
        }
        c0064b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(f1561b);
        e();
    }
}
