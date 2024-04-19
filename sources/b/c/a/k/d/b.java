package b.c.a.k.d;

import b.c.a.k.d.b;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: NoBodyRequest.java */
/* loaded from: classes.dex */
public abstract class b<T, R extends b> extends d<T, R> {
    private static final long serialVersionUID = 1200621102761691196L;

    public b(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request.Builder G(RequestBody requestBody) {
        this.f1208b = b.c.a.l.b.c(this.f1209c, this.j.e);
        return b.c.a.l.b.a(new Request.Builder(), this.k);
    }

    @Override // b.c.a.k.d.d
    public RequestBody g() {
        return null;
    }
}
