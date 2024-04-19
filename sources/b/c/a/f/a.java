package b.c.a.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
/* compiled from: BaseDao.java */
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static String f1161a;

    /* renamed from: b  reason: collision with root package name */
    protected Lock f1162b;

    /* renamed from: c  reason: collision with root package name */
    protected SQLiteOpenHelper f1163c;

    /* renamed from: d  reason: collision with root package name */
    protected SQLiteDatabase f1164d;

    public a(SQLiteOpenHelper sQLiteOpenHelper) {
        f1161a = getClass().getSimpleName();
        this.f1162b = d.f1170a;
        this.f1163c = sQLiteOpenHelper;
        this.f1164d = e();
    }

    protected final void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public boolean b(String str, String[] strArr) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        this.f1162b.lock();
        try {
            try {
                this.f1164d.beginTransaction();
                this.f1164d.delete(d(), str, strArr);
                this.f1164d.setTransactionSuccessful();
                return true;
            } catch (Exception e) {
                b.c.a.l.d.a(e);
                this.f1164d.endTransaction();
                this.f1162b.unlock();
                String str3 = f1161a;
                b.c.a.l.d.b(str3, (System.currentTimeMillis() - currentTimeMillis) + " delete");
                return false;
            }
        } finally {
            this.f1164d.endTransaction();
            this.f1162b.unlock();
            str2 = f1161a;
            b.c.a.l.d.b(str2, (System.currentTimeMillis() - currentTimeMillis) + " delete");
        }
    }

    public abstract ContentValues c(T t);

    public abstract String d();

    public SQLiteDatabase e() {
        return this.f1163c.getWritableDatabase();
    }

    public abstract T f(Cursor cursor);

    public List<T> g(String str, String[] strArr) {
        return h(null, str, strArr, null, null, null, null);
    }

    public List<T> h(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        String str6;
        StringBuilder sb;
        long currentTimeMillis = System.currentTimeMillis();
        this.f1162b.lock();
        ArrayList arrayList = new ArrayList();
        try {
            this.f1164d.beginTransaction();
            cursor = this.f1164d.query(d(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursor.isClosed() && cursor.moveToNext()) {
                try {
                    try {
                        arrayList.add(f(cursor));
                    } catch (Exception e) {
                        e = e;
                        b.c.a.l.d.a(e);
                        a(null, cursor);
                        this.f1164d.endTransaction();
                        this.f1162b.unlock();
                        str6 = f1161a;
                        sb = new StringBuilder();
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append(" query");
                        b.c.a.l.d.b(str6, sb.toString());
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    a(null, cursor);
                    this.f1164d.endTransaction();
                    this.f1162b.unlock();
                    b.c.a.l.d.b(f1161a, (System.currentTimeMillis() - currentTimeMillis) + " query");
                    throw th;
                }
            }
            this.f1164d.setTransactionSuccessful();
            a(null, cursor);
            this.f1164d.endTransaction();
            this.f1162b.unlock();
            str6 = f1161a;
            sb = new StringBuilder();
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            a(null, cursor);
            this.f1164d.endTransaction();
            this.f1162b.unlock();
            b.c.a.l.d.b(f1161a, (System.currentTimeMillis() - currentTimeMillis) + " query");
            throw th;
        }
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" query");
        b.c.a.l.d.b(str6, sb.toString());
        return arrayList;
    }

    public boolean i(T t) {
        String str;
        if (t == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f1162b.lock();
        try {
            this.f1164d.beginTransaction();
            this.f1164d.replace(d(), null, c(t));
            this.f1164d.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            b.c.a.l.d.a(e);
            return false;
        } finally {
            this.f1164d.endTransaction();
            this.f1162b.unlock();
            str = f1161a;
            b.c.a.l.d.b(str, (System.currentTimeMillis() - currentTimeMillis) + " replaceT");
        }
    }
}
