package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo;
import okhttp3.WebSocket;
import okio.ByteString;
/* loaded from: classes.dex */
public class WebSocketInfo implements IWebSocketInfo {
    private static final String EMPTY_REASON_STRING = "";
    private ByteString mByteStringMessage;
    private ClosedReason mClosedReason;
    private boolean mOnReconnect;
    private IWebSocketInfo.STATE mState;
    private String mStringMessage;
    private WebSocket mWebSocket;

    private WebSocketInfo() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IWebSocketInfo createReconnect() {
        WebSocketInfo webSocketInfo = new WebSocketInfo();
        webSocketInfo.mOnReconnect = true;
        return webSocketInfo;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public ByteString byteStringMessage() {
        return this.mByteStringMessage;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public String closedReason() {
        ClosedReason closedReason = this.mClosedReason;
        return (closedReason == null || closedReason.reason() == null) ? "" : this.mClosedReason.reason();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public int closedReasonCode() {
        ClosedReason closedReason = this.mClosedReason;
        if (closedReason == null) {
            return 0;
        }
        return closedReason.code();
    }

    public WebSocket getWebSocket() {
        return this.mWebSocket;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public boolean isClosed() {
        return this.mState == IWebSocketInfo.STATE.CLOSED;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public boolean isOnOpen() {
        return this.mState == IWebSocketInfo.STATE.OPEN;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public boolean isOnReconnect() {
        return this.mOnReconnect;
    }

    public void setClosedReason(int i, String str) {
        this.mClosedReason = new ClosedReason(i, str);
    }

    public void setWebSocket(WebSocket webSocket) {
        this.mWebSocket = webSocket;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo
    public String stringMessage() {
        return this.mStringMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketInfo(WebSocket webSocket, IWebSocketInfo.STATE state) {
        this.mWebSocket = webSocket;
        this.mState = state;
    }

    public void byteStringMessage(ByteString byteString) {
        this.mByteStringMessage = byteString;
    }

    public void stringMessage(String str) {
        this.mStringMessage = str;
    }

    /* loaded from: classes.dex */
    private class ClosedReason {
        private int mCode;
        private String mReason;

        public ClosedReason(int i, String str) {
            this.mCode = i;
            this.mReason = str;
        }

        public int code() {
            return this.mCode;
        }

        public String reason() {
            return this.mReason;
        }

        private ClosedReason() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketInfo(WebSocket webSocket, String str) {
        this.mWebSocket = webSocket;
        this.mStringMessage = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketInfo(WebSocket webSocket, ByteString byteString) {
        this.mWebSocket = webSocket;
        this.mByteStringMessage = byteString;
    }
}
