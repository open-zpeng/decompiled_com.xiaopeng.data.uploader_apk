package b.b.a.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import b.b.a.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: AppMonitor.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Application f892a;

    /* renamed from: b  reason: collision with root package name */
    protected static j f893b;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f894c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f895d;
    protected static b.b.a.a.d e;
    private static String i;
    private static String j;
    private static boolean k;
    private static String l;
    private static Context n;
    private static String p;
    private static Object f = new Object();
    private static List<h> g = Collections.synchronizedList(new ArrayList());
    private static boolean h = false;
    private static i m = i.Local;
    private static ServiceConnection o = new c();
    private static Map<String, ?> q = Collections.synchronizedMap(new HashMap());

    /* compiled from: AppMonitor.java */
    /* renamed from: b.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class RunnableC0032a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f896b;

        RunnableC0032a(Map map) {
            this.f896b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.e.R(this.f896b);
            } catch (RemoteException e) {
                a.h(e);
            }
        }
    }

    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.e.c0();
            } catch (RemoteException e) {
                a.h(e);
            }
        }
    }

    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    static class c implements ServiceConnection {

        /* compiled from: AppMonitor.java */
        /* renamed from: b.b.a.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0033a implements Runnable {
            RunnableC0033a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.q();
            }
        }

        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            j jVar;
            if (i.Service == a.m) {
                a.e = d.a.j0(iBinder);
                if (a.h && (jVar = a.f893b) != null) {
                    jVar.postAtFrontOfQueue(new RunnableC0033a());
                }
            }
            synchronized (a.f) {
                a.f.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.b.a.b.f.i.c("AppMonitor", "[onServiceDisconnected]");
            synchronized (a.f) {
                a.f.notifyAll();
            }
            boolean unused = a.h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.e.init();
            } catch (RemoteException unused) {
                a.g();
                try {
                    a.e.init();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f898b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f899c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f900d;
        final /* synthetic */ String e;

        e(boolean z, String str, String str2, String str3) {
            this.f898b = z;
            this.f899c = str;
            this.f900d = str2;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.e.F(this.f898b, this.f899c, this.f900d, this.e);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public static class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f901b;

        f(String str) {
            this.f901b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.e.K(this.f901b);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public static class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f902b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f903c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b.b.a.a.q.f f904d;
        final /* synthetic */ b.b.a.a.q.c e;
        final /* synthetic */ boolean f;

        g(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar, boolean z) {
            this.f902b = str;
            this.f903c = str2;
            this.f904d = fVar;
            this.e = cVar;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.b.a.b.f.i.c("AppMonitor", "register stat event. module: ", this.f902b, " monitorPoint: ", this.f903c);
                a.e.t(this.f902b, this.f903c, this.f904d, this.e, this.f);
            } catch (RemoteException e) {
                a.h(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f905a;

        /* renamed from: b  reason: collision with root package name */
        public String f906b;

        /* renamed from: c  reason: collision with root package name */
        public b.b.a.a.q.f f907c;

        /* renamed from: d  reason: collision with root package name */
        public b.b.a.a.q.c f908d;
        public boolean e;

        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public enum i {
        Local,
        Service
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* loaded from: classes.dex */
    public static class j extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private boolean f912a;

        public j(Looper looper) {
            super(looper);
            this.f912a = false;
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = runnable;
                sendMessage(obtain);
            } catch (Throwable unused) {
            }
        }

        public void b(boolean z) {
            this.f912a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f912a) {
                    this.f912a = false;
                    synchronized (a.f) {
                        try {
                            a.f.wait(5000L);
                        } catch (InterruptedException unused) {
                            a.g();
                        }
                    }
                }
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ((Runnable) obj).run();
                }
            } catch (Throwable unused2) {
            }
            super.handleMessage(message);
        }
    }

    private static Runnable c() {
        return new d();
    }

    private static Runnable d(String str) {
        return new f(str);
    }

    private static Runnable e(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar, boolean z) {
        return new g(str, str2, fVar, cVar, z);
    }

    private static Runnable f(boolean z, String str, String str2, String str3) {
        return new e(z, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        e = new b.b.a.a.e(f892a);
        m = i.Local;
        b.b.a.b.f.i.a("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Exception exc) {
        b.b.a.b.f.i.b("AppMonitor", "", exc);
        if (exc instanceof DeadObjectException) {
            q();
        }
    }

    private static boolean i() {
        Application application = f892a;
        if (application == null) {
            return false;
        }
        boolean bindService = application.getApplicationContext().bindService(new Intent(f892a.getApplicationContext(), b.b.a.a.c.class), o, 1);
        if (!bindService) {
            g();
        }
        b.b.a.b.f.i.c("AppMonitor", "bindsuccess:", Boolean.valueOf(bindService));
        return bindService;
    }

    public static boolean o() {
        if (!f895d) {
            b.b.a.b.f.i.c("AppMonitor", "Please call UTAnalytics.getInstance().setAppApplicationInstance()||.setAppApplicationInstance4sdk() before call other method");
        }
        return f895d;
    }

    public static synchronized void p(Application application) {
        synchronized (a.class) {
            b.b.a.b.f.i.c("AppMonitor", "[init]");
            try {
                if (!f895d) {
                    f892a = application;
                    if (application != null) {
                        n = application.getApplicationContext();
                    }
                    HandlerThread handlerThread = new HandlerThread("AppMonitor_Client");
                    f894c = handlerThread;
                    handlerThread.start();
                    f893b = new j(f894c.getLooper());
                    if (m == i.Local) {
                        g();
                    } else if (i()) {
                        f893b.b(true);
                    }
                    c().run();
                    f895d = true;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void q() {
        synchronized (a.class) {
            b.b.a.b.f.i.c("AppMonitor", "[restart]");
            try {
                if (h) {
                    h = false;
                    g();
                    c().run();
                    f(k, j, l, p).run();
                    d(i).run();
                    synchronized (g) {
                        for (int i2 = 0; i2 < g.size(); i2++) {
                            h hVar = g.get(i2);
                            if (hVar != null) {
                                try {
                                    e(hVar.f905a, hVar.f906b, hVar.f907c, hVar.f908d, hVar.e).run();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static void r(String str) {
        if (o()) {
            f893b.a(d(str));
            i = str;
        }
    }

    public static void s(boolean z, String str, String str2, String str3) {
        if (o()) {
            f893b.a(f(z, str, str2, str3));
            k = z;
            j = str;
            l = str2;
            p = str3;
        }
    }

    public static void t() {
        if (o()) {
            f893b.a(new b());
        }
    }

    public static void u(Map<String, String> map) {
        if (o()) {
            f893b.a(new RunnableC0032a(map));
        }
    }
}
