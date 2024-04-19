package b.c.a.d;

import okhttp3.Response;
/* compiled from: StringCallback.java */
/* loaded from: classes.dex */
public abstract class c extends a<String> {
    private b.c.a.e.b convert = new b.c.a.e.b();

    @Override // b.c.a.e.a
    public String convertResponse(Response response) throws Throwable {
        String convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
