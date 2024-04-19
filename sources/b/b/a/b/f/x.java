package b.b.a.b.f;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: UtSslSocketFactory.java */
/* loaded from: classes.dex */
class x extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private Method f1090a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f1091b;

    public x(String str) {
        this.f1091b = str;
    }

    public String a() {
        return this.f1091b;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        i.c("UtSslSocketFactory", "bizHost", this.f1091b, "host", str, "port", Integer.valueOf(i), "autoClose", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(this.f1091b)) {
            i.c("UtSslSocketFactory", "customized createSocket. host: " + this.f1091b);
            try {
                SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.r, new SSLSessionCache(b.b.a.b.a.j()));
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 24) {
                    sSLCertificateSocketFactory.setTrustManagers(y.a());
                } else {
                    sSLCertificateSocketFactory.setTrustManagers(v.a());
                }
                SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f1091b, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                if (i2 < 17) {
                    try {
                        if (this.f1090a == null) {
                            Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                            this.f1090a = method;
                            method.setAccessible(true);
                        }
                        this.f1090a.invoke(sSLSocket, this.f1091b);
                    } catch (Exception unused) {
                    }
                } else {
                    sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
                    sSLCertificateSocketFactory.setHostname(sSLSocket, this.f1091b);
                }
                sSLSocket.startHandshake();
                return sSLSocket;
            } catch (Throwable th) {
                throw new IOException("createSocket exception: " + th);
            }
        }
        throw new IOException("SDK set empty bizHost");
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f1091b) || !(obj instanceof x)) {
            return false;
        }
        String str = ((x) obj).f1091b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f1091b.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
