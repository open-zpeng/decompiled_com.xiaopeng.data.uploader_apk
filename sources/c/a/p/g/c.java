package c.a.p.g;

import c.a.j;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* loaded from: classes.dex */
public final class c extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    static final f f1570b;

    /* renamed from: c  reason: collision with root package name */
    static final f f1571c;

    /* renamed from: d  reason: collision with root package name */
    private static final TimeUnit f1572d = TimeUnit.SECONDS;
    static final C0065c e;
    static final a f;
    final ThreadFactory g;
    final AtomicReference<a> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final long f1573b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0065c> f1574c;

        /* renamed from: d  reason: collision with root package name */
        final c.a.m.a f1575d;
        private final ScheduledExecutorService e;
        private final Future<?> f;
        private final ThreadFactory g;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f1573b = nanos;
            this.f1574c = new ConcurrentLinkedQueue<>();
            this.f1575d = new c.a.m.a();
            this.g = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, c.f1571c);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.e = scheduledExecutorService;
            this.f = scheduledFuture;
        }

        void a() {
            if (this.f1574c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<C0065c> it = this.f1574c.iterator();
            while (it.hasNext()) {
                C0065c next = it.next();
                if (next.g() > c2) {
                    return;
                }
                if (this.f1574c.remove(next)) {
                    this.f1575d.b(next);
                }
            }
        }

        C0065c b() {
            if (this.f1575d.e()) {
                return c.e;
            }
            while (!this.f1574c.isEmpty()) {
                C0065c poll = this.f1574c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C0065c c0065c = new C0065c(this.g);
            this.f1575d.c(c0065c);
            return c0065c;
        }

        long c() {
            return System.nanoTime();
        }

        void d(C0065c c0065c) {
            c0065c.h(c() + this.f1573b);
            this.f1574c.offer(c0065c);
        }

        void e() {
            this.f1575d.dispose();
            Future<?> future = this.f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    static final class b extends j.b {

        /* renamed from: c  reason: collision with root package name */
        private final a f1577c;

        /* renamed from: d  reason: collision with root package name */
        private final C0065c f1578d;
        final AtomicBoolean e = new AtomicBoolean();

        /* renamed from: b  reason: collision with root package name */
        private final c.a.m.a f1576b = new c.a.m.a();

        b(a aVar) {
            this.f1577c = aVar;
            this.f1578d = aVar.b();
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f1576b.e()) {
                return c.a.p.a.d.INSTANCE;
            }
            return this.f1578d.d(runnable, j, timeUnit, this.f1576b);
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.e.compareAndSet(false, true)) {
                this.f1576b.dispose();
                this.f1577c.d(this.f1578d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: c.a.p.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0065c extends e {

        /* renamed from: d  reason: collision with root package name */
        private long f1579d;

        C0065c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f1579d = 0L;
        }

        public long g() {
            return this.f1579d;
        }

        public void h(long j) {
            this.f1579d = j;
        }
    }

    static {
        C0065c c0065c = new C0065c(new f("RxCachedThreadSchedulerShutdown"));
        e = c0065c;
        c0065c.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f fVar = new f("RxCachedThreadScheduler", max);
        f1570b = fVar;
        f1571c = new f("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, fVar);
        f = aVar;
        aVar.e();
    }

    public c() {
        this(f1570b);
    }

    @Override // c.a.j
    public j.b a() {
        return new b(this.h.get());
    }

    public void d() {
        a aVar = new a(60L, f1572d, this.g);
        if (this.h.compareAndSet(f, aVar)) {
            return;
        }
        aVar.e();
    }

    public c(ThreadFactory threadFactory) {
        this.g = threadFactory;
        this.h = new AtomicReference<>(f);
        d();
    }
}
