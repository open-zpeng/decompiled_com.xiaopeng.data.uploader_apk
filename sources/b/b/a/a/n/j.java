package b.b.a.a.n;

import android.content.Context;
import b.b.a.a.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* compiled from: SampleRules.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f976a = null;

    /* renamed from: b  reason: collision with root package name */
    private static j f977b;

    /* renamed from: c  reason: collision with root package name */
    private Map<i.g, g> f978c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private int f979d;
    private String e;

    private j() {
        i.g[] values;
        for (i.g gVar : i.g.values()) {
            if (gVar == i.g.ALARM) {
                this.f978c.put(gVar, new f(gVar, gVar.e()));
            } else {
                this.f978c.put(gVar, new g(gVar, gVar.e()));
            }
        }
    }

    public static j a() {
        if (f977b == null) {
            synchronized (j.class) {
                if (f977b == null) {
                    f977b = new j();
                }
            }
        }
        return f977b;
    }

    public static boolean d(i.g gVar, String str, String str2) {
        return a().h(gVar, str, str2, null);
    }

    public static boolean e(i.g gVar, String str, String str2, Map<String, String> map) {
        return a().h(gVar, str, str2, map);
    }

    public static boolean f(String str, String str2, Boolean bool, Map<String, String> map) {
        return a().i(str, str2, bool, map);
    }

    public void b(Context context) {
        j();
    }

    public void c(i.g gVar, int i) {
        g gVar2 = this.f978c.get(gVar);
        if (gVar2 != null) {
            gVar2.f(i);
        }
    }

    public void g(String str) {
        String str2;
        i.g[] values;
        b.b.a.b.f.i.c("SampleRules", "config:", str);
        synchronized (this) {
            if (!b.b.a.a.p.b.b(str) && ((str2 = this.e) == null || !str2.equals(str))) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    for (i.g gVar : i.g.values()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(gVar.toString());
                        g gVar2 = this.f978c.get(gVar);
                        if (optJSONObject != null && gVar2 != null) {
                            b.b.a.b.f.i.c(f976a, gVar, optJSONObject);
                            gVar2.d(optJSONObject);
                        }
                    }
                    this.e = str;
                } catch (Throwable unused) {
                }
            }
        }
    }

    public boolean h(i.g gVar, String str, String str2, Map<String, String> map) {
        g gVar2 = this.f978c.get(gVar);
        if (gVar2 != null) {
            return gVar2.c(this.f979d, str, str2, map);
        }
        return false;
    }

    public boolean i(String str, String str2, Boolean bool, Map<String, String> map) {
        g gVar = this.f978c.get(i.g.ALARM);
        if (gVar == null || !(gVar instanceof f)) {
            return false;
        }
        return ((f) gVar).g(this.f979d, str, str2, bool, map);
    }

    public void j() {
        this.f979d = new Random(System.currentTimeMillis()).nextInt(com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.r);
    }
}
