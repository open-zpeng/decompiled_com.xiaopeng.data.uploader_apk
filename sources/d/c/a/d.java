package d.c.a;
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f1953b;

    /* renamed from: c  reason: collision with root package name */
    static /* synthetic */ Class f1954c;

    /* renamed from: d  reason: collision with root package name */
    private int f1955d = 1;

    static {
        if (f1954c == null) {
            f1954c = b("org.tukaani.xz.DeltaOptions");
        }
        f1953b = true;
    }

    public d(int i) throws p {
        d(i);
    }

    static /* synthetic */ Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // d.c.a.f
    public g a(g gVar) {
        return new e(gVar, this);
    }

    public int c() {
        return this.f1955d;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1953b) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }

    public void d(int i) throws p {
        if (i >= 1 && i <= 256) {
            this.f1955d = i;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Delta distance must be in the range [1, 256]: ");
        stringBuffer.append(i);
        throw new p(stringBuffer.toString());
    }
}
