package c.a.p.g;

import c.a.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* loaded from: classes.dex */
public final class j extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    static final f f1596b;

    /* renamed from: c  reason: collision with root package name */
    static final ScheduledExecutorService f1597c;

    /* renamed from: d  reason: collision with root package name */
    final ThreadFactory f1598d;
    final AtomicReference<ScheduledExecutorService> e;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends j.b {

        /* renamed from: b  reason: collision with root package name */
        final ScheduledExecutorService f1599b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.m.a f1600c = new c.a.m.a();

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f1601d;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f1599b = scheduledExecutorService;
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f1601d) {
                return c.a.p.a.d.INSTANCE;
            }
            h hVar = new h(c.a.s.a.o(runnable), this.f1600c);
            this.f1600c.c(hVar);
            try {
                if (j <= 0) {
                    schedule = this.f1599b.submit((Callable) hVar);
                } else {
                    schedule = this.f1599b.schedule((Callable) hVar, j, timeUnit);
                }
                hVar.a(schedule);
                return hVar;
            } catch (RejectedExecutionException e) {
                dispose();
                c.a.s.a.m(e);
                return c.a.p.a.d.INSTANCE;
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.f1601d) {
                return;
            }
            this.f1601d = true;
            this.f1600c.dispose();
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f1597c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f1596b = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(f1596b);
    }

    static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // c.a.j
    public j.b a() {
        return new a(this.e.get());
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        g gVar = new g(c.a.s.a.o(runnable));
        try {
            if (j <= 0) {
                schedule = this.e.get().submit(gVar);
            } else {
                schedule = this.e.get().schedule(gVar, j, timeUnit);
            }
            gVar.a(schedule);
            return gVar;
        } catch (RejectedExecutionException e) {
            c.a.s.a.m(e);
            return c.a.p.a.d.INSTANCE;
        }
    }

    public j(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.e = atomicReference;
        this.f1598d = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }
}
