package b.c.a.e;

import okhttp3.Response;
import okhttp3.ResponseBody;
/* compiled from: StringConvert.java */
/* loaded from: classes.dex */
public class b implements a<String> {
    @Override // b.c.a.e.a
    /* renamed from: a */
    public String convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return body.string();
    }
}
