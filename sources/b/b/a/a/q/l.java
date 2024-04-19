package b.b.a.a.q;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* compiled from: UTDimensionValueSet.java */
/* loaded from: classes.dex */
public class l extends d {

    /* renamed from: c  reason: collision with root package name */
    private static final Set<b.b.a.b.g.a> f1000c = new a();

    /* compiled from: UTDimensionValueSet.java */
    /* loaded from: classes.dex */
    static class a extends HashSet<b.b.a.b.g.a> {
        a() {
            add(b.b.a.b.g.a.PAGE);
            add(b.b.a.b.g.a.ARG1);
            add(b.b.a.b.g.a.ARG2);
            add(b.b.a.b.g.a.ARG3);
            add(b.b.a.b.g.a.ARGS);
        }
    }

    @Override // b.b.a.a.q.d, b.b.a.a.l.b
    public void a() {
        super.a();
    }

    @Override // b.b.a.a.q.d, b.b.a.a.l.b
    public void b(Object... objArr) {
        super.b(objArr);
    }

    public Integer k() {
        int i;
        String str;
        Map<String, String> map = this.f985b;
        if (map != null && (str = map.get(b.b.a.b.g.a.EVENTID.toString())) != null) {
            try {
                i = b.b.a.a.p.a.a(str);
            } catch (NumberFormatException unused) {
            }
            return Integer.valueOf(i);
        }
        i = 0;
        return Integer.valueOf(i);
    }
}
