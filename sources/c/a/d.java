package c.a;
/* compiled from: MaybeObserver.java */
/* loaded from: classes.dex */
public interface d<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(c.a.m.b bVar);
}
