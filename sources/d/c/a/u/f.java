package d.c.a.u;
/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    final g f2001a = new g();

    /* renamed from: b  reason: collision with root package name */
    final int[] f2002b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    int f2003c;

    /* renamed from: d  reason: collision with root package name */
    int f2004d;
    int e;
    boolean f;
    boolean g;
    int h;
    int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f2003c = 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2, int i3) {
        this.f2003c = i;
        this.f2004d = i2;
        this.e = i3;
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, int i2, int i3) {
        this.f2003c = i;
        this.f2004d = i2 + 1;
        this.e = i3;
        this.f = true;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, int i2, int i3, int i4, int i5) {
        this.f2003c = i;
        this.f2004d = i4 + i2 + 1;
        this.e = i5;
        this.f = true;
        this.g = true;
        this.h = i2;
        this.i = i3;
    }
}
