package b.b.a.a.l;

import org.json.JSONArray;
/* compiled from: ReuseJSONArray.java */
/* loaded from: classes.dex */
public class d extends JSONArray implements b {
    @Override // b.b.a.a.l.b
    public void a() {
        for (int i = 0; i < length(); i++) {
            Object opt = opt(i);
            if (opt != null && (opt instanceof b)) {
                a.a().d((b) opt);
            }
        }
    }

    @Override // b.b.a.a.l.b
    public void b(Object... objArr) {
    }
}
