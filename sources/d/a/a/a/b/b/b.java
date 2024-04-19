package d.a.a.a.b.b;

import com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import d.a.a.a.b.b.a;
import java.util.BitSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BlockSort.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1943a = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};

    /* renamed from: b  reason: collision with root package name */
    private int f1944b;

    /* renamed from: c  reason: collision with root package name */
    private int f1945c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1946d;
    private final int[] e = new int[IError.ERR_SERVICE_DISCONNECTED];
    private final int[] f = new int[IError.ERR_SERVICE_DISCONNECTED];
    private final int[] g = new int[IError.ERR_SERVICE_DISCONNECTED];
    private final int[] h = new int[IRadioController.TEF663x_PCHANNEL];
    private final int[] i = new int[IRadioController.TEF663x_PCHANNEL];
    private final boolean[] j = new boolean[IRadioController.TEF663x_PCHANNEL];
    private final int[] k = new int[65537];
    private final char[] l;
    private int[] m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a.C0090a c0090a) {
        this.l = c0090a.s;
    }

    private void b(int[] iArr, int[] iArr2, int i, int i2) {
        int i3;
        int i4;
        char c2 = 0;
        h(0, i, i2);
        long j = 0;
        int i5 = 1;
        long j2 = 0;
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            int[] g = g(i6);
            int i7 = g[c2];
            int i8 = g[i5];
            if (i8 - i7 < 10) {
                c(iArr, iArr2, i7, i8);
            } else {
                j2 = ((j2 * 7621) + 1) % 32768;
                long j3 = j2 % 3;
                if (j3 == j) {
                    i3 = iArr2[iArr[i7]];
                } else if (j3 == 1) {
                    i3 = iArr2[iArr[(i7 + i8) >>> i5]];
                } else {
                    i3 = iArr2[iArr[i8]];
                }
                long j4 = i3;
                int i9 = i8;
                int i10 = i9;
                int i11 = i7;
                int i12 = i11;
                while (true) {
                    if (i12 <= i9) {
                        int i13 = iArr2[iArr[i12]] - ((int) j4);
                        if (i13 == 0) {
                            i(iArr, i12, i11);
                            i11++;
                        } else if (i13 <= 0) {
                        }
                        i12++;
                    }
                    i4 = i10;
                    while (i12 <= i9) {
                        int i14 = iArr2[iArr[i9]] - ((int) j4);
                        if (i14 == 0) {
                            i(iArr, i9, i4);
                            i4--;
                            i9--;
                        } else if (i14 < 0) {
                            break;
                        } else {
                            i9--;
                        }
                    }
                    if (i12 > i9) {
                        break;
                    }
                    i(iArr, i12, i9);
                    i12++;
                    i9--;
                    i10 = i4;
                    i5 = 1;
                }
                if (i4 < i11) {
                    c2 = 0;
                    j = 0;
                    i5 = 1;
                } else {
                    int f = f(i11 - i7, i12 - i11);
                    j(iArr, i7, i12 - f, f);
                    int i15 = i8 - i4;
                    int i16 = i4 - i9;
                    int f2 = f(i15, i16);
                    j(iArr, i9 + 1, (i8 - f2) + 1, f2);
                    int i17 = ((i12 + i7) - i11) - 1;
                    int i18 = (i8 - i16) + 1;
                    if (i17 - i7 > i8 - i18) {
                        int i19 = i6 + 1;
                        h(i6, i7, i17);
                        h(i19, i18, i8);
                        i6 = i19 + 1;
                    } else {
                        int i20 = i6 + 1;
                        h(i6, i18, i8);
                        h(i20, i7, i17);
                        i6 = i20 + 1;
                    }
                    i5 = 1;
                    c2 = 0;
                    j = 0;
                }
            }
        }
    }

    private void c(int[] iArr, int[] iArr2, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 - i > 3) {
            for (int i3 = i2 - 4; i3 >= i; i3--) {
                int i4 = iArr[i3];
                int i5 = iArr2[i4];
                int i6 = i3 + 4;
                while (i6 <= i2 && i5 > iArr2[iArr[i6]]) {
                    iArr[i6 - 4] = iArr[i6];
                    i6 += 4;
                }
                iArr[i6 - 4] = i4;
            }
        }
        for (int i7 = i2 - 1; i7 >= i; i7--) {
            int i8 = iArr[i7];
            int i9 = iArr2[i8];
            int i10 = i7 + 1;
            while (i10 <= i2 && i9 > iArr2[iArr[i10]]) {
                iArr[i10 - 1] = iArr[i10];
                i10++;
            }
            iArr[i10 - 1] = i8;
        }
    }

    private int f(int i, int i2) {
        return i < i2 ? i : i2;
    }

    private int[] g(int i) {
        return new int[]{this.e[i], this.f[i]};
    }

    private void h(int i, int i2, int i3) {
        this.e[i] = i2;
        this.f[i] = i3;
    }

    private void i(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private void j(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            i(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    private int[] k() {
        int[] iArr = this.m;
        if (iArr == null) {
            int[] iArr2 = new int[this.l.length / 2];
            this.m = iArr2;
            return iArr2;
        }
        return iArr;
    }

    private void l(a.C0090a c0090a, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr = this.e;
        int[] iArr2 = this.f;
        int[] iArr3 = this.g;
        int[] iArr4 = c0090a.r;
        byte[] bArr = c0090a.q;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        int i7 = 1;
        int i8 = 1;
        while (true) {
            int i9 = i8 - 1;
            if (i9 < 0) {
                return;
            }
            int i10 = iArr[i9];
            int i11 = iArr2[i9];
            int i12 = iArr3[i9];
            if (i11 - i10 >= 20 && i12 <= 10) {
                int i13 = i12 + 1;
                int o = o(bArr[iArr4[i10] + i13], bArr[iArr4[i11] + i13], bArr[iArr4[(i10 + i11) >>> i7] + i13]) & 255;
                int i14 = i10;
                int i15 = i14;
                int i16 = i11;
                int i17 = i16;
                while (true) {
                    if (i14 <= i16) {
                        int i18 = (bArr[iArr4[i14] + i13] & 255) - o;
                        if (i18 == 0) {
                            int i19 = iArr4[i14];
                            iArr4[i14] = iArr4[i15];
                            iArr4[i15] = i19;
                            i15++;
                            i14++;
                        } else if (i18 < 0) {
                            i14++;
                        }
                    }
                    i6 = i17;
                    while (i14 <= i16) {
                        int i20 = (bArr[iArr4[i16] + i13] & 255) - o;
                        if (i20 != 0) {
                            if (i20 <= 0) {
                                break;
                            }
                            i16--;
                        } else {
                            int i21 = iArr4[i16];
                            iArr4[i16] = iArr4[i6];
                            iArr4[i6] = i21;
                            i6--;
                            i16--;
                        }
                    }
                    if (i14 > i16) {
                        break;
                    }
                    int i22 = iArr4[i14];
                    iArr4[i14] = iArr4[i16];
                    iArr4[i16] = i22;
                    i16--;
                    i14++;
                    i17 = i6;
                }
                if (i6 < i15) {
                    iArr[i9] = i10;
                    iArr2[i9] = i11;
                    iArr3[i9] = i13;
                    i8 = i9 + 1;
                    i5 = 1;
                    i7 = i5;
                } else {
                    int i23 = i15 - i10;
                    int i24 = i14 - i15;
                    if (i23 >= i24) {
                        i23 = i24;
                    }
                    p(iArr4, i10, i14 - i23, i23);
                    int i25 = i11 - i6;
                    int i26 = i6 - i16;
                    if (i25 >= i26) {
                        i25 = i26;
                    }
                    i5 = 1;
                    p(iArr4, i14, (i11 - i25) + 1, i25);
                    int i27 = ((i14 + i10) - i15) - 1;
                    int i28 = (i11 - i26) + 1;
                    iArr[i9] = i10;
                    iArr2[i9] = i27;
                    iArr3[i9] = i12;
                    int i29 = i9 + 1;
                    iArr[i29] = i27 + 1;
                    iArr2[i29] = i28 - 1;
                    iArr3[i29] = i13;
                    int i30 = i29 + 1;
                    iArr[i30] = i28;
                    iArr2[i30] = i11;
                    iArr3[i30] = i12;
                    i9 = i30 + 1;
                }
            } else {
                i5 = i7;
                if (m(c0090a, i10, i11, i12, i4)) {
                    return;
                }
            }
            i8 = i9;
            i7 = i5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x01f0, code lost:
        r4 = r19;
        r11 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0166, code lost:
        r20 = r4;
        r6 = r24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m(d.a.a.a.b.b.a.C0090a r30, int r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.a.b.b.b.m(d.a.a.a.b.b.a$a, int, int, int, int):boolean");
    }

    private static byte o(byte b2, byte b3, byte b4) {
        if (b2 < b3) {
            if (b3 >= b4) {
                if (b2 >= b4) {
                    return b2;
                }
                return b4;
            }
            return b3;
        }
        if (b3 <= b4) {
            if (b2 <= b4) {
                return b2;
            }
            return b4;
        }
        return b3;
    }

    private static void p(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.C0090a c0090a, int i) {
        this.f1945c = i * 30;
        this.f1944b = 0;
        this.f1946d = true;
        if (i + 1 < 10000) {
            d(c0090a, i);
        } else {
            n(c0090a, i);
            if (this.f1946d && this.f1944b > this.f1945c) {
                d(c0090a, i);
            }
        }
        int[] iArr = c0090a.r;
        c0090a.t = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                c0090a.t = i2;
                return;
            }
        }
    }

    final void d(a.C0090a c0090a, int i) {
        int[] iArr;
        byte[] bArr = c0090a.q;
        int i2 = i + 1;
        bArr[0] = bArr[i2];
        e(c0090a.r, bArr, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            c0090a.r[i3] = iArr[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr2 = c0090a.r;
            if (iArr2[i4] == -1) {
                iArr2[i4] = i;
                return;
            }
        }
    }

    final void e(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[257];
        int[] k = k();
        for (int i3 = 0; i3 < i; i3++) {
            k[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = bArr[i4] & 255;
            iArr2[i5] = iArr2[i5] + 1;
        }
        for (int i6 = 1; i6 < 257; i6++) {
            iArr2[i6] = iArr2[i6] + iArr2[i6 - 1];
        }
        for (int i7 = 0; i7 < i; i7++) {
            int i8 = bArr[i7] & 255;
            int i9 = iArr2[i8] - 1;
            iArr2[i8] = i9;
            iArr[i9] = i7;
        }
        BitSet bitSet = new BitSet(i + 64);
        for (int i10 = 0; i10 < 256; i10++) {
            bitSet.set(iArr2[i10]);
        }
        for (int i11 = 0; i11 < 32; i11++) {
            int i12 = (i11 * 2) + i;
            bitSet.set(i12);
            bitSet.clear(i12 + 1);
        }
        int i13 = 1;
        do {
            int i14 = 0;
            for (int i15 = 0; i15 < i; i15++) {
                if (bitSet.get(i15)) {
                    i14 = i15;
                }
                int i16 = iArr[i15] - i13;
                if (i16 < 0) {
                    i16 += i;
                }
                k[i16] = i14;
            }
            int i17 = -1;
            i2 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i17 + 1);
                int i18 = nextClearBit - 1;
                if (i18 < i && (i17 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i) {
                    if (i17 > i18) {
                        i2 += (i17 - i18) + 1;
                        b(iArr, k, i18, i17);
                        int i19 = -1;
                        while (i18 <= i17) {
                            int i20 = k[iArr[i18]];
                            if (i19 != i20) {
                                bitSet.set(i18);
                                i19 = i20;
                            }
                            i18++;
                        }
                    }
                }
            }
            i13 *= 2;
            if (i13 > i) {
                return;
            }
        } while (i2 != 0);
    }

    final void n(a.C0090a c0090a, int i) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int[] iArr2 = this.h;
        int[] iArr3 = this.i;
        boolean[] zArr = this.j;
        int[] iArr4 = this.k;
        byte[] bArr = c0090a.q;
        int[] iArr5 = c0090a.r;
        char[] cArr = this.l;
        int i7 = this.f1945c;
        boolean z = this.f1946d;
        int i8 = 65537;
        while (true) {
            i8--;
            if (i8 < 0) {
                break;
            }
            iArr4[i8] = 0;
        }
        for (int i9 = 0; i9 < 20; i9++) {
            bArr[i + i9 + 2] = bArr[(i9 % (i + 1)) + 1];
        }
        int i10 = i + 20 + 1;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            }
            cArr[i10] = 0;
        }
        int i11 = i + 1;
        bArr[0] = bArr[i11];
        int i12 = 255;
        int i13 = bArr[0] & 255;
        int i14 = 0;
        while (i14 <= i) {
            i14++;
            int i15 = bArr[i14] & 255;
            int i16 = (i13 << 8) + i15;
            iArr4[i16] = iArr4[i16] + 1;
            i13 = i15;
        }
        for (int i17 = 1; i17 <= 65536; i17++) {
            iArr4[i17] = iArr4[i17] + iArr4[i17 - 1];
        }
        char c2 = 1;
        int i18 = bArr[1] & 255;
        int i19 = 0;
        while (i19 < i) {
            int i20 = bArr[i19 + 2] & 255;
            int i21 = (i18 << 8) + i20;
            int i22 = iArr4[i21] - 1;
            iArr4[i21] = i22;
            iArr5[i22] = i19;
            i19++;
            i18 = i20;
            c2 = 1;
        }
        int i23 = ((bArr[i11] & 255) << 8) + (bArr[c2] & 255);
        int i24 = iArr4[i23] - 1;
        iArr4[i23] = i24;
        iArr5[i24] = i;
        int i25 = 256;
        while (true) {
            i25--;
            if (i25 < 0) {
                break;
            }
            zArr[i25] = false;
            iArr2[i25] = i25;
        }
        int i26 = 364;
        while (i26 != 1) {
            i26 /= 3;
            int i27 = i26;
            while (i27 <= i12) {
                int i28 = iArr2[i27];
                int i29 = iArr4[(i28 + 1) << 8] - iArr4[i28 << 8];
                int i30 = i26 - 1;
                int i31 = iArr2[i27 - i26];
                int i32 = i27;
                while (true) {
                    i6 = i7;
                    if (iArr4[(i31 + 1) << 8] - iArr4[i31 << 8] <= i29) {
                        break;
                    }
                    iArr2[i32] = i31;
                    int i33 = i32 - i26;
                    if (i33 <= i30) {
                        i32 = i33;
                        break;
                    }
                    i31 = iArr2[i33 - i26];
                    i32 = i33;
                    i7 = i6;
                }
                iArr2[i32] = i28;
                i27++;
                i7 = i6;
                i12 = 255;
            }
        }
        int i34 = i7;
        int i35 = 0;
        while (i35 <= i12) {
            int i36 = iArr2[i35];
            int i37 = 0;
            while (i37 <= i12) {
                int i38 = (i36 << 8) + i37;
                int i39 = iArr4[i38];
                if ((i39 & 2097152) != 2097152) {
                    int i40 = i39 & (-2097153);
                    int i41 = (iArr4[i38 + 1] & (-2097153)) - 1;
                    if (i41 > i40) {
                        i5 = 2097152;
                        i2 = i37;
                        i3 = i34;
                        iArr = iArr2;
                        i4 = i35;
                        l(c0090a, i40, i41, 2, i);
                        if (z && this.f1944b > i3) {
                            return;
                        }
                    } else {
                        i2 = i37;
                        i3 = i34;
                        i5 = 2097152;
                        iArr = iArr2;
                        i4 = i35;
                    }
                    iArr4[i38] = i39 | i5;
                } else {
                    i2 = i37;
                    i3 = i34;
                    iArr = iArr2;
                    i4 = i35;
                }
                i37 = i2 + 1;
                i35 = i4;
                iArr2 = iArr;
                i12 = 255;
                i34 = i3;
            }
            int i42 = i34;
            int[] iArr6 = iArr2;
            int i43 = i35;
            int i44 = 0;
            for (int i45 = i12; i44 <= i45; i45 = 255) {
                iArr3[i44] = iArr4[(i44 << 8) + i36] & (-2097153);
                i44++;
            }
            int i46 = i36 << 8;
            int i47 = iArr4[i46] & (-2097153);
            int i48 = (i36 + 1) << 8;
            int i49 = iArr4[i48] & (-2097153);
            while (i47 < i49) {
                int i50 = iArr5[i47];
                int i51 = i49;
                int i52 = bArr[i50] & 255;
                if (!zArr[i52]) {
                    iArr5[iArr3[i52]] = i50 == 0 ? i : i50 - 1;
                    iArr3[i52] = iArr3[i52] + 1;
                }
                i47++;
                i49 = i51;
            }
            int i53 = 256;
            while (true) {
                i53--;
                if (i53 < 0) {
                    break;
                }
                int i54 = (i53 << 8) + i36;
                iArr4[i54] = iArr4[i54] | 2097152;
            }
            zArr[i36] = true;
            if (i43 < 255) {
                int i55 = iArr4[i46] & (-2097153);
                int i56 = ((-2097153) & iArr4[i48]) - i55;
                int i57 = 0;
                while ((i56 >> i57) > 65534) {
                    i57++;
                }
                int i58 = 0;
                while (i58 < i56) {
                    int i59 = iArr5[i55 + i58];
                    char c3 = (char) (i58 >> i57);
                    cArr[i59] = c3;
                    int i60 = i55;
                    if (i59 < 20) {
                        cArr[i59 + i + 1] = c3;
                    }
                    i58++;
                    i55 = i60;
                }
            }
            i35 = i43 + 1;
            iArr2 = iArr6;
            i12 = 255;
            i34 = i42;
        }
    }
}
