package a.a.c.h;

import android.view.View;
import android.view.ViewParent;
/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f314a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f315b;

    /* renamed from: c  reason: collision with root package name */
    private final View f316c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f317d;
    private int[] e;

    public h(View view) {
        this.f316c = view;
    }

    private ViewParent e(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f315b;
        }
        return this.f314a;
    }

    private void i(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f314a = viewParent;
        } else if (i != 1) {
        } else {
            this.f315b = viewParent;
        }
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent e;
        if (!g() || (e = e(0)) == null) {
            return false;
        }
        return o.a(e, this.f316c, f, f2, z);
    }

    public boolean b(float f, float f2) {
        ViewParent e;
        if (!g() || (e = e(0)) == null) {
            return false;
        }
        return o.b(e, this.f316c, f, f2);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent e;
        int i4;
        int i5;
        if (!g() || (e = e(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f316c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        o.c(e, this.f316c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f316c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean d(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent e;
        int i6;
        int i7;
        if (!g() || (e = e(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f316c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        o.d(e, this.f316c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.f316c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean f(int i) {
        return e(i) != null;
    }

    public boolean g() {
        return this.f317d;
    }

    public void h(boolean z) {
        if (this.f317d) {
            m.o(this.f316c);
        }
        this.f317d = z;
    }

    public boolean j(int i, int i2) {
        if (f(i2)) {
            return true;
        }
        if (g()) {
            View view = this.f316c;
            for (ViewParent parent = this.f316c.getParent(); parent != null; parent = parent.getParent()) {
                if (o.f(parent, view, this.f316c, i, i2)) {
                    i(i2, parent);
                    o.e(parent, view, this.f316c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void k(int i) {
        ViewParent e = e(i);
        if (e != null) {
            o.g(e, this.f316c, i);
            i(i, null);
        }
    }
}
