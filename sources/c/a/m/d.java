package c.a.m;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* loaded from: classes.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(T t) {
        super(c.a.p.b.b.d(t, "value is null"));
    }

    public final boolean a() {
        return get() == null;
    }

    protected abstract void b(T t);

    @Override // c.a.m.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        b(andSet);
    }
}
