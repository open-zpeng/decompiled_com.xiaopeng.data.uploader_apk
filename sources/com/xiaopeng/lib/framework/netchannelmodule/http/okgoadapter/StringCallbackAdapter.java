package com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter;

import b.c.a.d.c;
import b.c.a.j.d;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
/* loaded from: classes.dex */
public class StringCallbackAdapter extends c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Callback mOuterCallback;

    public StringCallbackAdapter(Callback callback) {
        this.mOuterCallback = callback;
    }

    @Override // b.c.a.d.a, b.c.a.d.b
    public void onError(d<String> dVar) {
        super.onError(dVar);
        this.mOuterCallback.onFailure(new ResponseAdapter(dVar));
    }

    @Override // b.c.a.d.b
    public void onSuccess(d<String> dVar) {
        this.mOuterCallback.onSuccess(new ResponseAdapter(dVar));
    }
}
