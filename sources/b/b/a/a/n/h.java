package b.b.a.a.n;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModuleSampling.java */
/* loaded from: classes.dex */
public class h extends a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    private String f972b;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, i> f973c;

    public h(String str, int i) {
        super(i);
        this.f972b = str;
        this.f973c = new HashMap();
    }

    public boolean c(int i, String str, Map<String, String> map) {
        i iVar;
        Map<String, i> map2 = this.f973c;
        if (map2 != null && (iVar = map2.get(str)) != null) {
            return iVar.c(i, map);
        }
        return b(i);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("monitorPoints");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("monitorPoint");
                    String optString2 = jSONObject2.optString("metric_comment_detail");
                    if (b.b.a.a.p.b.a(optString)) {
                        i iVar = this.f973c.get(optString);
                        if (iVar == null) {
                            iVar = new i(optString, this.f960a);
                            this.f973c.put(optString, iVar);
                        }
                        iVar.d(jSONObject2);
                        b.b.a.a.q.i b2 = b.b.a.a.q.j.c().b(this.f972b, optString);
                        if (b2 != null) {
                            b2.k(optString2);
                        }
                        Object opt = jSONObject2.opt("measures");
                        if (opt instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) opt;
                            b.b.a.a.q.f c2 = b.b.a.a.q.f.c();
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                                if (jSONObject3 != null) {
                                    String optString3 = jSONObject3.optString("name");
                                    Double valueOf = Double.valueOf(jSONObject3.optDouble("min"));
                                    Double valueOf2 = Double.valueOf(jSONObject3.optDouble("max"));
                                    if (optString3 != null && valueOf != null && valueOf2 != null) {
                                        c2.b(new b.b.a.a.q.e(optString3, Double.valueOf(0.0d), valueOf, valueOf2));
                                    }
                                }
                            }
                            b.b.a.a.q.i b3 = b.b.a.a.q.j.c().b("config_prefix" + this.f972b, "config_prefix" + optString);
                            if (b3 != null) {
                                b.b.a.a.q.j.c().d(b3);
                            }
                            b.b.a.a.q.j.c().a(new b.b.a.a.q.a("config_prefix" + this.f972b, "config_prefix" + optString, c2));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
