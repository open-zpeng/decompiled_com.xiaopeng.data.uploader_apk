package b.b.a.b.f;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* compiled from: UtTrustManager.java */
/* loaded from: classes.dex */
class y implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private static TrustManager[] f1092a;

    y() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized TrustManager[] a() {
        TrustManager[] trustManagerArr;
        synchronized (y.class) {
            if (f1092a == null) {
                f1092a = new TrustManager[]{new y()};
            }
            trustManagerArr = f1092a;
        }
        return trustManagerArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr != null && x509CertificateArr.length != 0) {
            if (str != null && str.length() != 0) {
                try {
                    x509CertificateArr[0].checkValidity();
                    return;
                } catch (Exception unused) {
                    throw new CertificateException("Certificate not valid or trusted.");
                }
            }
            throw new IllegalArgumentException("parameter is not used");
        }
        throw new IllegalArgumentException("parameter is not used");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
