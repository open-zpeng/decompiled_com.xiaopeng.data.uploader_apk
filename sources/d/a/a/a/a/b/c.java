package d.a.a.a.a.b;

import d.c.a.l;
import d.c.a.m;
import d.c.a.q;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
/* compiled from: Coders.java */
/* loaded from: classes.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<h, d.a.a.a.a.b.b> f1917a = new a();

    /* compiled from: Coders.java */
    /* loaded from: classes.dex */
    static class a extends HashMap<h, d.a.a.a.a.b.b> {
        private static final long serialVersionUID = 1664829131806520867L;

        a() {
            put(h.COPY, new d());
            put(h.LZMA, new f());
            put(h.LZMA2, new d.a.a.a.a.b.e());
            put(h.DEFLATE, new e());
            put(h.BZIP2, new C0089c());
            put(h.AES256SHA256, new d.a.a.a.a.b.a());
            put(h.BCJ_X86_FILTER, new b(new q()));
            put(h.BCJ_PPC_FILTER, new b(new l()));
            put(h.BCJ_IA64_FILTER, new b(new d.c.a.i()));
            put(h.BCJ_ARM_FILTER, new b(new d.c.a.a()));
            put(h.BCJ_ARM_THUMB_FILTER, new b(new d.c.a.b()));
            put(h.BCJ_SPARC_FILTER, new b(new m()));
            put(h.DELTA_FILTER, new d.a.a.a.a.b.d());
        }
    }

    /* compiled from: Coders.java */
    /* loaded from: classes.dex */
    static class b extends d.a.a.a.a.b.b {

        /* renamed from: c  reason: collision with root package name */
        private final d.c.a.f f1918c;

        /* compiled from: Coders.java */
        /* loaded from: classes.dex */
        class a extends FilterOutputStream {
            a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
            }
        }

        b(d.c.a.f fVar) {
            super(new Class[0]);
            this.f1918c = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // d.a.a.a.a.b.b
        public OutputStream b(OutputStream outputStream, Object obj) {
            return new a(this.f1918c.a(new d.c.a.h(outputStream)));
        }
    }

    /* compiled from: Coders.java */
    /* renamed from: d.a.a.a.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0089c extends d.a.a.a.a.b.b {
        C0089c() {
            super(Number.class);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // d.a.a.a.a.b.b
        public OutputStream b(OutputStream outputStream, Object obj) throws IOException {
            return new d.a.a.a.b.b.a(outputStream, d.a.a.a.a.b.b.d(obj, 9));
        }
    }

    /* compiled from: Coders.java */
    /* loaded from: classes.dex */
    static class d extends d.a.a.a.a.b.b {
        d() {
            super(new Class[0]);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // d.a.a.a.a.b.b
        public OutputStream b(OutputStream outputStream, Object obj) {
            return outputStream;
        }
    }

    /* compiled from: Coders.java */
    /* loaded from: classes.dex */
    static class e extends d.a.a.a.a.b.b {

        /* compiled from: Coders.java */
        /* loaded from: classes.dex */
        class a extends OutputStream {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DeflaterOutputStream f1920b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Deflater f1921c;

            a(DeflaterOutputStream deflaterOutputStream, Deflater deflater) {
                this.f1920b = deflaterOutputStream;
                this.f1921c = deflater;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    this.f1920b.close();
                } finally {
                    this.f1921c.end();
                }
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                this.f1920b.write(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                this.f1920b.write(bArr);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                this.f1920b.write(bArr, i, i2);
            }
        }

        e() {
            super(Number.class);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // d.a.a.a.a.b.b
        public OutputStream b(OutputStream outputStream, Object obj) {
            Deflater deflater = new Deflater(d.a.a.a.a.b.b.d(obj, 9), true);
            return new a(new DeflaterOutputStream(outputStream, deflater), deflater);
        }
    }

    /* compiled from: Coders.java */
    /* loaded from: classes.dex */
    static class f extends d.a.a.a.a.b.b {
        f() {
            super(new Class[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputStream a(OutputStream outputStream, h hVar, Object obj) throws IOException {
        d.a.a.a.a.b.b b2 = b(hVar);
        if (b2 != null) {
            return b2.b(outputStream, obj);
        }
        throw new IOException("Unsupported compression method " + hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d.a.a.a.a.b.b b(h hVar) {
        return f1917a.get(hVar);
    }
}
