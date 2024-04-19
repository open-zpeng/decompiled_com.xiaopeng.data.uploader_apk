package d.c.a;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: b  reason: collision with root package name */
    protected OutputStream f1959b;

    public h(OutputStream outputStream) {
        this.f1959b = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1959b.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f1959b.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f1959b.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f1959b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f1959b.write(bArr, i, i2);
    }
}
