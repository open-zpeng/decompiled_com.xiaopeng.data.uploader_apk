package b.b.a.a.o;

import b.b.a.b.f.i;
import b.b.a.b.f.t;
import java.util.Map;
/* compiled from: UTAggregationPlugin.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f980a = null;

    /* renamed from: b  reason: collision with root package name */
    private static a f981b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f981b == null) {
                f981b = new a();
            }
            aVar = f981b;
        }
        return aVar;
    }

    public void b(Map<String, String> map) {
        if (map == null) {
            return;
        }
        i.c(f980a, "[sendToUT]:", " args:", map);
        if (b.b.a.b.a.g) {
            b.b.a.b.a.d(map.get(b.b.a.b.g.a.PAGE.toString()), map.get(b.b.a.b.g.a.EVENTID.toString()), map.get(b.b.a.b.g.a.ARG1.toString()), map.get(b.b.a.b.g.a.ARG2.toString()), map.get(b.b.a.b.g.a.ARG3.toString()), map);
            return;
        }
        map.put("_fuamf", "yes");
        t.a(map);
    }
}
