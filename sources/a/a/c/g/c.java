package a.a.c.g;
/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class c<E> implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f281b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f282c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f283d;
    private Object[] e;
    private int f;

    public c() {
        this(10);
    }

    private void d() {
        int i = this.f;
        long[] jArr = this.f283d;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f281b) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f282c = false;
        this.f = i2;
    }

    public void a(long j, E e) {
        int i = this.f;
        if (i != 0 && j <= this.f283d[i - 1]) {
            h(j, e);
            return;
        }
        if (this.f282c && i >= this.f283d.length) {
            d();
        }
        int i2 = this.f;
        if (i2 >= this.f283d.length) {
            int f = b.f(i2 + 1);
            long[] jArr = new long[f];
            Object[] objArr = new Object[f];
            long[] jArr2 = this.f283d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f283d = jArr;
            this.e = objArr;
        }
        this.f283d[i2] = j;
        this.e[i2] = e;
        this.f = i2 + 1;
    }

    /* renamed from: b */
    public c<E> clone() {
        try {
            c<E> cVar = (c) super.clone();
            cVar.f283d = (long[]) this.f283d.clone();
            cVar.e = (Object[]) this.e.clone();
            return cVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void c(long j) {
        int b2 = b.b(this.f283d, this.f, j);
        if (b2 >= 0) {
            Object[] objArr = this.e;
            Object obj = objArr[b2];
            Object obj2 = f281b;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f282c = true;
            }
        }
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e) {
        int b2 = b.b(this.f283d, this.f, j);
        if (b2 >= 0) {
            Object[] objArr = this.e;
            if (objArr[b2] != f281b) {
                return (E) objArr[b2];
            }
        }
        return e;
    }

    public long g(int i) {
        if (this.f282c) {
            d();
        }
        return this.f283d[i];
    }

    public void h(long j, E e) {
        int b2 = b.b(this.f283d, this.f, j);
        if (b2 >= 0) {
            this.e[b2] = e;
            return;
        }
        int i = ~b2;
        int i2 = this.f;
        if (i < i2) {
            Object[] objArr = this.e;
            if (objArr[i] == f281b) {
                this.f283d[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f282c && i2 >= this.f283d.length) {
            d();
            i = ~b.b(this.f283d, this.f, j);
        }
        int i3 = this.f;
        if (i3 >= this.f283d.length) {
            int f = b.f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.f283d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f283d = jArr;
            this.e = objArr2;
        }
        int i4 = this.f;
        if (i4 - i != 0) {
            long[] jArr3 = this.f283d;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i, objArr4, i5, this.f - i);
        }
        this.f283d[i] = j;
        this.e[i] = e;
        this.f++;
    }

    public int i() {
        if (this.f282c) {
            d();
        }
        return this.f;
    }

    public E j(int i) {
        if (this.f282c) {
            d();
        }
        return (E) this.e[i];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(g(i));
            sb.append('=');
            E j = j(i);
            if (j != this) {
                sb.append(j);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public c(int i) {
        this.f282c = false;
        if (i == 0) {
            this.f283d = b.f279b;
            this.e = b.f280c;
        } else {
            int f = b.f(i);
            this.f283d = new long[f];
            this.e = new Object[f];
        }
        this.f = 0;
    }
}
