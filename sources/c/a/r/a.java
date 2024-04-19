package c.a.r;

import c.a.i;
import c.a.m.b;
import c.a.p.a.c;
import c.a.p.h.e;
/* compiled from: SerializedObserver.java */
/* loaded from: classes.dex */
public final class a<T> implements i<T>, b {

    /* renamed from: b  reason: collision with root package name */
    final i<? super T> f1626b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f1627c;

    /* renamed from: d  reason: collision with root package name */
    b f1628d;
    boolean e;
    c.a.p.h.a<Object> f;
    volatile boolean g;

    public a(i<? super T> iVar) {
        this(iVar, false);
    }

    void a() {
        c.a.p.h.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f;
                if (aVar == null) {
                    this.e = false;
                    return;
                }
                this.f = null;
            }
        } while (!aVar.a((i<? super T>) this.f1626b));
    }

    @Override // c.a.m.b
    public void dispose() {
        this.f1628d.dispose();
    }

    @Override // c.a.i
    public void onComplete() {
        if (this.g) {
            return;
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            if (this.e) {
                c.a.p.h.a<Object> aVar = this.f;
                if (aVar == null) {
                    aVar = new c.a.p.h.a<>(4);
                    this.f = aVar;
                }
                aVar.b(e.complete());
                return;
            }
            this.g = true;
            this.e = true;
            this.f1626b.onComplete();
        }
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (this.g) {
            c.a.s.a.m(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.g) {
                if (this.e) {
                    this.g = true;
                    c.a.p.h.a<Object> aVar = this.f;
                    if (aVar == null) {
                        aVar = new c.a.p.h.a<>(4);
                        this.f = aVar;
                    }
                    Object error = e.error(th);
                    if (this.f1627c) {
                        aVar.b(error);
                    } else {
                        aVar.c(error);
                    }
                    return;
                }
                this.g = true;
                this.e = true;
                z = false;
            }
            if (z) {
                c.a.s.a.m(th);
            } else {
                this.f1626b.onError(th);
            }
        }
    }

    @Override // c.a.i
    public void onNext(T t) {
        if (this.g) {
            return;
        }
        if (t == null) {
            this.f1628d.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            if (this.e) {
                c.a.p.h.a<Object> aVar = this.f;
                if (aVar == null) {
                    aVar = new c.a.p.h.a<>(4);
                    this.f = aVar;
                }
                aVar.b(e.next(t));
                return;
            }
            this.e = true;
            this.f1626b.onNext(t);
            a();
        }
    }

    @Override // c.a.i
    public void onSubscribe(b bVar) {
        if (c.validate(this.f1628d, bVar)) {
            this.f1628d = bVar;
            this.f1626b.onSubscribe(this);
        }
    }

    public a(i<? super T> iVar, boolean z) {
        this.f1626b = iVar;
        this.f1627c = z;
    }
}
