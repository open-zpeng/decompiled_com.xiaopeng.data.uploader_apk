package b.b.a.a;

import android.app.Application;
import android.os.RemoteException;
import b.b.a.a.b;
import b.b.a.a.d;
import b.b.a.a.i;
import java.util.Map;
/* compiled from: Monitor.java */
/* loaded from: classes.dex */
public class e extends d.a {

    /* renamed from: a  reason: collision with root package name */
    private Application f918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Application application) {
        this.f918a = application;
    }

    private i.g k0(int i) {
        return i.g.a(i);
    }

    @Override // b.b.a.a.d
    public void A(String str, String str2, String str3) throws RemoteException {
        b.d.f(str, str2, str3);
    }

    @Override // b.b.a.a.d
    public void B(int i) throws RemoteException {
        b.c.d(i);
    }

    @Override // b.b.a.a.d
    public void D(int i) throws RemoteException {
        b.d.h(i);
    }

    @Override // b.b.a.a.d
    public void F(boolean z, String str, String str2, String str3) throws RemoteException {
        b.i(z, str, str2, str3);
    }

    @Override // b.b.a.a.d
    public void G() throws RemoteException {
        b.m();
    }

    @Override // b.b.a.a.d
    public void H(String str, String str2, b.b.a.a.q.d dVar, b.b.a.a.q.h hVar, Map map) throws RemoteException {
        b.b.a.b.f.i.c("Monitor", "[stat_commit3]");
        b.d.e(str, str2, dVar, hVar, map);
    }

    @Override // b.b.a.a.d
    public void I(int i) throws RemoteException {
        b.d.g(i);
    }

    @Override // b.b.a.a.d
    public void K(String str) throws RemoteException {
        b.h(str);
    }

    @Override // b.b.a.a.d
    public void L(String str, String str2, double d2, Map map) throws RemoteException {
        b.d.c(str, str2, d2, map);
    }

    @Override // b.b.a.a.d
    public void M(String str, String str2, b.b.a.a.q.f fVar) throws RemoteException {
        b.d(str, str2, fVar);
    }

    @Override // b.b.a.a.d
    public void N(String str, String str2, String str3, String str4, Map map) throws RemoteException {
        b.a.c(str, str2, str3, str4, map);
    }

    @Override // b.b.a.a.d
    public void O(String str, String str2, double d2, Map map) throws RemoteException {
        b.C0034b.b(str, str2, d2, map);
    }

    @Override // b.b.a.a.d
    public void P(String str, String str2, String str3, double d2, Map map) throws RemoteException {
        b.C0034b.c(str, str2, str3, d2, map);
    }

    @Override // b.b.a.a.d
    public void Q(int i) throws RemoteException {
        b.c.c(i);
    }

    @Override // b.b.a.a.d
    public void R(Map map) throws RemoteException {
        b.o(map);
    }

    @Override // b.b.a.a.d
    public void S(int i, int i2) throws RemoteException {
        b.l(k0(i), i2);
    }

    @Override // b.b.a.a.d
    public void T(int i) throws RemoteException {
        b.a.f(i);
    }

    @Override // b.b.a.a.d
    public void U(String str, String str2, b.b.a.a.q.d dVar, double d2, Map map) throws RemoteException {
        b.d.d(str, str2, dVar, d2, map);
    }

    @Override // b.b.a.a.d
    public void V(int i) throws RemoteException {
        b.k(i);
    }

    @Override // b.b.a.a.d
    public void W(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar) throws RemoteException {
        b.e(str, str2, fVar, cVar);
    }

    @Override // b.b.a.a.d
    public void Z(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException {
        b.a.b(str, str2, str3, str4, str5, map);
    }

    @Override // b.b.a.a.d
    public void b0(int i) throws RemoteException {
        b.C0034b.d(i);
    }

    @Override // b.b.a.a.d
    public void c0() throws RemoteException {
        b.n();
    }

    @Override // b.b.a.a.d
    public void destroy() throws RemoteException {
        b.a();
    }

    @Override // b.b.a.a.d
    public void f(String str, String str2, double d2) throws RemoteException {
        b.c.b(str, str2, d2);
    }

    @Override // b.b.a.a.d
    public boolean f0(String str, String str2) throws RemoteException {
        return b.c.a(str, str2);
    }

    @Override // b.b.a.a.d
    public void g(int i) throws RemoteException {
        b.C0034b.e(i);
    }

    @Override // b.b.a.a.d
    public void h(int i) throws RemoteException {
        b.j(i);
    }

    @Override // b.b.a.a.d
    public void h0(String str, String str2, b.b.a.a.q.f fVar, boolean z) throws RemoteException {
        b.g(str, str2, fVar, z);
    }

    @Override // b.b.a.a.d
    public boolean i(String str, String str2) throws RemoteException {
        return b.C0034b.a(str, str2);
    }

    @Override // b.b.a.a.d
    public void init() throws RemoteException {
        b.c(this.f918a);
    }

    @Override // b.b.a.a.d
    public void j(int i) throws RemoteException {
        b.a.g(i);
    }

    @Override // b.b.a.a.d
    public void n(String str, String str2, String str3, Map map) throws RemoteException {
        b.a.d(str, str2, str3, map);
    }

    @Override // b.b.a.a.d
    public void p(boolean z) throws RemoteException {
        b.b(z);
    }

    @Override // b.b.a.a.d
    public void q(g gVar, String str) throws RemoteException {
        h.c(gVar, str);
    }

    @Override // b.b.a.a.d
    public void t(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar, boolean z) throws RemoteException {
        b.f(str, str2, fVar, cVar, z);
    }

    @Override // b.b.a.a.d
    public void u(String str, String str2, String str3) throws RemoteException {
        b.d.a(str, str2, str3);
    }

    @Override // b.b.a.a.d
    public boolean v(String str, String str2) throws RemoteException {
        return b.a.a(str, str2);
    }

    @Override // b.b.a.a.d
    public void w(String str, String str2, Map map) throws RemoteException {
        b.a.e(str, str2, map);
    }

    @Override // b.b.a.a.d
    public boolean x(String str, String str2) throws RemoteException {
        return b.d.b(str, str2);
    }

    @Override // b.b.a.a.d
    public void y(g gVar, String str) throws RemoteException {
        h.b(gVar, str);
    }
}
