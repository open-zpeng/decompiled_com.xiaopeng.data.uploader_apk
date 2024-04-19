package b.c.a.c.c;
/* compiled from: RequestFailedCachePolicy.java */
/* loaded from: classes.dex */
public class g<T> extends b.c.a.c.c.a<T> {

    /* compiled from: RequestFailedCachePolicy.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1154b;

        a(b.c.a.j.d dVar) {
            this.f1154b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f.onSuccess(this.f1154b);
            g.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1156b;

        b(b.c.a.j.d dVar) {
            this.f1156b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f.onCacheSuccess(this.f1156b);
            g.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1158b;

        c(b.c.a.j.d dVar) {
            this.f1158b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f.onError(this.f1158b);
            g.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.f.onStart(gVar.f1123a);
            try {
                g.this.e();
                g.this.f();
            } catch (Throwable th) {
                g.this.f.onError(b.c.a.j.d.c(false, g.this.e, null, th));
            }
        }
    }

    public g(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
        super(dVar);
    }

    @Override // b.c.a.c.c.b
    public void b(b.c.a.c.a<T> aVar, b.c.a.d.b<T> bVar) {
        this.f = bVar;
        g(new d());
    }

    @Override // b.c.a.c.c.b
    public void onError(b.c.a.j.d<T> dVar) {
        b.c.a.c.a<T> aVar = this.g;
        if (aVar != null) {
            g(new b(b.c.a.j.d.m(true, aVar.c(), dVar.e(), dVar.f())));
        } else {
            g(new c(dVar));
        }
    }

    @Override // b.c.a.c.c.b
    public void onSuccess(b.c.a.j.d<T> dVar) {
        g(new a(dVar));
    }
}
