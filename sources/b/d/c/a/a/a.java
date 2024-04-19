package b.d.c.a.a;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateModuleEntry.java */
/* loaded from: classes.dex */
public class a implements IModuleEntry {

    /* renamed from: a  reason: collision with root package name */
    private volatile ISystemDelegate f1272a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1273b;

    public a(Context context) {
        this.f1273b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == ISystemDelegate.class) {
            if (this.f1272a == null) {
                synchronized (this) {
                    if (this.f1272a == null) {
                        this.f1272a = new b(this.f1273b);
                    }
                }
            }
            return this.f1272a;
        }
        return null;
    }
}
