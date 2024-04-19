package d.c.a.u;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final int f1986a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f1987b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    final g f1988c = new g();

    /* renamed from: d  reason: collision with root package name */
    final short[][] f1989d = (short[][]) Array.newInstance(short.class, 12, 16);
    final short[] e = new short[12];
    final short[] f = new short[12];
    final short[] g = new short[12];
    final short[] h = new short[12];
    final short[][] i = (short[][]) Array.newInstance(short.class, 12, 16);
    final short[][] j = (short[][]) Array.newInstance(short.class, 4, 64);
    final short[][] k = {new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
    final short[] l = new short[16];

    /* renamed from: d.c.a.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    abstract class AbstractC0091a {

        /* renamed from: a  reason: collision with root package name */
        final short[] f1990a = new short[2];

        /* renamed from: b  reason: collision with root package name */
        final short[][] f1991b = (short[][]) Array.newInstance(short.class, 16, 8);

        /* renamed from: c  reason: collision with root package name */
        final short[][] f1992c = (short[][]) Array.newInstance(short.class, 16, 8);

        /* renamed from: d  reason: collision with root package name */
        final short[] f1993d = new short[IRadioController.TEF663x_PCHANNEL];

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractC0091a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            d.c.a.v.a.a(this.f1990a);
            int i = 0;
            while (true) {
                short[][] sArr = this.f1991b;
                if (i >= sArr.length) {
                    break;
                }
                d.c.a.v.a.a(sArr[i]);
                i++;
            }
            for (int i2 = 0; i2 < this.f1991b.length; i2++) {
                d.c.a.v.a.a(this.f1992c[i2]);
            }
            d.c.a.v.a.a(this.f1993d);
        }
    }

    /* loaded from: classes.dex */
    abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f1994a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1995b;

        /* renamed from: d.c.a.u.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        abstract class AbstractC0092a {

            /* renamed from: a  reason: collision with root package name */
            final short[] f1997a = new short[768];

            /* JADX INFO: Access modifiers changed from: package-private */
            public AbstractC0092a() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void a() {
                d.c.a.v.a.a(this.f1997a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, int i2) {
            this.f1994a = i;
            this.f1995b = (1 << i2) - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int a(int i, int i2) {
            int i3 = this.f1994a;
            return (i >> (8 - i3)) + ((i2 & this.f1995b) << i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        this.f1986a = (1 << i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int a(int i) {
        if (i < 6) {
            return i - 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int[] iArr = this.f1987b;
        int i = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.f1988c.c();
        int i2 = 0;
        while (true) {
            short[][] sArr = this.f1989d;
            if (i2 >= sArr.length) {
                break;
            }
            d.c.a.v.a.a(sArr[i2]);
            i2++;
        }
        d.c.a.v.a.a(this.e);
        d.c.a.v.a.a(this.f);
        d.c.a.v.a.a(this.g);
        d.c.a.v.a.a(this.h);
        int i3 = 0;
        while (true) {
            short[][] sArr2 = this.i;
            if (i3 >= sArr2.length) {
                break;
            }
            d.c.a.v.a.a(sArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            short[][] sArr3 = this.j;
            if (i4 >= sArr3.length) {
                break;
            }
            d.c.a.v.a.a(sArr3[i4]);
            i4++;
        }
        while (true) {
            short[][] sArr4 = this.k;
            if (i >= sArr4.length) {
                d.c.a.v.a.a(this.l);
                return;
            } else {
                d.c.a.v.a.a(sArr4[i]);
                i++;
            }
        }
    }
}
