package d.b;
/* compiled from: Subscriber.java */
/* loaded from: classes.dex */
public interface a<T> {
    void a(b bVar);

    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
