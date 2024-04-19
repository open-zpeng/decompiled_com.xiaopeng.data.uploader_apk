package d.a.a.a.a.b;

import d.c.a.p;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: DeltaDecoder.java */
/* loaded from: classes.dex */
class d extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(Number.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.a.a.a.a.b.b
    public OutputStream b(OutputStream outputStream, Object obj) throws IOException {
        try {
            return new d.c.a.d(b.d(obj, 1)).a(new d.c.a.h(outputStream));
        } catch (p e) {
            throw new IOException(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.a.a.a.a.b.b
    public byte[] c(Object obj) {
        return new byte[]{(byte) (b.d(obj, 1) - 1)};
    }
}
