package b.b.a.a.n;

import b.b.a.a.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventTypeSampling.java */
/* loaded from: classes.dex */
public class g extends a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    private i.g f969b;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, h> f970c;

    /* renamed from: d  reason: collision with root package name */
    protected int f971d;

    public g(i.g gVar, int i) {
        super(i);
        this.f971d = -1;
        this.f969b = gVar;
        this.f970c = Collections.synchronizedMap(new HashMap());
    }

    public boolean c(int i, String str, String str2, Map<String, String> map) {
        h hVar;
        Map<String, h> map2 = this.f970c;
        if (map2 == null || (hVar = map2.get(str)) == null) {
            return i < this.f960a;
        }
        return hVar.c(i, str2, map);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        e(jSONObject);
        this.f970c.clear();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("metrics");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("module");
                    if (b.b.a.a.p.b.a(optString)) {
                        h hVar = this.f970c.get(optString);
                        if (hVar == null) {
                            hVar = new h(optString, this.f960a);
                            this.f970c.put(optString, hVar);
                        }
                        hVar.d(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(JSONObject jSONObject) {
        i.g gVar;
        b.b.a.b.f.i.c("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("cacheCount");
            if (optInt <= 0 || (gVar = this.f969b) == null) {
                return;
            }
            gVar.b(optInt);
        } catch (Throwable th) {
            b.b.a.b.f.i.b("EventTypeSampling", "updateTriggerCount", th);
        }
    }

    public void f(int i) {
        this.f960a = i;
    }
}
