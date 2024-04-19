package b.b.a.b.g;

import android.text.TextUtils;
import b.b.a.b.f.c;
import b.b.a.b.f.h;
import b.b.a.b.f.i;
import b.b.a.b.f.n;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.util.Map;
/* compiled from: Log.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f1094a;

    /* renamed from: b  reason: collision with root package name */
    public String f1095b;

    /* renamed from: c  reason: collision with root package name */
    public String f1096c;

    /* renamed from: d  reason: collision with root package name */
    private String f1097d;
    public String e;
    public String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private Map<String, String> k;

    public b() {
        this.f1096c = "3";
        this.e = null;
        this.f = "";
    }

    public String a() {
        try {
            byte[] a2 = c.a(this.f1097d.getBytes(XmartV1Constants.UTF8_ENCODING), 2);
            if (a2 != null) {
                return new String(n.c(a2, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String b() {
        return this.f1097d;
    }

    public void c(String str) {
        if (str != null) {
            try {
                this.f1097d = new String(c.c(n.c(str.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"), 2), XmartV1Constants.UTF8_ENCODING);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void d(String str) {
        this.f1097d = str;
    }

    public void e() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = String.valueOf(System.currentTimeMillis());
        }
        String a2 = h.a(this.g, this.f1095b, this.h, this.i, this.j, this.k, this.f, this.e);
        i.c("UTLog", this, a2);
        c(a2);
    }

    public String toString() {
        return "Log [id=" + this.f1094a + ", eventId=" + this.f1095b + ", index=" + this.f + "]";
    }

    public b(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.f1096c = "3";
        this.e = null;
        this.f = "";
        this.f1095b = str2;
        this.g = str;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = map;
        this.e = String.valueOf(System.currentTimeMillis());
        e();
    }
}
