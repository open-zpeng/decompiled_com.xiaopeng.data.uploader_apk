package com.ta.utdid2.c.a;

import com.ta.utdid2.c.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: TransactionXMLFile.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1823c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private File f1824a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1825b = new Object();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<File, a> f121a = new HashMap<>();

    /* compiled from: TransactionXMLFile.java */
    /* loaded from: classes.dex */
    private static final class a implements b {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f1826d = new Object();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<b.InterfaceC0079b, Object> f1827a;

        /* renamed from: b  reason: collision with root package name */
        private final File f1828b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1829c;

        /* renamed from: c  reason: collision with other field name */
        private final File f122c;

        /* renamed from: c  reason: collision with other field name */
        private Map f123c;
        private boolean k = false;

        a(File file, int i, Map map) {
            this.f1828b = file;
            this.f122c = d.a(file);
            this.f1829c = i;
            this.f123c = map == null ? new HashMap() : map;
            this.f1827a = new WeakHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            if (this.f1828b.exists()) {
                if (!this.f122c.exists()) {
                    if (!this.f1828b.renameTo(this.f122c)) {
                        return false;
                    }
                } else {
                    this.f1828b.delete();
                }
            }
            try {
                FileOutputStream a2 = a(this.f1828b);
                if (a2 == null) {
                    return false;
                }
                e.a(this.f123c, a2);
                a2.close();
                this.f122c.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.f1828b.exists()) {
                    this.f1828b.delete();
                }
                return false;
            }
        }

        public boolean c() {
            boolean z;
            synchronized (this) {
                z = this.k;
            }
            return z;
        }

        @Override // com.ta.utdid2.c.a.b
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f123c);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.c.a.b
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f123c.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        @Override // com.ta.utdid2.c.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f123c.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        @Override // com.ta.utdid2.c.a.b
        /* renamed from: a */
        public boolean mo59a() {
            return this.f1828b != null && new File(this.f1828b.getAbsolutePath()).exists();
        }

        /* compiled from: TransactionXMLFile.java */
        /* renamed from: com.ta.utdid2.c.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class C0080a implements b.a {

            /* renamed from: d  reason: collision with root package name */
            private final Map<String, Object> f1831d = new HashMap();
            private boolean l = false;

            public C0080a() {
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.f1831d.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.l = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC0079b> hashSet;
                boolean d2;
                synchronized (d.f1823c) {
                    z = a.this.f1827a.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f1827a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.l) {
                            a.this.f123c.clear();
                            this.l = false;
                        }
                        for (Map.Entry<String, Object> entry : this.f1831d.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f123c.remove(key);
                            } else {
                                a.this.f123c.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.f1831d.clear();
                    }
                    d2 = a.this.d();
                    if (d2) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.InterfaceC0079b interfaceC0079b : hashSet) {
                            if (interfaceC0079b != null) {
                                interfaceC0079b.a(a.this, str);
                            }
                        }
                    }
                }
                return d2;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, int i) {
                synchronized (this) {
                    this.f1831d.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, long j) {
                synchronized (this) {
                    this.f1831d.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, float f) {
                synchronized (this) {
                    this.f1831d.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.f1831d.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.c.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.f1831d.put(str, this);
                }
                return this;
            }
        }

        public void a(boolean z) {
            synchronized (this) {
                this.k = z;
            }
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f123c = map;
                }
            }
        }

        @Override // com.ta.utdid2.c.a.b
        public b.a a() {
            return new C0080a();
        }

        private FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }
    }

    public d(String str) {
        if (str != null && str.length() > 0) {
            this.f1824a = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    private File b(String str) {
        File a2 = a();
        return a(a2, String.valueOf(str) + ".xml");
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File a() {
        File file;
        synchronized (this.f1825b) {
            file = this.f1824a;
        }
        return file;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0080, code lost:
        if (r2 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b9, code lost:
        if (r3 == null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00be A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0085, blocks: (B:50:0x0082, B:74:0x00be), top: B:107:0x003e }] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ta.utdid2.c.a.b a(java.lang.String r10, int r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.a.d.a(java.lang.String, int):com.ta.utdid2.c.a.b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File a(File file) {
        return new File(String.valueOf(file.getPath()) + ".bak");
    }
}
