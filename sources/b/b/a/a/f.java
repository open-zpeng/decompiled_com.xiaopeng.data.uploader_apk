package b.b.a.a;

import java.util.HashMap;
import java.util.Map;
/* compiled from: SdkMeta.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f919a;

    static {
        HashMap hashMap = new HashMap();
        f919a = hashMap;
        hashMap.put("sdk-version", "2.6.4.10_for_bc");
    }

    public static Map<String, String> a() {
        b.b.a.b.a.j();
        Map<String, String> map = f919a;
        if (!map.containsKey("sdk-version")) {
            map.put("sdk-version", "2.6.4.10_for_bc");
        }
        return map;
    }
}
