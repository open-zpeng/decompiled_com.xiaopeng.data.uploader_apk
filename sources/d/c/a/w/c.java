package d.c.a.w;

import com.xiaopeng.lib.utils.FileUtils;
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2014a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2015b;

    /* renamed from: c  reason: collision with root package name */
    private int f2016c;

    public c(boolean z, int i) {
        this.f2015b = z;
        this.f2016c = i;
    }

    @Override // d.c.a.w.f
    public int a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char c2;
        char c3 = 16;
        int i5 = (i + i2) - 16;
        int i6 = i;
        while (i6 <= i5) {
            int i7 = f2014a[bArr[i6] & 31];
            int i8 = 5;
            int i9 = 0;
            while (i9 < 3) {
                if (((i7 >>> i9) & 1) == 0) {
                    c2 = c3;
                    i3 = i6;
                    i4 = i9;
                } else {
                    int i10 = i8 >>> 3;
                    int i11 = i8 & 7;
                    long j = 0;
                    int i12 = 0;
                    while (i12 < 6) {
                        j |= (bArr[(i6 + i10) + i12] & 255) << (i12 * 8);
                        i12++;
                        i6 = i6;
                    }
                    i3 = i6;
                    long j2 = j >>> i11;
                    if (((j2 >>> 37) & 15) == 5 && ((j2 >>> 9) & 7) == 0) {
                        i4 = i9;
                        int i13 = (((((int) (j2 >>> 36)) & 1) << 20) | ((int) ((j2 >>> 13) & 1048575))) << 4;
                        long j3 = (this.f2015b ? i13 + ((this.f2016c + i3) - i) : i13 - ((this.f2016c + i3) - i)) >>> 4;
                        c2 = 16;
                        long j4 = ((((j2 & (-77309403137L)) | ((j3 & 1048575) << 13)) | ((j3 & FileUtils.SIZE_1MB) << 16)) << i11) | (((1 << i11) - 1) & j);
                        for (int i14 = 0; i14 < 6; i14++) {
                            bArr[i3 + i10 + i14] = (byte) (j4 >>> (i14 * 8));
                        }
                    } else {
                        i4 = i9;
                        c2 = 16;
                    }
                }
                i9 = i4 + 1;
                i8 += 41;
                c3 = c2;
                i6 = i3;
            }
            i6 += 16;
        }
        int i15 = i6 - i;
        this.f2016c += i15;
        return i15;
    }
}
