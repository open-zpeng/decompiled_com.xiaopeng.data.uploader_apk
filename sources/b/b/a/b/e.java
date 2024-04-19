package b.b.a.b;

import java.util.Map;
/* compiled from: UTMCVariables.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f1041a = new e();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1042b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1043c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f1044d = null;
    private Map<String, String> e = null;
    private boolean f = false;
    private boolean g = false;
    private String h = null;
    private String i = null;
    private String j = null;
    private boolean k = false;

    public static e a() {
        return f1041a;
    }

    public synchronized Map<String, String> b() {
        return this.e;
    }

    public synchronized void c(Map<String, String> map) {
        this.e = map;
    }

    public synchronized boolean d() {
        return this.g;
    }

    public synchronized void e(String str) {
        this.h = str;
    }

    public synchronized void f() {
        this.g = true;
    }
}
