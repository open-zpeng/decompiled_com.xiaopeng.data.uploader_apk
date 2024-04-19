package d.c.a.v;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2006a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f2007b;

    /* renamed from: c  reason: collision with root package name */
    static /* synthetic */ Class f2008c;

    /* renamed from: d  reason: collision with root package name */
    private long f2009d;
    private int e;
    private int f;
    private byte g;
    private final byte[] h;
    private int i;

    static {
        if (f2008c == null) {
            f2008c = b("org.tukaani.xz.rangecoder.RangeEncoder");
        }
        f2007b = true;
        f2006a = new int[128];
        for (int i = 8; i < 2048; i += 16) {
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < 4; i4++) {
                i2 *= i2;
                i3 <<= 1;
                while (((-65536) & i2) != 0) {
                    i2 >>>= 1;
                    i3++;
                }
            }
            f2006a[i >> 4] = 161 - i3;
        }
    }

    public b(int i) {
        this.h = new byte[i];
        m();
    }

    static /* synthetic */ Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static int h(int i, int i2) {
        if (f2007b || i2 == 0 || i2 == 1) {
            return f2006a[(i ^ ((-i2) & 2047)) >>> 4];
        }
        throw new AssertionError();
    }

    public static int i(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 0;
        do {
            int i3 = length & 1;
            length >>>= 1;
            i2 += h(sArr[length], i3);
        } while (length != 1);
        return i2;
    }

    public static int j(int i) {
        return i << 4;
    }

    public static int l(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 0;
        int i3 = 1;
        do {
            int i4 = length & 1;
            length >>>= 1;
            i2 += h(sArr[i3], i4);
            i3 = (i3 << 1) | i4;
        } while (length != 1);
        return i2;
    }

    private void n() {
        int i;
        long j = this.f2009d;
        int i2 = (int) (j >>> 32);
        if (i2 != 0 || j < 4278190080L) {
            byte b2 = this.g;
            do {
                byte[] bArr = this.h;
                int i3 = this.i;
                this.i = i3 + 1;
                bArr[i3] = (byte) (b2 + i2);
                b2 = 255;
                i = this.f - 1;
                this.f = i;
            } while (i != 0);
            this.g = (byte) (this.f2009d >>> 24);
        }
        this.f++;
        this.f2009d = (this.f2009d & 16777215) << 8;
    }

    public void c(short[] sArr, int i, int i2) {
        short s = sArr[i];
        int i3 = this.e;
        int i4 = (i3 >>> 11) * s;
        if (i2 == 0) {
            this.e = i4;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
        } else {
            this.f2009d += i4 & 4294967295L;
            this.e = i3 - i4;
            sArr[i] = (short) (s - (s >>> 5));
        }
        int i5 = this.e;
        if (((-16777216) & i5) == 0) {
            this.e = i5 << 8;
            n();
        }
    }

    public void d(short[] sArr, int i) {
        int length = sArr.length;
        int i2 = 1;
        do {
            length >>>= 1;
            int i3 = i & length;
            c(sArr, i2, i3);
            i2 <<= 1;
            if (i3 != 0) {
                i2 |= 1;
                continue;
            }
        } while (length != 1);
    }

    public void e(int i, int i2) {
        do {
            int i3 = this.e >>> 1;
            this.e = i3;
            i2--;
            this.f2009d += (0 - ((i >>> i2) & 1)) & i3;
            if (((-16777216) & i3) == 0) {
                this.e = i3 << 8;
                n();
                continue;
            }
        } while (i2 != 0);
    }

    public void f(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 1;
        do {
            int i3 = length & 1;
            length >>>= 1;
            c(sArr, i2, i3);
            i2 = (i2 << 1) | i3;
        } while (length != 1);
    }

    public int g() {
        for (int i = 0; i < 5; i++) {
            n();
        }
        return this.i;
    }

    public int k() {
        return ((this.i + this.f) + 5) - 1;
    }

    public void m() {
        this.f2009d = 0L;
        this.e = -1;
        this.g = (byte) 0;
        this.f = 1;
        this.i = 0;
    }

    public void o(OutputStream outputStream) throws IOException {
        outputStream.write(this.h, 0, this.i);
    }
}
