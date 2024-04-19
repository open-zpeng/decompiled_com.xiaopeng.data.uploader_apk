package d.a.a.a.a.b;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: CoderBase.java */
/* loaded from: classes.dex */
abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1915a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private final Class<?>[] f1916b;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Class<?>... clsArr) {
        this.f1916b = clsArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(Object obj, int i) {
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Object obj) {
        for (Class<?> cls : this.f1916b) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStream b(OutputStream outputStream, Object obj) throws IOException {
        throw new UnsupportedOperationException("method doesn't support writing");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c(Object obj) {
        return f1915a;
    }
}
