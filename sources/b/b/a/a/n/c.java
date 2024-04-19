package b.b.a.a.n;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: AccurateSampling.java */
/* loaded from: classes.dex */
public class c extends a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    private Map<String, b> f966b;

    public c(int i) {
        super(i);
        this.f966b = new HashMap();
    }

    public Boolean c(int i, Map<String, String> map) {
        Map<String, b> map2;
        if (map == null || (map2 = this.f966b) == null) {
            return null;
        }
        for (String str : map2.keySet()) {
            if (!this.f966b.get(str).a(map.get(str))) {
                return null;
            }
        }
        return Boolean.valueOf(b(i));
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
    }
}
