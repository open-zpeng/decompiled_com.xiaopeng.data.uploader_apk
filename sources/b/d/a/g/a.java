package b.d.a.g;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.List;
/* compiled from: AbstractStatDelegate.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    protected Context f1243b;

    public a(Context context) {
        this.f1243b = context;
    }

    public abstract void a(String str);

    public abstract void b(IMoleEvent iMoleEvent);

    public abstract void c(IStatEvent iStatEvent);

    public abstract void d(IStatEvent iStatEvent, List<String> list);

    public abstract void e(List<String> list);

    public abstract void f(String str, String str2);

    public abstract void g(String str, String str2);

    public abstract String h();
}
