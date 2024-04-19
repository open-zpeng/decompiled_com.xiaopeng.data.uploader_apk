package d.c.a;

import java.io.IOException;
import java.util.Objects;
/* loaded from: classes.dex */
class n extends g {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f1966b;

    /* renamed from: c  reason: collision with root package name */
    static /* synthetic */ Class f1967c;

    /* renamed from: d  reason: collision with root package name */
    private g f1968d;
    private final d.c.a.w.f e;
    private final byte[] f = new byte[4096];
    private int g = 0;
    private int h = 0;
    private IOException i = null;
    private boolean j = false;
    private final byte[] k = new byte[1];

    static {
        if (f1967c == null) {
            f1967c = a("org.tukaani.xz.SimpleOutputStream");
        }
        f1966b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar, d.c.a.w.f fVar) {
        Objects.requireNonNull(gVar);
        this.f1968d = gVar;
        this.e = fVar;
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void b() throws IOException {
        if (!f1966b && this.j) {
            throw new AssertionError();
        }
        IOException iOException = this.i;
        if (iOException != null) {
            throw iOException;
        }
        try {
            this.f1968d.write(this.f, this.g, this.h);
            this.j = true;
        } catch (IOException e) {
            this.i = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1968d != null) {
            if (!this.j) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
            try {
                this.f1968d.close();
            } catch (IOException e) {
                if (this.i == null) {
                    this.i = e;
                }
            }
            this.f1968d = null;
        }
        IOException iOException = this.i;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw new p("Flushing is not supported");
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.k;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.i;
        if (iOException != null) {
            throw iOException;
        }
        if (this.j) {
            throw new r("Stream finished or closed");
        }
        while (i2 > 0) {
            int min = Math.min(i2, 4096 - (this.g + this.h));
            System.arraycopy(bArr, i, this.f, this.g + this.h, min);
            i += min;
            i2 -= min;
            int i4 = this.h + min;
            this.h = i4;
            int a2 = this.e.a(this.f, this.g, i4);
            if (!f1966b && a2 > this.h) {
                throw new AssertionError();
            }
            this.h -= a2;
            try {
                this.f1968d.write(this.f, this.g, a2);
                int i5 = this.g + a2;
                this.g = i5;
                int i6 = this.h;
                if (i5 + i6 == 4096) {
                    byte[] bArr2 = this.f;
                    System.arraycopy(bArr2, i5, bArr2, 0, i6);
                    this.g = 0;
                }
            } catch (IOException e) {
                this.i = e;
                throw e;
            }
        }
    }
}
