package a.a.c.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f254b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f255c;
    private final int f;
    private final int g;
    private final String h;

    /* renamed from: a  reason: collision with root package name */
    private final Object f253a = new Object();
    private Handler.Callback e = new a();

    /* renamed from: d  reason: collision with root package name */
    private int f256d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c.this.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                c.this.b((Runnable) message.obj);
                return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f258b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Handler f259c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f260d;

        /* compiled from: SelfDestructiveThread.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f261b;

            a(Object obj) {
                this.f261b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f260d.a(this.f261b);
            }
        }

        b(Callable callable, Handler handler, d dVar) {
            this.f258b = callable;
            this.f259c = handler;
            this.f260d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f258b.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f259c.post(new a(obj));
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: a.a.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0010c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callable f264c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReentrantLock f265d;
        final /* synthetic */ AtomicBoolean e;
        final /* synthetic */ Condition f;

        RunnableC0010c(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f263b = atomicReference;
            this.f264c = callable;
            this.f265d = reentrantLock;
            this.e = atomicBoolean;
            this.f = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f263b.set(this.f264c.call());
            } catch (Exception unused) {
            }
            this.f265d.lock();
            try {
                this.e.set(false);
                this.f.signal();
            } finally {
                this.f265d.unlock();
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void c(Runnable runnable) {
        synchronized (this.f253a) {
            if (this.f254b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.f254b = handlerThread;
                handlerThread.start();
                this.f255c = new Handler(this.f254b.getLooper(), this.e);
                this.f256d++;
            }
            this.f255c.removeMessages(0);
            Handler handler = this.f255c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.f253a) {
            if (this.f255c.hasMessages(1)) {
                return;
            }
            this.f254b.quit();
            this.f254b = null;
            this.f255c = null;
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f253a) {
            this.f255c.removeMessages(0);
            Handler handler = this.f255c;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(callable, new Handler(), dVar));
    }

    public <T> T e(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new RunnableC0010c(atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
