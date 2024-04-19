package b.c.a.k;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: PostRequest.java */
/* loaded from: classes.dex */
public class c<T> extends b.c.a.k.d.a<T, c<T>> {
    public c(String str) {
        super(str);
    }

    @Override // b.c.a.k.d.d
    public Request f(RequestBody requestBody) {
        return G(requestBody).post(requestBody).url(this.f1208b).tag(this.e).build();
    }
}
