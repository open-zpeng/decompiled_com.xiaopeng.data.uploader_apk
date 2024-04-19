package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import c.a.e;
import c.a.f;
import c.a.g;
import c.a.o.a;
import c.a.o.d;
import c.a.o.h;
import com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RxWebSocketInternal {
    private static final int CLOSE_BY_CANCELLATION = 3000;
    private static final int CLOSE_CLIENT_NORMAL = 1000;
    private static final int DEFAULT_RETRY_INTERVAL = 1000;
    private OkHttpClient mClient;
    private Map<String, String> mHeaders;
    private String mLogTag;
    private Map<String, e<IWebSocketInfo>> mObservableMap;
    private long mPingInterval;
    private long mReconnectInterval;
    private boolean mShowLog;
    private Map<String, WebSocket> mWebSocketMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CancelableInternal implements d {
        private boolean showLog;
        private String tag;
        private String url;
        private WebSocket webSocket;

        public CancelableInternal(WebSocket webSocket, String str, boolean z, String str2) {
            this.webSocket = webSocket;
            this.url = str;
            this.showLog = z;
            this.tag = str2;
        }

        @Override // c.a.o.d
        public void cancel() throws Exception {
            this.webSocket.close(3000, "close WebSocket from rx cancel");
            if (this.showLog) {
                String str = this.tag;
                Log.d(str, this.url + " --> cancel for rx cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Holder {
        private static final RxWebSocketInternal INSTANCE = new RxWebSocketInternal();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class WebSocketOnSubscribe implements g<IWebSocketInfo> {
        private String url;
        private WebSocket webSocket;

        public WebSocketOnSubscribe(String str) {
            this.url = str;
        }

        private void initWebSocket(f<IWebSocketInfo> fVar) {
            WebSocket newWebSocket = RxWebSocketInternal.this.mClient.newWebSocket(RxWebSocketInternal.this.getRequest(this.url), new WebSocketListenerInternal(fVar, RxWebSocketInternal.this.mWebSocketMap, this.url, RxWebSocketInternal.this.mShowLog, RxWebSocketInternal.this.mLogTag));
            this.webSocket = newWebSocket;
            fVar.a(new CancelableInternal(newWebSocket, this.url, RxWebSocketInternal.this.mShowLog, RxWebSocketInternal.this.mLogTag));
        }

        @Override // c.a.g
        public void subscribe(f<IWebSocketInfo> fVar) throws Exception {
            if (this.webSocket != null && Looper.getMainLooper().getThread() != Thread.currentThread()) {
                long j = RxWebSocketInternal.this.mReconnectInterval;
                if (j == 0) {
                    j = 1000;
                }
                SystemClock.sleep(j);
                fVar.onNext(WebSocketInfo.createReconnect());
            }
            initWebSocket(fVar);
        }
    }

    public static RxWebSocketInternal getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request getRequest(String str) {
        Request.Builder url = new Request.Builder().get().url(str);
        if (this.mHeaders.size() > 0) {
            for (String str2 : this.mHeaders.keySet()) {
                url.addHeader(str2, this.mHeaders.get(str2));
            }
        }
        return url.build();
    }

    public void asyncSend(String str, final String str2) {
        getWebSocket(str).y(1L).u(new c.a.o.e<WebSocket>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.10
            @Override // c.a.o.e
            public void accept(WebSocket webSocket) throws Exception {
                webSocket.send(str2);
            }
        });
    }

    public void client(OkHttpClient okHttpClient) {
        Objects.requireNonNull(okHttpClient, "mClient == null");
        this.mClient = okHttpClient.newBuilder().pingInterval(this.mPingInterval, TimeUnit.MILLISECONDS).build();
    }

    public void close(String str) {
        WebSocket webSocket = this.mWebSocketMap.get(str);
        if (webSocket != null) {
            this.mObservableMap.remove(str);
            this.mWebSocketMap.remove(str);
            webSocket.close(IError.ERR_SERVICE_DISCONNECTED, null);
        }
    }

    public e<WebSocket> getWebSocket(String str) {
        return getWebSocketInfo(str).j(new h<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.9
            @Override // c.a.o.h
            public boolean test(IWebSocketInfo iWebSocketInfo) throws Exception {
                return ((WebSocketInfo) iWebSocketInfo).getWebSocket() != null;
            }
        }).m(new c.a.o.f<IWebSocketInfo, WebSocket>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.8
            @Override // c.a.o.f
            public WebSocket apply(IWebSocketInfo iWebSocketInfo) throws Exception {
                return ((WebSocketInfo) iWebSocketInfo).getWebSocket();
            }
        });
    }

    public e<ByteString> getWebSocketByteString(String str) {
        return getWebSocketInfo(str).j(new h<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.7
            @Override // c.a.o.h
            public boolean test(IWebSocketInfo iWebSocketInfo) throws Exception {
                return iWebSocketInfo.byteStringMessage() != null;
            }
        }).m(new c.a.o.f<IWebSocketInfo, ByteString>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.6
            @Override // c.a.o.f
            public ByteString apply(IWebSocketInfo iWebSocketInfo) throws Exception {
                return iWebSocketInfo.byteStringMessage();
            }
        });
    }

    public e<IWebSocketInfo> getWebSocketInfo(final String str, long j, TimeUnit timeUnit) {
        e<IWebSocketInfo> eVar = this.mObservableMap.get(str);
        if (eVar == null) {
            eVar = e.d(new WebSocketOnSubscribe(str)).z(j, timeUnit).r(new h<Throwable>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.3
                @Override // c.a.o.h
                public boolean test(Throwable th) throws Exception {
                    if (RxWebSocketInternal.this.mShowLog) {
                        String str2 = RxWebSocketInternal.this.mLogTag;
                        Log.d(str2, "predicate retry for " + th);
                    }
                    return (th instanceof IOException) || (th instanceof TimeoutException);
                }
            }).e(new a() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.2
                @Override // c.a.o.a
                public void run() throws Exception {
                    RxWebSocketInternal.this.mObservableMap.remove(str);
                    RxWebSocketInternal.this.mWebSocketMap.remove(str);
                    if (RxWebSocketInternal.this.mShowLog) {
                        Log.d(RxWebSocketInternal.this.mLogTag, "OnDispose");
                    }
                }
            }).h(new c.a.o.e<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.1
                @Override // c.a.o.e
                public void accept(IWebSocketInfo iWebSocketInfo) throws Exception {
                    if (iWebSocketInfo.isOnOpen()) {
                        RxWebSocketInternal.this.mWebSocketMap.put(str, ((WebSocketInfo) iWebSocketInfo).getWebSocket());
                    }
                }
            }).s().x(c.a.t.a.b()).n(c.a.l.b.a.a());
            this.mObservableMap.put(str, eVar);
        } else {
            WebSocket webSocket = this.mWebSocketMap.get(str);
            if (webSocket != null) {
                eVar = eVar.t(new WebSocketInfo(webSocket, IWebSocketInfo.STATE.OPEN));
            }
        }
        return eVar.n(c.a.l.b.a.a());
    }

    public e<String> getWebSocketString(String str) {
        return getWebSocketInfo(str).j(new h<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.5
            @Override // c.a.o.h
            public boolean test(IWebSocketInfo iWebSocketInfo) throws Exception {
                return iWebSocketInfo.stringMessage() != null;
            }
        }).m(new c.a.o.f<IWebSocketInfo, String>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.4
            @Override // c.a.o.f
            public String apply(IWebSocketInfo iWebSocketInfo) throws Exception {
                return iWebSocketInfo.stringMessage();
            }
        });
    }

    public void header(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.mHeaders.put(str, str2);
    }

    public void pingInterval(long j) {
        this.mPingInterval = j;
        this.mClient = this.mClient.newBuilder().pingInterval(j, TimeUnit.MILLISECONDS).build();
    }

    public void reconnectInterval(long j) {
        this.mReconnectInterval = j;
    }

    public void send(String str, String str2) {
        WebSocket webSocket = this.mWebSocketMap.get(str);
        if (webSocket != null) {
            webSocket.send(str2);
            return;
        }
        throw new IllegalStateException("WebSocket channel not open");
    }

    public void showLog(boolean z) {
        this.mShowLog = z;
    }

    public void sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        this.mClient = this.mClient.newBuilder().sslSocketFactory(sSLSocketFactory, x509TrustManager).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WebSocketListenerInternal extends WebSocketListener {
        private f<IWebSocketInfo> emitter;
        private boolean showLog;
        private String tag;
        private String url;
        private Map<String, WebSocket> webSocketMap;

        public WebSocketListenerInternal(f<IWebSocketInfo> fVar, Map<String, WebSocket> map, String str, boolean z, String str2) {
            this.emitter = fVar;
            this.webSocketMap = map;
            this.url = str;
            this.showLog = z;
            this.tag = str2;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int i, String str) {
            if (this.showLog) {
                String str2 = this.tag;
                Log.d(str2, this.url + " --> onClosed:code= " + i + "reason:" + str);
            }
            if (this.emitter.b()) {
                return;
            }
            WebSocketInfo webSocketInfo = new WebSocketInfo(webSocket, IWebSocketInfo.STATE.CLOSED);
            webSocketInfo.setClosedReason(i, str);
            this.emitter.onNext(webSocketInfo);
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int i, String str) {
            webSocket.close(IError.ERR_SERVICE_DISCONNECTED, null);
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (this.showLog && !(th instanceof UnknownHostException)) {
                String str = this.tag;
                Log.e(str, th.toString() + webSocket.request().url().uri().getPath());
            }
            if (this.emitter.b()) {
                return;
            }
            this.emitter.onError(th);
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            if (this.emitter.b()) {
                return;
            }
            this.emitter.onNext(new WebSocketInfo(webSocket, str));
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            if (this.showLog) {
                String str = this.tag;
                Log.d(str, this.url + " --> onOpen");
            }
            this.webSocketMap.put(this.url, webSocket);
            if (this.emitter.b()) {
                return;
            }
            this.emitter.onNext(new WebSocketInfo(webSocket, IWebSocketInfo.STATE.OPEN));
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, ByteString byteString) {
            if (this.emitter.b()) {
                return;
            }
            this.emitter.onNext(new WebSocketInfo(webSocket, byteString));
        }
    }

    private RxWebSocketInternal() {
        this.mLogTag = "RxWebSocket";
        this.mReconnectInterval = 1000L;
        this.mPingInterval = 1000L;
        try {
            Class.forName("okhttp3.OkHttpClient");
            try {
                Class.forName("c.a.e");
                try {
                    Class.forName("c.a.l.b.a");
                    this.mObservableMap = new ConcurrentHashMap();
                    this.mWebSocketMap = new ConcurrentHashMap();
                    this.mHeaders = new ConcurrentHashMap();
                    this.mClient = new OkHttpClient();
                } catch (ClassNotFoundException unused) {
                    throw new RuntimeException("Must be dependency rxandroid 2.x");
                }
            } catch (ClassNotFoundException unused2) {
                throw new RuntimeException("Must be dependency rxjava 2.x");
            }
        } catch (ClassNotFoundException unused3) {
            throw new RuntimeException("Must be dependency okhttp3 !");
        }
    }

    public void showLog(boolean z, String str) {
        showLog(z);
        this.mLogTag = str;
    }

    public void asyncSend(String str, final ByteString byteString) {
        getWebSocket(str).y(1L).u(new c.a.o.e<WebSocket>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.11
            @Override // c.a.o.e
            public void accept(WebSocket webSocket) throws Exception {
                webSocket.send(byteString);
            }
        });
    }

    public void send(String str, ByteString byteString) {
        WebSocket webSocket = this.mWebSocketMap.get(str);
        if (webSocket != null) {
            webSocket.send(byteString);
            return;
        }
        throw new IllegalStateException("WebSocket channel not open");
    }

    public e<IWebSocketInfo> getWebSocketInfo(String str) {
        return getWebSocketInfo(str, 1L, TimeUnit.HOURS);
    }
}
