package b.b.a.a.n;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: AlarmMonitorPointSampling.java */
/* loaded from: classes.dex */
public class e extends i {

    /* renamed from: d  reason: collision with root package name */
    private int f968d;
    private int e;

    public e(String str, int i, int i2) {
        super(str, 0);
        this.f968d = i;
        this.e = i2;
    }

    @Override // b.b.a.a.n.i
    public /* bridge */ /* synthetic */ boolean c(int i, Map map) {
        return super.c(i, map);
    }

    @Override // b.b.a.a.n.i
    public void d(JSONObject jSONObject) {
        super.d(jSONObject);
        int i = this.f960a;
        this.f968d = i;
        this.e = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f968d = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.e = valueOf2.intValue();
            }
            b.b.a.b.f.i.c("AlarmMonitorPointSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling", valueOf2);
        } catch (Exception unused) {
        }
    }

    public boolean e(int i, Boolean bool, Map<String, String> map) {
        b.b.a.b.f.i.c("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f968d), "failSampling:", Integer.valueOf(this.e));
        List<c> list = this.f975c;
        if (list != null && map != null) {
            for (c cVar : list) {
                Boolean c2 = cVar.c(i, map);
                if (c2 != null) {
                    return c2.booleanValue();
                }
            }
        }
        return f(i, bool.booleanValue());
    }

    protected boolean f(int i, boolean z) {
        return z ? i < this.f968d : i < this.e;
    }
}
