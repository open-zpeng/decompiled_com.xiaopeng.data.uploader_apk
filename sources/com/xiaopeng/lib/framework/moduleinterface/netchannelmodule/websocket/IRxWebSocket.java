package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import c.a.e;
import okio.ByteString;
/* loaded from: classes.dex */
public interface IRxWebSocket {
    void close(String str);

    IWebSocketConfig config();

    e<IWebSocketInfo> get(String str);

    e<IWebSocketInfo> get(String str, long j);

    IRxWebSocket header(String str, String str2);

    void send(String str, String str2) throws Exception;

    void send(String str, ByteString byteString) throws Exception;
}
