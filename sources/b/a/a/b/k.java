package b.a.a.b;

import b.a.a.d;
import b.a.a.v;
import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: Streams.java */
    /* loaded from: classes.dex */
    private static final class b extends Writer {

        /* renamed from: b  reason: collision with root package name */
        private final Appendable f859b;

        /* renamed from: c  reason: collision with root package name */
        private final a f860c;

        /* compiled from: Streams.java */
        /* loaded from: classes.dex */
        static class a implements CharSequence {

            /* renamed from: b  reason: collision with root package name */
            char[] f861b;

            a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f861b[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f861b.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f861b, i, i2 - i);
            }
        }

        private b(Appendable appendable) {
            this.f860c = new a();
            this.f859b = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f859b.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            a aVar = this.f860c;
            aVar.f861b = cArr;
            this.f859b.append(aVar, i, i2 + i);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    public static void b(v vVar, d.h hVar) throws IOException {
        b.a.a.b.a.l.P.a(hVar, vVar);
    }
}
