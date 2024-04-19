package c.a.p.g;

import c.a.j;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes.dex */
public final class k extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    private static final k f1602b = new k();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f1603b;

        /* renamed from: c  reason: collision with root package name */
        private final c f1604c;

        /* renamed from: d  reason: collision with root package name */
        private final long f1605d;

        a(Runnable runnable, c cVar, long j) {
            this.f1603b = runnable;
            this.f1604c = cVar;
            this.f1605d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1604c.e) {
                return;
            }
            long a2 = this.f1604c.a(TimeUnit.MILLISECONDS);
            long j = this.f1605d;
            if (j > a2) {
                try {
                    Thread.sleep(j - a2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    c.a.s.a.m(e);
                    return;
                }
            }
            if (this.f1604c.e) {
                return;
            }
            this.f1603b.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: b  reason: collision with root package name */
        final Runnable f1606b;

        /* renamed from: c  reason: collision with root package name */
        final long f1607c;

        /* renamed from: d  reason: collision with root package name */
        final int f1608d;
        volatile boolean e;

        b(Runnable runnable, Long l, int i) {
            this.f1606b = runnable;
            this.f1607c = l.longValue();
            this.f1608d = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int b2 = c.a.p.b.b.b(this.f1607c, bVar.f1607c);
            return b2 == 0 ? c.a.p.b.b.a(this.f1608d, bVar.f1608d) : b2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class c extends j.b implements c.a.m.b {

        /* renamed from: b  reason: collision with root package name */
        final PriorityBlockingQueue<b> f1609b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f1610c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f1611d = new AtomicInteger();
        volatile boolean e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final b f1612b;

            a(b bVar) {
                this.f1612b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1612b.e = true;
                c.this.f1609b.remove(this.f1612b);
            }
        }

        c() {
        }

        @Override // c.a.j.b
        public c.a.m.b b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return d(new a(runnable, this, a2), a2);
        }

        c.a.m.b d(Runnable runnable, long j) {
            if (this.e) {
                return c.a.p.a.d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f1611d.incrementAndGet());
            this.f1609b.add(bVar);
            if (this.f1610c.getAndIncrement() == 0) {
                int i = 1;
                while (!this.e) {
                    b poll = this.f1609b.poll();
                    if (poll == null) {
                        i = this.f1610c.addAndGet(-i);
                        if (i == 0) {
                            return c.a.p.a.d.INSTANCE;
                        }
                    } else if (!poll.e) {
                        poll.f1606b.run();
                    }
                }
                this.f1609b.clear();
                return c.a.p.a.d.INSTANCE;
            }
            return c.a.m.c.b(new a(bVar));
        }

        @Override // c.a.m.b
        public void dispose() {
            this.e = true;
        }
    }

    k() {
    }

    public static k d() {
        return f1602b;
    }

    @Override // c.a.j
    public j.b a() {
        return new c();
    }

    @Override // c.a.j
    public c.a.m.b b(Runnable runnable) {
        c.a.s.a.o(runnable).run();
        return c.a.p.a.d.INSTANCE;
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            c.a.s.a.o(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            c.a.s.a.m(e);
        }
        return c.a.p.a.d.INSTANCE;
    }
}
