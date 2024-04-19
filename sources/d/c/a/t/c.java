package d.c.a.t;
/* loaded from: classes.dex */
final class c extends e {
    static final /* synthetic */ boolean m;
    static /* synthetic */ Class n;
    private final d o;
    private final int[] p;
    private final f q;
    private final int r;
    private final int s;
    private int t;
    private int u;

    static {
        if (n == null) {
            n = a("org.tukaani.xz.lz.HC4");
        }
        m = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.t = -1;
        this.o = new d(i);
        int i7 = i + 1;
        this.s = i7;
        this.p = new int[i7];
        this.u = i7;
        this.q = new f(i4 - 1);
        this.r = i6 <= 0 ? (i4 / 4) + 4 : i6;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private int x() {
        int o = o(4, 4);
        if (o != 0) {
            int i = this.u + 1;
            this.u = i;
            if (i == Integer.MAX_VALUE) {
                int i2 = Integer.MAX_VALUE - this.s;
                this.o.f(i2);
                e.q(this.p, i2);
                this.u -= i2;
            }
            int i3 = this.t + 1;
            this.t = i3;
            if (i3 == this.s) {
                this.t = 0;
            }
        }
        return o;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f A[LOOP:0: B:24:0x008f->B:27:0x009f, LOOP_START, PHI: r7 
      PHI: (r7v12 int) = (r7v5 int), (r7v13 int) binds: [B:23:0x008d, B:27:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1  */
    @Override // d.c.a.t.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d.c.a.t.f k() {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.t.c.k():d.c.a.t.f");
    }

    @Override // d.c.a.t.e
    public void v(int i) {
        if (!m && i < 0) {
            throw new AssertionError();
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (x() != 0) {
                this.o.a(this.g, this.h);
                this.p[this.t] = this.o.d();
                this.o.g(this.u);
            }
            i = i2;
        }
    }
}
