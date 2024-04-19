package b.a.a.b.a;

import b.a.a.d;
import b.a.a.m;
import b.a.a.n;
import b.a.a.p;
import b.a.a.v;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class e extends d.h {
    private static final Writer m = new a();
    private static final p n = new p("closed");
    private final List<v> o;
    private String p;
    private v q;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes.dex */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public e() {
        super(m);
        this.o = new ArrayList();
        this.q = m.f887a;
    }

    private void C(v vVar) {
        if (this.p != null) {
            if (!vVar.c() || y()) {
                ((n) D()).h(this.p, vVar);
            }
            this.p = null;
        } else if (this.o.isEmpty()) {
            this.q = vVar;
        } else {
            v D = D();
            if (!(D instanceof b.a.a.j)) {
                throw new IllegalStateException();
            }
            ((b.a.a.j) D).h(vVar);
        }
    }

    private v D() {
        List<v> list = this.o;
        return list.get(list.size() - 1);
    }

    public v B() {
        if (this.o.isEmpty()) {
            return this.q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.o);
    }

    @Override // b.a.a.d.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.o.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.o.add(n);
    }

    @Override // b.a.a.d.h
    public d.h d(long j) throws IOException {
        C(new p(Long.valueOf(j)));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h e(Number number) throws IOException {
        if (number == null) {
            return u();
        }
        if (!v()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        C(new p(number));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h f(String str) throws IOException {
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof n) {
            this.p = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // b.a.a.d.h, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // b.a.a.d.h
    public d.h g(boolean z) throws IOException {
        C(new p(Boolean.valueOf(z)));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h i() throws IOException {
        b.a.a.j jVar = new b.a.a.j();
        C(jVar);
        this.o.add(jVar);
        return this;
    }

    @Override // b.a.a.d.h
    public d.h j(String str) throws IOException {
        if (str == null) {
            return u();
        }
        C(new p(str));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h m() throws IOException {
        n nVar = new n();
        C(nVar);
        this.o.add(nVar);
        return this;
    }

    @Override // b.a.a.d.h
    public d.h p() throws IOException {
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof b.a.a.j) {
            List<v> list = this.o;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // b.a.a.d.h
    public d.h s() throws IOException {
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof n) {
            List<v> list = this.o;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // b.a.a.d.h
    public d.h u() throws IOException {
        C(m.f887a);
        return this;
    }
}
