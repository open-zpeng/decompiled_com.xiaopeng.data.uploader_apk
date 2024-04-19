package c.a.l.b;

import android.os.Handler;
import android.os.Message;
import c.a.j;
import c.a.m.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/* compiled from: HandlerScheduler.java */
/* loaded from: classes.dex */
final class b extends j {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1445b;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes.dex */
    private static final class a extends j.b {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f1446b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f1447c;

        a(Handler handler) {
            this.f1446b = handler;
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f1447c) {
                return c.a();
            }
            RunnableC0059b runnableC0059b = new RunnableC0059b(this.f1446b, c.a.s.a.o(runnable));
            Message obtain = Message.obtain(this.f1446b, runnableC0059b);
            obtain.obj = this;
            this.f1446b.sendMessageDelayed(obtain, Math.max(0L, timeUnit.toMillis(j)));
            if (this.f1447c) {
                this.f1446b.removeCallbacks(runnableC0059b);
                return c.a();
            }
            return runnableC0059b;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1447c = true;
            this.f1446b.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: c.a.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class RunnableC0059b implements Runnable, c.a.m.b {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f1448b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f1449c;

        /* renamed from: d  reason: collision with root package name */
        private volatile boolean f1450d;

        RunnableC0059b(Handler handler, Runnable runnable) {
            this.f1448b = handler;
            this.f1449c = runnable;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1450d = true;
            this.f1448b.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1449c.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                c.a.s.a.m(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler) {
        this.f1445b = handler;
    }

    @Override // c.a.j
    public j.b a() {
        return new a(this.f1445b);
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0059b runnableC0059b = new RunnableC0059b(this.f1445b, c.a.s.a.o(runnable));
        this.f1445b.postDelayed(runnableC0059b, Math.max(0L, timeUnit.toMillis(j)));
        return runnableC0059b;
    }
}
