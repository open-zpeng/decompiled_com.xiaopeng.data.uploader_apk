package d.c.a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes.dex */
class k extends g {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f1963b;

    /* renamed from: c  reason: collision with root package name */
    static /* synthetic */ Class f1964c;

    /* renamed from: d  reason: collision with root package name */
    private g f1965d;
    private final DataOutputStream e;
    private final d.c.a.t.e f;
    private final d.c.a.v.b g;
    private final d.c.a.u.c h;
    private final int i;
    private boolean j;
    private boolean k = true;
    private boolean l = true;
    private int m = 0;
    private boolean n = false;
    private IOException o = null;
    private final byte[] p = new byte[1];

    static {
        if (f1964c == null) {
            f1964c = a("org.tukaani.xz.LZMA2OutputStream");
        }
        f1963b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, j jVar) {
        this.j = true;
        Objects.requireNonNull(gVar);
        this.f1965d = gVar;
        this.e = new DataOutputStream(gVar);
        d.c.a.v.b bVar = new d.c.a.v.b(65536);
        this.g = bVar;
        int d2 = jVar.d();
        d.c.a.u.c m = d.c.a.u.c.m(bVar, jVar.e(), jVar.f(), jVar.j(), jVar.h(), d2, b(d2), jVar.i(), jVar.g(), jVar.c());
        this.h = m;
        d.c.a.t.e n = m.n();
        this.f = n;
        byte[] k = jVar.k();
        if (k != null && k.length > 0) {
            n.u(d2, k);
            this.j = false;
        }
        this.i = (((jVar.j() * 5) + jVar.f()) * 9) + jVar.e();
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static int b(int i) {
        if (65536 > i) {
            return 65536 - i;
        }
        return 0;
    }

    private void c() throws IOException {
        int g = this.g.g();
        int v = this.h.v();
        boolean z = f1963b;
        if (!z && g <= 0) {
            throw new AssertionError(g);
        }
        if (!z && v <= 0) {
            throw new AssertionError(v);
        }
        if (g + 2 < v) {
            e(v, g);
        } else {
            this.h.b();
            v = this.h.v();
            if (!z && v <= 0) {
                throw new AssertionError(v);
            }
            f(v);
        }
        this.m -= v;
        this.h.w();
        this.g.m();
    }

    private void d() throws IOException {
        if (!f1963b && this.n) {
            throw new AssertionError();
        }
        IOException iOException = this.o;
        if (iOException != null) {
            throw iOException;
        }
        this.f.s();
        while (this.m > 0) {
            try {
                this.h.e();
                c();
            } catch (IOException e) {
                this.o = e;
                throw e;
            }
        }
        this.f1965d.write(0);
        this.n = true;
    }

    private void e(int i, int i2) throws IOException {
        int i3 = i - 1;
        this.e.writeByte((this.l ? this.j ? 224 : 192 : this.k ? 160 : 128) | (i3 >>> 16));
        this.e.writeShort(i3);
        this.e.writeShort(i2 - 1);
        if (this.l) {
            this.e.writeByte(this.i);
        }
        this.g.o(this.f1965d);
        this.l = false;
        this.k = false;
        this.j = false;
    }

    private void f(int i) throws IOException {
        while (true) {
            int i2 = 1;
            if (i <= 0) {
                this.k = true;
                return;
            }
            int min = Math.min(i, 65536);
            DataOutputStream dataOutputStream = this.e;
            if (!this.j) {
                i2 = 2;
            }
            dataOutputStream.writeByte(i2);
            this.e.writeShort(min - 1);
            this.f.b(this.f1965d, i, min);
            i -= min;
            this.j = false;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1965d != null) {
            if (!this.n) {
                try {
                    d();
                } catch (IOException unused) {
                }
            }
            try {
                this.f1965d.close();
            } catch (IOException e) {
                if (this.o == null) {
                    this.o = e;
                }
            }
            this.f1965d = null;
        }
        IOException iOException = this.o;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.o;
        if (iOException != null) {
            throw iOException;
        }
        if (this.n) {
            throw new r("Stream finished or closed");
        }
        try {
            this.f.t();
            while (this.m > 0) {
                this.h.e();
                c();
            }
            this.f1965d.flush();
        } catch (IOException e) {
            this.o = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.p;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.o;
        if (iOException != null) {
            throw iOException;
        }
        if (this.n) {
            throw new r("Stream finished or closed");
        }
        while (i2 > 0) {
            try {
                int c2 = this.f.c(bArr, i, i2);
                i += c2;
                i2 -= c2;
                this.m += c2;
                if (this.h.e()) {
                    c();
                }
            } catch (IOException e) {
                this.o = e;
                throw e;
            }
        }
    }
}
