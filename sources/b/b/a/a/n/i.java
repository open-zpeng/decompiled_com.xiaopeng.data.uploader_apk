package b.b.a.a.n;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: MonitorPointSampling.java */
/* loaded from: classes.dex */
class i extends a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    private String f974b;

    /* renamed from: c  reason: collision with root package name */
    protected List<c> f975c;

    public i(String str, int i) {
        super(i);
        this.f974b = str;
    }

    public boolean c(int i, Map<String, String> map) {
        List<c> list = this.f975c;
        if (list != null && map != null) {
            for (c cVar : list) {
                Boolean c2 = cVar.c(i, map);
                if (c2 != null) {
                    return c2.booleanValue();
                }
            }
        }
        return b(i);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("extra");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    c cVar = new c(this.f960a);
                    if (this.f975c == null) {
                        this.f975c = new ArrayList();
                    }
                    this.f975c.add(cVar);
                    cVar.d(jSONObject2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
