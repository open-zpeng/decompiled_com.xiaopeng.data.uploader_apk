package d.c.a.u;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import d.c.a.u.a;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public abstract class c extends d.c.a.u.a {
    static final /* synthetic */ boolean m;
    static /* synthetic */ Class n;
    int A;
    int B;
    private int C;
    private final d.c.a.v.b o;
    final d.c.a.t.e p;
    final b q;
    final a r;
    final a s;
    final int t;
    private int u;
    private int v;
    private final int w;
    private final int[][] x;
    private final int[][] y;
    private final int[] z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends a.AbstractC0091a {
        private final int[] f;
        private final int[][] g;

        a(int i, int i2) {
            super();
            int i3 = 1 << i;
            this.f = new int[i3];
            this.g = (int[][]) Array.newInstance(int.class, i3, Math.max((i2 - 2) + 1, 16));
        }

        private void e(int i) {
            int h = d.c.a.v.b.h(this.f1990a[0], 0);
            int i2 = 0;
            while (i2 < 8) {
                this.g[i][i2] = d.c.a.v.b.i(this.f1991b[i], i2) + h;
                i2++;
            }
            int h2 = d.c.a.v.b.h(this.f1990a[0], 1);
            int h3 = d.c.a.v.b.h(this.f1990a[1], 0);
            while (i2 < 16) {
                this.g[i][i2] = h2 + h3 + d.c.a.v.b.i(this.f1992c[i], i2 - 8);
                i2++;
            }
            int h4 = d.c.a.v.b.h(this.f1990a[1], 1);
            while (true) {
                int[][] iArr = this.g;
                if (i2 >= iArr[i].length) {
                    return;
                }
                iArr[i][i2] = h2 + h4 + d.c.a.v.b.i(this.f1993d, (i2 - 8) - 8);
                i2++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // d.c.a.u.a.AbstractC0091a
        public void a() {
            super.a();
            int i = 0;
            while (true) {
                int[] iArr = this.f;
                if (i >= iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }

        void b(int i, int i2) {
            int i3 = i - 2;
            if (i3 < 8) {
                c.this.o.c(this.f1990a, 0, 0);
                c.this.o.d(this.f1991b[i2], i3);
            } else {
                c.this.o.c(this.f1990a, 0, 1);
                int i4 = i3 - 8;
                if (i4 < 8) {
                    c.this.o.c(this.f1990a, 1, 0);
                    c.this.o.d(this.f1992c[i2], i4);
                } else {
                    c.this.o.c(this.f1990a, 1, 1);
                    c.this.o.d(this.f1993d, i4 - 8);
                }
            }
            int[] iArr = this.f;
            iArr[i2] = iArr[i2] - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c(int i, int i2) {
            return this.g[i2][i - 2];
        }

        void d() {
            int i = 0;
            while (true) {
                int[] iArr = this.f;
                if (i >= iArr.length) {
                    return;
                }
                if (iArr[i] <= 0) {
                    iArr[i] = 32;
                    e(i);
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends a.b {

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ boolean f1999d;
        a[] e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a extends a.b.AbstractC0092a {
            private a() {
                super();
            }

            void b() {
                int f = c.this.p.f(c.this.B);
                int i = IRadioController.TEF663x_PCHANNEL;
                int i2 = f | IRadioController.TEF663x_PCHANNEL;
                if (c.this.f1988c.b()) {
                    do {
                        c.this.o.c(this.f1997a, i2 >>> 8, (i2 >>> 7) & 1);
                        i2 <<= 1;
                    } while (i2 < 65536);
                } else {
                    int f2 = c.this.p.f(c.this.f1987b[0] + 1 + c.this.B);
                    do {
                        f2 <<= 1;
                        c.this.o.c(this.f1997a, (f2 & i) + i + (i2 >>> 8), (i2 >>> 7) & 1);
                        i2 <<= 1;
                        i &= ~(f2 ^ i2);
                    } while (i2 < 65536);
                }
                c.this.f1988c.e();
            }

            int c(int i, int i2) {
                int i3 = IRadioController.TEF663x_PCHANNEL;
                int i4 = i | IRadioController.TEF663x_PCHANNEL;
                int i5 = 0;
                do {
                    i2 <<= 1;
                    i5 += d.c.a.v.b.h(this.f1997a[(i2 & i3) + i3 + (i4 >>> 8)], (i4 >>> 7) & 1);
                    i4 <<= 1;
                    i3 &= ~(i2 ^ i4);
                } while (i4 < 65536);
                return i5;
            }

            int d(int i) {
                int i2 = i | IRadioController.TEF663x_PCHANNEL;
                int i3 = 0;
                do {
                    i3 += d.c.a.v.b.h(this.f1997a[i2 >>> 8], (i2 >>> 7) & 1);
                    i2 <<= 1;
                } while (i2 < 65536);
                return i3;
            }
        }

        static {
            if (c.n == null) {
                c.n = c.d("org.tukaani.xz.lzma.LZMAEncoder");
            }
            f1999d = true;
        }

        b(int i, int i2) {
            super(i, i2);
            this.e = new a[1 << (i + i2)];
            int i3 = 0;
            while (true) {
                a[] aVarArr = this.e;
                if (i3 >= aVarArr.length) {
                    return;
                }
                aVarArr[i3] = new a();
                i3++;
            }
        }

        void c() {
            if (!f1999d && c.this.B < 0) {
                throw new AssertionError();
            }
            c cVar = c.this;
            this.e[a(cVar.p.f(cVar.B + 1), c.this.p.l() - c.this.B)].b();
        }

        void d() {
            if (!f1999d && c.this.B < 0) {
                throw new AssertionError();
            }
            this.e[0].b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e(int i, int i2, int i3, int i4, g gVar) {
            int h = d.c.a.v.b.h(c.this.f1989d[gVar.a()][c.this.f1986a & i4], 0);
            int a2 = a(i3, i4);
            return h + (gVar.b() ? this.e[a2].d(i) : this.e[a2].c(i, i2));
        }

        void f() {
            int i = 0;
            while (true) {
                a[] aVarArr = this.e;
                if (i >= aVarArr.length) {
                    return;
                }
                aVarArr[i].a();
                i++;
            }
        }
    }

    static {
        if (n == null) {
            n = d("org.tukaani.xz.lzma.LZMAEncoder");
        }
        m = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d.c.a.v.b bVar, d.c.a.t.e eVar, int i, int i2, int i3, int i4, int i5) {
        super(i3);
        this.u = 0;
        this.v = 0;
        this.y = (int[][]) Array.newInstance(int.class, 4, 128);
        this.z = new int[16];
        this.A = 0;
        this.B = -1;
        this.C = 0;
        this.o = bVar;
        this.p = eVar;
        this.t = i5;
        this.q = new b(i, i2);
        this.r = new a(i3, i5);
        this.s = new a(i3, i5);
        int l = l(i4 - 1) + 1;
        this.w = l;
        this.x = (int[][]) Array.newInstance(int.class, 4, l);
        b();
    }

    static /* synthetic */ Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private boolean f() {
        boolean z = m;
        if (z || this.B == -1) {
            if (this.p.m(0)) {
                x(1);
                this.o.c(this.f1989d[this.f1988c.a()], 0, 0);
                this.q.d();
                int i = this.B - 1;
                this.B = i;
                if (z || i == -1) {
                    int i2 = this.C + 1;
                    this.C = i2;
                    if (z || i2 == 1) {
                        return true;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            return false;
        }
        throw new AssertionError();
    }

    private void g(int i, int i2, int i3) {
        this.f1988c.g();
        this.r.b(i2, i3);
        int l = l(i);
        this.o.d(this.j[d.c.a.u.a.a(i2)], l);
        if (l >= 4) {
            int i4 = (l >>> 1) - 1;
            int i5 = i - (((l & 1) | 2) << i4);
            if (l < 14) {
                this.o.f(this.k[l - 4], i5);
            } else {
                this.o.e(i5 >>> 4, i4 - 4);
                this.o.f(this.l, i5 & 15);
                this.v--;
            }
        }
        int[] iArr = this.f1987b;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = i;
        this.u--;
    }

    private void h(int i, int i2, int i3) {
        if (i == 0) {
            this.o.c(this.f, this.f1988c.a(), 0);
            this.o.c(this.i[this.f1988c.a()], i3, i2 != 1 ? 1 : 0);
        } else {
            int i4 = this.f1987b[i];
            this.o.c(this.f, this.f1988c.a(), 1);
            if (i == 1) {
                this.o.c(this.g, this.f1988c.a(), 0);
            } else {
                this.o.c(this.g, this.f1988c.a(), 1);
                this.o.c(this.h, this.f1988c.a(), i - 2);
                if (i == 3) {
                    int[] iArr = this.f1987b;
                    iArr[3] = iArr[2];
                }
                int[] iArr2 = this.f1987b;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.f1987b;
            iArr3[1] = iArr3[0];
            iArr3[0] = i4;
        }
        if (i2 == 1) {
            this.f1988c.h();
            return;
        }
        this.s.b(i2, i3);
        this.f1988c.f();
    }

    private boolean i() {
        if (this.p.m(this.B + 1)) {
            int s = s();
            boolean z = m;
            if (z || this.B >= 0) {
                int l = (this.p.l() - this.B) & this.f1986a;
                if (this.A != -1) {
                    this.o.c(this.f1989d[this.f1988c.a()], l, 1);
                    int i = this.A;
                    if (i < 4) {
                        if (!z && this.p.j(-this.B, this.f1987b[i], s) != s) {
                            throw new AssertionError();
                        }
                        this.o.c(this.e, this.f1988c.a(), 1);
                        h(this.A, s, l);
                    } else if (!z && this.p.j(-this.B, i - 4, s) != s) {
                        throw new AssertionError();
                    } else {
                        this.o.c(this.e, this.f1988c.a(), 0);
                        g(this.A - 4, s, l);
                    }
                } else if (!z && s != 1) {
                    throw new AssertionError();
                } else {
                    this.o.c(this.f1989d[this.f1988c.a()], l, 0);
                    this.q.c();
                }
                this.B -= s;
                this.C += s;
                return true;
            }
            throw new AssertionError();
        }
        return false;
    }

    public static int l(int i) {
        int i2;
        int i3;
        if (i <= 4) {
            return i;
        }
        if (((-65536) & i) == 0) {
            i3 = i << 16;
            i2 = 15;
        } else {
            i2 = 31;
            i3 = i;
        }
        if (((-16777216) & i3) == 0) {
            i3 <<= 8;
            i2 -= 8;
        }
        if (((-268435456) & i3) == 0) {
            i3 <<= 4;
            i2 -= 4;
        }
        if (((-1073741824) & i3) == 0) {
            i3 <<= 2;
            i2 -= 2;
        }
        if ((i3 & Integer.MIN_VALUE) == 0) {
            i2--;
        }
        return (i2 << 1) + ((i >>> (i2 - 1)) & 1);
    }

    public static c m(d.c.a.v.b bVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 != 1) {
            if (i4 == 2) {
                return new e(bVar, i, i2, i3, i5, i6, i7, i8, i9);
            }
            throw new IllegalArgumentException();
        }
        return new d(bVar, i, i2, i3, i5, i6, i7, i8, i9);
    }

    private void y() {
        this.v = 16;
        for (int i = 0; i < 16; i++) {
            this.z[i] = d.c.a.v.b.l(this.l, i);
        }
    }

    private void z() {
        this.u = 128;
        int i = 0;
        while (true) {
            if (i >= 4) {
                break;
            }
            for (int i2 = 0; i2 < this.w; i2++) {
                this.x[i][i2] = d.c.a.v.b.i(this.j[i], i2);
            }
            for (int i3 = 14; i3 < this.w; i3++) {
                int[] iArr = this.x[i];
                iArr[i3] = iArr[i3] + d.c.a.v.b.j(((i3 >>> 1) - 1) - 4);
            }
            for (int i4 = 0; i4 < 4; i4++) {
                this.y[i][i4] = this.x[i][i4];
            }
            i++;
        }
        int i5 = 4;
        for (int i6 = 4; i6 < 14; i6++) {
            int i7 = ((i6 & 1) | 2) << ((i6 >>> 1) - 1);
            int i8 = i6 - 4;
            int length = this.k[i8].length;
            for (int i9 = 0; i9 < length; i9++) {
                int l = d.c.a.v.b.l(this.k[i8], i5 - i7);
                for (int i10 = 0; i10 < 4; i10++) {
                    this.y[i10][i5] = this.x[i10][i6] + l;
                }
                i5++;
            }
        }
        if (!m && i5 != 128) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.u <= 0) {
            z();
        }
        if (this.v <= 0) {
            y();
        }
        this.r.d();
        this.s.d();
    }

    @Override // d.c.a.u.a
    public void b() {
        super.b();
        this.q.f();
        this.r.a();
        this.s.a();
        this.u = 0;
        this.v = 0;
        this.C += this.B + 1;
        this.B = -1;
    }

    public boolean e() {
        if (this.p.n() || f()) {
            while (this.C <= 2096879 && this.o.k() <= 65510) {
                if (!i()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(g gVar, int i) {
        return d.c.a.v.b.h(this.f1989d[gVar.a()][i], 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i, g gVar) {
        return i + d.c.a.v.b.h(this.e[gVar.a()], 1);
    }

    public d.c.a.t.e n() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o(int i, int i2, g gVar, int i3) {
        return p(k(j(gVar, i3), gVar), i, gVar, i3) + this.s.c(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p(int i, int i2, g gVar, int i3) {
        int h;
        if (i2 == 0) {
            h = d.c.a.v.b.h(this.f[gVar.a()], 0) + d.c.a.v.b.h(this.i[gVar.a()][i3], 1);
        } else {
            i += d.c.a.v.b.h(this.f[gVar.a()], 1);
            if (i2 != 1) {
                return i + d.c.a.v.b.h(this.g[gVar.a()], 1) + d.c.a.v.b.h(this.h[gVar.a()], i2 - 2);
            }
            h = d.c.a.v.b.h(this.g[gVar.a()], 0);
        }
        return i + h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q(int i, int i2, int i3, int i4) {
        int c2 = i + this.r.c(i3, i4);
        int a2 = d.c.a.u.a.a(i3);
        if (i2 < 128) {
            return c2 + this.y[a2][i2];
        }
        return c2 + this.x[a2][l(i2)] + this.z[i2 & 15];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d.c.a.t.f r() {
        this.B++;
        d.c.a.t.f k = this.p.k();
        if (m || this.p.w(k)) {
            return k;
        }
        throw new AssertionError();
    }

    abstract int s();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i, g gVar) {
        return i + d.c.a.v.b.h(this.e[gVar.a()], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u(int i, g gVar, int i2) {
        return i + d.c.a.v.b.h(this.f[gVar.a()], 0) + d.c.a.v.b.h(this.i[gVar.a()][i2], 0);
    }

    public int v() {
        return this.C;
    }

    public void w() {
        this.C = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i) {
        this.B += i;
        this.p.v(i);
    }
}
