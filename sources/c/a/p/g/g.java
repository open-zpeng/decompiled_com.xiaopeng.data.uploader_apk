package c.a.p.g;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes.dex */
public final class g extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public g(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() throws Exception {
        this.e = Thread.currentThread();
        try {
            this.f1560d.run();
            return null;
        } finally {
            lazySet(a.f1558b);
            this.e = null;
        }
    }
}
