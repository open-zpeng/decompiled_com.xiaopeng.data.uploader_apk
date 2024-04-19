package b.c.a.k.d;

import android.text.TextUtils;
import b.c.a.k.d.c;
import b.c.a.k.d.d;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public abstract class d<T, R extends d> implements Serializable {
    private static final long serialVersionUID = -7174118653689916252L;

    /* renamed from: b  reason: collision with root package name */
    protected String f1208b;

    /* renamed from: c  reason: collision with root package name */
    protected String f1209c;

    /* renamed from: d  reason: collision with root package name */
    protected transient OkHttpClient f1210d;
    protected transient Object e;
    protected int f;
    protected b.c.a.c.b g;
    protected String h;
    protected long i;
    protected b.c.a.j.b j = new b.c.a.j.b();
    protected b.c.a.j.a k = new b.c.a.j.a();
    protected transient Request l;
    protected transient b.c.a.b.b<T> m;
    protected transient b.c.a.d.b<T> n;
    protected transient b.c.a.e.a<T> o;
    protected transient b.c.a.c.c.b<T> p;
    protected transient c.InterfaceC0050c q;

    public d(String str) {
        this.f1208b = str;
        this.f1209c = str;
        b.c.a.a h = b.c.a.a.h();
        String d2 = b.c.a.j.a.d();
        if (!TextUtils.isEmpty(d2)) {
            u("Accept-Language", d2);
        }
        String i = b.c.a.j.a.i();
        if (!TextUtils.isEmpty(i)) {
            u(HttpHeaders.USER_AGENT, i);
        }
        if (h.e() != null) {
            v(h.e());
        }
        if (h.d() != null) {
            t(h.d());
        }
        this.f = h.j();
        this.g = h.b();
        this.i = h.c();
    }

    public R A(Map<String, String> map, boolean... zArr) {
        this.j.l(map, zArr);
        return this;
    }

    public R B() {
        this.k.a();
        return this;
    }

    public R C() {
        this.j.a();
        return this;
    }

    public R D(String str) {
        this.k.n(str);
        return this;
    }

    public R E(String str) {
        this.j.m(str);
        return this;
    }

    public R F(Object obj) {
        this.e = obj;
        return this;
    }

    public b.c.a.b.b<T> a() {
        b.c.a.b.b<T> bVar = this.m;
        return bVar == null ? new b.c.a.b.a(this) : bVar;
    }

    public R b(String str) {
        b.c.a.l.b.b(str, "cacheKey == null");
        this.h = str;
        return this;
    }

    public R c(b.c.a.c.b bVar) {
        this.g = bVar;
        return this;
    }

    public Response d() throws IOException {
        return p().execute();
    }

    public void e(b.c.a.d.b<T> bVar) {
        b.c.a.l.b.b(bVar, "callback == null");
        this.n = bVar;
        a().a(bVar);
    }

    public abstract Request f(RequestBody requestBody);

    protected abstract RequestBody g();

    public String h() {
        return this.f1209c;
    }

    public String i() {
        return this.h;
    }

    public b.c.a.c.b j() {
        return this.g;
    }

    public b.c.a.c.c.b<T> k() {
        return this.p;
    }

    public long l() {
        return this.i;
    }

    public b.c.a.e.a<T> m() {
        if (this.o == null) {
            this.o = this.n;
        }
        b.c.a.l.b.b(this.o, "converter == null, do you forget to call Request#converter(Converter<T>) ?");
        return this.o;
    }

    public b.c.a.j.a n() {
        return this.k;
    }

    public b.c.a.j.b o() {
        return this.j;
    }

    public Call p() {
        RequestBody g = g();
        if (g != null) {
            c cVar = new c(g, this.n);
            cVar.e(this.q);
            this.l = f(cVar);
        } else {
            this.l = f(null);
        }
        if (this.f1210d == null) {
            this.f1210d = b.c.a.a.h().i();
        }
        return this.f1210d.newCall(this.l);
    }

    public Request q() {
        return this.l;
    }

    public int r() {
        return this.f;
    }

    public String s() {
        return this.f1208b;
    }

    public R t(b.c.a.j.a aVar) {
        this.k.l(aVar);
        return this;
    }

    public R u(String str, String str2) {
        this.k.m(str, str2);
        return this;
    }

    public R v(b.c.a.j.b bVar) {
        this.j.c(bVar);
        return this;
    }

    public R w(String str, float f, boolean... zArr) {
        this.j.d(str, f, zArr);
        return this;
    }

    public R x(String str, int i, boolean... zArr) {
        this.j.e(str, i, zArr);
        return this;
    }

    public R y(String str, String str2, boolean... zArr) {
        this.j.j(str, str2, zArr);
        return this;
    }

    public R z(String str, boolean z, boolean... zArr) {
        this.j.k(str, z, zArr);
        return this;
    }
}
