package d.c.a.s;
/* loaded from: classes.dex */
public class b extends a {
    public b(int i) {
        super(i);
    }

    public void a(byte[] bArr, int i, int i2, byte[] bArr2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr3 = this.f1973b;
            int i4 = this.f1972a;
            int i5 = this.f1974c;
            byte b2 = bArr3[(i4 + i5) & 255];
            this.f1974c = i5 - 1;
            int i6 = i + i3;
            bArr3[i5 & 255] = bArr[i6];
            bArr2[i3] = (byte) (bArr[i6] - b2);
        }
    }
}
