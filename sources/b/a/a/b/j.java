package b.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class j {

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class a extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f854a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f855b;

        a(Method method, Object obj) {
            this.f854a = method;
            this.f855b = obj;
        }

        @Override // b.a.a.b.j
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.f854a.invoke(this.f855b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class b extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f856a;

        b(Method method) {
            this.f856a = method;
        }

        @Override // b.a.a.b.j
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.f856a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f857a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f858b;

        c(Method method, int i) {
            this.f857a = method;
            this.f858b = i;
        }

        @Override // b.a.a.b.j
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.f857a.invoke(null, cls, Integer.valueOf(this.f858b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class d extends j {
        d() {
        }

        @Override // b.a.a.b.j
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static j a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    return new b(declaredMethod);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3, intValue);
            }
        }
    }

    public abstract <T> T b(Class<T> cls) throws Exception;
}
