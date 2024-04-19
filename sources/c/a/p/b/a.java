package c.a.p.b;

import java.util.Comparator;
import java.util.concurrent.Callable;
/* compiled from: Functions.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final c.a.o.f<Object, Object> f1460a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f1461b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final c.a.o.a f1462c = new C0061a();

    /* renamed from: d  reason: collision with root package name */
    static final c.a.o.e<Object> f1463d = new b();
    public static final c.a.o.e<Throwable> e = new e();
    public static final c.a.o.e<Throwable> f = new k();
    public static final c.a.o.g g = new c();
    static final c.a.o.h<Object> h = new l();
    static final c.a.o.h<Object> i = new f();
    static final Callable<Object> j = new j();
    static final Comparator<Object> k = new i();
    public static final c.a.o.e<d.b.b> l = new h();

    /* compiled from: Functions.java */
    /* renamed from: c.a.p.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0061a implements c.a.o.a {
        C0061a() {
        }

        @Override // c.a.o.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class b implements c.a.o.e<Object> {
        b() {
        }

        @Override // c.a.o.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class c implements c.a.o.g {
        c() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class e implements c.a.o.e<Throwable> {
        e() {
        }

        @Override // c.a.o.e
        /* renamed from: a */
        public void accept(Throwable th) {
            c.a.s.a.m(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class f implements c.a.o.h<Object> {
        f() {
        }

        @Override // c.a.o.h
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class g implements c.a.o.f<Object, Object> {
        g() {
        }

        @Override // c.a.o.f
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class h implements c.a.o.e<d.b.b> {
        h() {
        }

        @Override // c.a.o.e
        /* renamed from: a */
        public void accept(d.b.b bVar) throws Exception {
            bVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class k implements c.a.o.e<Throwable> {
        k() {
        }

        @Override // c.a.o.e
        /* renamed from: a */
        public void accept(Throwable th) {
            c.a.s.a.m(new c.a.n.c(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class l implements c.a.o.h<Object> {
        l() {
        }

        @Override // c.a.o.h
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> c.a.o.e<T> a() {
        return (c.a.o.e<T>) f1463d;
    }

    public static <T> c.a.o.f<T, T> b() {
        return (c.a.o.f<T, T>) f1460a;
    }
}
