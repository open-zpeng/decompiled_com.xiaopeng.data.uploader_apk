package a.a.c.g;
/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class i<E> implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f303b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f304c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f305d;
    private Object[] e;
    private int f;

    public i() {
        this(10);
    }

    private void c() {
        int i = this.f;
        int[] iArr = this.f305d;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f303b) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f304c = false;
        this.f = i2;
    }

    public void a(int i, E e) {
        int i2 = this.f;
        if (i2 != 0 && i <= this.f305d[i2 - 1]) {
            g(i, e);
            return;
        }
        if (this.f304c && i2 >= this.f305d.length) {
            c();
        }
        int i3 = this.f;
        if (i3 >= this.f305d.length) {
            int e2 = b.e(i3 + 1);
            int[] iArr = new int[e2];
            Object[] objArr = new Object[e2];
            int[] iArr2 = this.f305d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f305d = iArr;
            this.e = objArr;
        }
        this.f305d[i3] = i;
        this.e[i3] = e;
        this.f = i3 + 1;
    }

    /* renamed from: b */
    public i<E> clone() {
        try {
            i<E> iVar = (i) super.clone();
            iVar.f305d = (int[]) this.f305d.clone();
            iVar.e = (Object[]) this.e.clone();
            return iVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E d(int i) {
        return e(i, null);
    }

    public E e(int i, E e) {
        int a2 = b.a(this.f305d, this.f, i);
        if (a2 >= 0) {
            Object[] objArr = this.e;
            if (objArr[a2] != f303b) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    public int f(int i) {
        if (this.f304c) {
            c();
        }
        return this.f305d[i];
    }

    public void g(int i, E e) {
        int a2 = b.a(this.f305d, this.f, i);
        if (a2 >= 0) {
            this.e[a2] = e;
            return;
        }
        int i2 = ~a2;
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.e;
            if (objArr[i2] == f303b) {
                this.f305d[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f304c && i3 >= this.f305d.length) {
            c();
            i2 = ~b.a(this.f305d, this.f, i);
        }
        int i4 = this.f;
        if (i4 >= this.f305d.length) {
            int e2 = b.e(i4 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.f305d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f305d = iArr;
            this.e = objArr2;
        }
        int i5 = this.f;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f305d;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f - i2);
        }
        this.f305d[i2] = i;
        this.e[i2] = e;
        this.f++;
    }

    public int h() {
        if (this.f304c) {
            c();
        }
        return this.f;
    }

    public E i(int i) {
        if (this.f304c) {
            c();
        }
        return (E) this.e[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(f(i));
            sb.append('=');
            E i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public i(int i) {
        this.f304c = false;
        if (i == 0) {
            this.f305d = b.f278a;
            this.e = b.f280c;
        } else {
            int e = b.e(i);
            this.f305d = new int[e];
            this.e = new Object[e];
        }
        this.f = 0;
    }
}
