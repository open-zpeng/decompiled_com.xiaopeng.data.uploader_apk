package b.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class j extends v implements Iterable<v> {

    /* renamed from: b  reason: collision with root package name */
    private final List<v> f886b = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof j) && ((j) obj).f886b.equals(this.f886b));
    }

    public void h(v vVar) {
        if (vVar == null) {
            vVar = m.f887a;
        }
        this.f886b.add(vVar);
    }

    public int hashCode() {
        return this.f886b.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<v> iterator() {
        return this.f886b.iterator();
    }
}
