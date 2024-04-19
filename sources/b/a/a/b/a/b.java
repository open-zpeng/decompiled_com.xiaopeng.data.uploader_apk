package b.a.a.b.a;

import b.a.a.d;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.b.e f754b;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private static final class a<E> extends t<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final t<E> f755a;

        /* renamed from: b  reason: collision with root package name */
        private final b.a.a.b.i<? extends Collection<E>> f756b;

        public a(b.a.a.h hVar, Type type, t<E> tVar, b.a.a.b.i<? extends Collection<E>> iVar) {
            this.f755a = new k(hVar, tVar, type);
            this.f756b = iVar;
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Collection<E> c(d.f fVar) throws IOException {
            if (fVar.t() == d.g.NULL) {
                fVar.w();
                return null;
            }
            Collection<E> O000000o = this.f756b.O000000o();
            fVar.c();
            while (fVar.s()) {
                O000000o.add(this.f755a.c(fVar));
            }
            fVar.l();
            return O000000o;
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                hVar.u();
                return;
            }
            hVar.i();
            for (E e : collection) {
                this.f755a.a(hVar, e);
            }
            hVar.p();
        }
    }

    public b(b.a.a.b.e eVar) {
        this.f754b = eVar;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
        Type d2 = aVar.d();
        Class<? super T> a2 = aVar.a();
        if (Collection.class.isAssignableFrom(a2)) {
            Type f = b.a.a.b.c.f(d2, a2);
            return new a(hVar, f, hVar.b(b.a.a.e.a.c(f)), this.f754b.a(aVar));
        }
        return null;
    }
}
