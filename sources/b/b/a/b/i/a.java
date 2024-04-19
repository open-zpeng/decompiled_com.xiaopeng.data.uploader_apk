package b.b.a.b.i;

import b.b.a.b.a;
import b.b.a.b.f.i;
import b.b.a.b.f.s;
import java.util.Random;
/* compiled from: UploadEngine.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static a f1105a = new a();

    /* renamed from: b  reason: collision with root package name */
    protected long f1106b = a.b.a();

    /* renamed from: c  reason: collision with root package name */
    private boolean f1107c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f1108d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UploadEngine.java */
    /* renamed from: b.b.a.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a extends b {
        C0042a() {
        }

        @Override // b.b.a.b.i.b
        public void a() {
            if (a.this.f1107c) {
                b.b.a.b.b.a.c();
                a.this.c();
                i.c("UploadTask", "mPeriod:", Long.valueOf(a.this.f1106b));
                if (s.a().h(2)) {
                    s.a().i(2);
                }
                if (b.k()) {
                    return;
                }
                s.a().e(2, this, a.this.f1106b);
            }
        }

        @Override // b.b.a.b.i.b
        public void b() {
            a.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        long a2;
        int i;
        i.c("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(b.b.a.b.a.f1003c), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(b.b.a.b.f.b.b(b.b.a.b.a.j())));
        boolean z = !b.b.a.b.f.b.b(b.b.a.b.a.j());
        b.b.a.b.a.f1003c = z;
        a.b.a();
        if (z) {
            a2 = a.b.f();
            i = this.f1108d;
        } else {
            a2 = a.b.a();
            i = this.f1108d;
        }
        this.f1106b = a2 + i;
        if (a.b.g()) {
            this.f1106b = 3000L;
        }
        return this.f1106b;
    }

    public static a d() {
        return f1105a;
    }

    public void e() {
        if (this.f1108d == 0) {
            this.f1108d = 7000;
        } else {
            this.f1108d = 0;
        }
    }

    public synchronized void f() {
        this.f1107c = true;
        if (s.a().h(2)) {
            s.a().i(2);
        }
        c();
        Random random = new Random();
        if (!b.k()) {
            s.a().e(2, new C0042a(), random.nextInt((int) this.f1106b));
        }
    }

    public synchronized void g() {
        this.f1107c = false;
        s.a().i(2);
    }
}
