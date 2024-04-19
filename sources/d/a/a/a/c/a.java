package d.a.a.a.c;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: CountingOutputStream.java */
/* loaded from: classes.dex */
public class a extends FilterOutputStream {

    /* renamed from: b  reason: collision with root package name */
    private long f1949b;

    public a(OutputStream outputStream) {
        super(outputStream);
        this.f1949b = 0L;
    }

    protected void a(long j) {
        if (j != -1) {
            this.f1949b += j;
        }
    }

    public long b() {
        return this.f1949b;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        ((FilterOutputStream) this).out.write(i);
        a(1L);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i, i2);
        a(i2);
    }
}
