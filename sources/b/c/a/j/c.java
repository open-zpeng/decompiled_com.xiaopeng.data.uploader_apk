package b.c.a.j;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Progress.java */
/* loaded from: classes.dex */
public class c implements Serializable {
    private static final long serialVersionUID = 6353658567594109891L;

    /* renamed from: b  reason: collision with root package name */
    public String f1193b;

    /* renamed from: c  reason: collision with root package name */
    public String f1194c;

    /* renamed from: d  reason: collision with root package name */
    public String f1195d;
    public String e;
    public String f;
    public float g;
    public long i;
    public transient long j;
    public int k;
    private transient long n;
    private transient long o = SystemClock.elapsedRealtime();
    public long h = -1;
    public int l = 0;
    public long m = System.currentTimeMillis();
    private transient List<Long> p = new ArrayList();

    /* compiled from: Progress.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);
    }

    private long a(long j) {
        this.p.add(Long.valueOf(j));
        if (this.p.size() > 10) {
            this.p.remove(0);
        }
        long j2 = 0;
        for (Long l : this.p) {
            j2 = ((float) j2) + ((float) l.longValue());
        }
        return j2 / this.p.size();
    }

    public static c b(c cVar, long j, long j2, a aVar) {
        cVar.h = j2;
        cVar.i += j;
        cVar.n += j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = cVar.o;
        if ((elapsedRealtime - j3 >= b.c.a.a.f1112a) || cVar.i == j2) {
            long j4 = elapsedRealtime - j3;
            if (j4 == 0) {
                j4 = 1;
            }
            cVar.g = (((float) cVar.i) * 1.0f) / ((float) j2);
            cVar.j = cVar.a((cVar.n * 1000) / j4);
            cVar.o = elapsedRealtime;
            cVar.n = 0L;
            if (aVar != null) {
                aVar.a(cVar);
            }
        }
        return cVar;
    }

    public static c c(c cVar, long j, a aVar) {
        return b(cVar, j, cVar.h, aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        String str = this.f1193b;
        String str2 = ((c) obj).f1193b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f1193b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress{fraction=" + this.g + ", totalSize=" + this.h + ", currentSize=" + this.i + ", speed=" + this.j + ", status=" + this.k + ", priority=" + this.l + ", folder=" + this.f1195d + ", filePath=" + this.e + ", fileName=" + this.f + ", tag=" + this.f1193b + ", url=" + this.f1194c + '}';
    }
}
