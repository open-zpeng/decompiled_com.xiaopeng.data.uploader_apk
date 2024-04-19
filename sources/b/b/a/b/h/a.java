package b.b.a.b.h;

import b.b.a.b.f.i;
import b.b.a.b.f.j;
/* compiled from: BaseRequestAuth.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f1098a;

    /* renamed from: b  reason: collision with root package name */
    private String f1099b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1100c;

    public a(String str, String str2, boolean z) {
        this.f1098a = null;
        this.f1099b = null;
        this.f1100c = false;
        this.f1098a = str;
        this.f1099b = str2;
        this.f1100c = z;
    }

    public boolean a() {
        return this.f1100c;
    }

    @Override // b.b.a.b.h.b
    public String getAppkey() {
        return this.f1098a;
    }

    @Override // b.b.a.b.h.b
    public String getSign(String str) {
        if (this.f1098a == null || this.f1099b == null) {
            i.c("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return j.a(j.b((str + this.f1099b).getBytes()));
        }
    }
}
