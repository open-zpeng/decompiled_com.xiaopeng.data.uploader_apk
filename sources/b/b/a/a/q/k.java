package b.b.a.a.q;

import b.b.a.a.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: MetricValueSet.java */
/* loaded from: classes.dex */
public class k implements b.b.a.a.l.b {

    /* renamed from: b  reason: collision with root package name */
    private Map<i, i.e> f999b = Collections.synchronizedMap(new HashMap());

    @Override // b.b.a.a.l.b
    public void a() {
        for (i.e eVar : this.f999b.values()) {
            b.b.a.a.l.a.a().d(eVar);
        }
        this.f999b.clear();
    }

    @Override // b.b.a.a.l.b
    public void b(Object... objArr) {
        if (this.f999b == null) {
            this.f999b = Collections.synchronizedMap(new HashMap());
        }
    }

    public i.e c(Integer num, String str, String str2, String str3, Class<? extends i.e> cls) {
        i iVar;
        boolean z;
        i.e eVar;
        boolean z2 = false;
        if (num.intValue() == i.g.STAT.a()) {
            iVar = j.c().b(str, str2);
            z = false;
        } else {
            iVar = (i) b.b.a.a.l.a.a().b(i.class, str, str2, str3);
            z = true;
        }
        i.e eVar2 = null;
        if (iVar != null) {
            if (this.f999b.containsKey(iVar)) {
                eVar2 = this.f999b.get(iVar);
                z2 = z;
            } else {
                synchronized (k.class) {
                    eVar = (i.e) b.b.a.a.l.a.a().b(cls, num, str, str2, str3);
                    this.f999b.put(iVar, eVar);
                }
                eVar2 = eVar;
            }
            if (z2) {
                b.b.a.a.l.a.a().d(iVar);
            }
        }
        return eVar2;
    }

    public List<i.e> d() {
        return new ArrayList(this.f999b.values());
    }
}
