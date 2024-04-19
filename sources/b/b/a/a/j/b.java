package b.b.a.a.j;

import android.content.Context;
import b.b.a.a.f;
import b.b.a.a.i;
import b.b.a.a.l.d;
import b.b.a.a.l.e;
import b.b.a.a.p.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* compiled from: ExceptionEventBuilder.java */
/* loaded from: classes.dex */
public class b {
    private static String a(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
            }
        }
        String sb2 = sb.toString();
        return b.b.a.a.p.b.b(sb2) ? th.toString() : sb2;
    }

    private static JSONObject b(Context context, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) b.b.a.a.l.a.a().b(e.class, new Object[0]);
        if (context != null) {
            try {
                jSONObject.put("pname", b.b.a.b.f.b.a(context));
            } catch (Exception unused) {
            }
        }
        jSONObject.put("page", "APPMONITOR");
        jSONObject.put("monitorPoint", "sdk-exception");
        jSONObject.put("arg", th.getClass().getSimpleName());
        jSONObject.put("successCount", 0);
        jSONObject.put("failCount", 1);
        ArrayList arrayList = new ArrayList();
        String a2 = a(th);
        if (a2 != null) {
            JSONObject jSONObject2 = (JSONObject) b.b.a.a.l.a.a().b(e.class, new Object[0]);
            jSONObject2.put("errorCode", a2);
            jSONObject2.put("errorCount", 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", arrayList);
        return jSONObject;
    }

    public static void c(Context context, Throwable th) {
        if (th != null) {
            try {
                i.C0036i c0036i = (i.C0036i) b.b.a.a.l.a.a().b(i.C0036i.class, new Object[0]);
                i.g gVar = i.g.ALARM;
                c0036i.f946c = gVar.a();
                HashMap hashMap = new HashMap();
                hashMap.put("meta", f.a());
                d dVar = (d) b.b.a.a.l.a.a().b(d.class, new Object[0]);
                dVar.put(b(context, th));
                hashMap.put("data", dVar);
                c0036i.g.put(gVar.m0a(), new JSONObject(hashMap).toString());
                c0036i.f947d = "APPMONITOR";
                c0036i.e = "sdk-exception";
                c.a(c0036i);
                b.b.a.a.l.a.a().d(dVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void d(Throwable th) {
        c(null, th);
    }
}
