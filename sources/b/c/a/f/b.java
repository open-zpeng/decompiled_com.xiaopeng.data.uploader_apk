package b.c.a.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.irdeto.securesdk.core.SSUtils;
import java.util.List;
/* compiled from: CacheManager.java */
/* loaded from: classes.dex */
public class b extends b.c.a.f.a<b.c.a.c.a<?>> {

    /* compiled from: CacheManager.java */
    /* renamed from: b.c.a.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0047b {

        /* renamed from: a  reason: collision with root package name */
        private static final b f1165a = new b();
    }

    public static b l() {
        return C0047b.f1165a;
    }

    @Override // b.c.a.f.a
    public String d() {
        return SSUtils.O00000o0;
    }

    public b.c.a.c.a<?> j(String str) {
        if (str == null) {
            return null;
        }
        List<b.c.a.c.a<?>> g = g("key=?", new String[]{str});
        if (g.size() > 0) {
            return g.get(0);
        }
        return null;
    }

    @Override // b.c.a.f.a
    /* renamed from: k */
    public ContentValues c(b.c.a.c.a<?> aVar) {
        return b.c.a.c.a.b(aVar);
    }

    @Override // b.c.a.f.a
    /* renamed from: m */
    public b.c.a.c.a<?> f(Cursor cursor) {
        return b.c.a.c.a.h(cursor);
    }

    public boolean n(String str) {
        if (str == null) {
            return false;
        }
        return b("key=?", new String[]{str});
    }

    public <T> b.c.a.c.a<T> o(String str, b.c.a.c.a<T> aVar) {
        aVar.k(str);
        i(aVar);
        return aVar;
    }

    private b() {
        super(new d());
    }
}
