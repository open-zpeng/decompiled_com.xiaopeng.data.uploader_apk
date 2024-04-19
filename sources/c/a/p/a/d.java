package c.a.p.a;

import c.a.i;
import c.a.k;
/* compiled from: EmptyDisposable.java */
/* loaded from: classes.dex */
public enum d implements c.a.p.c.a<Object> {
    INSTANCE,
    NEVER;

    public static void complete(i<?> iVar) {
        iVar.onSubscribe(INSTANCE);
        iVar.onComplete();
    }

    public static void error(Throwable th, i<?> iVar) {
        iVar.onSubscribe(INSTANCE);
        iVar.onError(th);
    }

    @Override // c.a.p.c.c
    public void clear() {
    }

    @Override // c.a.m.b
    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // c.a.p.c.c
    public boolean isEmpty() {
        return true;
    }

    @Override // c.a.p.c.c
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // c.a.p.c.c
    public Object poll() throws Exception {
        return null;
    }

    @Override // c.a.p.c.b
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(c.a.d<?> dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    public static void error(Throwable th, c.a.a aVar) {
        aVar.onSubscribe(INSTANCE);
        aVar.onError(th);
    }

    public static void complete(c.a.a aVar) {
        aVar.onSubscribe(INSTANCE);
        aVar.onComplete();
    }

    public static void error(Throwable th, k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onError(th);
    }

    public static void error(Throwable th, c.a.d<?> dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onError(th);
    }
}
