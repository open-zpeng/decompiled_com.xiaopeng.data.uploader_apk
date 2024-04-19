package b.b.a.a.n;

import b.b.a.a.i;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmSampling.java */
/* loaded from: classes.dex */
public class f extends g {
    String e;
    private int f;
    private int g;

    public f(i.g gVar, int i) {
        super(gVar, i);
        this.e = "AlarmSampling";
        this.f = 0;
        this.g = 0;
        this.f = i;
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.b.a.a.n.a
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.f960a;
        this.f = i;
        this.g = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.g = valueOf2.intValue();
            }
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.n.g
    public /* bridge */ /* synthetic */ boolean c(int i, String str, String str2, Map map) {
        return super.c(i, str, str2, map);
    }

    @Override // b.b.a.a.n.g
    public void d(JSONObject jSONObject) {
        a(jSONObject);
        e(jSONObject);
        this.f970c.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("module");
                    if (b.b.a.a.p.b.a(string)) {
                        h hVar = this.f970c.get(string);
                        if (hVar == null) {
                            hVar = new d(string, this.f, this.g);
                            this.f970c.put(string, hVar);
                        }
                        hVar.d(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.n.g
    public void f(int i) {
        super.f(i);
        this.f = i;
        this.g = i;
    }

    public boolean g(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        h hVar;
        String str3 = this.e;
        b.b.a.b.f.i.c(str3, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f), "failSampling:" + this.g);
        Map<String, h> map2 = this.f970c;
        if (map2 == null || (hVar = map2.get(str)) == null || !(hVar instanceof d)) {
            return bool.booleanValue() ? i < this.f : i < this.g;
        }
        return ((d) hVar).e(i, str2, bool, map);
    }
}
