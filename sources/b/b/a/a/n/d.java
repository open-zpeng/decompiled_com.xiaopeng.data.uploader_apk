package b.b.a.a.n;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmModuleSampling.java */
/* loaded from: classes.dex */
public class d extends h {

    /* renamed from: d  reason: collision with root package name */
    private int f967d;
    private int e;

    public d(String str, int i, int i2) {
        super(str, 0);
        int i3 = this.f960a;
        this.f967d = i3;
        this.e = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.b.a.a.n.a
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.f960a;
        this.f967d = i;
        this.e = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f967d = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.e = valueOf2.intValue();
            }
            b.b.a.b.f.i.c("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling");
        } catch (Exception unused) {
        }
    }

    @Override // b.b.a.a.n.h
    public /* bridge */ /* synthetic */ boolean c(int i, String str, Map map) {
        return super.c(i, str, map);
    }

    @Override // b.b.a.a.n.h
    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("monitorPoint");
                    if (b.b.a.a.p.b.a(string)) {
                        i iVar = this.f973c.get(string);
                        if (iVar == null) {
                            iVar = new e(string, this.f967d, this.e);
                            this.f973c.put(string, iVar);
                        }
                        iVar.d(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean e(int i, String str, Boolean bool, Map<String, String> map) {
        i iVar;
        b.b.a.b.f.i.c("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f967d), "failSampling:", Integer.valueOf(this.e));
        Map<String, i> map2 = this.f973c;
        if (map2 != null && (iVar = map2.get(str)) != null && (iVar instanceof e)) {
            return ((e) iVar).e(i, bool, map);
        }
        return f(i, bool.booleanValue());
    }

    protected boolean f(int i, boolean z) {
        return z ? i < this.f967d : i < this.e;
    }
}
