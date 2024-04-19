package b.c.a.k.d;

import b.c.a.j.c;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
/* compiled from: ProgressRequestBody.java */
/* loaded from: classes.dex */
public class c<T> extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private RequestBody f1200a;

    /* renamed from: b  reason: collision with root package name */
    private b.c.a.d.b<T> f1201b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0050c f1202c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.c f1203b;

        a(b.c.a.j.c cVar) {
            this.f1203b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f1201b != null) {
                c.this.f1201b.uploadProgress(this.f1203b);
            }
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes.dex */
    private final class b extends ForwardingSink {

        /* renamed from: b  reason: collision with root package name */
        private b.c.a.j.c f1205b;

        /* compiled from: ProgressRequestBody.java */
        /* loaded from: classes.dex */
        class a implements c.a {
            a() {
            }

            @Override // b.c.a.j.c.a
            public void a(b.c.a.j.c cVar) {
                if (c.this.f1202c != null) {
                    c.this.f1202c.uploadProgress(cVar);
                } else {
                    c.this.d(cVar);
                }
            }
        }

        b(Sink sink) {
            super(sink);
            b.c.a.j.c cVar = new b.c.a.j.c();
            this.f1205b = cVar;
            cVar.h = c.this.contentLength();
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            b.c.a.j.c.c(this.f1205b, j, new a());
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: b.c.a.k.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050c {
        void uploadProgress(b.c.a.j.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RequestBody requestBody, b.c.a.d.b<T> bVar) {
        this.f1200a = requestBody;
        this.f1201b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b.c.a.j.c cVar) {
        b.c.a.l.b.f(new a(cVar));
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.f1200a.contentLength();
        } catch (IOException e) {
            b.c.a.l.d.a(e);
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f1200a.contentType();
    }

    public void e(InterfaceC0050c interfaceC0050c) {
        this.f1202c = interfaceC0050c;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new b(bufferedSink));
        this.f1200a.writeTo(buffer);
        buffer.flush();
    }
}
