package b.c.a.c.c;

import okhttp3.Call;
import okhttp3.Response;
/* compiled from: DefaultCachePolicy.java */
/* loaded from: classes.dex */
public class c<T> extends b.c.a.c.c.a<T> {

    /* compiled from: DefaultCachePolicy.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1128b;

        a(b.c.a.j.d dVar) {
            this.f1128b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.onSuccess(this.f1128b);
            c.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1130b;

        b(b.c.a.j.d dVar) {
            this.f1130b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.onError(this.f1130b);
            c.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: b.c.a.c.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0046c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1132b;

        RunnableC0046c(b.c.a.j.d dVar) {
            this.f1132b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.onError(this.f1132b);
            c.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* loaded from: classes.dex */
    class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1134b;

        d(b.c.a.j.d dVar) {
            this.f1134b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.onCacheSuccess(this.f1134b);
            c.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f.onStart(cVar.f1123a);
            try {
                c.this.e();
                c.this.f();
            } catch (Throwable th) {
                c.this.f.onError(b.c.a.j.d.c(false, c.this.e, null, th));
            }
        }
    }

    public c(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
        super(dVar);
    }

    @Override // b.c.a.c.c.b
    public void b(b.c.a.c.a<T> aVar, b.c.a.d.b<T> bVar) {
        this.f = bVar;
        g(new e());
    }

    @Override // b.c.a.c.c.a
    public boolean d(Call call, Response response) {
        if (response.code() != 304) {
            return false;
        }
        b.c.a.c.a<T> aVar = this.g;
        if (aVar == null) {
            g(new RunnableC0046c(b.c.a.j.d.c(true, call, response, b.c.a.g.a.a(this.f1123a.i()))));
        } else {
            g(new d(b.c.a.j.d.m(true, aVar.c(), call, response)));
        }
        return true;
    }

    @Override // b.c.a.c.c.b
    public void onError(b.c.a.j.d<T> dVar) {
        g(new b(dVar));
    }

    @Override // b.c.a.c.c.b
    public void onSuccess(b.c.a.j.d<T> dVar) {
        g(new a(dVar));
    }
}
