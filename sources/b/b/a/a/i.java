package b.b.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import b.b.a.a.q.j;
import b.b.a.a.q.l;
import b.b.a.b.a;
import b.b.a.b.f.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundTrigger.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f923b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f924c = false;

    /* renamed from: d  reason: collision with root package name */
    private Application f925d;
    private boolean e = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundTrigger.java */
    @TargetApi(14)
    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f926a;

        a(Runnable runnable) {
            this.f926a = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            s.a().i(4);
            s.a().e(4, this.f926a, 60000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            s.a().i(4);
            s.a().e(4, this.f926a, 60000L);
        }
    }

    /* compiled from: AlarmEvent.java */
    /* loaded from: classes.dex */
    public class b extends e {
        public int f = 0;
        public int g = 0;
        public Map<String, String> h;
        public Map<String, Integer> i;

        @Override // b.b.a.a.i.e, b.b.a.a.l.b
        public synchronized void a() {
            super.a();
            this.f = 0;
            this.g = 0;
            Map<String, String> map = this.h;
            if (map != null) {
                map.clear();
            }
            Map<String, Integer> map2 = this.i;
            if (map2 != null) {
                map2.clear();
            }
        }

        @Override // b.b.a.a.i.e
        public synchronized JSONObject c() {
            JSONObject c2;
            c2 = super.c();
            try {
                c2.put("successCount", this.f);
                c2.put("failCount", this.g);
                if (this.i != null) {
                    JSONArray jSONArray = (JSONArray) b.b.a.a.l.a.a().b(b.b.a.a.l.d.class, new Object[0]);
                    for (Map.Entry<String, Integer> entry : this.i.entrySet()) {
                        JSONObject jSONObject = (JSONObject) b.b.a.a.l.a.a().b(b.b.a.a.l.e.class, new Object[0]);
                        String key = entry.getKey();
                        jSONObject.put("errorCode", key);
                        jSONObject.put("errorCount", entry.getValue());
                        if (this.h.containsKey(key)) {
                            jSONObject.put("errorMsg", this.h.get(key));
                        }
                        jSONArray.put(jSONObject);
                    }
                    c2.put("errors", jSONArray);
                }
            } catch (Exception unused) {
            }
            return c2;
        }

        public synchronized void d(String str, String str2) {
            if (b.b.a.a.p.b.b(str)) {
                return;
            }
            if (this.h == null) {
                this.h = new HashMap();
            }
            if (this.i == null) {
                this.i = new HashMap();
            }
            if (b.b.a.a.p.b.a(str2)) {
                int i = 100;
                if (str2.length() <= 100) {
                    i = str2.length();
                }
                this.h.put(str, str2.substring(0, i));
            }
            if (!this.i.containsKey(str)) {
                this.i.put(str, 1);
            } else {
                Map<String, Integer> map = this.i;
                map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            }
        }

        public synchronized void e() {
            this.f++;
        }

        public synchronized void f() {
            this.g++;
        }
    }

    /* compiled from: CountEvent.java */
    /* loaded from: classes.dex */
    public class c extends e {
        public int f;
        public double g;

        @Override // b.b.a.a.i.e, b.b.a.a.l.b
        public synchronized void b(Object... objArr) {
            super.b(objArr);
            this.g = 0.0d;
            this.f = 0;
        }

        @Override // b.b.a.a.i.e
        public synchronized JSONObject c() {
            JSONObject c2;
            c2 = super.c();
            try {
                c2.put("count", this.f);
                c2.put("value", this.g);
            } catch (Exception unused) {
            }
            return c2;
        }

        public synchronized void d(double d2) {
            this.g += d2;
            this.f++;
        }
    }

    /* compiled from: DurationEvent.java */
    /* loaded from: classes.dex */
    public class d extends e {
        private static final Long f = 300000L;
        private b.b.a.a.q.i g;
        private b.b.a.a.q.h h;
        private b.b.a.a.q.d i;
        private Map<String, b.b.a.a.q.g> j;
        private Long k;

        @Override // b.b.a.a.i.e, b.b.a.a.l.b
        public void a() {
            super.a();
            this.g = null;
            this.k = null;
            for (b.b.a.a.q.g gVar : this.j.values()) {
                b.b.a.a.l.a.a().d(gVar);
            }
            this.j.clear();
            if (this.h != null) {
                b.b.a.a.l.a.a().d(this.h);
                this.h = null;
            }
            if (this.i != null) {
                b.b.a.a.l.a.a().d(this.i);
                this.i = null;
            }
        }

        @Override // b.b.a.a.i.e, b.b.a.a.l.b
        public void b(Object... objArr) {
            super.b(objArr);
            if (this.j == null) {
                this.j = new HashMap();
            }
            b.b.a.a.q.i b2 = j.c().b(this.f928b, this.f929c);
            this.g = b2;
            if (b2.d() != null) {
                this.i = (b.b.a.a.q.d) b.b.a.a.l.a.a().b(b.b.a.a.q.d.class, new Object[0]);
                this.g.d().c(this.i);
            }
            this.h = (b.b.a.a.q.h) b.b.a.a.l.a.a().b(b.b.a.a.q.h.class, new Object[0]);
        }

        public b.b.a.a.q.d d() {
            return this.i;
        }

        public b.b.a.a.q.h e() {
            return this.h;
        }

        public void f(b.b.a.a.q.d dVar) {
            b.b.a.a.q.d dVar2 = this.i;
            if (dVar2 == null) {
                this.i = dVar;
            } else {
                dVar2.d(dVar);
            }
        }

        public void g(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.j.isEmpty()) {
                this.k = Long.valueOf(currentTimeMillis);
            }
            this.j.put(str, (b.b.a.a.q.g) b.b.a.a.l.a.a().b(b.b.a.a.q.g.class, Double.valueOf(currentTimeMillis), Double.valueOf(currentTimeMillis - this.k.longValue())));
        }

        public boolean h(String str) {
            b.b.a.a.q.g gVar = this.j.get(str);
            if (gVar != null) {
                double currentTimeMillis = System.currentTimeMillis();
                b.b.a.b.f.i.c("DurationEvent", "statEvent consumeTime. module:", this.f928b, " monitorPoint:", this.f929c, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - gVar.f()));
                gVar.k(currentTimeMillis - gVar.f());
                gVar.i(true);
                this.h.j(str, gVar);
                if (this.g.e().g(this.h)) {
                    return true;
                }
            }
            return false;
        }

        public boolean i() {
            long currentTimeMillis = System.currentTimeMillis();
            List<b.b.a.a.q.e> e = this.g.e().e();
            if (e != null) {
                int size = e.size();
                for (int i = 0; i < size; i++) {
                    b.b.a.a.q.e eVar = e.get(i);
                    if (eVar != null) {
                        double doubleValue = eVar.c() != null ? eVar.c().doubleValue() : f.longValue();
                        b.b.a.a.q.g gVar = this.j.get(eVar.d());
                        if (gVar != null && !gVar.g() && currentTimeMillis - gVar.f() > doubleValue) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: Event.java */
    /* loaded from: classes.dex */
    public abstract class e implements b.b.a.a.l.b {

        /* renamed from: b  reason: collision with root package name */
        public String f928b;

        /* renamed from: c  reason: collision with root package name */
        public String f929c;

        /* renamed from: d  reason: collision with root package name */
        public String f930d;
        public int e;

        @Override // b.b.a.a.l.b
        public void a() {
            this.e = 0;
            this.f928b = null;
            this.f929c = null;
            this.f930d = null;
        }

        @Override // b.b.a.a.l.b
        public void b(Object... objArr) {
            this.e = ((Integer) objArr[0]).intValue();
            this.f928b = (String) objArr[1];
            this.f929c = (String) objArr[2];
            if (objArr.length <= 3 || objArr[3] == null) {
                return;
            }
            this.f930d = (String) objArr[3];
        }

        public JSONObject c() {
            JSONObject jSONObject = (JSONObject) b.b.a.a.l.a.a().b(b.b.a.a.l.e.class, new Object[0]);
            try {
                jSONObject.put("page", this.f928b);
                jSONObject.put("monitorPoint", this.f929c);
                String str = this.f930d;
                if (str != null) {
                    jSONObject.put("arg", str);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* compiled from: EventRepo.java */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        private static f f931a;

        /* renamed from: d  reason: collision with root package name */
        private AtomicInteger f934d = new AtomicInteger(0);
        private AtomicInteger e = new AtomicInteger(0);
        private AtomicInteger f = new AtomicInteger(0);

        /* renamed from: c  reason: collision with root package name */
        private Map<l, b.b.a.a.q.k> f933c = new ConcurrentHashMap();

        /* renamed from: b  reason: collision with root package name */
        private Map<String, d> f932b = new ConcurrentHashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EventRepo.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map f935b;

            a(Map map) {
                this.f935b = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.b.a.a.p.c.d(this.f935b);
            }
        }

        private f() {
        }

        private e a(l lVar, String str, String str2, String str3, Class<? extends e> cls) {
            Integer k;
            b.b.a.a.q.k kVar;
            if (b.b.a.a.p.b.a(str) && b.b.a.a.p.b.a(str2) && (k = lVar.k()) != null) {
                synchronized (this.f933c) {
                    kVar = this.f933c.get(lVar);
                    if (kVar == null) {
                        kVar = (b.b.a.a.q.k) b.b.a.a.l.a.a().b(b.b.a.a.q.k.class, new Object[0]);
                        this.f933c.put(lVar, kVar);
                    }
                }
                return kVar.c(k, str, str2, str3, cls);
            }
            return null;
        }

        public static synchronized f b() {
            f fVar;
            synchronized (f.class) {
                if (f931a == null) {
                    f931a = new f();
                }
                fVar = f931a;
            }
            return fVar;
        }

        private l c(int i, Map<String, String> map) {
            l lVar = (l) b.b.a.a.l.a.a().b(l.class, new Object[0]);
            if (map != null) {
                lVar.i(map);
            }
            lVar.j(b.b.a.b.g.a.ACCESS.toString(), b.b.a.b.a.e());
            lVar.j(b.b.a.b.g.a.ACCESS_SUBTYPE.toString(), b.b.a.b.a.g());
            lVar.j(b.b.a.b.g.a.USERID.toString(), b.b.a.b.a.h());
            lVar.j(b.b.a.b.g.a.USERNICK.toString(), b.b.a.b.a.i());
            lVar.j(b.b.a.b.g.a.EVENTID.toString(), String.valueOf(i));
            return lVar;
        }

        private String d(String str, String str2) {
            b.b.a.a.q.i b2 = j.c().b(str, str2);
            if (b2 != null) {
                return b2.h();
            }
            return null;
        }

        private void k(g gVar, AtomicInteger atomicInteger) {
            int incrementAndGet = atomicInteger.incrementAndGet();
            b.b.a.b.f.i.d("EventRepo", gVar.toString(), " EVENT size:", String.valueOf(incrementAndGet));
            if (incrementAndGet >= gVar.b()) {
                b.b.a.b.f.i.c("EventRepo", gVar.toString(), " event size exceed trigger count.");
                atomicInteger.set(0);
                f(gVar.a());
            }
        }

        private void q(String str, String str2) {
            b.b.a.a.q.i b2 = j.c().b(str, str2);
            if (b2 != null) {
                b2.j();
            }
        }

        public Map<l, List<e>> e(int i) {
            HashMap hashMap = new HashMap();
            synchronized (this.f933c) {
                ArrayList arrayList = new ArrayList(this.f933c.keySet());
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    l lVar = (l) arrayList.get(i2);
                    if (lVar != null && lVar.k().intValue() == i) {
                        hashMap.put(lVar, this.f933c.get(lVar).d());
                        this.f933c.remove(lVar);
                    }
                }
            }
            return hashMap;
        }

        public void f(int i) {
            s.a().g(new a(e(i)));
        }

        public void g(int i, String str, String str2, b.b.a.a.q.h hVar, b.b.a.a.q.d dVar, Map<String, String> map) {
            b.b.a.a.q.i b2 = j.c().b(str, str2);
            if (b2 != null) {
                if (b2.d() != null) {
                    b2.d().c(dVar);
                }
                if (b2.e() != null) {
                    b2.e().f(hVar);
                }
                l c2 = c(i, map);
                ((h) a(c2, str, str2, null, h.class)).e(dVar, hVar);
                if (a.b.g()) {
                    h hVar2 = (h) b.b.a.a.l.a.a().b(h.class, Integer.valueOf(i), str, str2);
                    hVar2.e(dVar, hVar);
                    b.b.a.a.p.c.b(c2, hVar2);
                }
                k(g.a(i), this.f);
                return;
            }
            b.b.a.b.f.i.a("EventRepo", "metric is null");
        }

        public void h(int i, String str, String str2, String str3, double d2, Map<String, String> map) {
            l c2 = c(i, map);
            ((c) a(c2, str, str2, str3, c.class)).d(d2);
            if (a.b.g()) {
                c cVar = (c) b.b.a.a.l.a.a().b(c.class, Integer.valueOf(i), str, str2, str3);
                cVar.d(d2);
                b.b.a.a.p.c.b(c2, cVar);
            }
            k(g.a(i), this.e);
        }

        public void i(int i, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            l c2 = c(i, map);
            b bVar = (b) a(c2, str, str2, str3, b.class);
            bVar.f();
            bVar.d(str4, str5);
            if (a.b.g()) {
                b bVar2 = (b) b.b.a.a.l.a.a().b(b.class, Integer.valueOf(i), str, str2, str3);
                bVar2.f();
                bVar2.d(str4, str5);
                b.b.a.a.p.c.b(c2, bVar2);
            }
            k(g.a(i), this.f934d);
        }

        public void j(int i, String str, String str2, String str3, Map<String, String> map) {
            l c2 = c(i, map);
            ((b) a(c2, str, str2, str3, b.class)).e();
            if (a.b.g()) {
                b bVar = (b) b.b.a.a.l.a.a().b(b.class, Integer.valueOf(i), str, str2, str3);
                bVar.e();
                b.b.a.a.p.c.b(c2, bVar);
            }
            k(g.a(i), this.f934d);
        }

        public void l(Integer num, String str, String str2, String str3) {
            String d2 = d(str, str2);
            if (d2 != null) {
                n(d2, num, str, str2, str3);
            }
        }

        public void m(String str, Integer num, String str2, String str3, b.b.a.a.q.d dVar) {
            d dVar2;
            synchronized (d.class) {
                dVar2 = this.f932b.get(str);
                if (dVar2 == null) {
                    dVar2 = (d) b.b.a.a.l.a.a().b(d.class, num, str2, str3);
                    this.f932b.put(str, dVar2);
                }
            }
            dVar2.f(dVar);
        }

        public void n(String str, Integer num, String str2, String str3, String str4) {
            d dVar;
            b.b.a.a.q.i b2 = j.c().b(str2, str3);
            if (b2 == null || b2.e() == null || b2.e().d(str4) == null) {
                return;
            }
            synchronized (d.class) {
                dVar = this.f932b.get(str);
                if (dVar == null) {
                    dVar = (d) b.b.a.a.l.a.a().b(d.class, num, str2, str3);
                    this.f932b.put(str, dVar);
                }
            }
            dVar.g(str4);
        }

        public void o(String str, String str2, String str3) {
            String d2 = d(str, str2);
            if (d2 != null) {
                p(d2, str3, true, null);
            }
        }

        public void p(String str, String str2, boolean z, Map<String, String> map) {
            d dVar = this.f932b.get(str);
            if (dVar == null || !dVar.h(str2)) {
                return;
            }
            this.f932b.remove(str);
            if (z) {
                q(dVar.f928b, dVar.f929c);
            }
            g(dVar.e, dVar.f928b, dVar.f929c, dVar.e(), dVar.d(), map);
            b.b.a.a.l.a.a().d(dVar);
        }

        public void r() {
            ArrayList arrayList = new ArrayList(this.f932b.keySet());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) arrayList.get(i);
                d dVar = this.f932b.get(str);
                if (dVar != null && dVar.i()) {
                    this.f932b.remove(str);
                }
            }
        }
    }

    /* compiled from: EventType.java */
    /* loaded from: classes.dex */
    public enum g {
        ALARM(65501, 30, "alarmData", DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT),
        COUNTER(65502, 30, "counterData", DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT),
        OFFLINE_COUNTER(65133, 30, "counterData", DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT),
        STAT(65503, 30, "statData", DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
        
        static String e = "EventType";
        private int g;
        private int i;
        private String j;
        private int m;
        private int k = 25;
        private int l = 180;
        private boolean h = true;

        g(int i, int i2, String str, int i3) {
            this.g = i;
            this.i = i2;
            this.j = str;
            this.m = i3;
        }

        public int a() {
            return this.g;
        }

        public void b(boolean z) {
            this.h = z;
        }

        public int c() {
            return this.k;
        }

        public int d() {
            return this.l;
        }

        public int e() {
            return this.m;
        }

        public boolean isOpen() {
            return this.h;
        }

        public void setStatisticsInterval(int i) {
            this.k = i;
            this.l = i;
        }

        public static g a(int i) {
            g[] values;
            for (g gVar : values()) {
                if (gVar != null && gVar.a() == i) {
                    return gVar;
                }
            }
            return null;
        }

        public int b() {
            return this.i;
        }

        public void c(int i) {
            this.m = i;
        }

        public void b(int i) {
            String str = e;
            b.b.a.b.f.i.c(str, "[setTriggerCount]", this.j, i + "");
            this.i = i;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m0a() {
            return this.j;
        }
    }

    /* compiled from: StatEvent.java */
    /* loaded from: classes.dex */
    public class h extends e {
        private b.b.a.a.q.i f;
        private Map<b.b.a.a.q.d, a> g;

        /* compiled from: StatEvent.java */
        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            private int f941a = 0;

            /* renamed from: b  reason: collision with root package name */
            private int f942b = 0;

            /* renamed from: c  reason: collision with root package name */
            private List<b.b.a.a.q.h> f943c = new ArrayList();

            public a() {
            }

            private b.b.a.a.q.h b(b.b.a.a.q.h hVar) {
                List<b.b.a.a.q.e> e;
                b.b.a.a.q.h hVar2 = (b.b.a.a.q.h) b.b.a.a.l.a.a().b(b.b.a.a.q.h.class, new Object[0]);
                if (h.this.f != null && h.this.f.e() != null && (e = h.this.f.e().e()) != null) {
                    int size = e.size();
                    for (int i = 0; i < size; i++) {
                        b.b.a.a.q.e eVar = e.get(i);
                        if (eVar != null) {
                            b.b.a.a.q.g gVar = (b.b.a.a.q.g) b.b.a.a.l.a.a().b(b.b.a.a.q.g.class, new Object[0]);
                            b.b.a.a.q.g g = hVar.g(eVar.d());
                            if (g.e() != null) {
                                gVar.j(g.e().doubleValue());
                            }
                            gVar.k(g.f());
                            hVar2.j(eVar.d(), gVar);
                        }
                    }
                }
                return hVar2;
            }

            public List<Map<String, Map<String, Double>>> c() {
                Map<String, b.b.a.a.q.g> f;
                List<b.b.a.a.q.h> list = this.f943c;
                if (list == null || list.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int size = this.f943c.size();
                for (int i = 0; i < size; i++) {
                    b.b.a.a.q.h hVar = this.f943c.get(i);
                    if (hVar != null && (f = hVar.f()) != null && !f.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry<String, b.b.a.a.q.g> entry : f.entrySet()) {
                            HashMap hashMap2 = new HashMap();
                            String key = entry.getKey();
                            b.b.a.a.q.g value = entry.getValue();
                            hashMap2.put("value", Double.valueOf(value.f()));
                            if (value.e() != null) {
                                hashMap2.put("offset", value.e());
                            }
                            hashMap.put(key, hashMap2);
                        }
                        arrayList.add(hashMap);
                    }
                }
                return arrayList;
            }

            public void d(b.b.a.a.q.h hVar) {
                if (hVar != null) {
                    if (h.this.f != null && h.this.f.i()) {
                        this.f943c.add(b(hVar));
                    } else if (this.f943c.isEmpty()) {
                        this.f943c.add(b(hVar));
                    } else {
                        this.f943c.get(0).h(hVar);
                    }
                }
            }

            public void f() {
                this.f941a++;
            }

            public void g() {
                this.f942b++;
            }
        }

        @Override // b.b.a.a.i.e, b.b.a.a.l.b
        public synchronized void a() {
            super.a();
            this.f = null;
            for (b.b.a.a.q.d dVar : this.g.keySet()) {
                b.b.a.a.l.a.a().d(dVar);
            }
            this.g.clear();
        }

        @Override // b.b.a.a.i.e, b.b.a.a.l.b
        public void b(Object... objArr) {
            super.b(objArr);
            if (this.g == null) {
                this.g = new HashMap();
            }
            this.f = j.c().b(this.f928b, this.f929c);
        }

        @Override // b.b.a.a.i.e
        public synchronized JSONObject c() {
            JSONObject c2;
            Set<String> keySet;
            c2 = super.c();
            try {
                b.b.a.a.q.i iVar = this.f;
                if (iVar != null) {
                    c2.put("isCommitDetail", String.valueOf(iVar.i()));
                }
                JSONArray jSONArray = (JSONArray) b.b.a.a.l.a.a().b(b.b.a.a.l.d.class, new Object[0]);
                Map<b.b.a.a.q.d, a> map = this.g;
                if (map != null) {
                    for (Map.Entry<b.b.a.a.q.d, a> entry : map.entrySet()) {
                        JSONObject jSONObject = (JSONObject) b.b.a.a.l.a.a().b(b.b.a.a.l.e.class, new Object[0]);
                        b.b.a.a.q.d key = entry.getKey();
                        a value = entry.getValue();
                        Object valueOf = Integer.valueOf(value.f941a);
                        Object valueOf2 = Integer.valueOf(value.f942b);
                        jSONObject.put("count", valueOf);
                        jSONObject.put("noise", valueOf2);
                        jSONObject.put("dimensions", key != null ? new JSONObject(key.g()) : "");
                        List<Map<String, Map<String, Double>>> c3 = value.c();
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i = 0; i < c3.size(); i++) {
                            JSONObject jSONObject2 = new JSONObject();
                            Map<String, Map<String, Double>> map2 = c3.get(i);
                            if (map2 != null && (keySet = map2.keySet()) != null) {
                                for (String str : keySet) {
                                    if (map2.get(str) != null) {
                                        jSONObject2.put(str, new JSONObject(map2.get(str)));
                                    } else {
                                        jSONObject2.put(str, "");
                                    }
                                }
                            }
                            jSONArray2.put(jSONObject2);
                        }
                        jSONObject.put("measures", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                c2.put("values", jSONArray);
            } catch (Exception unused) {
            }
            return c2;
        }

        public synchronized void e(b.b.a.a.q.d dVar, b.b.a.a.q.h hVar) {
            a aVar;
            if (dVar == null) {
                b.b.a.a.q.d dVar2 = (b.b.a.a.q.d) b.b.a.a.l.a.a().b(b.b.a.a.q.d.class, new Object[0]);
                dVar2.d(dVar);
                dVar = dVar2;
            }
            if (this.g.containsKey(dVar)) {
                aVar = this.g.get(dVar);
            } else {
                b.b.a.a.q.d dVar3 = (b.b.a.a.q.d) b.b.a.a.l.a.a().b(b.b.a.a.q.d.class, new Object[0]);
                dVar3.d(dVar);
                a aVar2 = new a();
                this.g.put(dVar3, aVar2);
                aVar = aVar2;
            }
            b.b.a.a.q.i iVar = this.f;
            if (iVar != null ? iVar.l(dVar, hVar) : false) {
                aVar.f();
                aVar.d(hVar);
            } else {
                aVar.g();
                if (this.f.i()) {
                    aVar.d(hVar);
                }
            }
            b.b.a.b.f.i.c("StatEvent", "entity  count:", Integer.valueOf(aVar.f941a), " noise:", Integer.valueOf(aVar.f942b));
        }
    }

    /* compiled from: UTEvent.java */
    /* renamed from: b.b.a.a.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036i implements b.b.a.a.l.b {

        /* renamed from: b  reason: collision with root package name */
        public String f945b;

        /* renamed from: c  reason: collision with root package name */
        public int f946c;

        /* renamed from: d  reason: collision with root package name */
        public String f947d;
        public String e;
        public String f;
        public Map<String, String> g;

        @Override // b.b.a.a.l.b
        public void a() {
            this.f945b = null;
            this.f946c = 0;
            this.f947d = null;
            this.e = null;
            this.f = null;
            Map<String, String> map = this.g;
            if (map != null) {
                map.clear();
            }
        }

        @Override // b.b.a.a.l.b
        public void b(Object... objArr) {
            if (this.g == null) {
                this.g = new HashMap();
            }
        }
    }

    public i(Application application) {
        this.f925d = application;
    }

    private static boolean a(Context context) {
        String a2 = b.b.a.b.f.b.a(context);
        b.b.a.b.f.i.c("BackgroundTrigger", "[checkRuningProcess]:", a2);
        return (TextUtils.isEmpty(a2) || a2.indexOf(":") == -1) ? false : true;
    }

    @TargetApi(14)
    public static void b(Application application) {
        if (f923b) {
            return;
        }
        b.b.a.b.f.i.c("BackgroundTrigger", "init BackgroundTrigger");
        f924c = a(application.getApplicationContext());
        i iVar = new i(application);
        if (f924c) {
            s.a().e(4, iVar, 60000L);
        } else if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new a(iVar));
        }
        f923b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        b.b.a.b.f.i.c("BackgroundTrigger", "[bg check]");
        boolean b2 = b.b.a.b.f.b.b(this.f925d.getApplicationContext());
        if (this.e != b2) {
            this.e = b2;
            if (b2) {
                b.b.a.a.n.j.a().j();
                g[] values = g.values();
                int length = values.length;
                while (i < length) {
                    g gVar = values[i];
                    b.b.a.a.b.l(gVar, gVar.c());
                    i++;
                }
                b.b.a.b.a.l();
            } else {
                g[] values2 = g.values();
                int length2 = values2.length;
                while (i < length2) {
                    g gVar2 = values2[i];
                    b.b.a.a.b.l(gVar2, gVar2.d());
                    i++;
                }
                b.b.a.a.b.m();
                b.b.a.b.a.k();
            }
        }
        if (f924c) {
            s.a().e(4, this, 60000L);
        }
    }
}
