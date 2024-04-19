package b.b.a.a;

import b.b.a.a.i;
import b.b.a.a.n.j;
/* compiled from: TransactionDelegate.java */
/* loaded from: classes.dex */
public class h {
    private static void a(g gVar) {
        if (gVar == null || gVar.e == null) {
            return;
        }
        i.f.b().m(gVar.f, gVar.f920b, gVar.f921c, gVar.f922d, b.b.a.a.q.d.f().d(gVar.e));
    }

    public static void b(g gVar, String str) {
        try {
            if (b.f915c && gVar != null) {
                b.b.a.b.f.i.c("TransactionDelegate", "statEvent begin. module: ", gVar.f921c, " monitorPoint: ", gVar.f922d, " measureName: ", str);
                i.g gVar2 = i.g.STAT;
                if (!gVar2.isOpen() || (!b.f913a && !j.d(gVar2, gVar.f921c, gVar.f922d))) {
                    b.b.a.b.f.i.c("TransactionDelegate", "log discard", gVar.f921c, " monitorPoint: ", gVar.f922d, " measureName: ", str);
                    return;
                }
                i.f.b().n(gVar.f, gVar.f920b, gVar.f921c, gVar.f922d, str);
                a(gVar);
            }
        } catch (Throwable th) {
            b.b.a.a.j.b.d(th);
        }
    }

    public static void c(g gVar, String str) {
        try {
            if (b.f915c && gVar != null) {
                b.b.a.b.f.i.c("TransactionDelegate", "statEvent end. module: ", gVar.f921c, " monitorPoint: ", gVar.f922d, " measureName: ", str);
                i.g gVar2 = i.g.STAT;
                if (!gVar2.isOpen() || (!b.f913a && !j.d(gVar2, gVar.f921c, gVar.f922d))) {
                    b.b.a.b.f.i.c("TransactionDelegate", "log discard", gVar.f921c, " monitorPoint: ", gVar.f922d, " measureName: ", str);
                    return;
                }
                a(gVar);
                i.f.b().p(gVar.f, str, false, gVar.g);
            }
        } catch (Throwable th) {
            b.b.a.a.j.b.d(th);
        }
    }
}
