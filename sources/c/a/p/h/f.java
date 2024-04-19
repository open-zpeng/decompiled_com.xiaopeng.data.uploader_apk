package c.a.p.h;
/* compiled from: OpenHashSet.java */
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f1622a;

    /* renamed from: b  reason: collision with root package name */
    int f1623b;

    /* renamed from: c  reason: collision with root package name */
    int f1624c;

    /* renamed from: d  reason: collision with root package name */
    int f1625d;
    T[] e;

    public f() {
        this(16, 0.75f);
    }

    static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.f1623b;
        int c2 = c(t.hashCode()) & i;
        T t3 = tArr[c2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                c2 = (c2 + 1) & i;
                t2 = tArr[c2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[c2] = t;
        int i2 = this.f1624c + 1;
        this.f1624c = i2;
        if (i2 >= this.f1625d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.e;
    }

    void d() {
        T[] tArr = this.e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f1624c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c2 = c(tArr[length].hashCode()) & i2;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i2;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
                i3 = i4;
            } else {
                this.f1623b = i2;
                this.f1625d = (int) (i * this.f1622a);
                this.e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.f1623b;
        int c2 = c(t.hashCode()) & i;
        T t3 = tArr[c2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(c2, tArr, i);
        }
        do {
            c2 = (c2 + 1) & i;
            t2 = tArr[c2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(c2, tArr, i);
    }

    boolean f(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f1624c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int c2 = c(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= c2 && c2 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < c2 && c2 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public f(int i, float f) {
        this.f1622a = f;
        int a2 = g.a(i);
        this.f1623b = a2 - 1;
        this.f1625d = (int) (f * a2);
        this.e = (T[]) new Object[a2];
    }
}
