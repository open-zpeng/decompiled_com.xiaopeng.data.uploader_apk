package c.a.n;
/* compiled from: Exceptions.java */
/* loaded from: classes.dex */
public final class b {
    public static RuntimeException a(Throwable th) {
        throw c.a.p.h.d.c(th);
    }

    public static void b(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
