package b.c.a.d;

import b.c.a.j.d;
/* compiled from: AbsCallback.java */
/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {
    public void downloadProgress(b.c.a.j.c cVar) {
    }

    @Override // b.c.a.d.b
    public void onCacheSuccess(d<T> dVar) {
    }

    @Override // b.c.a.d.b
    public void onError(d<T> dVar) {
        b.c.a.l.d.a(dVar.d());
    }

    @Override // b.c.a.d.b
    public void onFinish() {
    }

    @Override // b.c.a.d.b
    public void onStart(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
    }

    @Override // b.c.a.d.b
    public void uploadProgress(b.c.a.j.c cVar) {
    }
}
