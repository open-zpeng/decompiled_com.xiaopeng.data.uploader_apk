package b.b.a.b.f;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* compiled from: RC4.java */
/* loaded from: classes.dex */
public class n {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RC4.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int[] f1079a;

        /* renamed from: b  reason: collision with root package name */
        public int f1080b;

        /* renamed from: c  reason: collision with root package name */
        public int f1081c;

        private b() {
            this.f1079a = new int[IRadioController.TEF663x_PCHANNEL];
        }
    }

    private static b a(String str) {
        if (str != null) {
            b bVar = new b();
            for (int i = 0; i < 256; i++) {
                bVar.f1079a[i] = i;
            }
            bVar.f1080b = 0;
            bVar.f1081c = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                try {
                    char charAt = str.charAt(i2);
                    int[] iArr = bVar.f1079a;
                    i3 = ((charAt + iArr[i4]) + i3) % IRadioController.TEF663x_PCHANNEL;
                    int i5 = iArr[i4];
                    iArr[i4] = iArr[i3];
                    iArr[i3] = i5;
                    i2 = (i2 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return bVar;
        }
        return null;
    }

    private static byte[] b(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i = bVar.f1080b;
        int i2 = bVar.f1081c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % IRadioController.TEF663x_PCHANNEL;
            int[] iArr = bVar.f1079a;
            i2 = (iArr[i] + i2) % IRadioController.TEF663x_PCHANNEL;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            int i5 = (iArr[i] + iArr[i2]) % IRadioController.TEF663x_PCHANNEL;
            bArr[i3] = (byte) (iArr[i5] ^ bArr[i3]);
        }
        bVar.f1080b = i;
        bVar.f1081c = i2;
        return bArr;
    }

    public static byte[] c(byte[] bArr, String str) {
        b a2;
        if (bArr == null || str == null || (a2 = a(str)) == null) {
            return null;
        }
        return b(bArr, a2);
    }
}
