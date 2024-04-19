package c.a.p.e.a;
/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes.dex */
public final class e<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    private final c.a.o.e<? super c.a.m.b> f1494c;

    /* renamed from: d  reason: collision with root package name */
    private final c.a.o.a f1495d;

    public e(c.a.e<T> eVar, c.a.o.e<? super c.a.m.b> eVar2, c.a.o.a aVar) {
        super(eVar);
        this.f1494c = eVar2;
        this.f1495d = aVar;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        this.f1474b.a(new c.a.p.d.d(iVar, this.f1494c, this.f1495d));
    }
}
