package d.c.a;

import java.io.IOException;
/* loaded from: classes.dex */
class e extends g {

    /* renamed from: b  reason: collision with root package name */
    private g f1956b;

    /* renamed from: c  reason: collision with root package name */
    private final d.c.a.s.b f1957c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1958d = new byte[4096];
    private boolean e = false;
    private IOException f = null;
    private final byte[] g = new byte[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, d dVar) {
        this.f1956b = gVar;
        this.f1957c = new d.c.a.s.b(dVar.c());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        g gVar = this.f1956b;
        if (gVar != null) {
            try {
                gVar.close();
            } catch (IOException e) {
                if (this.f == null) {
                    this.f = e;
                }
            }
            this.f1956b = null;
        }
        IOException iOException = this.f;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.f;
        if (iOException != null) {
            throw iOException;
        }
        if (this.e) {
            throw new r("Stream finished or closed");
        }
        try {
            this.f1956b.flush();
        } catch (IOException e) {
            this.f = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.g;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.f;
        if (iOException != null) {
            throw iOException;
        }
        if (this.e) {
            throw new r("Stream finished");
        }
        while (i2 > 4096) {
            try {
                this.f1957c.a(bArr, i, 4096, this.f1958d);
                this.f1956b.write(this.f1958d);
                i += 4096;
                i2 -= 4096;
            } catch (IOException e) {
                this.f = e;
                throw e;
            }
        }
        this.f1957c.a(bArr, i, i2, this.f1958d);
        this.f1956b.write(this.f1958d, 0, i2);
    }
}
