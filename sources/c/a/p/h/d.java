package c.a.p.h;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ExceptionHelper.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f1618a = new a();

    /* compiled from: ExceptionHelper.java */
    /* loaded from: classes.dex */
    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f1618a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new c.a.n.a(th2, th)));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f1618a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static RuntimeException c(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }
}
