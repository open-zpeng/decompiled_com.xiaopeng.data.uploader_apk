package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import b.c.a.j.d;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerCallback;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.BasePostRequestAdapter;
/* loaded from: classes.dex */
public class ServerRequest extends BasePostRequestAdapter<ServerBean> {

    /* loaded from: classes.dex */
    public class ServerCallbackImplAdapter extends ServerCallbackImpl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private IServerCallback mOuterCallback;

        public ServerCallbackImplAdapter(IServerCallback iServerCallback) {
            this.mOuterCallback = iServerCallback;
        }

        @Override // b.c.a.d.a, b.c.a.d.b
        public void onError(d<ServerBean> dVar) {
            super.onError(dVar);
            this.mOuterCallback.onFailure(new ServerResponse(dVar));
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.xmart.ServerCallbackImpl, b.c.a.d.b
        public void onSuccess(d<ServerBean> dVar) {
            this.mOuterCallback.onSuccess(new ServerResponse(dVar));
        }
    }

    public ServerRequest(String str) {
        super(str);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.BasePostRequestAdapter, com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(IServerCallback iServerCallback) {
        super.execute(new ServerCallbackImplAdapter(iServerCallback));
    }
}
