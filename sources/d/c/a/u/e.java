package d.c.a.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends c {
    private static int D;
    private static int E;
    static final /* synthetic */ boolean F;
    static /* synthetic */ Class G;
    private final f[] H;
    private int I;
    private int J;
    private d.c.a.t.f K;
    private final int[] L;
    private final g M;

    static {
        if (G == null) {
            G = d("org.tukaani.xz.lzma.LZMAEncoderNormal");
        }
        F = true;
        D = 4096;
        E = 4096;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d.c.a.v.b bVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(bVar, d.c.a.t.e.h(i4, Math.max(i5, D), E, i6, 273, i7, i8), i, i2, i3, i4, i6);
        this.H = new f[4096];
        this.I = 0;
        this.J = 0;
        this.L = new int[4];
        this.M = new g();
        for (int i9 = 0; i9 < 4096; i9++) {
            this.H[i9] = new f();
        }
    }

    private void B(int i, int i2, int i3, int i4) {
        boolean z;
        int f = this.p.f(0);
        int f2 = this.p.f(this.H[this.I].f2002b[0] + 1);
        int e = this.H[this.I].f2003c + this.q.e(f, f2, this.p.f(1), i, this.H[this.I].f2001a);
        f[] fVarArr = this.H;
        int i5 = this.I;
        if (e < fVarArr[i5 + 1].f2003c) {
            fVarArr[i5 + 1].b(e, i5, -1);
            z = true;
        } else {
            z = false;
        }
        if (f2 == f) {
            f[] fVarArr2 = this.H;
            int i6 = this.I;
            if (fVarArr2[i6 + 1].f2004d == i6 || fVarArr2[i6 + 1].e != 0) {
                int u = u(i4, fVarArr2[i6].f2001a, i2);
                f[] fVarArr3 = this.H;
                int i7 = this.I;
                if (u <= fVarArr3[i7 + 1].f2003c) {
                    fVarArr3[i7 + 1].b(u, i7, 0);
                    z = true;
                }
            }
        }
        if (z || f2 == f || i3 <= 2) {
            return;
        }
        int j = this.p.j(1, this.H[this.I].f2002b[0], Math.min(this.t, i3 - 1));
        if (j >= 2) {
            this.M.d(this.H[this.I].f2001a);
            this.M.e();
            int o = e + o(0, j, this.M, (i + 1) & this.f1986a);
            int i8 = this.I + 1 + j;
            while (true) {
                int i9 = this.J;
                if (i9 >= i8) {
                    break;
                }
                f[] fVarArr4 = this.H;
                int i10 = i9 + 1;
                this.J = i10;
                fVarArr4[i10].a();
            }
            f[] fVarArr5 = this.H;
            if (o < fVarArr5[i8].f2003c) {
                fVarArr5[i8].c(o, this.I, 0);
            }
        }
    }

    private int C(int i, int i2, int i3, int i4) {
        int i5;
        int min = Math.min(i3, this.t);
        int i6 = 2;
        for (int i7 = 0; i7 < 4; i7++) {
            int i8 = this.p.i(this.H[this.I].f2002b[i7], min);
            if (i8 >= 2) {
                while (true) {
                    int i9 = this.J;
                    i5 = this.I;
                    if (i9 >= i5 + i8) {
                        break;
                    }
                    f[] fVarArr = this.H;
                    int i10 = i9 + 1;
                    this.J = i10;
                    fVarArr[i10].a();
                }
                int p = p(i4, i7, this.H[i5].f2001a, i2);
                for (int i11 = i8; i11 >= 2; i11--) {
                    int c2 = this.s.c(i11, i2) + p;
                    f[] fVarArr2 = this.H;
                    int i12 = this.I;
                    if (c2 < fVarArr2[i12 + i11].f2003c) {
                        fVarArr2[i12 + i11].b(c2, i12, i7);
                    }
                }
                if (i7 == 0) {
                    i6 = i8 + 1;
                }
                int i13 = i6;
                int j = this.p.j(i8 + 1, this.H[this.I].f2002b[i7], Math.min(this.t, (i3 - i8) - 1));
                if (j >= 2) {
                    int c3 = p + this.s.c(i8, i2);
                    this.M.d(this.H[this.I].f2001a);
                    this.M.f();
                    int i14 = i + i8;
                    int e = c3 + this.q.e(this.p.g(i8, 0), this.p.f(0), this.p.g(i8, 1), i14, this.M);
                    this.M.e();
                    int o = e + o(0, j, this.M, (i14 + 1) & this.f1986a);
                    int i15 = this.I + i8 + 1 + j;
                    while (true) {
                        int i16 = this.J;
                        if (i16 >= i15) {
                            break;
                        }
                        f[] fVarArr3 = this.H;
                        int i17 = i16 + 1;
                        this.J = i17;
                        fVarArr3[i17].a();
                    }
                    f[] fVarArr4 = this.H;
                    if (o < fVarArr4[i15].f2003c) {
                        fVarArr4[i15].d(o, this.I, i7, i8, 0);
                    }
                }
                i6 = i13;
            }
        }
        return i6;
    }

    private void D(int i, int i2, int i3, int i4, int i5) {
        int i6;
        d.c.a.t.f fVar;
        int[] iArr;
        int i7;
        int i8 = i5;
        d.c.a.t.f fVar2 = this.K;
        if (fVar2.f1983a[fVar2.f1985c - 1] > i3) {
            fVar2.f1985c = 0;
            while (true) {
                fVar = this.K;
                iArr = fVar.f1983a;
                i7 = fVar.f1985c;
                if (iArr[i7] >= i3) {
                    break;
                }
                fVar.f1985c = i7 + 1;
            }
            fVar.f1985c = i7 + 1;
            iArr[i7] = i3;
        }
        d.c.a.t.f fVar3 = this.K;
        if (fVar3.f1983a[fVar3.f1985c - 1] < i8) {
            return;
        }
        while (true) {
            int i9 = this.J;
            i6 = this.I;
            d.c.a.t.f fVar4 = this.K;
            if (i9 >= fVar4.f1983a[fVar4.f1985c - 1] + i6) {
                break;
            }
            f[] fVarArr = this.H;
            int i10 = i9 + 1;
            this.J = i10;
            fVarArr[i10].a();
        }
        int t = t(i4, this.H[i6].f2001a);
        int i11 = 0;
        while (i8 > this.K.f1983a[i11]) {
            i11++;
        }
        while (true) {
            int i12 = this.K.f1984b[i11];
            int q = q(t, i12, i8, i2);
            f[] fVarArr2 = this.H;
            int i13 = this.I;
            if (q < fVarArr2[i13 + i8].f2003c) {
                fVarArr2[i13 + i8].b(q, i13, i12 + 4);
            }
            if (i8 == this.K.f1983a[i11]) {
                int j = this.p.j(i8 + 1, i12, Math.min(this.t, (i3 - i8) - 1));
                if (j >= 2) {
                    this.M.d(this.H[this.I].f2001a);
                    this.M.g();
                    int i14 = i + i8;
                    int e = q + this.q.e(this.p.g(i8, 0), this.p.f(0), this.p.g(i8, 1), i14, this.M);
                    this.M.e();
                    int o = e + o(0, j, this.M, (i14 + 1) & this.f1986a);
                    int i15 = this.I + i8 + 1 + j;
                    while (true) {
                        int i16 = this.J;
                        if (i16 >= i15) {
                            break;
                        }
                        f[] fVarArr3 = this.H;
                        int i17 = i16 + 1;
                        this.J = i17;
                        fVarArr3[i17].a();
                    }
                    f[] fVarArr4 = this.H;
                    if (o < fVarArr4[i15].f2003c) {
                        fVarArr4[i15].d(o, this.I, i12 + 4, i8, 0);
                    }
                }
                i11++;
                if (i11 == this.K.f1985c) {
                    return;
                }
            }
            i8++;
        }
    }

    private int E() {
        int i = this.I;
        this.J = i;
        int i2 = this.H[i].f2004d;
        while (true) {
            f[] fVarArr = this.H;
            int i3 = this.I;
            f fVar = fVarArr[i3];
            if (fVar.f) {
                fVarArr[i2].f2004d = i3;
                fVarArr[i2].e = -1;
                int i4 = i2 - 1;
                this.I = i2;
                if (fVar.g) {
                    fVarArr[i4].f2004d = i4 + 1;
                    fVarArr[i4].e = fVar.i;
                    this.I = i4;
                    i2 = fVar.h;
                } else {
                    i2 = i4;
                }
            }
            int i5 = fVarArr[i2].f2004d;
            fVarArr[i2].f2004d = this.I;
            this.I = i2;
            if (i2 <= 0) {
                int i6 = fVarArr[0].f2004d;
                this.I = i6;
                this.A = fVarArr[i6].e;
                return i6;
            }
            i2 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void F() {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.u.e.F():void");
    }

    static /* synthetic */ Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // d.c.a.u.c, d.c.a.u.a
    public void b() {
        this.I = 0;
        this.J = 0;
        super.b();
    }

    @Override // d.c.a.u.c
    int s() {
        int i;
        int i2 = this.I;
        int i3 = this.J;
        if (i2 < i3) {
            f[] fVarArr = this.H;
            int i4 = fVarArr[i2].f2004d - i2;
            int i5 = fVarArr[i2].f2004d;
            this.I = i5;
            this.A = fVarArr[i5].e;
            return i4;
        } else if (F || i2 == i3) {
            this.I = 0;
            this.J = 0;
            this.A = -1;
            if (this.B == -1) {
                this.K = r();
            }
            int min = Math.min(this.p.d(), 273);
            if (min < 2) {
                return 1;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                this.L[i7] = this.p.i(this.f1987b[i7], min);
                int[] iArr = this.L;
                if (iArr[i7] < 2) {
                    iArr[i7] = 0;
                } else if (iArr[i7] > iArr[i6]) {
                    i6 = i7;
                }
            }
            int[] iArr2 = this.L;
            int i8 = iArr2[i6];
            int i9 = this.t;
            if (i8 >= i9) {
                this.A = i6;
                x(iArr2[i6] - 1);
                return this.L[i6];
            }
            d.c.a.t.f fVar = this.K;
            int i10 = fVar.f1985c;
            if (i10 > 0) {
                i = fVar.f1983a[i10 - 1];
                int i11 = fVar.f1984b[i10 - 1];
                if (i >= i9) {
                    this.A = i11 + 4;
                    x(i - 1);
                    return i;
                }
            } else {
                i = 0;
            }
            int f = this.p.f(0);
            int f2 = this.p.f(this.f1987b[0] + 1);
            if (i >= 2 || f == f2 || this.L[i6] >= 2) {
                int l = this.p.l();
                int i12 = l & this.f1986a;
                this.H[1].b(this.q.e(f, f2, this.p.f(1), l, this.f1988c), 0, -1);
                int j = j(this.f1988c, i12);
                int k = k(j, this.f1988c);
                if (f2 == f) {
                    int u = u(k, this.f1988c, i12);
                    f[] fVarArr2 = this.H;
                    if (u < fVarArr2[1].f2003c) {
                        fVarArr2[1].b(u, 0, 0);
                    }
                }
                int max = Math.max(i, this.L[i6]);
                this.J = max;
                if (max < 2) {
                    if (F || max == 0) {
                        this.A = this.H[1].e;
                        return 1;
                    }
                    throw new AssertionError(this.J);
                }
                A();
                this.H[0].f2001a.d(this.f1988c);
                System.arraycopy(this.f1987b, 0, this.H[0].f2002b, 0, 4);
                for (int i13 = this.J; i13 >= 2; i13--) {
                    this.H[i13].a();
                }
                int i14 = 0;
                for (int i15 = 4; i14 < i15; i15 = 4) {
                    int i16 = this.L[i14];
                    if (i16 >= 2) {
                        int p = p(k, i14, this.f1988c, i12);
                        while (true) {
                            int c2 = this.s.c(i16, i12) + p;
                            f[] fVarArr3 = this.H;
                            if (c2 < fVarArr3[i16].f2003c) {
                                fVarArr3[i16].b(c2, 0, i14);
                            }
                            i16--;
                            if (i16 < 2) {
                                break;
                            }
                        }
                    }
                    i14++;
                }
                int max2 = Math.max(this.L[0] + 1, 2);
                if (max2 <= i) {
                    int t = t(j, this.f1988c);
                    int i17 = 0;
                    while (max2 > this.K.f1983a[i17]) {
                        i17++;
                    }
                    while (true) {
                        int i18 = this.K.f1984b[i17];
                        int q = q(t, i18, max2, i12);
                        f[] fVarArr4 = this.H;
                        if (q < fVarArr4[max2].f2003c) {
                            fVarArr4[max2].b(q, 0, i18 + 4);
                        }
                        d.c.a.t.f fVar2 = this.K;
                        if (max2 == fVar2.f1983a[i17] && (i17 = i17 + 1) == fVar2.f1985c) {
                            break;
                        }
                        max2++;
                    }
                }
                int min2 = Math.min(this.p.d(), 4095);
                while (true) {
                    int i19 = this.I + 1;
                    this.I = i19;
                    if (i19 >= this.J) {
                        break;
                    }
                    d.c.a.t.f r = r();
                    this.K = r;
                    int i20 = r.f1985c;
                    if (i20 > 0 && r.f1983a[i20 - 1] >= this.t) {
                        break;
                    }
                    int i21 = min2 - 1;
                    int i22 = l + 1;
                    int i23 = i22 & this.f1986a;
                    F();
                    f[] fVarArr5 = this.H;
                    int i24 = this.I;
                    int j2 = fVarArr5[i24].f2003c + j(fVarArr5[i24].f2001a, i23);
                    int k2 = k(j2, this.H[this.I].f2001a);
                    B(i22, i23, i21, k2);
                    if (i21 >= 2) {
                        int C = C(i22, i23, i21, k2);
                        if (this.K.f1985c > 0) {
                            D(i22, i23, i21, j2, C);
                        }
                    }
                    min2 = i21;
                    l = i22;
                }
                return E();
            }
            return 1;
        } else {
            throw new AssertionError();
        }
    }
}
