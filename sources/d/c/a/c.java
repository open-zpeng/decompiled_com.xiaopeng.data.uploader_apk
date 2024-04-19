package d.c.a;
/* loaded from: classes.dex */
abstract class c extends f {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f1950b;

    /* renamed from: c  reason: collision with root package name */
    static /* synthetic */ Class f1951c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1952d;
    int e = 0;

    static {
        if (f1951c == null) {
            f1951c = b("org.tukaani.xz.BCJOptions");
        }
        f1950b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.f1952d = i;
    }

    static /* synthetic */ Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1950b) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}
