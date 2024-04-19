package d.c.a.t;
/* loaded from: classes.dex */
final class a extends e {
    private final d m;
    private final int[] n;
    private final f o;
    private final int p;
    private final int q;
    private int r;
    private int s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.r = -1;
        int i7 = i + 1;
        this.q = i7;
        this.s = i7;
        this.m = new d(i);
        this.n = new int[i7 * 2];
        this.o = new f(i4 - 1);
        this.p = i6 <= 0 ? (i4 / 2) + 16 : i6;
    }

    private int x() {
        int o = o(this.f, 4);
        if (o != 0) {
            int i = this.s + 1;
            this.s = i;
            if (i == Integer.MAX_VALUE) {
                int i2 = Integer.MAX_VALUE - this.q;
                this.m.f(i2);
                e.q(this.n, i2);
                this.s -= i2;
            }
            int i3 = this.r + 1;
            this.r = i3;
            if (i3 == this.q) {
                this.r = 0;
            }
        }
        return o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        r13 = r12.n;
        r13[r2] = 0;
        r13[r1] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void y(int r13, int r14) {
        /*
            r12 = this;
            int r0 = r12.p
            int r1 = r12.r
            int r2 = r1 << 1
            int r2 = r2 + 1
            int r1 = r1 << 1
            r3 = 0
            r4 = r3
            r5 = r4
        Ld:
            int r6 = r12.s
            int r6 = r6 - r14
            int r7 = r0 + (-1)
            if (r0 == 0) goto L7c
            int r0 = r12.q
            if (r6 < r0) goto L19
            goto L7c
        L19:
            int r8 = r12.r
            int r9 = r8 - r6
            if (r6 <= r8) goto L20
            goto L21
        L20:
            r0 = r3
        L21:
            int r9 = r9 + r0
            int r0 = r9 << 1
            int r8 = java.lang.Math.min(r4, r5)
            byte[] r9 = r12.g
            int r10 = r12.h
            int r11 = r10 + r8
            int r11 = r11 - r6
            r11 = r9[r11]
            int r10 = r10 + r8
            r9 = r9[r10]
            if (r11 != r9) goto L55
        L36:
            int r8 = r8 + 1
            if (r8 != r13) goto L47
            int[] r13 = r12.n
            r14 = r13[r0]
            r13[r1] = r14
            int r0 = r0 + 1
            r14 = r13[r0]
            r13[r2] = r14
            return
        L47:
            byte[] r9 = r12.g
            int r10 = r12.h
            int r11 = r10 + r8
            int r11 = r11 - r6
            r11 = r9[r11]
            int r10 = r10 + r8
            r9 = r9[r10]
            if (r11 == r9) goto L36
        L55:
            byte[] r9 = r12.g
            int r10 = r12.h
            int r11 = r10 + r8
            int r11 = r11 - r6
            r6 = r9[r11]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r10 = r10 + r8
            r9 = r9[r10]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r6 >= r9) goto L72
            int[] r5 = r12.n
            r5[r1] = r14
            int r0 = r0 + 1
            r14 = r5[r0]
            r1 = r0
            r5 = r8
            goto L7a
        L72:
            int[] r4 = r12.n
            r4[r2] = r14
            r14 = r4[r0]
            r2 = r0
            r4 = r8
        L7a:
            r0 = r7
            goto Ld
        L7c:
            int[] r13 = r12.n
            r13[r2] = r3
            r13[r1] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.t.a.y(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
        r1 = r17.n;
        r1[r7] = 0;
        r1[r5] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[LOOP:0: B:24:0x008b->B:27:0x009b, LOOP_START, PHI: r8 
      PHI: (r8v10 int) = (r8v4 int), (r8v11 int) binds: [B:23:0x0089, B:27:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013e  */
    @Override // d.c.a.t.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d.c.a.t.f k() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.t.a.k():d.c.a.t.f");
    }

    @Override // d.c.a.t.e
    public void v(int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            int i3 = this.f;
            int x = x();
            if (x < i3) {
                if (x == 0) {
                    i = i2;
                } else {
                    i3 = x;
                }
            }
            this.m.a(this.g, this.h);
            int d2 = this.m.d();
            this.m.g(this.s);
            y(i3, d2);
            i = i2;
        }
    }
}
