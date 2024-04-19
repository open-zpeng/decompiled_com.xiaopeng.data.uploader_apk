package d.a.a.a.b.b;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.lib.framework.netchannelmodule.common.TrafficStatsEntry;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
/* compiled from: BZip2CompressorOutputStream.java */
/* loaded from: classes.dex */
public class a extends d.a.a.a.b.a {

    /* renamed from: b  reason: collision with root package name */
    private int f1936b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1937c;

    /* renamed from: d  reason: collision with root package name */
    private int f1938d;
    private int e;
    private int g;
    private int h;
    private int k;
    private int l;
    private final int m;
    private C0090a n;
    private b o;
    private OutputStream p;
    private volatile boolean q;
    private final c f = new c();
    private int i = -1;
    private int j = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BZip2CompressorOutputStream.java */
    /* renamed from: d.a.a.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0090a {

        /* renamed from: a  reason: collision with root package name */
        final boolean[] f1939a = new boolean[IRadioController.TEF663x_PCHANNEL];

        /* renamed from: b  reason: collision with root package name */
        final byte[] f1940b = new byte[IRadioController.TEF663x_PCHANNEL];

        /* renamed from: c  reason: collision with root package name */
        final int[] f1941c = new int[258];

        /* renamed from: d  reason: collision with root package name */
        final byte[] f1942d = new byte[18002];
        final byte[] e = new byte[18002];
        final byte[] f = new byte[IRadioController.TEF663x_PCHANNEL];
        final byte[][] g = (byte[][]) Array.newInstance(byte.class, 6, 258);
        final int[][] h = (int[][]) Array.newInstance(int.class, 6, 258);
        final int[] i = new int[6];
        final short[] j = new short[6];
        final int[][] k = (int[][]) Array.newInstance(int.class, 6, 258);
        final byte[] l = new byte[6];
        final boolean[] m = new boolean[16];
        final int[] n = new int[260];
        final int[] o = new int[IInputController.KEYCODE_LEFT_OK_BUTTON];
        final int[] p = new int[IInputController.KEYCODE_LEFT_OK_BUTTON];
        final byte[] q;
        final int[] r;
        final char[] s;
        int t;

