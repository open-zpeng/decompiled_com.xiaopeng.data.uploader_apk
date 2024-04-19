package c.a.p.g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* loaded from: classes.dex */
abstract class a extends AtomicReference<Future<?>> implements c.a.m.b {

    /* renamed from: b  reason: collision with root package name */
    protected static final FutureTask<Void> f1558b;

    /* renamed from: c  reason: collision with root package name */
    protected static final FutureTask<Void> f1559c;
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: d  reason: collision with root package name */
    protected final Runnable f1560d;
    protected Thread e;

    static {
        Runnable runnable = c.a.p.b.a.f1461b;
        f1558b = new FutureTask<>(runnable, null);
        f1559c = new FutureTask<>(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.f1560d = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f1558b) {
                return;
            }
            if (future2 == f1559c) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // c.a.m.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f1558b || future == (futureTask = f1559c) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.e != Thread.currentThread());
    }
}
