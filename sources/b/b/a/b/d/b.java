package b.b.a.b.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import b.b.a.b.f.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogSqliteStore.java */
/* loaded from: classes.dex */
public class b implements b.b.a.b.d.a {

    /* renamed from: a  reason: collision with root package name */
    String f1027a = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";

    /* renamed from: b  reason: collision with root package name */
    String f1028b = "SELECT count(*) FROM %s";

    /* renamed from: c  reason: collision with root package name */
    String f1029c = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";

    /* renamed from: d  reason: collision with root package name */
    a f1030d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogSqliteStore.java */
    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f1031a;

        /* renamed from: b  reason: collision with root package name */
        private SQLiteDatabase f1032b;

        a(Context context) {
            super(context, "ut.db", (SQLiteDatabase.CursorFactory) null, 2);
            this.f1031a = new AtomicInteger();
        }

        public synchronized void a(SQLiteDatabase sQLiteDatabase) {
            SQLiteDatabase sQLiteDatabase2;
            if (sQLiteDatabase == null) {
                return;
            }
            try {
                if (this.f1031a.decrementAndGet() == 0 && (sQLiteDatabase2 = this.f1032b) != null) {
                    sQLiteDatabase2.close();
                    this.f1032b = null;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            try {
                if (this.f1031a.incrementAndGet() == 1) {
                    this.f1032b = super.getWritableDatabase();
                }
            }
            return this.f1032b;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable unused) {
            }
            b.this.f(cursor);
            super.onOpen(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1 && i2 == 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    i.b("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.f1030d = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // b.b.a.b.d.a
    public synchronized void b(String str, String str2) {
        SQLiteDatabase writableDatabase = this.f1030d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", str + " < ?", new String[]{String.valueOf(str2)});
            this.f1030d.a(writableDatabase);
        } else {
            i.c("UTSqliteLogStore", "db is null");
        }
    }

    @Override // b.b.a.b.d.a
    public synchronized int c() {
        int i;
        SQLiteDatabase writableDatabase = this.f1030d.getWritableDatabase();
        i = 0;
        if (writableDatabase != null) {
            Cursor rawQuery = writableDatabase.rawQuery(String.format(this.f1028b, "log"), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            f(rawQuery);
            this.f1030d.a(writableDatabase);
        } else {
            i.c("UTSqliteLogStore", "db is null");
        }
        return i;
    }

    @Override // b.b.a.b.d.a
    public synchronized void clear() {
        SQLiteDatabase writableDatabase = this.f1030d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.f1030d.a(writableDatabase);
        }
    }

    @Override // b.b.a.b.d.a
    public void d(int i) {
        if (i <= 0) {
            return;
        }
        SQLiteDatabase writableDatabase = this.f1030d.getWritableDatabase();
        if (writableDatabase != null) {
            try {
                writableDatabase.execSQL(String.format(this.f1029c, Integer.valueOf(i)));
            } catch (Throwable unused) {
            }
            this.f1030d.a(writableDatabase);
            return;
        }
        i.c("UTSqliteLogStore", "db is null");
    }

    @Override // b.b.a.b.d.a
    /* renamed from: e */
    public synchronized ArrayList<b.b.a.b.g.b> a(String str, int i) {
        ArrayList<b.b.a.b.g.b> arrayList = null;
        if (i <= 0) {
            return (ArrayList) Collections.EMPTY_LIST;
        }
        ArrayList<b.b.a.b.g.b> arrayList2 = new ArrayList<>(i);
        try {
            SQLiteDatabase writableDatabase = this.f1030d.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM ");
                sb.append("log");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" WHERE ");
                    sb.append(str);
                }
                sb.append(" ORDER BY ");
                sb.append("time");
                sb.append(" ASC ");
                sb.append(" LIMIT ");
                sb.append(i + "");
                String sb2 = sb.toString();
                i.c("UTSqliteLogStore", "sql:" + sb2);
                Cursor rawQuery = writableDatabase.rawQuery(sb2, null);
                while (rawQuery != null && rawQuery.moveToNext()) {
                    b.b.a.b.g.b bVar = new b.b.a.b.g.b();
                    i.c("UTSqliteLogStore", "pos", Integer.valueOf(rawQuery.getPosition()), "count", Integer.valueOf(rawQuery.getCount()));
                    bVar.f1094a = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    bVar.f1095b = rawQuery.getString(rawQuery.getColumnIndex("eventId"));
                    bVar.f1096c = rawQuery.getString(rawQuery.getColumnIndex("priority"));
                    bVar.d(rawQuery.getString(rawQuery.getColumnIndex("content")));
                    bVar.e = rawQuery.getString(rawQuery.getColumnIndex("time"));
                    try {
                        bVar.f = rawQuery.getString(rawQuery.getColumnIndex("_index"));
                    } catch (Throwable unused) {
                    }
                    arrayList2.add(bVar);
                }
                f(rawQuery);
                this.f1030d.a(writableDatabase);
            } else {
                i.c("UTSqliteLogStore", "db is null");
            }
        } catch (Throwable unused2) {
            arrayList = arrayList2;
            arrayList2 = arrayList;
            return arrayList2;
        }
        return arrayList2;
    }

