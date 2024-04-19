package a.a.c.g;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends h<K, V> implements Map<K, V> {
    e<K, V> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: a.a.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0013a extends e<K, V> {
        C0013a() {
        }

        @Override // a.a.c.g.e
        protected void a() {
            a.this.clear();
        }

        @Override // a.a.c.g.e
        protected Object b(int i, int i2) {
            return a.this.g[(i << 1) + i2];
        }

        @Override // a.a.c.g.e
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // a.a.c.g.e
        protected int d() {
            return a.this.h;
        }

        @Override // a.a.c.g.e
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // a.a.c.g.e
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // a.a.c.g.e
        protected void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // a.a.c.g.e
        protected void h(int i) {
            a.this.j(i);
        }

        @Override // a.a.c.g.e
        protected V i(int i, V v) {
            return a.this.k(i, v);
        }
    }

    public a() {
    }

    private e<K, V> m() {
        if (this.i == null) {
            this.i = new C0013a();
        }
        return this.i;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }

    public a(int i) {
        super(i);
    }
}
