package c.a.p.g;

import c.a.j;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* loaded from: classes.dex */
public final class d extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    private static final f f1580b = new f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f1581c;

    public d() {
        this(f1580b);
    }

    @Override // c.a.j
    public j.b a() {
        return new e(this.f1581c);
    }

    public d(ThreadFactory threadFactory) {
        this.f1581c = threadFactory;
    }
}
