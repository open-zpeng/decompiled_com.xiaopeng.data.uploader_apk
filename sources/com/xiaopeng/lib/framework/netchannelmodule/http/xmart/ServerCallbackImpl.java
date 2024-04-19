package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import b.c.a.d.a;
import b.c.a.d.b;
import b.c.a.j.d;
import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class ServerCallbackImpl extends a<ServerBean> implements b<ServerBean> {
    private ServerConverter convert = new ServerConverter();

    @Override // b.c.a.d.b
    public abstract /* synthetic */ void onSuccess(d<T> dVar);

    @Override // b.c.a.e.a
    public ServerBean convertResponse(Response response) throws Throwable {
        ServerBean convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
