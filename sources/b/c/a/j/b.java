package b.c.a.j;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
/* compiled from: HttpParams.java */
/* loaded from: classes.dex */
public class b implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final MediaType f1187b = MediaType.parse("text/plain;charset=utf-8");

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f1188c = MediaType.parse("application/json;charset=utf-8");

    /* renamed from: d  reason: collision with root package name */
    public static final MediaType f1189d = MediaType.parse(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    private static final long serialVersionUID = 7369819159227055048L;
    public LinkedHashMap<String, List<String>> e;
    public LinkedHashMap<String, List<a>> f;

    /* compiled from: HttpParams.java */
    /* loaded from: classes.dex */
    public static class a implements Serializable {
        private static final long serialVersionUID = -2356139899636767776L;

        /* renamed from: b  reason: collision with root package name */
        public File f1190b;

        /* renamed from: c  reason: collision with root package name */
        public String f1191c;

        /* renamed from: d  reason: collision with root package name */
        public transient MediaType f1192d;
        public long e;

        public a(File file, String str, MediaType mediaType) {
            this.f1190b = file;
            this.f1191c = str;
            this.f1192d = mediaType;
            this.e = file.length();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f1192d = MediaType.parse((String) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f1192d.toString());
        }

        public String toString() {
            return "FileWrapper{file=" + this.f1190b + ", fileName=" + this.f1191c + ", contentType=" + this.f1192d + ", fileSize=" + this.e + "}";
        }
    }

    public b() {
        b();
    }

    private void b() {
        this.e = new LinkedHashMap<>();
        this.f = new LinkedHashMap<>();
    }

    private void i(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return;
        }
        List<String> list = this.e.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.e.put(str, list);
        }
        if (z) {
            list.clear();
        }
        list.add(str2);
    }

    public void a() {
        this.e.clear();
        this.f.clear();
    }

    public void c(b bVar) {
        if (bVar != null) {
            LinkedHashMap<String, List<String>> linkedHashMap = bVar.e;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.e.putAll(bVar.e);
            }
            LinkedHashMap<String, List<a>> linkedHashMap2 = bVar.f;
            if (linkedHashMap2 == null || linkedHashMap2.isEmpty()) {
                return;
            }
            this.f.putAll(bVar.f);
        }
    }

    public void d(String str, float f, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, String.valueOf(f), zArr[0]);
        } else {
            i(str, String.valueOf(f), true);
        }
    }

    public void e(String str, int i, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, String.valueOf(i), zArr[0]);
        } else {
            i(str, String.valueOf(i), true);
        }
    }

    public void f(String str, File file) {
        g(str, file, file.getName());
    }

    public void g(String str, File file, String str2) {
        h(str, file, str2, b.c.a.l.b.e(str2));
    }

    public void h(String str, File file, String str2, MediaType mediaType) {
        if (str != null) {
            List<a> list = this.f.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f.put(str, list);
            }
            list.add(new a(file, str2, mediaType));
        }
    }

    public void j(String str, String str2, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, str2, zArr[0]);
        } else {
            i(str, str2, true);
        }
    }

    public void k(String str, boolean z, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, String.valueOf(z), zArr[0]);
        } else {
            i(str, String.valueOf(z), true);
        }
    }

    public void l(Map<String, String> map, boolean... zArr) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            j(entry.getKey(), entry.getValue(), zArr);
        }
    }

    public void m(String str) {
        o(str);
        n(str);
    }

    public void n(String str) {
        this.f.remove(str);
    }

    public void o(String str) {
        this.e.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : this.e.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, List<a>> entry2 : this.f.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue());
        }
        return sb.toString();
    }
}
