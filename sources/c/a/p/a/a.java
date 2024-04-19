package c.a.p.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CancellableDisposable.java */
/* loaded from: classes.dex */
public final class a extends AtomicReference<c.a.o.d> implements c.a.m.b {
    private static final long serialVersionUID = 5718521705281392066L;

    public a(c.a.o.d dVar) {
        super(dVar);
    }

    @Override // c.a.m.b
    public void dispose() {
        c.a.o.d andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            c.a.n.b.b(e);
            c.a.s.a.m(e);
        }
    }
}
