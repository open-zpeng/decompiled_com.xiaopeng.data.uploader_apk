package d.c.a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes.dex */
class o extends g {

    /* renamed from: b  reason: collision with root package name */
    private g f1969b;

    /* renamed from: c  reason: collision with root package name */
    private final DataOutputStream f1970c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1971d = new byte[65536];
    private int e = 0;
    private boolean f = true;
    private boolean g = false;
    private IOException h = null;
    private final byte[] i = new byte[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        Objects.requireNonNull(gVar);
        this.f1969b = gVar;
        this.f1970c = new DataOutputStream(gVar);
    }

    private void a() throws IOException {
        this.f1970c.writeByte(this.f ? 1 : 2);
        this.f1970c.writeShort(this.e - 1);
        this.f1970c.write(this.f1971d, 0, this.e);
        this.e = 0;
        this.f = false;
    }

    private void b() throws IOException {
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        if (this.g) {
            throw new r("Stream finished or closed");
        }
        try {
            if (this.e > 0) {
                a();
            }
            this.f1969b.write(0);
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1969b != null) {
            if (!this.g) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
            try {
                this.f1969b.close();
            } catch (IOException e) {
                if (this.h == null) {
                    this.h = e;
                }
            }
            this.f1969b = null;
        }
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        if (this.g) {
            throw new r("Stream finished or closed");
        }
        try {
            if (this.e > 0) {
                a();
            }
            this.f1969b.flush();
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.i;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        if (this.g) {
            throw new r("Stream finished or closed");
        }
        while (i2 > 0) {
            try {
                int min = Math.min(this.f1971d.length - this.e, i2);
                System.arraycopy(bArr, i, this.f1971d, this.e, min);
                i2 -= min;
                int i4 = this.e + min;
                this.e = i4;
                if (i4 == this.f1971d.length) {
                    a();
                }
            } catch (IOException e) {
                this.h = e;
                throw e;
            }
        }
    }
}
