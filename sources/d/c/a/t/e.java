package d.c.a.t;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1979a;

    /* renamed from: b  reason: collision with root package name */
    static /* synthetic */ Class f1980b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1981c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1982d;
    final int e;
    final int f;
    final byte[] g;
    int h = -1;
    private int i = -1;
    private boolean j = false;
    private int k = 0;
    private int l = 0;

    static {
        if (f1980b == null) {
            f1980b = a("org.tukaani.xz.lz.LZEncoder");
        }
        f1979a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, int i2, int i3, int i4, int i5) {
        this.g = new byte[e(i, i2, i3, i5)];
        this.f1981c = i2 + i;
        this.f1982d = i3 + i5;
        this.e = i5;
        this.f = i4;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static int e(int i, int i2, int i3, int i4) {
        return i2 + i + i3 + i4 + Math.min((i / 2) + 262144, 536870912);
    }

    public static e h(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i6 != 4) {
            if (i6 == 20) {
                return new a(i, i2, i3, i4, i5, i7);
            }
            throw new IllegalArgumentException();
        }
        return new c(i, i2, i3, i4, i5, i7);
    }

    private void p() {
        int i = ((this.h + 1) - this.f1981c) & (-16);
        byte[] bArr = this.g;
        System.arraycopy(bArr, i, bArr, 0, this.k - i);
        this.h -= i;
        this.i -= i;
        this.k -= i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] <= i) {
                iArr[i2] = 0;
            } else {
                iArr[i2] = iArr[i2] - i;
            }
        }
    }

    private void r() {
        int i;
        int i2 = this.l;
        if (i2 <= 0 || (i = this.h) >= this.i) {
            return;
        }
        this.h = i - i2;
        this.l = 0;
        v(i2);
        if (!f1979a && this.l >= i2) {
            throw new AssertionError();
        }
    }

    public void b(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.g, (this.h + 1) - i, i2);
    }

    public int c(byte[] bArr, int i, int i2) {
        if (f1979a || !this.j) {
            if (this.h >= this.g.length - this.f1982d) {
                p();
            }
            byte[] bArr2 = this.g;
            int length = bArr2.length;
            int i3 = this.k;
            if (i2 > length - i3) {
                i2 = bArr2.length - i3;
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            int i4 = this.k + i2;
            this.k = i4;
            int i5 = this.f1982d;
            if (i4 >= i5) {
                this.i = i4 - i5;
            }
            r();
            return i2;
        }
        throw new AssertionError();
    }

    public int d() {
        if (f1979a || n()) {
            return this.k - this.h;
        }
        throw new AssertionError();
    }

    public int f(int i) {
        return this.g[this.h - i] & 255;
    }

    public int g(int i, int i2) {
        return this.g[(this.h + i) - i2] & 255;
    }

    public int i(int i, int i2) {
        int i3 = (this.h - i) - 1;
        int i4 = 0;
        while (i4 < i2) {
            byte[] bArr = this.g;
            if (bArr[this.h + i4] != bArr[i3 + i4]) {
                break;
            }
            i4++;
        }
        return i4;
    }

    public int j(int i, int i2, int i3) {
        int i4 = this.h + i;
        int i5 = (i4 - i2) - 1;
        int i6 = 0;
        while (i6 < i3) {
            byte[] bArr = this.g;
            if (bArr[i4 + i6] != bArr[i5 + i6]) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public abstract f k();

    public int l() {
        return this.h;
    }

    public boolean m(int i) {
        return this.h - i < this.i;
    }

    public boolean n() {
        return this.h != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o(int i, int i2) {
        if (f1979a || i >= i2) {
            int i3 = this.h + 1;
            this.h = i3;
            int i4 = this.k - i3;
            if (i4 < i) {
                if (i4 < i2 || !this.j) {
                    this.l++;
                    return 0;
                }
                return i4;
            }
            return i4;
        }
        throw new AssertionError();
    }

    public void s() {
        this.i = this.k - 1;
        this.j = true;
        r();
    }

    public void t() {
        this.i = this.k - 1;
        r();
    }

    public void u(int i, byte[] bArr) {
        boolean z = f1979a;
        if (!z && n()) {
            throw new AssertionError();
        }
        if (!z && this.k != 0) {
            throw new AssertionError();
        }
        if (bArr != null) {
            int min = Math.min(bArr.length, i);
            System.arraycopy(bArr, bArr.length - min, this.g, 0, min);
            this.k += min;
            v(min);
        }
    }

    public abstract void v(int i);

    public boolean w(f fVar) {
        int min = Math.min(d(), this.e);
        for (int i = 0; i < fVar.f1985c; i++) {
            if (i(fVar.f1984b[i], min) != fVar.f1983a[i]) {
                return false;
            }
        }
        return true;
    }
}
