package b.a.a.b.a;

import b.a.a.d;
import b.a.a.m;
import b.a.a.n;
import b.a.a.p;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class c extends d.f {
    private static final Reader p = new a();
    private static final Object q = new Object();
    private final List<Object> r;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes.dex */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    private void O(d.g gVar) throws IOException {
        if (t() == gVar) {
            return;
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + t());
    }

    private Object P() {
        List<Object> list = this.r;
        return list.get(list.size() - 1);
    }

    private Object R() {
        List<Object> list = this.r;
        return list.remove(list.size() - 1);
    }

    @Override // b.a.a.d.f
    public void B() throws IOException {
        if (t() == d.g.NAME) {
            u();
        } else {
            R();
        }
    }

    @Override // b.a.a.d.f
    public int C() throws IOException {
        d.g t = t();
        d.g gVar = d.g.NUMBER;
        if (t == gVar || t == d.g.STRING) {
            int o = ((p) P()).o();
            R();
            return o;
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + t);
    }

    public void Q() throws IOException {
        O(d.g.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.r.add(entry.getValue());
        this.r.add(new p((String) entry.getKey()));
    }

    @Override // b.a.a.d.f
    public void c() throws IOException {
        O(d.g.BEGIN_ARRAY);
        this.r.add(((b.a.a.j) P()).iterator());
    }

    @Override // b.a.a.d.f, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.r.clear();
        this.r.add(q);
    }

    @Override // b.a.a.d.f
    public void l() throws IOException {
        O(d.g.END_ARRAY);
        R();
        R();
    }

    @Override // b.a.a.d.f
    public void o() throws IOException {
        O(d.g.END_OBJECT);
        R();
        R();
    }

    @Override // b.a.a.d.f
    public void q() throws IOException {
        O(d.g.BEGIN_OBJECT);
        this.r.add(((n) P()).i().iterator());
    }

    @Override // b.a.a.d.f
    public boolean s() throws IOException {
        d.g t = t();
        return (t == d.g.END_OBJECT || t == d.g.END_ARRAY) ? false : true;
    }

    @Override // b.a.a.d.f
    public d.g t() throws IOException {
        if (this.r.isEmpty()) {
            return d.g.END_DOCUMENT;
        }
        Object P = P();
        if (P instanceof Iterator) {
            List<Object> list = this.r;
            boolean z = list.get(list.size() - 2) instanceof n;
            Iterator it = (Iterator) P;
            if (!it.hasNext()) {
                return z ? d.g.END_OBJECT : d.g.END_ARRAY;
            } else if (z) {
                return d.g.NAME;
            } else {
                this.r.add(it.next());
                return t();
            }
        } else if (P instanceof n) {
            return d.g.BEGIN_OBJECT;
        } else {
            if (P instanceof b.a.a.j) {
                return d.g.BEGIN_ARRAY;
            }
            if (!(P instanceof p)) {
                if (P instanceof m) {
                    return d.g.NULL;
                }
                if (P == q) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
            p pVar = (p) P;
            if (pVar.t()) {
                return d.g.STRING;
            }
            if (pVar.j()) {
                return d.g.BOOLEAN;
            }
            if (pVar.s()) {
                return d.g.NUMBER;
            }
            throw new AssertionError();
        }
    }

    @Override // b.a.a.d.f
    public String toString() {
        return c.class.getSimpleName();
    }

    @Override // b.a.a.d.f
    public String u() throws IOException {
        O(d.g.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.r.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // b.a.a.d.f
    public String v() throws IOException {
        d.g t = t();
        d.g gVar = d.g.STRING;
        if (t == gVar || t == d.g.NUMBER) {
            return ((p) R()).l();
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + t);
    }

    @Override // b.a.a.d.f
    public void w() throws IOException {
        O(d.g.NULL);
        R();
    }

    @Override // b.a.a.d.f
    public boolean x() throws IOException {
        O(d.g.BOOLEAN);
        return ((p) R()).q();
    }

    @Override // b.a.a.d.f
    public double y() throws IOException {
        d.g t = t();
        d.g gVar = d.g.NUMBER;
        if (t != gVar && t != d.g.STRING) {
            throw new IllegalStateException("Expected " + gVar + " but was " + t);
        }
        double n = ((p) P()).n();
        if (E() || !(Double.isNaN(n) || Double.isInfinite(n))) {
            R();
            return n;
        }
        throw new NumberFormatException("JSON forbids NaN and infinities: " + n);
    }

    @Override // b.a.a.d.f
    public long z() throws IOException {
        d.g t = t();
        d.g gVar = d.g.NUMBER;
        if (t == gVar || t == d.g.STRING) {
            long p2 = ((p) P()).p();
            R();
            return p2;
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + t);
    }
}
