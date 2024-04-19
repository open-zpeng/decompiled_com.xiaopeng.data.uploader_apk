package b.b.a.a;

import android.app.Application;
import android.text.TextUtils;
import b.b.a.a.i;
import b.b.a.a.n.j;
import b.b.a.b.a;
import b.b.a.b.f.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: AppMonitorDelegate.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f913a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Application f914b = null;

    /* renamed from: c  reason: collision with root package name */
    static volatile boolean f915c = false;

    /* compiled from: AppMonitorDelegate.java */
    /* loaded from: classes.dex */
    public static class a {
        @Deprecated
        public static boolean a(String str, String str2) {
            return j.d(i.g.ALARM, str, str2);
        }

        public static void b(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    b.b.a.b.b.a.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("_status", "0");
                    if (b.f915c && a.b.i()) {
                        i.g gVar = i.g.ALARM;
                        if (gVar.isOpen() && (b.f913a || j.f(str, str2, Boolean.FALSE, hashMap))) {
                            b.b.a.b.f.i.c("AppMonitorDelegate", "commitFail module:", str, " monitorPoint:", str2, " errorCode:", str4, "errorMsg:", str5);
                            b.b.a.b.b.a.b();
                            i.f.b().i(gVar.a(), str, str2, str3, str4, str5, map);
                            return;
                        }
                    }
                    b.b.a.b.f.i.a("log discard !", "");
                    return;
                }
                b.b.a.b.f.i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        public static void c(String str, String str2, String str3, String str4, Map<String, String> map) {
            b(str, str2, null, str3, str4, map);
        }

        public static void d(String str, String str2, String str3, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    b.b.a.b.b.a.a();
                    if (b.f915c && a.b.i()) {
                        i.g gVar = i.g.ALARM;
                        if (gVar.isOpen() && (b.f913a || j.f(str, str2, Boolean.TRUE, null))) {
                            b.b.a.b.f.i.c("AppMonitorDelegate", "commitSuccess module:", str, " monitorPoint:", str2);
                            b.b.a.b.b.a.b();
                            i.f.b().j(gVar.a(), str, str2, str3, map);
                            return;
                        }
                    }
                    b.b.a.b.f.i.a("log discard !", "");
                    return;
                }
                b.b.a.b.f.i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        public static void e(String str, String str2, Map<String, String> map) {
            d(str, str2, null, map);
        }

        public static void f(int i) {
            j.a().c(i.g.ALARM, i);
        }

        public static void g(int i) {
            i.g gVar = i.g.ALARM;
            gVar.setStatisticsInterval(i);
            b.l(gVar, i);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: b.b.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034b {
        @Deprecated
        public static boolean a(String str, String str2) {
            return j.d(i.g.COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d2, Map<String, String> map) {
            c(str, str2, null, d2, map);
        }

        public static void c(String str, String str2, String str3, double d2, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    b.b.a.b.b.a.p();
                    if (b.f915c && a.b.i()) {
                        i.g gVar = i.g.COUNTER;
                        if (gVar.isOpen()) {
                            if (b.f913a || j.d(gVar, str, str2)) {
                                b.b.a.b.f.i.c("AppMonitorDelegate", "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d2));
                                b.b.a.b.b.a.q();
                                i.f.b().h(gVar.a(), str, str2, str3, d2, map);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                b.b.a.b.f.i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        public static void d(int i) {
            j.a().c(i.g.COUNTER, i);
        }

        public static void e(int i) {
            i.g gVar = i.g.COUNTER;
            gVar.setStatisticsInterval(i);
            b.l(gVar, i);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* loaded from: classes.dex */
    public static class c {
        @Deprecated
        public static boolean a(String str, String str2) {
            return j.d(i.g.OFFLINE_COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d2) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    b.b.a.b.b.a.n();
                    if (b.f915c && a.b.i()) {
                        i.g gVar = i.g.OFFLINE_COUNTER;
                        if (gVar.isOpen()) {
                            if (b.f913a || j.d(gVar, str, str2)) {
                                b.b.a.b.f.i.c("AppMonitorDelegate", "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d2));
                                b.b.a.b.b.a.o();
                                i.f.b().h(gVar.a(), str, str2, null, d2, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                b.b.a.b.f.i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        public static void c(int i) {
            j.a().c(i.g.OFFLINE_COUNTER, i);
        }

        public static void d(int i) {
            i.g gVar = i.g.OFFLINE_COUNTER;
            gVar.setStatisticsInterval(i);
            b.l(gVar, i);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* loaded from: classes.dex */
    public static class d {
        public static void a(String str, String str2, String str3) {
            try {
                if (b.f915c && a.b.i()) {
                    i.g gVar = i.g.STAT;
                    if (gVar.isOpen()) {
                        if (b.f913a || j.d(gVar, str, str2)) {
                            b.b.a.b.f.i.c("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                            i.f.b().l(Integer.valueOf(gVar.a()), str, str2, str3);
                        }
                    }
                }
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        @Deprecated
        public static boolean b(String str, String str2) {
            return j.d(i.g.STAT, str, str2);
        }

        public static void c(String str, String str2, double d2, Map<String, String> map) {
            d(str, str2, null, d2, map);
        }

        public static void d(String str, String str2, b.b.a.a.q.d dVar, double d2, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    b.b.a.b.b.a.l();
                    if (b.f915c && a.b.i()) {
                        i.g gVar = i.g.STAT;
                        if (gVar.isOpen()) {
                            if (b.f913a || j.d(gVar, str, str2)) {
                                b.b.a.b.f.i.c("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                                b.b.a.a.q.i b2 = b.b.a.a.q.j.c().b(str, str2);
                                b.b.a.b.b.a.m();
                                if (b2 != null) {
                                    List<b.b.a.a.q.e> e = b2.e().e();
                                    if (e.size() == 1) {
                                        e(str, str2, dVar, ((b.b.a.a.q.h) b.b.a.a.l.a.a().b(b.b.a.a.q.h.class, new Object[0])).i(e.get(0).d(), d2), map);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                b.b.a.b.f.i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
            if (b.b.a.a.n.j.e(r1, r11, r12, r13 != null ? r13.g() : null) != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void e(java.lang.String r11, java.lang.String r12, b.b.a.a.q.d r13, b.b.a.a.q.h r14, java.util.Map<java.lang.String, java.lang.String> r15) {
            /*
                boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L7d
                if (r1 != 0) goto L75
                boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto Le
                goto L75
            Le:
                b.b.a.b.b.a.l()     // Catch: java.lang.Throwable -> L7d
                boolean r1 = b.b.a.a.b.f915c     // Catch: java.lang.Throwable -> L7d
                r2 = 3
                java.lang.String r3 = " monitorPoint: "
                r5 = 2
                r6 = 1
                r7 = 0
                r8 = 4
                if (r1 == 0) goto L63
                boolean r1 = b.b.a.b.a.b.i()     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto L63
                b.b.a.a.i$g r1 = b.b.a.a.i.g.STAT     // Catch: java.lang.Throwable -> L7d
                boolean r9 = r1.isOpen()     // Catch: java.lang.Throwable -> L7d
                if (r9 == 0) goto L63
                boolean r9 = b.b.a.a.b.f913a     // Catch: java.lang.Throwable -> L7d
                if (r9 != 0) goto L3c
                if (r13 == 0) goto L35
                java.util.Map r9 = r13.g()     // Catch: java.lang.Throwable -> L7d
                goto L36
            L35:
                r9 = 0
            L36:
                boolean r9 = b.b.a.a.n.j.e(r1, r11, r12, r9)     // Catch: java.lang.Throwable -> L7d
                if (r9 == 0) goto L63
            L3c:
                java.lang.String r9 = "statEvent commit success"
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
                java.lang.String r10 = "statEvent commit. module: "
                r8[r7] = r10     // Catch: java.lang.Throwable -> L7d
                r8[r6] = r11     // Catch: java.lang.Throwable -> L7d
                r8[r5] = r3     // Catch: java.lang.Throwable -> L7d
                r8[r2] = r12     // Catch: java.lang.Throwable -> L7d
                b.b.a.b.f.i.c(r9, r8)     // Catch: java.lang.Throwable -> L7d
                b.b.a.b.b.a.m()     // Catch: java.lang.Throwable -> L7d
                b.b.a.a.i$f r2 = b.b.a.a.i.f.b()     // Catch: java.lang.Throwable -> L7d
                int r3 = r1.a()     // Catch: java.lang.Throwable -> L7d
                r1 = r2
                r2 = r3
                r3 = r11
                r4 = r12
                r5 = r14
                r6 = r13
                r7 = r15
                r1.g(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7d
                goto L81
            L63:
                java.lang.String r1 = "statEvent commit failed,log discard"
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
                java.lang.String r9 = " ,. module: "
                r8[r7] = r9     // Catch: java.lang.Throwable -> L7d
                r8[r6] = r11     // Catch: java.lang.Throwable -> L7d
                r8[r5] = r3     // Catch: java.lang.Throwable -> L7d
                r8[r2] = r12     // Catch: java.lang.Throwable -> L7d
                b.b.a.b.f.i.c(r1, r8)     // Catch: java.lang.Throwable -> L7d
                goto L81
            L75:
                java.lang.String r0 = "AppMonitorDelegate"
                java.lang.String r1 = "module & monitorPoint must not null"
                b.b.a.b.f.i.a(r0, r1)     // Catch: java.lang.Throwable -> L7d
                return
            L7d:
                r0 = move-exception
                b.b.a.a.j.b.d(r0)
            L81:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.b.d.e(java.lang.String, java.lang.String, b.b.a.a.q.d, b.b.a.a.q.h, java.util.Map):void");
        }

        public static void f(String str, String str2, String str3) {
            try {
                if (b.f915c && a.b.i()) {
                    i.g gVar = i.g.STAT;
                    if (gVar.isOpen()) {
                        if (b.f913a || j.d(gVar, str, str2)) {
                            b.b.a.b.f.i.c("AppMonitorDelegate", "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                            i.f.b().o(str, str2, str3);
                        }
                    }
                }
            } catch (Throwable th) {
                b.b.a.a.j.b.d(th);
            }
        }

        public static void g(int i) {
            j.a().c(i.g.STAT, i);
        }

        public static void h(int i) {
            i.g gVar = i.g.STAT;
            gVar.setStatisticsInterval(i);
            b.l(gVar, i);
        }
    }

    public static synchronized void a() {
        synchronized (b.class) {
            try {
                b.b.a.b.f.i.c("AppMonitorDelegate", "start destory");
                if (f915c) {
                    m.c();
                    m.d();
                    k.a();
                    Application application = f914b;
                    if (application != null) {
                        l.e(application.getApplicationContext());
                    }
                    f915c = false;
                }
            } finally {
            }
        }
    }

    public static void b(boolean z) {
        b.b.a.b.f.i.c("AppMonitorDelegate", "[enableLog]");
        b.b.a.b.f.i.e(z);
    }

    public static synchronized void c(Application application) {
        synchronized (b.class) {
            b.b.a.b.f.i.c("AppMonitorDelegate", "start init");
            if (!f915c) {
                f914b = application;
                b.b.a.b.a.b(application.getApplicationContext());
                k.b();
                m.e();
                i.b(application);
                l.d(application.getApplicationContext());
                f915c = true;
            }
        }
    }

    public static void d(String str, String str2, b.b.a.a.q.f fVar) {
        e(str, str2, fVar, null);
    }

    public static void e(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar) {
        f(str, str2, fVar, cVar, false);
    }

    public static void f(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar, boolean z) {
        try {
            if (f915c) {
                if (!b.b.a.a.p.b.b(str) && !b.b.a.a.p.b.b(str2)) {
                    b.b.a.a.q.j.c().a(new b.b.a.a.q.i(str, str2, fVar, cVar, z));
                    return;
                }
                b.b.a.b.f.i.c("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (f913a) {
                    throw new b.b.a.a.j.a("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            b.b.a.a.j.b.d(th);
        }
    }

    public static void g(String str, String str2, b.b.a.a.q.f fVar, boolean z) {
        f(str, str2, fVar, null, z);
    }

    public static void h(String str) {
        b.b.a.b.a.n(str);
    }

    public static void i(boolean z, String str, String str2, String str3) {
        b.b.a.b.h.b aVar;
        if (z) {
            aVar = new b.b.a.b.h.c(str, str3);
        } else {
            aVar = new b.b.a.b.h.a(str, str2, "1".equalsIgnoreCase(str3));
        }
        b.b.a.b.a.c(aVar);
        a.b.d(f914b);
    }

    public static void j(int i) {
        i.g[] values;
        b.b.a.b.f.i.c("AppMonitorDelegate", "[setSampling]");
        for (i.g gVar : i.g.values()) {
            gVar.c(i);
            j.a().c(gVar, i);
        }
    }

    public static void k(int i) {
        i.g[] values;
        for (i.g gVar : i.g.values()) {
            gVar.setStatisticsInterval(i);
            l(gVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(i.g gVar, int i) {
        try {
            if (f915c && gVar != null) {
                m.b(gVar.a(), i);
                if (i > 0) {
                    gVar.b(true);
                } else {
                    gVar.b(false);
                }
            }
        } catch (Throwable th) {
            b.b.a.a.j.b.d(th);
        }
    }

    public static synchronized void m() {
        synchronized (b.class) {
            try {
                b.b.a.b.f.i.c("AppMonitorDelegate", "triggerUpload");
                if (f915c && a.b.i()) {
                    m.c();
                }
            } finally {
            }
        }
    }

    public static void n() {
        b.b.a.b.f.i.c("AppMonitorDelegate", "[turnOffRealTimeDebug]");
    }

    public static void o(Map<String, String> map) {
        a.b.q(map);
    }
}
