package b.b.a.a.p;

import b.b.a.a.f;
import b.b.a.a.i;
import b.b.a.a.l.d;
import b.b.a.a.q.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: UTUtil.java */
/* loaded from: classes.dex */
public class c {
    public static void a(i.C0036i c0036i) {
        if (c0036i == null) {
            return;
        }
        b.b.a.b.a.d(c0036i.f945b, String.valueOf(c0036i.f946c), c0036i.f947d, c0036i.e, c0036i.f, c0036i.g);
        b.b.a.a.l.a.a().d(c0036i);
    }

    public static void b(l lVar, i.e eVar) {
        Integer k = lVar.k();
        if (k != null) {
            i.g a2 = i.g.a(k.intValue());
            i.C0036i c0036i = (i.C0036i) b.b.a.a.l.a.a().b(i.C0036i.class, new Object[0]);
            c0036i.f946c = 6699;
            if (lVar.g() != null) {
                c0036i.g.putAll(lVar.g());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("meta", f.a());
            hashMap.put("_event_id", k);
            d dVar = (d) b.b.a.a.l.a.a().b(d.class, new Object[0]);
            dVar.put(eVar.c());
            b.b.a.a.l.a.a().d(eVar);
            hashMap.put("data", dVar);
            c0036i.g.put(a2.m0a(), new JSONObject(hashMap).toString());
            c0036i.g.put(b.b.a.b.g.a.EVENTID.toString(), String.valueOf(6699));
            c(c0036i);
            b.b.a.a.l.a.a().d(dVar);
        }
    }

    public static void c(i.C0036i c0036i) {
        b.b.a.b.f.i.c("UTUtil", "upload without flowback. args:", c0036i.g);
        b.b.a.a.o.a.a().b(c0036i.g);
        b.b.a.a.l.a.a().d(c0036i);
    }

    public static void d(Map<l, List<i.e>> map) {
        Integer k;
        for (Map.Entry<l, List<i.e>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            l key = entry.getKey();
            List<i.e> value = entry.getValue();
            if (value.size() != 0 && (k = key.k()) != null) {
                i.g a2 = i.g.a(k.intValue());
                int i = 0;
                i.C0036i c0036i = (i.C0036i) b.b.a.a.l.a.a().b(i.C0036i.class, new Object[0]);
                c0036i.f946c = k.intValue();
                if (key.g() != null) {
                    c0036i.g.putAll(key.g());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("meta", f.a());
                d dVar = (d) b.b.a.a.l.a.a().b(d.class, new Object[0]);
                for (i.e eVar : value) {
                    dVar.put(eVar.c());
                    if (i == 0) {
                        sb.append(eVar.f928b);
                        sb2.append(eVar.f929c);
                    } else {
                        sb.append(",");
                        sb.append(eVar.f928b);
                        sb2.append(",");
                        sb2.append(eVar.f929c);
                    }
                    i++;
                    b.b.a.a.l.a.a().d(eVar);
                }
                hashMap.put("data", dVar);
                c0036i.g.put(a2.m0a(), new JSONObject(hashMap).toString());
                String sb3 = sb.toString();
                String sb4 = sb2.toString();
                c0036i.g.put(b.b.a.b.g.a.ARG1.toString(), sb3);
                c0036i.g.put(b.b.a.b.g.a.ARG2.toString(), sb4);
                c0036i.f947d = sb3;
                c0036i.e = sb4;
                c(c0036i);
                b.b.a.a.l.a.a().d(dVar);
            }
            b.b.a.a.l.a.a().d(key);
        }
    }
}
