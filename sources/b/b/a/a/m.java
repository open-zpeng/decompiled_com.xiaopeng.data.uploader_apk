package b.b.a.a;

import b.b.a.a.i;
import b.b.a.b.f.s;
import com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadTask.java */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f957b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Integer, m> f958c;

    /* renamed from: d  reason: collision with root package name */
    private int f959d;
    private int e;
    private long f = System.currentTimeMillis();

    private m(int i, int i2) {
        this.f959d = 180000;
        this.e = i;
        this.f959d = i2;
    }

    private static int a(int i) {
        if (i != 65133) {
            switch (i) {
                case 65501:
                    return 6;
                case 65502:
                    return 9;
                case 65503:
                    return 10;
                default:
                    return 0;
            }
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i, int i2) {
        b.b.a.b.f.i.c("CommitTask", "[setStatisticsInterval] eventId" + i + " statisticsInterval:" + i2);
        synchronized (f958c) {
            m mVar = f958c.get(Integer.valueOf(i));
            if (mVar == null) {
                if (i2 > 0) {
                    m mVar2 = new m(i, i2 * IError.ERR_SERVICE_DISCONNECTED);
                    f958c.put(Integer.valueOf(i), mVar2);
                    b.b.a.b.f.i.c("CommitTask", "post next eventId" + i + ": uploadTask.interval " + mVar2.f959d);
                    s.a().e(a(i), mVar2, (long) mVar2.f959d);
                }
            } else if (i2 > 0) {
                int i3 = mVar.f959d;
                int i4 = i2 * IError.ERR_SERVICE_DISCONNECTED;
                if (i3 != i4) {
                    s.a().i(a(i));
                    mVar.f959d = i4;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = mVar.f959d - (currentTimeMillis - mVar.f);
                    if (j < 0) {
                        j = 0;
                    }
                    b.b.a.b.f.i.c("CommitTask", mVar + "post next eventId" + i + " next:" + j + "  uploadTask.interval: " + mVar.f959d);
                    s.a().e(a(i), mVar, j);
                    mVar.f = currentTimeMillis;
                }
            } else {
                b.b.a.b.f.i.c("CommitTask", "uploadTasks.size:" + f958c.size());
                f958c.remove(Integer.valueOf(i));
                b.b.a.b.f.i.c("CommitTask", "uploadTasks.size:" + f958c.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        for (i.g gVar : i.g.values()) {
            i.f.b().f(gVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        for (i.g gVar : i.g.values()) {
            s.a().i(a(gVar.a()));
        }
        f957b = false;
        f958c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        i.g[] values;
        if (f957b) {
            return;
        }
        b.b.a.b.f.i.c("CommitTask", "init StatisticsAlarmEvent");
        f958c = new ConcurrentHashMap();
        for (i.g gVar : i.g.values()) {
            if (gVar.isOpen()) {
                int a2 = gVar.a();
                m mVar = new m(a2, gVar.c() * IError.ERR_SERVICE_DISCONNECTED);
                f958c.put(Integer.valueOf(a2), mVar);
                s.a().e(a(a2), mVar, mVar.f959d);
            }
        }
        f957b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.b.a.b.f.i.c("CommitTask", "check&commit event:", Integer.valueOf(this.e));
        i.f.b().f(this.e);
        if (f958c.containsValue(this)) {
            this.f = System.currentTimeMillis();
            b.b.a.b.f.i.c("CommitTask", "next:" + this.e);
            s.a().e(a(this.e), this, (long) this.f959d);
        }
    }
}
