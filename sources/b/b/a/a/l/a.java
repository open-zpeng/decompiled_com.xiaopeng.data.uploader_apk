package b.b.a.a.l;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BalancedPool.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f951a = new a();

    /* renamed from: b  reason: collision with root package name */
    private Map<Class<? extends b>, c<? extends b>> f952b = new HashMap();

    private a() {
    }

    public static a a() {
        return f951a;
    }

    private synchronized <T extends b> c<T> c(Class<T> cls) {
        c<T> cVar;
        cVar = (c<T>) this.f952b.get(cls);
        if (cVar == null) {
            cVar = new c<>();
            this.f952b.put(cls, cVar);
        }
        return cVar;
    }

    public <T extends b> T b(Class<T> cls, Object... objArr) {
        T a2 = c(cls).a();
        if (a2 == null) {
            try {
                a2 = cls.newInstance();
            } catch (Exception e) {
                b.b.a.a.j.b.d(e);
            }
        }
        if (a2 != null) {
            a2.b(objArr);
        }
        return a2;
    }

    public <T extends b> void d(T t) {
        if (t == null || (t instanceof e) || (t instanceof d)) {
            return;
        }
        c(t.getClass()).b(t);
    }
}
