package d.a.a.a.a.b;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: LZMA2Decoder.java */
/* loaded from: classes.dex */
class e extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        super(d.c.a.j.class, Number.class);
    }

    private int e(Object obj) {
        if (obj instanceof d.c.a.j) {
            return ((d.c.a.j) obj).d();
        }
        return g(obj);
    }

    private d.c.a.j f(Object obj) throws IOException {
        if (obj instanceof d.c.a.j) {
            return (d.c.a.j) obj;
        }
        d.c.a.j jVar = new d.c.a.j();
        jVar.l(g(obj));
        return jVar;
    }

    private int g(Object obj) {
        return b.d(obj, 8388608);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.a.a.a.a.b.b
    public OutputStream b(OutputStream outputStream, Object obj) throws IOException {
        return f(obj).a(new d.c.a.h(outputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.a.a.a.a.b.b
    public byte[] c(Object obj) {
        int e = e(obj);
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(e);
        return new byte[]{(byte) (((19 - numberOfLeadingZeros) * 2) + ((e >>> (30 - numberOfLeadingZeros)) - 2))};
    }
}
