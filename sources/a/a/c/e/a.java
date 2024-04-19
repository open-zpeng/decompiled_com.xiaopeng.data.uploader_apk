package a.a.c.e;

import a.a.c.g.g;
import android.util.Base64;
import java.util.List;
/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f231a;

    /* renamed from: b  reason: collision with root package name */
    private final String f232b;

    /* renamed from: c  reason: collision with root package name */
    private final String f233c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f234d;
    private final int e;
    private final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        String str4 = (String) g.b(str);
        this.f231a = str4;
        String str5 = (String) g.b(str2);
        this.f232b = str5;
        String str6 = (String) g.b(str3);
        this.f233c = str6;
        this.f234d = (List) g.b(list);
        this.e = 0;
        this.f = str4 + "-" + str5 + "-" + str6;
    }

    public List<List<byte[]>> a() {
        return this.f234d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.f231a;
    }

    public String e() {
        return this.f232b;
    }

    public String f() {
        return this.f233c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f231a + ", mProviderPackage: " + this.f232b + ", mQuery: " + this.f233c + ", mCertificates:");
        for (int i = 0; i < this.f234d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f234d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
