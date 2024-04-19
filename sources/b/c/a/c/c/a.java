package b.c.a.c.c;

import android.graphics.Bitmap;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
/* compiled from: BaseCachePolicy.java */
/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> f1123a;

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f1124b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile int f1125c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f1126d;
    protected Call e;
    protected b.c.a.d.b<T> f;
    protected b.c.a.c.a<T> g;

    /* compiled from: BaseCachePolicy.java */
    /* renamed from: b.c.a.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0045a implements Callback {
        C0045a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if ((iOException instanceof SocketTimeoutException) && a.this.f1125c < a.this.f1123a.r()) {
                a.this.f1125c++;
                a aVar = a.this;
                aVar.e = aVar.f1123a.p();
                if (a.this.f1124b) {
                    a.this.e.cancel();
                } else {
                    a.this.e.enqueue(this);
                }
            } else if (call.isCanceled()) {
            } else {
                a.this.onError(b.c.a.j.d.c(false, call, null, iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            int code = response.code();
            if (code != 404 && code < 500) {
                if (a.this.d(call, response)) {
                    return;
                }
                try {
                    T convertResponse = a.this.f1123a.m().convertResponse(response);
                    a.this.h(response.headers(), convertResponse);
                    a.this.onSuccess(b.c.a.j.d.m(false, convertResponse, call, response));
                    return;
                } catch (Throwable th) {
                    a.this.onError(b.c.a.j.d.c(false, call, response, th));
                    return;
                }
            }
            a.this.onError(b.c.a.j.d.c(false, call, response, b.c.a.g.b.b()));
        }
    }

    public a(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
        this.f1123a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Headers headers, T t) {
        if (this.f1123a.j() == b.c.a.c.b.NO_CACHE || (t instanceof Bitmap)) {
            return;
        }
        b.c.a.c.a<T> b2 = b.c.a.l.a.b(headers, t, this.f1123a.j(), this.f1123a.i());
        if (b2 == null) {
            b.c.a.f.b.l().n(this.f1123a.i());
        } else {
            b.c.a.f.b.l().o(this.f1123a.i(), b2);
        }
    }

    @Override // b.c.a.c.c.b
    public b.c.a.c.a<T> a() {
        if (this.f1123a.i() == null) {
            b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar = this.f1123a;
            dVar.b(b.c.a.l.b.c(dVar.h(), this.f1123a.o().e));
        }
        if (this.f1123a.j() == null) {
            this.f1123a.c(b.c.a.c.b.NO_CACHE);
        }
        b.c.a.c.b j = this.f1123a.j();
        if (j != b.c.a.c.b.NO_CACHE) {
            b.c.a.c.a<T> aVar = (b.c.a.c.a<T>) b.c.a.f.b.l().j(this.f1123a.i());
            this.g = aVar;
            b.c.a.l.a.a(this.f1123a, aVar, j);
            b.c.a.c.a<T> aVar2 = this.g;
            if (aVar2 != null && aVar2.a(j, this.f1123a.l(), System.currentTimeMillis())) {
                this.g.j(true);
            }
        }
        b.c.a.c.a<T> aVar3 = this.g;
        if (aVar3 == null || aVar3.g() || this.g.c() == null || this.g.f() == null) {
            this.g = null;
        }
        return this.g;
    }

    public boolean d(Call call, Response response) {
        return false;
    }

    public synchronized Call e() throws Throwable {
        if (!this.f1126d) {
            this.f1126d = true;
            this.e = this.f1123a.p();
            if (this.f1124b) {
                this.e.cancel();
            }
        } else {
            throw b.c.a.g.b.a("Already executed!");
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.e.enqueue(new C0045a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Runnable runnable) {
        b.c.a.a.h().g().post(runnable);
    }
}
