package d.c.a.s;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final int f1972a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f1973b = new byte[IRadioController.TEF663x_PCHANNEL];

    /* renamed from: c  reason: collision with root package name */
    int f1974c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        if (i < 1 || i > 256) {
            throw new IllegalArgumentException();
        }
        this.f1972a = i;
    }
}
