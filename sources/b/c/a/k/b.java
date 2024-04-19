package b.c.a.k;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HeadRequest.java */
/* loaded from: classes.dex */
public class b<T> extends b.c.a.k.d.b<T, b<T>> {
    public b(String str) {
        super(str);
    }

    @Override // b.c.a.k.d.d
    public Request f(RequestBody requestBody) {
        return G(requestBody).head().url(this.f1208b).tag(this.e).build();
    }
}
