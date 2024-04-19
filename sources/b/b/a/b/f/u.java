package b.b.a.b.f;

import android.content.Context;
import android.text.TextUtils;
import b.b.a.b.a;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
/* compiled from: UrlWrapper.java */
/* loaded from: classes.dex */
public class u {
    private static String a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        String str6;
        Context j = b.b.a.b.a.j();
        String c2 = b.c();
        String f = b.f();
        if (f == null) {
            f = "";
        }
        String str7 = d.a(j).get(b.b.a.b.g.a.APPVERSION.toString());
        String str8 = d.a(j).get(b.b.a.b.g.a.OS.toString());
        String str9 = d.a(j).get(b.b.a.b.g.a.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        b.b.a.b.h.b a2 = b.b.a.b.a.a();
        str5 = "1";
        String str10 = "0";
        if (!(a2 instanceof b.b.a.b.h.c)) {
            if (a2 instanceof b.b.a.b.h.a) {
                str10 = ((b.b.a.b.h.a) a2).a() ? "1" : "0";
                str5 = "0";
            } else {
                str5 = "0";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        sb.append(f);
        sb.append(str7);
        sb.append(str8);
        sb.append("2.6.4.10_for_bc");
        sb.append(str9);
        sb.append(valueOf);
        sb.append("3.0");
        sb.append(str5);
        sb.append(str3 == null ? "" : str3);
        sb.append(str4 == null ? "" : str4);
        String sign = a2.getSign(j.c(sb.toString().getBytes()));
        if (TextUtils.isEmpty(str2)) {
            str6 = "";
        } else {
            str6 = str2 + "&";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", str, str6, c(c2), c(str7), c(f), c("3.0"), c(sign), c(str9), "2.6.4.10_for_bc", str8, valueOf, "", str5, str10);
    }

    public static String b(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String a2;
        String str2;
        String str3 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            for (String str4 : g.a().b(strArr, true)) {
                str3 = str3 + str4 + j.c((byte[]) map2.get(str4));
            }
        }
        try {
            a2 = a(str, null, null, str3);
        } catch (Throwable unused) {
            a2 = a(a.b.j(), null, null, str3);
        }
        if (TextUtils.isEmpty(a.b.f)) {
            return a2;
        }
        return a2 + "&dk=" + URLEncoder.encode(str2, XmartV1Constants.UTF8_ENCODING);
    }

    private static String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, XmartV1Constants.UTF8_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
