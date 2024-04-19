package d.c.a;
/* loaded from: classes.dex */
public class j extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1960b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1961c;

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f1962d;
    static /* synthetic */ Class e;
    private int f;
    private byte[] g = null;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    static {
        if (e == null) {
            e = b("org.tukaani.xz.LZMA2Options");
        }
        f1962d = true;
        f1960b = new int[]{262144, 1048576, 2097152, 4194304, 4194304, 8388608, 8388608, 16777216, 33554432, 67108864};
        f1961c = new int[]{4, 8, 24, 48};
    }

    public j() {
        try {
            m(6);
        } catch (p unused) {
            if (!f1962d) {
                throw new AssertionError();
            }
            throw new RuntimeException();
        }
    }

    static /* synthetic */ Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    @Override // d.c.a.f
    public g a(g gVar) {
        return this.k == 0 ? new o(gVar) : new k(gVar, this);
    }

    public int c() {
        return this.n;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1962d) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.m;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.l;
    }

    public int j() {
        return this.j;
    }

    public byte[] k() {
        return this.g;
    }

    public void l(int i) throws p {
        if (i < 4096) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LZMA2 dictionary size must be at least 4 KiB: ");
            stringBuffer.append(i);
            stringBuffer.append(" B");
            throw new p(stringBuffer.toString());
        } else if (i <= 805306368) {
            this.f = i;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("LZMA2 dictionary size must not exceed 768 MiB: ");
            stringBuffer2.append(i);
            stringBuffer2.append(" B");
            throw new p(stringBuffer2.toString());
        }
    }

    public void m(int i) throws p {
        if (i < 0 || i > 9) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unsupported preset: ");
            stringBuffer.append(i);
            throw new p(stringBuffer.toString());
        }
        this.h = 3;
        this.i = 0;
        this.j = 2;
        this.f = f1960b[i];
        if (i <= 3) {
            this.k = 1;
            this.m = 4;
            this.l = i <= 1 ? 128 : 273;
            this.n = f1961c[i];
            return;
        }
        this.k = 2;
        this.m = 20;
        this.l = i == 4 ? 16 : i == 5 ? 32 : 64;
        this.n = 0;
    }
}
