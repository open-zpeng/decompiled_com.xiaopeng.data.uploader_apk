package c.a.p.d;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* loaded from: classes.dex */
public abstract class b<T> extends AtomicInteger implements c.a.p.c.a<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // c.a.p.c.c
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
