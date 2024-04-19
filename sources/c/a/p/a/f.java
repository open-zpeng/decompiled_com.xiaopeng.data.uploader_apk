package c.a.p.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* loaded from: classes.dex */
public final class f extends AtomicReference<c.a.m.b> implements c.a.m.b {
    private static final long serialVersionUID = -754898800686245608L;

    public boolean a() {
        return c.isDisposed(get());
    }

    public boolean b(c.a.m.b bVar) {
        return c.replace(this, bVar);
    }

    public boolean c(c.a.m.b bVar) {
        return c.set(this, bVar);
    }

    @Override // c.a.m.b
    public void dispose() {
        c.dispose(this);
    }
}
