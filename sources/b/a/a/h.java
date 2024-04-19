package b.a.a;

import b.a.a.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Map<b.a.a.e.a<?>, f<?>>> f876a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<b.a.a.e.a<?>, t<?>> f877b;

    /* renamed from: c  reason: collision with root package name */
    private final List<u> f878c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a.a.b.e f879d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    final k i;
    final q j;

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    class a implements k {
        a() {
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    class b implements q {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class c extends t<Number> {
        c() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Double c(d.f fVar) throws IOException {
            if (fVar.t() == d.g.NULL) {
                fVar.w();
                return null;
            }
            return Double.valueOf(fVar.y());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            if (number == null) {
                hVar.u();
                return;
            }
            h.this.l(number.doubleValue());
            hVar.e(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class d extends t<Number> {
        d() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Float c(d.f fVar) throws IOException {
            if (fVar.t() == d.g.NULL) {
                fVar.w();
                return null;
            }
            return Float.valueOf((float) fVar.y());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            if (number == null) {
                hVar.u();
                return;
            }
            h.this.l(number.floatValue());
            hVar.e(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class e extends t<Number> {
        e() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.t() == d.g.NULL) {
                fVar.w();
                return null;
            }
            return Long.valueOf(fVar.z());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            if (number == null) {
                hVar.u();
            } else {
                hVar.j(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class f<T> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private t<T> f885a;

        f() {
        }

        @Override // b.a.a.t
        public void a(d.h hVar, T t) throws IOException {
            t<T> tVar = this.f885a;
            if (tVar == null) {
                throw new IllegalStateException();
            }
            tVar.a(hVar, t);
        }

        @Override // b.a.a.t
        public T c(d.f fVar) throws IOException {
            t<T> tVar = this.f885a;
            if (tVar != null) {
                return tVar.c(fVar);
            }
            throw new IllegalStateException();
        }

        public void d(t<T> tVar) {
            if (this.f885a != null) {
                throw new AssertionError();
            }
            this.f885a = tVar;
        }
    }

    public h() {
        this(b.a.a.b.d.f812b, b.a.a.d.O000000o, Collections.emptyMap(), false, false, false, true, false, false, s.O000000o, Collections.emptyList());
    }

    h(b.a.a.b.d dVar, g gVar, Map<Type, i<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, s sVar, List<u> list) {
        this.f876a = new ThreadLocal<>();
        this.f877b = Collections.synchronizedMap(new HashMap());
        this.i = new a();
        this.j = new b();
        b.a.a.b.e eVar = new b.a.a.b.e(map);
        this.f879d = eVar;
        this.e = z;
        this.g = z3;
        this.f = z4;
        this.h = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(b.a.a.b.a.l.Q);
        arrayList.add(b.a.a.b.a.h.f776a);
        arrayList.add(dVar);
        arrayList.addAll(list);
        arrayList.add(b.a.a.b.a.l.x);
        arrayList.add(b.a.a.b.a.l.m);
        arrayList.add(b.a.a.b.a.l.g);
        arrayList.add(b.a.a.b.a.l.i);
        arrayList.add(b.a.a.b.a.l.k);
        arrayList.add(b.a.a.b.a.l.c(Long.TYPE, Long.class, c(sVar)));
        arrayList.add(b.a.a.b.a.l.c(Double.TYPE, Double.class, f(z6)));
        arrayList.add(b.a.a.b.a.l.c(Float.TYPE, Float.class, s(z6)));
        arrayList.add(b.a.a.b.a.l.r);
        arrayList.add(b.a.a.b.a.l.t);
        arrayList.add(b.a.a.b.a.l.z);
        arrayList.add(b.a.a.b.a.l.B);
        arrayList.add(b.a.a.b.a.l.b(BigDecimal.class, b.a.a.b.a.l.v));
        arrayList.add(b.a.a.b.a.l.b(BigInteger.class, b.a.a.b.a.l.w));
        arrayList.add(b.a.a.b.a.l.D);
        arrayList.add(b.a.a.b.a.l.F);
        arrayList.add(b.a.a.b.a.l.J);
        arrayList.add(b.a.a.b.a.l.O);
        arrayList.add(b.a.a.b.a.l.H);
        arrayList.add(b.a.a.b.a.l.f789d);
        arrayList.add(b.a.a.b.a.d.f757a);
        arrayList.add(b.a.a.b.a.l.M);
        arrayList.add(b.a.a.b.a.i.f779a);
        arrayList.add(b.a.a.b.a.j.f781a);
        arrayList.add(b.a.a.b.a.l.K);
        arrayList.add(b.a.a.b.a.a.f751a);
        arrayList.add(b.a.a.b.a.l.R);
        arrayList.add(b.a.a.b.a.l.f787b);
        arrayList.add(new b.a.a.b.a.b(eVar));
        arrayList.add(new b.a.a.b.a.f(eVar, z2));
        arrayList.add(new b.a.a.b.a.g(eVar, gVar, dVar));
        this.f878c = Collections.unmodifiableList(arrayList);
    }

    private d.h a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        d.h hVar = new d.h(writer);
        if (this.h) {
            hVar.q("  ");
        }
        hVar.o(this.e);
        return hVar;
    }

    private t<Number> c(s sVar) {
        return sVar == s.O000000o ? b.a.a.b.a.l.n : new e();
    }

    private t<Number> f(boolean z) {
        return z ? b.a.a.b.a.l.p : new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void p(Object obj, d.f fVar) {
        if (obj != null) {
            try {
                if (fVar.t() == d.g.END_DOCUMENT) {
                    return;
                }
                throw new l("JSON document was not fully consumed.");
            } catch (d.i e2) {
                throw new r(e2);
            } catch (IOException e3) {
                throw new l(e3);
            }
        }
    }

    private t<Number> s(boolean z) {
        return z ? b.a.a.b.a.l.o : new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> t<T> b(b.a.a.e.a<T> aVar) {
        t<T> tVar = (t<T>) this.f877b.get(aVar);
        if (tVar != null) {
            return tVar;
        }
        Map<b.a.a.e.a<?>, f<?>> map = this.f876a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f876a.set(map);
            z = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            for (u uVar : this.f878c) {
                t tVar2 = (t<T>) uVar.a(this, aVar);
                if (tVar2 != null) {
                    fVar2.d(tVar2);
                    this.f877b.put(aVar, tVar2);
                    return tVar2;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f876a.remove();
            }
        }
    }

    public <T> t<T> d(u uVar, b.a.a.e.a<T> aVar) {
        boolean z = false;
        for (u uVar2 : this.f878c) {
            if (z) {
                t<T> a2 = uVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (uVar2 == uVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> t<T> e(Class<T> cls) {
        return b(b.a.a.e.a.e(cls));
    }

    public <T> T g(d.f fVar, Type type) throws l, r {
        boolean E = fVar.E();
        boolean z = true;
        fVar.e(true);
        try {
            try {
                try {
                    fVar.t();
                    z = false;
                    T c2 = b(b.a.a.e.a.c(type)).c(fVar);
                    fVar.e(E);
                    return c2;
                } catch (IOException e2) {
                    throw new r(e2);
                }
            } catch (EOFException e3) {
                if (z) {
                    fVar.e(E);
                    return null;
                }
                throw new r(e3);
            } catch (IllegalStateException e4) {
                throw new r(e4);
            }
        } catch (Throwable th) {
            fVar.e(E);
            throw th;
        }
    }

    public <T> T h(Reader reader, Type type) throws l, r {
        d.f fVar = new d.f(reader);
        T t = (T) g(fVar, type);
        p(t, fVar);
        return t;
    }

    public <T> T i(String str, Class<T> cls) throws r {
        return (T) b.a.a.b.l.a(cls).cast(j(str, cls));
    }

    public <T> T j(String str, Type type) throws r {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    public String k(v vVar) {
        StringWriter stringWriter = new StringWriter();
        o(vVar, stringWriter);
        return stringWriter.toString();
    }

    public void n(v vVar, d.h hVar) throws l {
        boolean v = hVar.v();
        hVar.l(true);
        boolean w = hVar.w();
        hVar.r(this.f);
        boolean y = hVar.y();
        hVar.o(this.e);
        try {
            try {
                b.a.a.b.k.b(vVar, hVar);
            } catch (IOException e2) {
                throw new l(e2);
            }
        } finally {
            hVar.l(v);
            hVar.r(w);
            hVar.o(y);
        }
    }

    public void o(v vVar, Appendable appendable) throws l {
        try {
            n(vVar, a(b.a.a.b.k.a(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void q(Object obj, Type type, d.h hVar) throws l {
        t b2 = b(b.a.a.e.a.c(type));
        boolean v = hVar.v();
        hVar.l(true);
        boolean w = hVar.w();
        hVar.r(this.f);
        boolean y = hVar.y();
        hVar.o(this.e);
        try {
            try {
                b2.a(hVar, obj);
            } catch (IOException e2) {
                throw new l(e2);
            }
        } finally {
            hVar.l(v);
            hVar.r(w);
            hVar.o(y);
        }
    }

    public void r(Object obj, Type type, Appendable appendable) throws l {
        try {
            q(obj, type, a(b.a.a.b.k.a(appendable)));
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public String t(Object obj) {
        return obj == null ? k(m.f887a) : u(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.e + "factories:" + this.f878c + ",instanceCreators:" + this.f879d + "}";
    }

    public String u(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        r(obj, type, stringWriter);
        return stringWriter.toString();
    }
}
