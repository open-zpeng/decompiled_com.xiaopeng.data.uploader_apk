package b.a.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    Comparator<? super K> f845d;
    e<K, V> e;
    int f;
    int g;
    final e<K, V> h;
    private h<K, V>.b i;
    private h<K, V>.c j;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f844c = true;

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<Comparable> f843b = new a();

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super(h.this, null);
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c2;
            if ((obj instanceof Map.Entry) && (c2 = h.this.c((Map.Entry) obj)) != null) {
                h.this.f(c2, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        class a extends h<K, V>.d<K> {
            a() {
                super(h.this, null);
            }

            @Override // java.util.Iterator
            public K next() {
                return a().g;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f848b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f849c;

        /* renamed from: d  reason: collision with root package name */
        int f850d;

        private d() {
            this.f848b = h.this.h.e;
            this.f849c = null;
            this.f850d = h.this.g;
        }

        /* synthetic */ d(h hVar, a aVar) {
            this();
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f848b;
            h hVar = h.this;
            if (eVar != hVar.h) {
                if (hVar.g == this.f850d) {
                    this.f848b = eVar.e;
                    this.f849c = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f848b != h.this.h;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f849c;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f849c = null;
            this.f850d = h.this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f851b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f852c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f853d;
        e<K, V> e;
        e<K, V> f;
        final K g;
        V h;
        int i;

        e() {
            this.g = null;
            this.f = this;
            this.e = this;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f851b = eVar;
            this.g = k;
            this.i = 1;
            this.e = eVar2;
            this.f = eVar3;
            eVar3.e = this;
            eVar2.f = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f852c; eVar2 != null; eVar2 = eVar2.f852c) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f853d; eVar2 != null; eVar2 = eVar2.f853d) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.g;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.h;
                Object value = entry.getValue();
                if (v == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!v.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.g;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        public String toString() {
            return this.g + "=" + this.h;
        }
    }

    public h() {
        this(f843b);
    }

    public h(Comparator<? super K> comparator) {
        this.f = 0;
        this.g = 0;
        this.h = new e<>();
        this.f845d = comparator == null ? f843b : comparator;
    }

    private void d(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f852c;
        e<K, V> eVar3 = eVar.f853d;
        e<K, V> eVar4 = eVar3.f852c;
        e<K, V> eVar5 = eVar3.f853d;
        eVar.f853d = eVar4;
        if (eVar4 != null) {
            eVar4.f851b = eVar;
        }
        e(eVar, eVar3);
        eVar3.f852c = eVar;
        eVar.f851b = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.i : 0, eVar4 != null ? eVar4.i : 0) + 1;
        eVar.i = max;
        eVar3.i = Math.max(max, eVar5 != null ? eVar5.i : 0) + 1;
    }

    private void e(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f851b;
        eVar.f851b = null;
        if (eVar2 != null) {
            eVar2.f851b = eVar3;
        }
        if (eVar3 == null) {
            this.e = eVar2;
        } else if (eVar3.f852c == eVar) {
            eVar3.f852c = eVar2;
        } else if (!f844c && eVar3.f853d != eVar) {
            throw new AssertionError();
        } else {
            eVar3.f853d = eVar2;
        }
    }

    private boolean g(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f852c;
        e<K, V> eVar3 = eVar.f853d;
        e<K, V> eVar4 = eVar2.f852c;
        e<K, V> eVar5 = eVar2.f853d;
        eVar.f852c = eVar5;
        if (eVar5 != null) {
            eVar5.f851b = eVar;
        }
        e(eVar, eVar2);
        eVar2.f853d = eVar;
        eVar.f851b = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.i : 0, eVar5 != null ? eVar5.i : 0) + 1;
        eVar.i = max;
        eVar2.i = Math.max(max, eVar4 != null ? eVar4.i : 0) + 1;
    }

    private void j(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f852c;
            e<K, V> eVar3 = eVar.f853d;
            int i = eVar2 != null ? eVar2.i : 0;
            int i2 = eVar3 != null ? eVar3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.f852c;
                e<K, V> eVar5 = eVar3.f853d;
                int i4 = (eVar4 != null ? eVar4.i : 0) - (eVar5 != null ? eVar5.i : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!f844c && i4 != 1) {
                        throw new AssertionError();
                    }
                    i(eVar3);
                }
                d(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.f852c;
                e<K, V> eVar7 = eVar2.f853d;
                int i5 = (eVar6 != null ? eVar6.i : 0) - (eVar7 != null ? eVar7.i : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!f844c && i5 != -1) {
                        throw new AssertionError();
                    }
                    d(eVar2);
                }
                i(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.i = i + 1;
                if (z) {
                    return;
                }
            } else if (!f844c && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                eVar.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f851b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    e<K, V> b(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f845d;
        e<K, V> eVar2 = this.e;
        if (eVar2 != null) {
            Comparable comparable = comparator == f843b ? (Comparable) k : null;
            while (true) {
                Object obj = (K) eVar2.g;
                i = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.f852c : eVar2.f853d;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.h;
            if (eVar2 != null) {
                eVar = new e<>(eVar2, k, eVar4, eVar4.f);
                if (i < 0) {
                    eVar2.f852c = eVar;
                } else {
                    eVar2.f853d = eVar;
                }
                j(eVar2, true);
            } else if (comparator == f843b && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.f);
                this.e = eVar;
            }
            this.f++;
            this.g++;
            return eVar;
        }
        return null;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && g(a2.h, entry.getValue())) {
            return a2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.e = null;
        this.f = 0;
        this.g++;
        e<K, V> eVar = this.h;
        eVar.f = eVar;
        eVar.e = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.f;
            eVar2.e = eVar.e;
            eVar.e.f = eVar2;
        }
        e<K, V> eVar3 = eVar.f852c;
        e<K, V> eVar4 = eVar.f853d;
        e<K, V> eVar5 = eVar.f851b;
        int i2 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                e(eVar, eVar3);
                eVar.f852c = null;
            } else if (eVar4 != null) {
                e(eVar, eVar4);
                eVar.f853d = null;
            } else {
                e(eVar, null);
            }
            j(eVar5, false);
            this.f--;
            this.g++;
            return;
        }
        e<K, V> b2 = eVar3.i > eVar4.i ? eVar3.b() : eVar4.a();
        f(b2, false);
        e<K, V> eVar6 = eVar.f852c;
        if (eVar6 != null) {
            i = eVar6.i;
            b2.f852c = eVar6;
            eVar6.f851b = b2;
            eVar.f852c = null;
        } else {
            i = 0;
        }
        e<K, V> eVar7 = eVar.f853d;
        if (eVar7 != null) {
            i2 = eVar7.i;
            b2.f853d = eVar7;
            eVar7.f851b = b2;
            eVar.f853d = null;
        }
        b2.i = Math.max(i, i2) + 1;
        e(eVar, b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.h;
        }
        return null;
    }

    e<K, V> h(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            f(a2, true);
        }
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.j;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.j = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> b2 = b(k, true);
        V v2 = b2.h;
        b2.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> h = h(obj);
        if (h != null) {
            return h.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f;
    }
}
