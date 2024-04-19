package c.a.p.h;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AtomicThrowable.java */
/* loaded from: classes.dex */
public final class b extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean a(Throwable th) {
        return d.a(this, th);
    }

    public Throwable b() {
        return d.b(this);
    }
}
