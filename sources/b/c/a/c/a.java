package b.c.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import b.c.a.l.c;
import java.io.Serializable;
/* compiled from: CacheEntity.java */
/* loaded from: classes.dex */
public class a<T> implements Serializable {
    private static final long serialVersionUID = -4337711009801627866L;

    /* renamed from: b  reason: collision with root package name */
    private String f1120b;

    /* renamed from: c  reason: collision with root package name */
    private long f1121c;

    /* renamed from: d  reason: collision with root package name */
    private b.c.a.j.a f1122d;
    private T e;
    private boolean f;

    public static <T> ContentValues b(a<T> aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", aVar.d());
        contentValues.put("localExpire", Long.valueOf(aVar.e()));
        contentValues.put("head", c.c(aVar.f()));
        contentValues.put("data", c.c(aVar.c()));
        return contentValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> a<T> h(Cursor cursor) {
        a<T> aVar = (a<T>) new a();
        aVar.k(cursor.getString(cursor.getColumnIndex("key")));
        aVar.l(cursor.getLong(cursor.getColumnIndex("localExpire")));
        aVar.m((b.c.a.j.a) c.d(cursor.getBlob(cursor.getColumnIndex("head"))));
        aVar.i(c.d(cursor.getBlob(cursor.getColumnIndex("data"))));
        return aVar;
    }

    public boolean a(b bVar, long j, long j2) {
        return bVar == b.DEFAULT ? e() < j2 : j != -1 && e() + j < j2;
    }

    public T c() {
        return this.e;
    }

    public String d() {
        return this.f1120b;
    }

    public long e() {
        return this.f1121c;
    }

    public b.c.a.j.a f() {
        return this.f1122d;
    }

    public boolean g() {
        return this.f;
    }

    public void i(T t) {
        this.e = t;
    }

    public void j(boolean z) {
        this.f = z;
    }

    public void k(String str) {
        this.f1120b = str;
    }

    public void l(long j) {
        this.f1121c = j;
    }

    public void m(b.c.a.j.a aVar) {
        this.f1122d = aVar;
    }

    public String toString() {
        return "CacheEntity{key='" + this.f1120b + "', responseHeaders=" + this.f1122d + ", data=" + this.e + ", localExpire=" + this.f1121c + '}';
    }
}
