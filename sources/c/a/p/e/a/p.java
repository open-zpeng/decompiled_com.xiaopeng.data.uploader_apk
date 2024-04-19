package c.a.p.e.a;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes.dex */
public final class p {

    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements c.a.p.c.a<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: b  reason: collision with root package name */
        final c.a.i<? super T> f1532b;

        /* renamed from: c  reason: collision with root package name */
        final T f1533c;

        public a(c.a.i<? super T> iVar, T t) {
            this.f1532b = iVar;
            this.f1533c = t;
        }

        @Override // c.a.p.c.c
        public void clear() {
            lazySet(3);
        }

        @Override // c.a.m.b
        public void dispose() {
            set(3);
        }

        @Override // c.a.p.c.c
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // c.a.p.c.c
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // c.a.p.c.c
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.f1533c;
            }
            return null;
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f1532b.onNext((T) this.f1533c);
                if (get() == 2) {
                    lazySet(3);
                    this.f1532b.onComplete();
                }
            }
        }
    }

    public static <T, R> boolean a(c.a.h<T> hVar, c.a.i<? super R> iVar, c.a.o.f<? super T, ? extends c.a.h<? extends R>> fVar) {
        if (hVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) hVar).call();
                if (obj == 0) {
                    c.a.p.a.d.complete(iVar);
                    return true;
                }
                try {
                    c.a.h hVar2 = (c.a.h) c.a.p.b.b.d(fVar.apply(obj), "The mapper returned a null ObservableSource");
                    if (hVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) hVar2).call();
                            if (call == null) {
                                c.a.p.a.d.complete(iVar);
                                return true;
                            }
                            a aVar = new a(iVar, call);
                            iVar.onSubscribe(aVar);
                            aVar.run();
                        } catch (Throwable th) {
                            c.a.n.b.b(th);
                            c.a.p.a.d.error(th, iVar);
                            return true;
                        }
                    } else {
                        hVar2.a(iVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    c.a.n.b.b(th2);
                    c.a.p.a.d.error(th2, iVar);
                    return true;
                }
            } catch (Throwable th3) {
                c.a.n.b.b(th3);
                c.a.p.a.d.error(th3, iVar);
                return true;
            }
        }
        return false;
    }
}
