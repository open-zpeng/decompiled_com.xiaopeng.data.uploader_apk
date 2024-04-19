package b.c.a.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* compiled from: DBUtils.java */
/* loaded from: classes.dex */
public class e {
    public static boolean a(SQLiteDatabase sQLiteDatabase, f fVar) {
        if (b(sQLiteDatabase, fVar.f1174a)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + fVar.f1174a, null);
            if (rawQuery == null) {
                return false;
            }
            try {
                int c2 = fVar.c();
                if (c2 == rawQuery.getColumnCount()) {
                    for (int i = 0; i < c2; i++) {
                        if (fVar.d(rawQuery.getColumnName(i)) == -1) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            } finally {
                rawQuery.close();
            }
        }
        return true;
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        if (str == null || sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", str});
            } catch (Exception e) {
                b.c.a.l.d.a(e);
                if (cursor != null) {
                    cursor.close();
                }
                i = 0;
            }
            if (!cursor.moveToFirst()) {
                cursor.close();
                return false;
            }
            i = cursor.getInt(0);
            cursor.close();
            return i > 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
