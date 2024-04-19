package b.a.a.b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Primitives.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f862a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f863b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        b(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        b(hashMap, hashMap2, Byte.TYPE, Byte.class);
        b(hashMap, hashMap2, Character.TYPE, Character.class);
        b(hashMap, hashMap2, Double.TYPE, Double.class);
        b(hashMap, hashMap2, Float.TYPE, Float.class);
        b(hashMap, hashMap2, Integer.TYPE, Integer.class);
        b(hashMap, hashMap2, Long.TYPE, Long.class);
        b(hashMap, hashMap2, Short.TYPE, Short.class);
        b(hashMap, hashMap2, Void.TYPE, Void.class);
        f862a = Collections.unmodifiableMap(hashMap);
        f863b = Collections.unmodifiableMap(hashMap2);
    }

    public static <T> Class<T> a(Class<T> cls) {
        Class<T> cls2 = (Class<T>) f862a.get(b.a(cls));
        return cls2 == null ? cls : cls2;
    }

    private static void b(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean c(Type type) {
        return f862a.containsKey(type);
    }
}
