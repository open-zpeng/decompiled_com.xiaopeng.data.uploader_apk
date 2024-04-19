package b.a.a.e;

import b.a.a.b.b;
import b.a.a.b.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f872a;

    /* renamed from: b  reason: collision with root package name */
    final Type f873b;

    /* renamed from: c  reason: collision with root package name */
    final int f874c;

    protected a() {
        Type b2 = b(a.class);
        this.f873b = b2;
        this.f872a = (Class<? super T>) c.r(b2);
        this.f874c = b2.hashCode();
    }

    a(Type type) {
        Type p = c.p((Type) b.a(type));
        this.f873b = p;
        this.f872a = (Class<? super T>) c.r(p);
        this.f874c = p.hashCode();
    }

    static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return c.p(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static a<?> c(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> e(Class<T> cls) {
        return new a<>(cls);
    }

    public final Class<? super T> a() {
        return this.f872a;
    }

    public final Type d() {
        return this.f873b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && c.k(this.f873b, ((a) obj).f873b);
    }

    public final int hashCode() {
        return this.f874c;
    }

    public final String toString() {
        return c.s(this.f873b);
    }
}
