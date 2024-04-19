package c.a.p.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* loaded from: classes.dex */
public final class f extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: b  reason: collision with root package name */
    final String f1584b;

    /* renamed from: c  reason: collision with root package name */
    final int f1585c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f1586d;

    /* compiled from: RxThreadFactory.java */
    /* loaded from: classes.dex */
    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public f(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f1584b + '-' + incrementAndGet();
        Thread aVar = this.f1586d ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f1585c);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f1584b + "]";
    }

    public f(String str, int i) {
        this(str, i, false);
    }

    public f(String str, int i, boolean z) {
        this.f1584b = str;
        this.f1585c = i;
        this.f1586d = z;
    }
}
