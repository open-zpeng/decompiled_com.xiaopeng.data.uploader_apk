package b.a.a.b.a;

import b.a.a.d;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends t<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f751a = new C0027a();

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f752b;

    /* renamed from: c  reason: collision with root package name */
    private final t<E> f753c;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: b.a.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0027a implements u {
        C0027a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            Type d2 = aVar.d();
            if ((d2 instanceof GenericArrayType) || ((d2 instanceof Class) && ((Class) d2).isArray())) {
                Type t = b.a.a.b.c.t(d2);
                return new a(hVar, hVar.b(b.a.a.e.a.c(t)), b.a.a.b.c.r(t));
            }
            return null;
        }
    }

    public a(b.a.a.h hVar, t<E> tVar, Class<E> cls) {
        this.f753c = new k(hVar, tVar, cls);
        this.f752b = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.a.a.t
    public void a(d.h hVar, Object obj) throws IOException {
        if (obj == null) {
            hVar.u();
            return;
        }
        hVar.i();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f753c.a(hVar, Array.get(obj, i));
        }
        hVar.p();
    }

    @Override // b.a.a.t
    public Object c(d.f fVar) throws IOException {
        if (fVar.t() == d.g.NULL) {
            fVar.w();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        fVar.c();
        while (fVar.s()) {
            arrayList.add(this.f753c.c(fVar));
        }
        fVar.l();
        Object newInstance = Array.newInstance((Class<?>) this.f752b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
