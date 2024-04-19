package d.c.a.t;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1975a = new int[IRadioController.TEF663x_PCHANNEL];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i2 & 1;
                i2 >>>= 1;
                if (i4 != 0) {
                    i2 ^= -306674912;
                }
            }
            f1975a[i] = i2;
        }
    }
}