    @Override // b.b.a.b.d.a
    /* renamed from: a */
    public synchronized boolean mo1a(List<b.b.a.b.g.b> list) {
        boolean z = true;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase sQLiteDatabase = null;
                boolean z2 = false;
                try {
                    sQLiteDatabase = this.f1030d.getWritableDatabase();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.beginTransaction();
                        int i = 0;
                        while (true) {
                            try {
                                if (i >= list.size()) {
                                    break;
                                }
                                b.b.a.b.g.b bVar = list.get(i);
                                if (bVar != null) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("eventId", bVar.f1095b);
                                    contentValues.put("priority", bVar.f1096c);
                                    contentValues.put("content", bVar.b());
                                    contentValues.put("time", bVar.e);
                                    contentValues.put("_index", bVar.f);
                                    long insert = sQLiteDatabase.insert("log", "", contentValues);
                                    if (insert == -1) {
                                        z = false;
                                        break;
                                    }
                                    i.c("UTSqliteLogStore", "[insert] ", bVar.f, " isSuccess:", Boolean.TRUE, "ret", Long.valueOf(insert));
                                }
                                i++;
                            } catch (Throwable th) {
                                th = th;
                                i.b("UTSqliteLogStore", "insert error", th);
                                b.b.a.a.j.b.d(th);
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.setTransactionSuccessful();
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                this.f1030d.a(sQLiteDatabase);
                                z2 = z;
                                return z2;
                            }
                        }
                        z2 = z;
                    } else {
                        i.c("UTSqliteLogStore", "db is null");
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Throwable unused3) {
                        }
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    this.f1030d.a(sQLiteDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                return z2;
            }
        }
        return true;
    }

    @Override // b.b.a.b.d.a
    public synchronized int a(List<b.b.a.b.g.b> list) {
        boolean z;
        int i;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = this.f1030d.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.beginTransaction();
                    i = 0;
                    z = true;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        long delete = writableDatabase.delete("log", "_id=?", new String[]{list.get(i2).f1094a + ""});
                        if (delete <= 0) {
                            i.c("UTSqliteLogStore", "[delete]  ", Integer.valueOf(list.get(i2).f1094a), " ret:", Long.valueOf(delete));
                            z = false;
                        } else if (!"6005".equalsIgnoreCase(list.get(i2).f1095b)) {
                            i++;
                        }
                    }
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (Throwable unused) {
                    }
                    try {
                        writableDatabase.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    this.f1030d.a(writableDatabase);
                } else {
                    i.c("UTSqliteLogStore", "db is null");
                    z = false;
                    i = 0;
                }
                i.c("UTSqliteLogStore", "delete ", Integer.valueOf(list.size()), " isSuccess:", Boolean.valueOf(z));
                return i;
            }
        }
        return 0;
    }
}
