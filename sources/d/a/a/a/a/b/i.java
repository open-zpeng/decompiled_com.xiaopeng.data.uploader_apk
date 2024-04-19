package d.a.a.a.a.b;
/* compiled from: SevenZMethodConfiguration.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final h f1929a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1930b;

    public i(h hVar) {
        this(hVar, null);
    }

    public h a() {
        return this.f1929a;
    }

    public Object b() {
        return this.f1930b;
    }

    public i(h hVar, Object obj) {
        this.f1929a = hVar;
        this.f1930b = obj;
        if (obj == null || c.b(hVar).a(obj)) {
            return;
        }
        throw new IllegalArgumentException("The " + hVar + " method doesn't support options of type " + obj.getClass());
    }
}
