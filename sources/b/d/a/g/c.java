package b.d.a.g;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.List;
/* compiled from: StatEventHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f1259a;

    /* renamed from: b  reason: collision with root package name */
    private a f1260b;

    private c(Context context) {
        this.f1260b = new d(context);
    }

    public static c a() {
        if (f1259a != null) {
            return f1259a;
        }
        throw new IllegalStateException("has not init the StatEventHeler");
    }

    public static void b(Context context) {
        f1259a = new c(context);
    }

    public void c(String str) {
        this.f1260b.a(str);
    }

    public void d(IMoleEvent iMoleEvent) {
        this.f1260b.b(iMoleEvent);
    }

    public void e(IStatEvent iStatEvent) {
        this.f1260b.c(iStatEvent);
    }

    public void f(IStatEvent iStatEvent, List<String> list) {
        this.f1260b.d(iStatEvent, list);
    }

    public void g(List<String> list) {
        this.f1260b.e(list);
    }

    public void h(String str, String str2) {
        this.f1260b.f(str, str2);
    }

    public void i(String str, String str2) {
        this.f1260b.g(str, str2);
    }

    public String j() {
        return this.f1260b.h();
    }
}
