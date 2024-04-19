package b.b.a.b.d;

import b.b.a.b.f.i;
import b.b.a.b.f.s;
import com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: LogStoreMgr.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1034a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1035b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1036c = new Object();
    private List<b.b.a.b.g.b> e = new CopyOnWriteArrayList();
    private Runnable f = new a();

    /* renamed from: d  reason: collision with root package name */
    private b.b.a.b.d.a f1037d = new b.b.a.b.d.b(b.b.a.b.a.j());

    /* compiled from: LogStoreMgr.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a();
        }
    }

    /* compiled from: LogStoreMgr.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
            int c2 = c.this.f1037d.c();
            if (c2 > 9000) {
                c.this.k(c2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogStoreMgr.java */
    /* renamed from: b.b.a.b.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0039c implements Runnable {
        RunnableC0039c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.c("LogStoreMgr", "CleanLogTask");
            int c2 = c.this.f1037d.c();
            if (c2 > 9000) {
                c.this.k(c2);
            }
        }
    }

    private c() {
        b.b.a.b.i.a.d().f();
        s.a().g(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        this.f1037d.b("time", String.valueOf(calendar.getTimeInMillis()));
    }

    public static synchronized c e() {
        c cVar;
        synchronized (c.class) {
            if (f1034a == null) {
                f1034a = new c();
            }
            cVar = f1034a;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        if (i > 9000) {
            this.f1037d.d((i - 9000) + IError.ERR_SERVICE_DISCONNECTED);
        }
    }

    public synchronized void a() {
        i.c("LogStoreMgr", "[store]");
        ArrayList arrayList = null;
        try {
            synchronized (this.e) {
                if (this.e.size() > 0) {
                    arrayList = new ArrayList(this.e);
                    this.e.clear();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.f1037d.mo1a((List<b.b.a.b.g.b>) arrayList);
            }
        } catch (Throwable unused) {
        }
    }

    public int c(List<b.b.a.b.g.b> list) {
        i.c("LogStoreMgr", list);
        return this.f1037d.a(list);
    }

    public List<b.b.a.b.g.b> f(String str, int i) {
        List<b.b.a.b.g.b> a2 = this.f1037d.a(str, i);
        i.c("LogStoreMgr", "[get]", a2);
        return a2;
    }

    public void i(b.b.a.b.g.b bVar) {
        i.c("LogStoreMgr", "[add] :", bVar.f);
        b.b.a.b.b.a.i(bVar.f1095b);
        this.e.add(bVar);
        if (this.e.size() >= 100) {
            s.a().i(1);
            s.a().e(1, this.f, 0L);
        } else if (!s.a().h(1)) {
            s.a().e(1, this.f, 5000L);
        }
        synchronized (f1036c) {
            int i = f1035b + 1;
            f1035b = i;
            if (i > 5000) {
                f1035b = 0;
                s.a().g(new RunnableC0039c());
            }
        }
    }

    public void j() {
        i.c("LogStoreMgr", "[clear]");
        this.f1037d.clear();
        this.e.clear();
    }
}
