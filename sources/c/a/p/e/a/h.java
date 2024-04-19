package c.a.p.e.a;
/* compiled from: ObservableFromArray.java */
/* loaded from: classes.dex */
public final class h<T> extends c.a.e<T> {

    /* renamed from: b  reason: collision with root package name */
    final T[] f1498b;

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes.dex */
    static final class a<T> extends c.a.p.d.c<T> {

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1499b;

        /* renamed from: c  reason: collision with root package name */
        final T[] f1500c;

        /* renamed from: d  reason: collision with root package name */
        int f1501d;
        boolean e;
        volatile boolean f;

        a(c.a.i<? super T> iVar, T[] tArr) {
            this.f1499b = iVar;
            this.f1500c = tArr;
        }

        public boolean a() {
            return this.f;
        }

        void b() {
            T[] tArr = this.f1500c;
            int length = tArr.length;
            for (int i = 0; i < length && !a(); i++) {
                T t = tArr[i];
                if (t == null) {
                    c.a.i<? super T> iVar = this.f1499b;
                    iVar.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.f1499b.onNext(t);
            }
            if (a()) {
                return;
            }
            this.f1499b.onComplete();
        }

        @Override // c.a.p.c.c
        public void clear() {
            this.f1501d = this.f1500c.length;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f = true;
        }

        @Override // c.a.p.c.c
        public boolean isEmpty() {
            return this.f1501d == this.f1500c.length;
        }

        @Override // c.a.p.c.c
        public T poll() {
            int i = this.f1501d;
            T[] tArr = this.f1500c;
            if (i != tArr.length) {
                this.f1501d = i + 1;
                return (T) c.a.p.b.b.d(tArr[i], "The array element is null");
            }
            return null;
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.e = true;
                return 1;
            }
            return 0;
        }
    }

    public h(T[] tArr) {
        this.f1498b = tArr;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        a aVar = new a(iVar, this.f1498b);
        iVar.onSubscribe(aVar);
        if (aVar.e) {
            return;
        }
        aVar.b();
    }
}
