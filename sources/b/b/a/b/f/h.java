package b.b.a.b.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* compiled from: LogAssemble.java */
/* loaded from: classes.dex */
public class h {
    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(b.b.a.b.g.a.PAGE.toString(), str);
        }
        hashMap.put(b.b.a.b.g.a.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(b.b.a.b.g.a.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(b.b.a.b.g.a.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(b.b.a.b.g.a.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(b.b.a.b.g.a.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(b.b.a.b.g.a.RESERVE3.toString(), str6);
        }
        return e(hashMap);
    }

    public static String b(Map<String, String> map) {
        boolean z;
        b.b.a.b.g.a aVar;
        StringBuilder sb = new StringBuilder();
        b.b.a.b.g.a[] values = b.b.a.b.g.a.values();
        int length = values.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length || (aVar = values[i]) == b.b.a.b.g.a.ARGS) {
                break;
            }
            if (map.containsKey(aVar.toString())) {
                str = map.get(aVar.toString()) + "";
                map.remove(aVar.toString());
            }
            sb.append(d(str));
            sb.append("||");
            i++;
        }
        b.b.a.b.g.a aVar2 = b.b.a.b.g.a.ARGS;
        if (map.containsKey(aVar2.toString())) {
            sb.append(d(map.get(aVar2.toString()) + ""));
            map.remove(aVar2.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str2 : map.keySet()) {
            String str3 = map.containsKey(str2) ? map.get(str2) + "" : null;
            if (z) {
                if ("StackTrace".equals(str2)) {
                    sb.append("StackTrace=====>");
                    sb.append(str3);
                } else {
                    sb.append(d(str2));
                    sb.append("=");
                    sb.append(str3);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                sb.append(",");
                sb.append("StackTrace=====>");
                sb.append(str3);
            } else {
                sb.append(",");
                sb.append(d(str2));
                sb.append("=");
                sb.append(str3);
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2) || !sb2.endsWith("||")) {
            return sb2;
        }
        return sb2 + "-";
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            String g = b.g();
            if (!TextUtils.isEmpty(g)) {
                b.b.a.b.g.a aVar = b.b.a.b.g.a.USERNICK;
                if (!map.containsKey(aVar.toString())) {
                    map.put(aVar.toString(), g);
                }
            }
            String d2 = b.d();
            if (!TextUtils.isEmpty(d2)) {
                b.b.a.b.g.a aVar2 = b.b.a.b.g.a.LL_USERNICK;
                if (!map.containsKey(aVar2.toString())) {
                    map.put(aVar2.toString(), d2);
                }
            }
            String h = b.h();
            if (!TextUtils.isEmpty(h)) {
                b.b.a.b.g.a aVar3 = b.b.a.b.g.a.USERID;
                if (!map.containsKey(aVar3.toString())) {
                    map.put(aVar3.toString(), h);
                }
            }
            String e = b.e();
            if (!TextUtils.isEmpty(e)) {
                b.b.a.b.g.a aVar4 = b.b.a.b.g.a.LL_USERID;
                if (!map.containsKey(aVar4.toString())) {
                    map.put(aVar4.toString(), e);
                }
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            b.b.a.b.g.a aVar5 = b.b.a.b.g.a.RECORD_TIMESTAMP;
            if (!map.containsKey(aVar5.toString())) {
                map.put(aVar5.toString(), valueOf);
            }
            b.b.a.b.g.a aVar6 = b.b.a.b.g.a.START_SESSION_TIMESTAMP;
            if (!map.containsKey(aVar6.toString())) {
                map.put(aVar6.toString(), String.valueOf(b.b.a.b.a.e));
            }
            Map<String, String> a2 = d.a(b.b.a.b.a.j());
            if (a2 != null) {
                for (String str : a2.keySet()) {
                    String str2 = a2.get(str);
                    if (!TextUtils.isEmpty(str2) && !map.containsKey(str) && !map.containsKey(str)) {
                        map.put(str, str2);
                    }
                }
            }
            String f = f(map);
            if (!TextUtils.isEmpty(f)) {
                b.b.a.b.g.a aVar7 = b.b.a.b.g.a.RESERVES;
                if (!map.containsKey(aVar7.toString())) {
                    map.put(aVar7.toString(), f);
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    private static String d(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static String e(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        c(map);
        return b(map);
    }

    private static String f(Map<String, String> map) {
        String str = "_ap=1";
        if ("y".equalsIgnoreCase(map.get(b.b.a.b.g.a.OS.toString()))) {
            String j = d.j();
            if (!TextUtils.isEmpty(j)) {
                str = "_ap=1,_did=" + j;
            }
        }
        String str2 = map.get(b.b.a.b.g.a.APPKEY.toString());
        if (TextUtils.isEmpty(b.c()) || TextUtils.isEmpty(str2) || b.c().equalsIgnoreCase(str2)) {
            return str;
        }
        return str + ",_mak=" + b.c();
    }
}
