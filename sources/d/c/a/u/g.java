package d.c.a.u;
/* loaded from: classes.dex */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private int f2005a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2005a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f2005a < 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f2005a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(g gVar) {
        this.f2005a = gVar.f2005a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        int i = this.f2005a;
        this.f2005a = i <= 3 ? 0 : i <= 9 ? i - 3 : i - 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f2005a = this.f2005a < 7 ? 8 : 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f2005a = this.f2005a >= 7 ? 10 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f2005a = this.f2005a < 7 ? 9 : 11;
    }
}
