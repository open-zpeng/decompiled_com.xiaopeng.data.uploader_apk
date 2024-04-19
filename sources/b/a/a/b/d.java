package b.a.a.b;

import b.a.a.d;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class d implements u, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public static final d f812b = new d();
    private boolean f;

    /* renamed from: c  reason: collision with root package name */
    private double f813c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    private int f814d = 136;
    private boolean e = true;
    private List<b.a.a.c> g = Collections.emptyList();
    private List<b.a.a.c> h = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* loaded from: classes.dex */
    class a<T> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private t<T> f815a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f816b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f817c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b.a.a.h f818d;
        final /* synthetic */ b.a.a.e.a e;

        a(boolean z, boolean z2, b.a.a.h hVar, b.a.a.e.a aVar) {
            this.f816b = z;
            this.f817c = z2;
            this.f818d = hVar;
            this.e = aVar;
        }

        private t<T> d() {
            t<T> tVar = this.f815a;
            if (tVar != null) {
                return tVar;
            }
            t<T> d2 = this.f818d.d(d.this, this.e);
            this.f815a = d2;
            return d2;
        }

        @Override // b.a.a.t
        public void a(d.h hVar, T t) throws IOException {
            if (this.f817c) {
                hVar.u();
            } else {
                d().a(hVar, t);
            }
        }

        @Override // b.a.a.t
        public T c(d.f fVar) throws IOException {
            if (this.f816b) {
                fVar.B();
                return null;
            }
            return d().c(fVar);
        }
    }

    private boolean c(b.a.a.a.c cVar) {
        return cVar == null || cVar.O000000o() <= this.f813c;
    }

    private boolean d(b.a.a.a.c cVar, b.a.a.a.d dVar) {
        return c(cVar) && e(dVar);
    }

    private boolean e(b.a.a.a.d dVar) {
        return dVar == null || dVar.O000000o() > this.f813c;
    }

    private boolean f(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean i(Class<?> cls) {
        return cls.isMemberClass() && !j(cls);
    }

    private boolean j(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        boolean g = g(a2, true);
        boolean g2 = g(a2, false);
        if (g || g2) {
            return new a(g2, g, hVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public boolean g(Class<?> cls, boolean z) {
        if (this.f813c == -1.0d || d((b.a.a.a.c) cls.getAnnotation(b.a.a.a.c.class), (b.a.a.a.d) cls.getAnnotation(b.a.a.a.d.class))) {
            if ((this.e || !i(cls)) && !f(cls)) {
                for (b.a.a.c cVar : z ? this.g : this.h) {
                    if (cVar.b(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean h(Field field, boolean z) {
        b.a.a.a.a aVar;
        if ((this.f814d & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f813c == -1.0d || d((b.a.a.a.c) field.getAnnotation(b.a.a.a.c.class), (b.a.a.a.d) field.getAnnotation(b.a.a.a.d.class))) && !field.isSynthetic()) {
            if (!this.f || ((aVar = (b.a.a.a.a) field.getAnnotation(b.a.a.a.a.class)) != null && (!z ? !aVar.O00000Oo() : !aVar.O000000o()))) {
                if ((this.e || !i(field.getType())) && !f(field.getType())) {
                    List<b.a.a.c> list = z ? this.g : this.h;
                    if (list.isEmpty()) {
                        return false;
                    }
                    b.a.a.f fVar = new b.a.a.f(field);
                    for (b.a.a.c cVar : list) {
                        if (cVar.a(fVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}
