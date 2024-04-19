package b.b.a.a.q;

import java.util.ArrayList;
import java.util.List;
/* compiled from: MetricRepo.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f997a;

    /* renamed from: b  reason: collision with root package name */
    public List<i> f998b;

    private j(int i) {
        this.f998b = new ArrayList(i);
    }

    public static j c() {
        if (f997a == null) {
            f997a = new j(3);
        }
        return f997a;
    }

    public void a(i iVar) {
        if (this.f998b.contains(iVar)) {
            return;
        }
        this.f998b.add(iVar);
    }

    public i b(String str, String str2) {
        List<i> list;
        if (str != null && str2 != null && (list = this.f998b) != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                i iVar = this.f998b.get(i);
                if (iVar != null && iVar.f().equals(str) && iVar.g().equals(str2)) {
                    return iVar;
                }
            }
        }
        return null;
    }

    public boolean d(i iVar) {
        if (this.f998b.contains(iVar)) {
            return this.f998b.remove(iVar);
        }
        return true;
    }
}
