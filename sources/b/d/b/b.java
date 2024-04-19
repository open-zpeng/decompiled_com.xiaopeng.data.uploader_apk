package b.d.b;
/* compiled from: InitEventHolder.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f1269a = new b();

    /* renamed from: b  reason: collision with root package name */
    private a f1270b;

    public static a b() {
        return f1269a;
    }

    public static void c(a aVar) {
        f1269a.f1270b = aVar;
    }

    @Override // b.d.b.a
    public void a(int i, String str) {
        a aVar = this.f1270b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }
}
