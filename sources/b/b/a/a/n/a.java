package b.b.a.a.n;

import org.json.JSONObject;
/* compiled from: AbstractSampling.java */
/* loaded from: classes.dex */
public abstract class a<T extends JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    protected int f960a;

    public a(int i) {
        this.f960a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        try {
            Integer valueOf = Integer.valueOf(t.getInt("sampling"));
            if (valueOf != null) {
                this.f960a = valueOf.intValue();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(int i) {
        return i < this.f960a;
    }
}
