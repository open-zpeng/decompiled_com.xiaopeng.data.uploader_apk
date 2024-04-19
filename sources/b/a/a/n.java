package b.a.a;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class n extends v {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.b.h<String, v> f888a = new b.a.a.b.h<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f888a.equals(this.f888a));
    }

    public void h(String str, v vVar) {
        if (vVar == null) {
            vVar = m.f887a;
        }
        this.f888a.put(str, vVar);
    }

    public int hashCode() {
        return this.f888a.hashCode();
    }

    public Set<Map.Entry<String, v>> i() {
        return this.f888a.entrySet();
    }
}
