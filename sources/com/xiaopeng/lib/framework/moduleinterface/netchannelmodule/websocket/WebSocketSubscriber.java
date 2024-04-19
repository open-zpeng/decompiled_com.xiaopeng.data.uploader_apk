package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import c.a.i;
import c.a.m.b;
import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements i<IWebSocketInfo> {
    private b disposable;
    private boolean hasOpened;

    public final void dispose() {
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    protected void onClose() {
    }

    protected void onClosed(int i, String str) {
    }

    @Override // c.a.i
    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        th.printStackTrace();
    }

    protected void onMessage(String str) {
    }

    protected void onMessage(ByteString byteString) {
    }

    protected void onOpen() {
    }

    protected void onReconnect() {
    }

    @Override // c.a.i
    public final void onSubscribe(b bVar) {
        this.disposable = bVar;
    }

    @Override // c.a.i
    public final void onNext(IWebSocketInfo iWebSocketInfo) {
        if (iWebSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (iWebSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(iWebSocketInfo.closedReasonCode(), iWebSocketInfo.closedReason());
        } else if (iWebSocketInfo.stringMessage() != null) {
            onMessage(iWebSocketInfo.stringMessage());
        } else if (iWebSocketInfo.byteStringMessage() != null) {
            onMessage(iWebSocketInfo.byteStringMessage());
        } else if (iWebSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }
}
