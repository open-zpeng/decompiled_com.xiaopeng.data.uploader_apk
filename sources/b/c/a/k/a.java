package b.c.a.k;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: GetRequest.java */
/* loaded from: classes.dex */
public class a<T> extends b.c.a.k.d.b<T, a<T>> {
    public a(String str) {
        super(str);
    }

    @Override // b.c.a.k.d.d
    public Request f(RequestBody requestBody) {
        return G(requestBody).get().url(this.f1208b).tag(this.e).build();
    }
}
