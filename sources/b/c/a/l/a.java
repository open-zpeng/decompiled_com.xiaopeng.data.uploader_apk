package b.c.a.l;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;
/* compiled from: HeaderParser.java */
/* loaded from: classes.dex */
public class a {
    public static <T> void a(b.c.a.k.d.d dVar, b.c.a.c.a<T> aVar, b.c.a.c.b bVar) {
        b.c.a.j.a f;
        if (aVar == null || bVar != b.c.a.c.b.DEFAULT || (f = aVar.f()) == null) {
            return;
        }
        String c2 = f.c(HttpHeaders.ETAG);
        if (c2 != null) {
            dVar.u("If-None-Match", c2);
        }
        long h = b.c.a.j.a.h(f.c(HttpHeaders.LAST_MODIFIED));
        if (h > 0) {
            dVar.u("If-Modified-Since", b.c.a.j.a.b(h));
        }
    }

    public static <T> b.c.a.c.a<T> b(Headers headers, T t, b.c.a.c.b bVar, String str) {
        long currentTimeMillis;
        long j;
        if (bVar == b.c.a.c.b.DEFAULT) {
            long f = b.c.a.j.a.f(headers.get(HttpHeaders.DATE));
            currentTimeMillis = b.c.a.j.a.g(headers.get(HttpHeaders.EXPIRES));
            String e = b.c.a.j.a.e(headers.get(HttpHeaders.CACHE_CONTROL), headers.get("Pragma"));
            if (TextUtils.isEmpty(e) && currentTimeMillis <= 0) {
                return null;
            }
            if (TextUtils.isEmpty(e)) {
                j = 0;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(e, ",");
                j = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.equals("no-cache") || lowerCase.equals("no-store")) {
                        return null;
                    }
                    if (lowerCase.startsWith("max-age=")) {
                        try {
                            j = Long.parseLong(lowerCase.substring(8));
                            if (j <= 0) {
                                return null;
                            }
                        } catch (Exception e2) {
                            d.a(e2);
                        }
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (f <= 0) {
                f = currentTimeMillis2;
            }
            if (j > 0) {
                currentTimeMillis = f + (j * 1000);
            } else if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        b.c.a.j.a aVar = new b.c.a.j.a();
        for (String str2 : headers.names()) {
            aVar.m(str2, headers.get(str2));
        }
        b.c.a.c.a<T> aVar2 = new b.c.a.c.a<>();
        aVar2.k(str);
        aVar2.i(t);
        aVar2.l(currentTimeMillis);
        aVar2.m(aVar);
        return aVar2;
    }
}
