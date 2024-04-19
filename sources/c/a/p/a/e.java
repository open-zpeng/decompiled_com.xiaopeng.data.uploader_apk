package c.a.p.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes.dex */
public final class e implements c.a.m.b, b {

    /* renamed from: b  reason: collision with root package name */
    List<c.a.m.b> f1458b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f1459c;

    @Override // c.a.p.a.b
    public boolean a(c.a.m.b bVar) {
        c.a.p.b.b.d(bVar, "Disposable item is null");
        if (this.f1459c) {
            return false;
        }
        synchronized (this) {
            if (this.f1459c) {
                return false;
            }
            List<c.a.m.b> list = this.f1458b;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // c.a.p.a.b
    public boolean b(c.a.m.b bVar) {
        if (a(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // c.a.p.a.b
    public boolean c(c.a.m.b bVar) {
        c.a.p.b.b.d(bVar, "d is null");
        if (!this.f1459c) {
            synchronized (this) {
                if (!this.f1459c) {
                    List list = this.f1458b;
                    if (list == null) {
                        list = new LinkedList();
                        this.f1458b = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    void d(List<c.a.m.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (c.a.m.b bVar : list) {
            try {
                bVar.dispose();
            } catch (Throwable th) {
                c.a.n.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw c.a.p.h.d.c((Throwable) arrayList.get(0));
            }
            throw new c.a.n.a(arrayList);
        }
    }

    @Override // c.a.m.b
    public void dispose() {
        if (this.f1459c) {
            return;
        }
        synchronized (this) {
            if (this.f1459c) {
                return;
            }
            this.f1459c = true;
            List<c.a.m.b> list = this.f1458b;
            this.f1458b = null;
            d(list);
        }
    }
}