        C0090a(int i) {
            int i2 = i * TrafficStatsEntry.FIRST_NETWORK_UID;
            this.q = new byte[i2 + 1 + 20];
            this.r = new int[i2];
            this.s = new char[i2 * 2];
        }
    }

    public a(OutputStream outputStream, int i) throws IOException {
        if (i < 1) {
            throw new IllegalArgumentException("blockSize(" + i + ") < 1");
        } else if (i <= 9) {
            this.f1937c = i;
            this.p = outputStream;
            this.m = (i * TrafficStatsEntry.FIRST_NETWORK_UID) - 20;
            l();
        } else {
            throw new IllegalArgumentException("blockSize(" + i + ") > 9");
        }
    }

    private void a() {
        this.o.a(this.n, this.f1936b);
    }

    private void b() throws IOException {
        while (this.e > 0) {
            this.p.write(this.f1938d >> 24);
            this.f1938d <<= 8;
            this.e -= 8;
        }
    }

    private void c(int i) throws IOException {
        e(8, (i >> 24) & 255);
        e(8, (i >> 16) & 255);
        e(8, (i >> 8) & 255);
        e(8, i & 255);
    }

    private void d(int i) throws IOException {
        e(8, i);
    }

    private void e(int i, int i2) throws IOException {
        OutputStream outputStream = this.p;
        int i3 = this.e;
        int i4 = this.f1938d;
        while (i3 >= 8) {
            outputStream.write(i4 >> 24);
            i4 <<= 8;
            i3 -= 8;
        }
        this.f1938d = (i2 << ((32 - i3) - i)) | i4;
        this.e = i3 + i;
    }

    private void f() throws IOException {
        int a2 = this.f.a();
        this.k = a2;
        int i = this.l;
        int i2 = (i >>> 31) | (i << 1);
        this.l = i2;
        this.l = a2 ^ i2;
        if (this.f1936b == -1) {
            return;
        }
        a();
        d(49);
        d(65);
        d(89);
        d(38);
        d(83);
        d(89);
        c(this.k);
        e(1, 0);
        n();
    }

    private void g() throws IOException {
        d(23);
        d(114);
        d(69);
        d(56);
        d(80);
        d(144);
        c(this.l);
        b();
    }

    private void i() {
        int i = this.f1936b;
        C0090a c0090a = this.n;
        boolean[] zArr = c0090a.f1939a;
        byte[] bArr = c0090a.q;
        int[] iArr = c0090a.r;
        char[] cArr = c0090a.s;
        int[] iArr2 = c0090a.f1941c;
        byte[] bArr2 = c0090a.f1940b;
        byte[] bArr3 = c0090a.f;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (zArr[i3]) {
                bArr2[i3] = (byte) i2;
                i2++;
            }
        }
        this.g = i2;
        int i4 = i2 + 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            iArr2[i5] = 0;
        }
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            bArr3[i2] = (byte) i2;
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 <= i; i8++) {
            byte b2 = bArr2[bArr[iArr[i8]] & 255];
            byte b3 = bArr3[0];
            int i9 = 0;
            while (b2 != b3) {
                i9++;
                byte b4 = bArr3[i9];
                bArr3[i9] = b3;
                b3 = b4;
            }
            bArr3[0] = b3;
            if (i9 == 0) {
                i6++;
            } else {
                if (i6 > 0) {
                    int i10 = i6 - 1;
                    while (true) {
                        if ((i10 & 1) == 0) {
                            cArr[i7] = 0;
                            i7++;
                            iArr2[0] = iArr2[0] + 1;
                        } else {
                            cArr[i7] = 1;
                            i7++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i10 < 2) {
                            break;
                        }
                        i10 = (i10 - 2) >> 1;
                    }
                    i6 = 0;
                }
                int i11 = i9 + 1;
                cArr[i7] = (char) i11;
                i7++;
                iArr2[i11] = iArr2[i11] + 1;
            }
        }
        if (i6 > 0) {
            int i12 = i6 - 1;
            while (true) {
                if ((i12 & 1) == 0) {
                    cArr[i7] = 0;
                    i7++;
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    cArr[i7] = 1;
                    i7++;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i12 < 2) {
                    break;
                }
                i12 = (i12 - 2) >> 1;
            }
        }
        cArr[i7] = (char) i4;
        iArr2[i4] = iArr2[i4] + 1;
        this.h = i7 + 1;
    }

    private static void j(int[] iArr, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            for (int i5 = 0; i5 < i3; i5++) {
                if ((bArr[i5] & 255) == i) {
                    iArr[i5] = i4;
                    i4++;
                }
            }
            i4 <<= 1;
            i++;
        }
    }

    private static void k(byte[] bArr, int[] iArr, C0090a c0090a, int i, int i2) {
        int[] iArr2 = c0090a.n;
        int[] iArr3 = c0090a.o;
        int[] iArr4 = c0090a.p;
        int i3 = i;
        while (true) {
            i3--;
            int i4 = 1;
            if (i3 < 0) {
                break;
            }
            int i5 = i3 + 1;
            if (iArr[i3] != 0) {
                i4 = iArr[i3];
            }
            iArr3[i5] = i4 << 8;
        }
        boolean z = true;
        while (z) {
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            int i6 = 0;
            for (int i7 = 1; i7 <= i; i7++) {
                iArr4[i7] = -1;
                i6++;
                iArr2[i6] = i7;
                int i8 = iArr2[i6];
                int i9 = i6;
                while (true) {
                    int i10 = i9 >> 1;
                    if (iArr3[i8] < iArr3[iArr2[i10]]) {
                        iArr2[i9] = iArr2[i10];
                        i9 = i10;
                    }
                }
                iArr2[i9] = i8;
            }
            int i11 = i;
            while (i6 > 1) {
                int i12 = iArr2[1];
                iArr2[1] = iArr2[i6];
                int i13 = i6 - 1;
                int i14 = iArr2[1];
                int i15 = 1;
                while (true) {
                    int i16 = i15 << 1;
                    if (i16 > i13) {
                        break;
                    }
                    if (i16 < i13) {
                        int i17 = i16 + 1;
                        if (iArr3[iArr2[i17]] < iArr3[iArr2[i16]]) {
                            i16 = i17;
                        }
                    }
                    if (iArr3[i14] < iArr3[iArr2[i16]]) {
                        break;
                    }
                    iArr2[i15] = iArr2[i16];
                    i15 = i16;
                }
                iArr2[i15] = i14;
                int i18 = iArr2[1];
                iArr2[1] = iArr2[i13];
                int i19 = i13 - 1;
                int i20 = iArr2[1];
                int i21 = 1;
                while (true) {
                    int i22 = i21 << 1;
                    if (i22 > i19) {
                        break;
                    }
                    if (i22 < i19) {
                        int i23 = i22 + 1;
                        if (iArr3[iArr2[i23]] < iArr3[iArr2[i22]]) {
                            i22 = i23;
                        }
                    }
                    if (iArr3[i20] < iArr3[iArr2[i22]]) {
                        break;
                    }
                    iArr2[i21] = iArr2[i22];
                    i21 = i22;
                }
                iArr2[i21] = i20;
                i11++;
                iArr4[i18] = i11;
                iArr4[i12] = i11;
                int i24 = iArr3[i12];
                int i25 = iArr3[i18];
                int i26 = (i24 & (-256)) + (i25 & (-256));
                int i27 = i24 & 255;
                int i28 = i25 & 255;
                if (i27 <= i28) {
                    i27 = i28;
                }
                iArr3[i11] = (i27 + 1) | i26;
                iArr4[i11] = -1;
                i6 = i19 + 1;
                iArr2[i6] = i11;
                int i29 = iArr2[i6];
                int i30 = iArr3[i29];
                int i31 = i6;
                while (true) {
                    int i32 = i31 >> 1;
                    if (i30 < iArr3[iArr2[i32]]) {
                        iArr2[i31] = iArr2[i32];
                        i31 = i32;
                    }
                }
                iArr2[i31] = i29;
            }
            z = false;
            for (int i33 = 1; i33 <= i; i33++) {
                int i34 = i33;
                int i35 = 0;
                while (true) {
                    i34 = iArr4[i34];
                    if (i34 < 0) {
                        break;
                    }
                    i35++;
                }
                bArr[i33 - 1] = (byte) i35;
                if (i35 > i2) {
                    z = true;
                }
            }
            if (z) {
                for (int i36 = 1; i36 < i; i36++) {
                    iArr3[i36] = (((iArr3[i36] >> 8) >> 1) + 1) << 8;
                }
            }
        }
    }

    private void l() throws IOException {
        d(66);
        d(90);
        this.n = new C0090a(this.f1937c);
        this.o = new b(this.n);
        d(104);
        d(this.f1937c + 48);
        this.l = 0;
        m();
    }

    private void m() {
        this.f.b();
        this.f1936b = -1;
        boolean[] zArr = this.n.f1939a;
        int i = IRadioController.TEF663x_PCHANNEL;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            zArr[i] = false;
        }
    }

    private void n() throws IOException {
        e(24, this.n.t);
        i();
        o();
    }

    private void o() throws IOException {
        byte[][] bArr = this.n.g;
        int i = this.g + 2;
        int i2 = 6;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i2];
            int i3 = i;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    bArr2[i3] = 15;
                }
            }
        }
        int i4 = this.h;
        int i5 = i4 >= 200 ? i4 < 600 ? 3 : i4 < 1200 ? 4 : i4 < 2400 ? 5 : 6 : 2;
        p(i5, i);
        int q = q(i5, i);
        r(i5, q);
        s(i5, i);
        t();
        u(i5, q);
        v(i5, i);
        w();
    }

    private void p(int i, int i2) {
        C0090a c0090a = this.n;
        byte[][] bArr = c0090a.g;
        int[] iArr = c0090a.f1941c;
        int i3 = this.h;
        int i4 = 0;
        for (int i5 = i; i5 > 0; i5--) {
            int i6 = i3 / i5;
            int i7 = i4 - 1;
            int i8 = i2 - 1;
            int i9 = 0;
            while (i9 < i6 && i7 < i8) {
                i7++;
                i9 += iArr[i7];
            }
            if (i7 > i4 && i5 != i && i5 != 1 && (1 & (i - i5)) != 0) {
                i9 -= iArr[i7];
                i7--;
            }
            byte[] bArr2 = bArr[i5 - 1];
            int i10 = i2;
            while (true) {
                i10--;
                if (i10 >= 0) {
                    if (i10 >= i4 && i10 <= i7) {
                        bArr2[i10] = 0;
                    } else {
                        bArr2[i10] = 15;
                    }
                }
            }
            i4 = i7 + 1;
            i3 -= i9;
        }
    }

    private int q(int i, int i2) {
        byte[] bArr;
        int i3;
        a aVar = this;
        C0090a c0090a = aVar.n;
        int[][] iArr = c0090a.h;
        int[] iArr2 = c0090a.i;
        short[] sArr = c0090a.j;
        char[] cArr = c0090a.s;
        byte[] bArr2 = c0090a.f1942d;
        byte[][] bArr3 = c0090a.g;
        int i4 = 0;
        byte[] bArr4 = bArr3[0];
        byte[] bArr5 = bArr3[1];
        byte[] bArr6 = bArr3[2];
        byte[] bArr7 = bArr3[3];
        int i5 = 4;
        byte[] bArr8 = bArr3[4];
        byte[] bArr9 = bArr3[5];
        int i6 = aVar.h;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = i;
            while (true) {
                i9--;
                if (i9 < 0) {
                    break;
                }
                iArr2[i9] = i4;
                int[] iArr3 = iArr[i9];
                int i10 = i2;
                while (true) {
                    i10--;
                    if (i10 >= 0) {
                        iArr3[i10] = i4;
                    }
                }
            }
            int i11 = i4;
            i8 = i11;
            while (i11 < aVar.h) {
                int i12 = i11;
                int min = Math.min((i11 + 50) - 1, i6 - 1);
                if (i == 6) {
                    int i13 = i12;
                    short s = 0;
                    short s2 = 0;
                    short s3 = 0;
                    short s4 = 0;
                    short s5 = 0;
                    short s6 = 0;
                    while (i13 <= min) {
                        char c2 = cArr[i13];
                        byte[] bArr10 = bArr4;
                        short s7 = (short) (s2 + (bArr5[c2] & 255));
                        short s8 = (short) (s3 + (bArr6[c2] & 255));
                        short s9 = (short) (s4 + (bArr7[c2] & 255));
                        short s10 = (short) (s5 + (bArr8[c2] & 255));
                        i13++;
                        s6 = (short) (s6 + (bArr9[c2] & 255));
                        s5 = s10;
                        bArr4 = bArr10;
                        s4 = s9;
                        s3 = s8;
                        s2 = s7;
                        s = (short) (s + (bArr4[c2] & 255));
                        i6 = i6;
                    }
                    bArr = bArr4;
                    i3 = i6;
                    sArr[0] = s;
                    sArr[1] = s2;
                    sArr[2] = s3;
                    sArr[3] = s4;
                    sArr[4] = s5;
                    sArr[5] = s6;
                } else {
                    bArr = bArr4;
                    i3 = i6;
                    int i14 = i;
                    while (true) {
                        i14--;
                        if (i14 < 0) {
                            break;
                        }
                        sArr[i14] = 0;
                    }
                    for (int i15 = i12; i15 <= min; i15++) {
                        char c3 = cArr[i15];
                        int i16 = i;
                        while (true) {
                            i16--;
                            if (i16 >= 0) {
                                sArr[i16] = (short) (sArr[i16] + (bArr3[i16][c3] & 255));
                            }
                        }
                    }
                }
                short s11 = 999999999;
                int i17 = i;
                int i18 = -1;
                while (true) {
                    i17--;
                    if (i17 < 0) {
                        break;
                    }
                    byte[] bArr11 = bArr5;
                    short s12 = sArr[i17];
                    if (s12 < s11) {
                        s11 = s12;
                        i18 = i17;
                    }
                    bArr5 = bArr11;
                }
                byte[] bArr12 = bArr5;
                iArr2[i18] = iArr2[i18] + 1;
                bArr2[i8] = (byte) i18;
                i8++;
                int[] iArr4 = iArr[i18];
                for (int i19 = i12; i19 <= min; i19++) {
                    char c4 = cArr[i19];
                    iArr4[c4] = iArr4[c4] + 1;
                }
                i11 = min + 1;
                bArr5 = bArr12;
                i6 = i3;
                bArr4 = bArr;
            }
            byte[] bArr13 = bArr4;
            byte[] bArr14 = bArr5;
            int i20 = i6;
            int i21 = 0;
            while (i21 < i) {
                k(bArr3[i21], iArr[i21], aVar.n, i2, 20);
                i21++;
                aVar = this;
            }
            i7++;
            i4 = 0;
            aVar = this;
            i5 = 4;
            bArr5 = bArr14;
            i6 = i20;
            bArr4 = bArr13;
        }
        return i8;
    }

    private void r(int i, int i2) {
        C0090a c0090a = this.n;
        byte[] bArr = c0090a.l;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            bArr[i] = (byte) i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = c0090a.f1942d[i3];
            byte b3 = bArr[0];
            int i4 = 0;
            while (b2 != b3) {
                i4++;
                byte b4 = bArr[i4];
                bArr[i4] = b3;
                b3 = b4;
            }
            bArr[0] = b3;
            c0090a.e[i3] = (byte) i4;
        }
    }

    private void s(int i, int i2) {
        C0090a c0090a = this.n;
        int[][] iArr = c0090a.k;
        byte[][] bArr = c0090a.g;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 32;
            byte[] bArr2 = bArr[i3];
            int i5 = i2;
            int i6 = 0;
            while (true) {
                i5--;
                if (i5 >= 0) {
                    int i7 = bArr2[i5] & 255;
                    if (i7 > i6) {
                        i6 = i7;
                    }
                    if (i7 < i4) {
                        i4 = i7;
                    }
                }
            }
            j(iArr[i3], bArr[i3], i4, i6, i2);
        }
    }

    private void t() throws IOException {
        C0090a c0090a = this.n;
        boolean[] zArr = c0090a.f1939a;
        boolean[] zArr2 = c0090a.m;
        int i = 16;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            zArr2[i] = false;
            int i2 = i * 16;
            int i3 = 16;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    if (zArr[i2 + i3]) {
                        zArr2[i] = true;
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            e(1, zArr2[i4] ? 1 : 0);
        }
        OutputStream outputStream = this.p;
        int i5 = this.e;
        int i6 = this.f1938d;
        for (int i7 = 0; i7 < 16; i7++) {
            if (zArr2[i7]) {
                int i8 = i7 * 16;
                for (int i9 = 0; i9 < 16; i9++) {
                    while (i5 >= 8) {
                        outputStream.write(i6 >> 24);
                        i6 <<= 8;
                        i5 -= 8;
                    }
                    if (zArr[i8 + i9]) {
                        i6 |= 1 << ((32 - i5) - 1);
                    }
                    i5++;
                }
            }
        }
        this.f1938d = i6;
        this.e = i5;
    }

    private void u(int i, int i2) throws IOException {
        e(3, i);
        e(15, i2);
        OutputStream outputStream = this.p;
        byte[] bArr = this.n.e;
        int i3 = this.e;
        int i4 = this.f1938d;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5] & 255;
            for (int i7 = 0; i7 < i6; i7++) {
                while (i3 >= 8) {
                    outputStream.write(i4 >> 24);
                    i4 <<= 8;
                    i3 -= 8;
                }
                i4 |= 1 << ((32 - i3) - 1);
                i3++;
            }
            while (i3 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i3 -= 8;
            }
            i3++;
        }
        this.f1938d = i4;
        this.e = i3;
    }

    private void v(int i, int i2) throws IOException {
        byte[][] bArr = this.n.g;
        OutputStream outputStream = this.p;
        int i3 = this.e;
        int i4 = this.f1938d;
        for (int i5 = 0; i5 < i; i5++) {
            byte[] bArr2 = bArr[i5];
            int i6 = bArr2[0] & 255;
            while (i3 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i3 -= 8;
            }
            i4 |= i6 << ((32 - i3) - 5);
            i3 += 5;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = bArr2[i7] & 255;
                while (i6 < i8) {
                    while (i3 >= 8) {
                        outputStream.write(i4 >> 24);
                        i4 <<= 8;
                        i3 -= 8;
                    }
                    i4 |= 2 << ((32 - i3) - 2);
                    i3 += 2;
                    i6++;
                }
                while (i6 > i8) {
                    while (i3 >= 8) {
                        outputStream.write(i4 >> 24);
                        i4 <<= 8;
                        i3 -= 8;
                    }
                    i4 |= 3 << ((32 - i3) - 2);
                    i3 += 2;
                    i6--;
                }
                while (i3 >= 8) {
                    outputStream.write(i4 >> 24);
                    i4 <<= 8;
                    i3 -= 8;
                }
                i3++;
            }
        }
        this.f1938d = i4;
        this.e = i3;
    }

    private void w() throws IOException {
        C0090a c0090a = this.n;
        byte[][] bArr = c0090a.g;
        int[][] iArr = c0090a.k;
        OutputStream outputStream = this.p;
        byte[] bArr2 = c0090a.f1942d;
        char[] cArr = c0090a.s;
        int i = this.h;
        int i2 = this.e;
        int i3 = this.f1938d;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int min = Math.min((i4 + 50) - 1, i - 1);
            int i6 = bArr2[i5] & 255;
            int[] iArr2 = iArr[i6];
            byte[] bArr3 = bArr[i6];
            while (i4 <= min) {
                char c2 = cArr[i4];
                while (i2 >= 8) {
                    outputStream.write(i3 >> 24);
                    i3 <<= 8;
                    i2 -= 8;
                }
                int i7 = bArr3[c2] & 255;
                i3 |= iArr2[c2] << ((32 - i2) - i7);
                i2 += i7;
                i4++;
            }
            i4 = min + 1;
            i5++;
        }
        this.f1938d = i3;
        this.e = i2;
    }

    private void x(int i) throws IOException {
        int i2 = this.i;
        if (i2 == -1) {
            this.i = i & 255;
            this.j++;
            return;
        }
        int i3 = i & 255;
        if (i2 == i3) {
            int i4 = this.j + 1;
            this.j = i4;
            if (i4 > 254) {
                y();
                this.i = -1;
                this.j = 0;
                return;
            }
            return;
        }
        y();
        this.j = 1;
        this.i = i3;
    }

    private void y() throws IOException {
        int i = this.f1936b;
        if (i < this.m) {
            int i2 = this.i;
            C0090a c0090a = this.n;
            c0090a.f1939a[i2] = true;
            byte b2 = (byte) i2;
            int i3 = this.j;
            this.f.c(i2, i3);
            if (i3 == 1) {
                c0090a.q[i + 2] = b2;
                this.f1936b = i + 1;
                return;
            } else if (i3 == 2) {
                byte[] bArr = c0090a.q;
                int i4 = i + 2;
                bArr[i4] = b2;
                bArr[i + 3] = b2;
                this.f1936b = i4;
                return;
            } else if (i3 != 3) {
                int i5 = i3 - 4;
                c0090a.f1939a[i5] = true;
                byte[] bArr2 = c0090a.q;
                bArr2[i + 2] = b2;
                bArr2[i + 3] = b2;
                bArr2[i + 4] = b2;
                int i6 = i + 5;
                bArr2[i6] = b2;
                bArr2[i + 6] = (byte) i5;
                this.f1936b = i6;
                return;
            } else {
                byte[] bArr3 = c0090a.q;
                bArr3[i + 2] = b2;
                int i7 = i + 3;
                bArr3[i7] = b2;
                bArr3[i + 4] = b2;
                this.f1936b = i7;
                return;
            }
        }
        f();
        m();
        y();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.q) {
            return;
        }
        OutputStream outputStream = this.p;
        h();
        outputStream.close();
    }

    protected void finalize() throws Throwable {
        if (!this.q) {
            System.err.println("Unclosed BZip2CompressorOutputStream detected, will *not* close it");
        }
        super.finalize();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.p;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream, d.a.a.a.b.b.b, d.a.a.a.b.b.a$a] */
    public void h() throws IOException {
        if (this.q) {
            return;
        }
        this.q = true;
        try {
            if (this.j > 0) {
                y();
            }
            this.i = -1;
            f();
            g();
        } finally {
            this.p = null;
            this.o = null;
            this.n = null;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (!this.q) {
            x(i);
            return;
        }
        throw new IOException("closed");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offs(" + i + ") < 0.");
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= bArr.length) {
                if (this.q) {
                    throw new IOException("stream closed");
                }
                while (i < i3) {
                    x(bArr[i]);
                    i++;
                }
                return;
            }
            throw new IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > buf.length(" + bArr.length + ").");
        } else {
            throw new IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
    }
}
