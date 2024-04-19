package b.b.a.a.q;

import android.text.TextUtils;
import java.util.List;
import java.util.UUID;
/* compiled from: Metric.java */
/* loaded from: classes.dex */
public class i implements b.b.a.a.l.b {

    /* renamed from: b  reason: collision with root package name */
    private String f994b;

    /* renamed from: c  reason: collision with root package name */
    private String f995c;

    /* renamed from: d  reason: collision with root package name */
    private String f996d;
    private boolean e;
    private String f;
    private c g;
    private f h;
    private String i;

    @Deprecated
    public i() {
        this.f = null;
    }

    private e c(String str, List<e> list) {
        if (list != null) {
            for (e eVar : list) {
                if (TextUtils.equals(str, eVar.f988d)) {
                    return eVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // b.b.a.a.l.b
    public void a() {
        this.f994b = null;
        this.f995c = null;
        this.f996d = null;
        this.e = false;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // b.b.a.a.l.b
    public void b(Object... objArr) {
        this.f994b = (String) objArr[0];
        this.f995c = (String) objArr[1];
        if (objArr.length > 2) {
            this.f996d = (String) objArr[2];
        }
    }

    public c d() {
        return this.g;
    }

    public f e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            i iVar = (i) obj;
            String str = this.f996d;
            if (str == null) {
                if (iVar.f996d != null) {
                    return false;
                }
            } else if (!str.equals(iVar.f996d)) {
                return false;
            }
            String str2 = this.f994b;
            if (str2 == null) {
                if (iVar.f994b != null) {
                    return false;
                }
            } else if (!str2.equals(iVar.f994b)) {
                return false;
            }
            String str3 = this.f995c;
            if (str3 == null) {
                if (iVar.f995c != null) {
                    return false;
                }
            } else if (!str3.equals(iVar.f995c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f994b;
    }

    public String g() {
        return this.f995c;
    }

    public synchronized String h() {
        if (this.i == null) {
            this.i = UUID.randomUUID().toString() + "$" + this.f994b + "$" + this.f995c;
        }
        return this.i;
    }

    public int hashCode() {
        String str = this.f996d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f994b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f995c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public synchronized boolean i() {
        if ("1".equalsIgnoreCase(this.f)) {
            return true;
        }
        if ("0".equalsIgnoreCase(this.f)) {
            return false;
        }
        return this.e;
    }

    public void j() {
        this.i = null;
    }

    public synchronized void k(String str) {
        this.f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(b.b.a.a.q.d r6, b.b.a.a.q.h r7) {
        /*
            r5 = this;
            b.b.a.a.q.c r0 = r5.g
            r1 = 1
            if (r0 == 0) goto La
            boolean r6 = r0.d(r6)
            goto Lb
        La:
            r6 = r1
        Lb:
            b.b.a.a.q.j r0 = b.b.a.a.q.j.c()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "config_prefix"
            r2.append(r3)
            java.lang.String r4 = r5.f994b
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = r5.f995c
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            b.b.a.a.q.i r0 = r0.b(r2, r3)
            r2 = 0
            if (r0 == 0) goto L8a
            b.b.a.a.q.f r3 = r0.e()
            if (r3 == 0) goto L8a
            if (r7 == 0) goto L8a
            java.util.Map r3 = r7.f()
            if (r3 == 0) goto L8a
            b.b.a.a.q.f r3 = r5.h
            if (r3 == 0) goto L8a
            b.b.a.a.q.f r0 = r0.e()
            java.util.List r0 = r0.e()
            java.util.Map r1 = r7.f()
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L60:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L89
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            b.b.a.a.q.e r4 = r5.c(r3, r0)
            if (r4 != 0) goto L7c
            b.b.a.a.q.f r4 = r5.h
            java.util.List r4 = r4.e()
            b.b.a.a.q.e r4 = r5.c(r3, r4)
        L7c:
            if (r4 == 0) goto L88
            b.b.a.a.q.g r3 = r7.g(r3)
            boolean r3 = r4.e(r3)
            if (r3 != 0) goto L60
        L88:
            return r2
        L89:
            return r6
        L8a:
            b.b.a.a.q.f r0 = r5.h
            if (r0 == 0) goto L99
            if (r6 == 0) goto L97
            boolean r6 = r0.g(r7)
            if (r6 == 0) goto L97
            goto L98
        L97:
            r1 = r2
        L98:
            r6 = r1
        L99:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.q.i.l(b.b.a.a.q.d, b.b.a.a.q.h):boolean");
    }

    public i(String str, String str2, f fVar, c cVar, boolean z) {
        this.f = null;
        this.f994b = str;
        this.f995c = str2;
        this.g = cVar;
        this.h = fVar;
        this.f996d = null;
        this.e = z;
    }
}
