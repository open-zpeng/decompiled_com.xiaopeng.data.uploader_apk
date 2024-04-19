package c.a;
/* compiled from: Observer.java */
/* loaded from: classes.dex */
public interface i<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(c.a.m.b bVar);
}
