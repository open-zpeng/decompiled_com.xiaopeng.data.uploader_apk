package b.b.a.a;

import b.b.a.a.i;
import b.b.a.b.f.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CleanTask.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f948b = false;

    /* renamed from: c  reason: collision with root package name */
    private static long f949c = 300000;

    /* renamed from: d  reason: collision with root package name */
    private static k f950d;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        s.a().i(5);
        f948b = false;
        f950d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        if (f948b) {
            return;
        }
        b.b.a.b.f.i.c("CleanTask", "init TimeoutEventManager");
        f950d = new k();
        s.a().e(5, f950d, f949c);
        f948b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.b.a.b.f.i.c("CleanTask", "clean TimeoutEvent");
        i.f.b().r();
        s.a().e(5, f950d, f949c);
    }
}
