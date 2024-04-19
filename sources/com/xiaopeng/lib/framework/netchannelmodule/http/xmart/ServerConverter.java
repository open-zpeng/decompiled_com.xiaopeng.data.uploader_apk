package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import b.c.a.e.a;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ServerConverter implements a<ServerBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // b.c.a.e.a
    public ServerBean convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body != null) {
            ServerBean serverBean = new ServerBean();
            JSONObject jSONObject = new JSONObject(body.string());
            serverBean.code(jSONObject.getInt("code"));
            try {
                serverBean.data(jSONObject.getString("data"));
            } catch (Throwable unused) {
            }
            try {
                serverBean.message(jSONObject.getString("msg"));
            } catch (Throwable unused2) {
            }
            return serverBean;
        }
        throw new IllegalStateException("null");
    }
}
