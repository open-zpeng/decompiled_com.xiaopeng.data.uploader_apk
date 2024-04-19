package d.c.a.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    private final int f1976b;
    private final int[] e;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f1977c = new int[1024];

    /* renamed from: d  reason: collision with root package name */
    private final int[] f1978d = new int[65536];
    private int f = 0;
    private int g = 0;
    private int h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        int[] iArr = new int[e(i)];
        this.e = iArr;
        this.f1976b = iArr.length - 1;
    }

    static int e(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = ((i5 | (i5 >>> 8)) >>> 1) | 65535;
        if (i6 > 16777216) {
            i6 >>>= 1;
        }
        return i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i) {
        int[] iArr = b.f1975a;
        int i2 = iArr[bArr[i] & 255] ^ (bArr[i + 1] & 255);
        this.f = i2 & 1023;
        int i3 = i2 ^ ((bArr[i + 2] & 255) << 8);
        this.g = 65535 & i3;
        this.h = ((iArr[bArr[i + 3] & 255] << 5) ^ i3) & this.f1976b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1977c[this.f];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1978d[this.g];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.e[this.h];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i) {
        e.q(this.f1977c, i);
        e.q(this.f1978d, i);
        e.q(this.e, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i) {
        this.f1977c[this.f] = i;
        this.f1978d[this.g] = i;
        this.e[this.h] = i;
    }
}
