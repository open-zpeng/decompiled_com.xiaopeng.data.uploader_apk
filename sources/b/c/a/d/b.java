package b.c.a.d;

import b.c.a.j.d;
/* compiled from: Callback.java */
/* loaded from: classes.dex */
public interface b<T> extends b.c.a.e.a<T> {
    void onCacheSuccess(d<T> dVar);

    void onError(d<T> dVar);

    void onFinish();

    void onStart(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar);

    void onSuccess(d<T> dVar);

    void uploadProgress(b.c.a.j.c cVar);
}
