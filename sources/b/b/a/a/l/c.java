package b.b.a.a.l;

import b.b.a.a.l.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ReuseItemPool.java */
/* loaded from: classes.dex */
public class c<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicLong f953a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private static AtomicLong f954b = new AtomicLong(0);
    private final int f = 20;
    private Integer e = null;

    /* renamed from: c  reason: collision with root package name */
    private AtomicLong f955c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    private AtomicLong f956d = new AtomicLong(0);
    private ConcurrentLinkedQueue<T> g = new ConcurrentLinkedQueue<>();
    private Set<Integer> h = new HashSet();

    public T a() {
        f953a.getAndIncrement();
        this.f955c.getAndIncrement();
        T poll = this.g.poll();
        if (poll != null) {
            this.h.remove(Integer.valueOf(System.identityHashCode(poll)));
            this.f956d.getAndIncrement();
            f954b.getAndIncrement();
        }
        return poll;
    }

    public void b(T t) {
        t.a();
        if (this.g.size() < 20) {
            synchronized (this.h) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.h.contains(Integer.valueOf(identityHashCode))) {
                    this.h.add(Integer.valueOf(identityHashCode));
                    this.g.offer(t);
                }
            }
        }
    }
}
