package c.a.p.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* loaded from: classes.dex */
public enum c implements c.a.m.b {
    DISPOSED;

    public static boolean dispose(AtomicReference<c.a.m.b> atomicReference) {
        c.a.m.b andSet;
        c.a.m.b bVar = atomicReference.get();
        c cVar = DISPOSED;
        if (bVar == cVar || (andSet = atomicReference.getAndSet(cVar)) == cVar) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
            return true;
        }
        return true;
    }

    public static boolean isDisposed(c.a.m.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<c.a.m.b> atomicReference, c.a.m.b bVar) {
        c.a.m.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static void reportDisposableSet() {
        c.a.s.a.m(new c.a.n.d("Disposable already set!"));
    }

    public static boolean set(AtomicReference<c.a.m.b> atomicReference, c.a.m.b bVar) {
        c.a.m.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<c.a.m.b> atomicReference, c.a.m.b bVar) {
        c.a.p.b.b.d(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
            return false;
        }
        return false;
    }

    public static boolean trySet(AtomicReference<c.a.m.b> atomicReference, c.a.m.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
            return false;
        }
        return false;
    }

    public static boolean validate(c.a.m.b bVar, c.a.m.b bVar2) {
        if (bVar2 == null) {
            c.a.s.a.m(new NullPointerException("next is null"));
            return false;
        } else if (bVar != null) {
            bVar2.dispose();
            reportDisposableSet();
            return false;
        } else {
            return true;
        }
    }

    @Override // c.a.m.b
    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
