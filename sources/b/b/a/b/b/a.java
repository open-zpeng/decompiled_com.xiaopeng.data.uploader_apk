package b.b.a.b.b;

import android.text.TextUtils;
import b.b.a.b.f.i;
import b.b.a.b.g.b;
import java.util.List;
/* compiled from: CoreStatics.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f1019a;

    /* renamed from: b  reason: collision with root package name */
    private static long f1020b;

    /* renamed from: c  reason: collision with root package name */
    private static long f1021c;

    /* renamed from: d  reason: collision with root package name */
    private static int f1022d;
    private static long e;
    private static long f;
    private static int g;
    private static long h;
    private static long i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static long r;
    private static long s;
    private static StringBuilder t = new StringBuilder();

    public static synchronized void a() {
        synchronized (a.class) {
            n++;
        }
    }

    public static synchronized void b() {
        synchronized (a.class) {
            o++;
        }
    }

    public static synchronized void c() {
        synchronized (a.class) {
            g++;
            if (f1019a == 0 && f1021c == 0) {
                return;
            }
            if (b.b.a.b.a.f1003c || g >= 6) {
                e(true);
            }
        }
    }

    public static synchronized void d(List<b> list, int i2) {
        synchronized (a.class) {
            if (list == null) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                b bVar = list.get(i4);
                if (bVar != null) {
                    if (!"6005".equalsIgnoreCase(bVar.f1095b)) {
                        i3++;
                    }
                    t.append(bVar.f);
                    if (i4 != list.size() - 1) {
                        t.append(",");
                    }
                }
            }
            i.c("CoreStatics", "[uploadInc]:", Long.valueOf(f1021c), "count:", Integer.valueOf(i2));
            long j2 = f1021c + i2;
            f1021c = j2;
            i.c("CoreStatics", "[uploadInc]:", Long.valueOf(j2));
            if (i3 != i2) {
                i.a("CoreStatics", "Mutil Process Upload Error");
            }
        }
    }

    @Deprecated
    public static synchronized void e(boolean z) {
        synchronized (a.class) {
        }
    }

    public static synchronized void f(int i2) {
        synchronized (a.class) {
            f1022d += i2;
        }
    }

    private static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }

    public static synchronized void h(String str) {
        synchronized (a.class) {
            if (g(str)) {
                return;
            }
            if ("65501".equalsIgnoreCase(str)) {
                s++;
            } else if ("65133".equalsIgnoreCase(str)) {
                q++;
            } else if ("65502".equalsIgnoreCase(str)) {
                r++;
            } else if ("65503".equalsIgnoreCase(str)) {
                p++;
            }
            f1019a++;
        }
    }

    public static synchronized void i(String str) {
        synchronized (a.class) {
            if (g(str)) {
                return;
            }
            f1020b++;
        }
    }

    public static synchronized void j() {
        synchronized (a.class) {
            e++;
        }
    }

    public static synchronized void k() {
        synchronized (a.class) {
            f++;
        }
    }

    public static synchronized void l() {
        synchronized (a.class) {
            h++;
        }
    }

    public static synchronized void m() {
        synchronized (a.class) {
            i++;
        }
    }

    public static synchronized void n() {
        synchronized (a.class) {
            j++;
        }
    }

    public static synchronized void o() {
        synchronized (a.class) {
            k++;
        }
    }

    public static synchronized void p() {
        synchronized (a.class) {
            l++;
        }
    }

    public static synchronized void q() {
        synchronized (a.class) {
            m++;
        }
    }
}
