package c.a.l.b;

import android.os.Handler;
import android.os.Looper;
import c.a.j;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final j f1443a = c.a.l.a.a.d(new CallableC0058a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: c.a.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class CallableC0058a implements Callable<j> {
        CallableC0058a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public j call() throws Exception {
            return b.f1444a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final j f1444a = new c.a.l.b.b(new Handler(Looper.getMainLooper()));
    }

    private a() {
        throw new AssertionError("No instances.");
    }

    public static j a() {
        return c.a.l.a.a.e(f1443a);
    }
}
