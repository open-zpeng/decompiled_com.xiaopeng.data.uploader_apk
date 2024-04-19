package b.d.a;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
/* compiled from: DataLogModuleEntry.java */
/* loaded from: classes.dex */
public class a implements IModuleEntry {

    /* renamed from: a  reason: collision with root package name */
    private volatile IDataLog f1212a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1213b;

    public a(Context context) {
        this.f1213b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == IDataLog.class) {
            if (this.f1212a == null) {
                synchronized (this) {
                    if (this.f1212a == null) {
                        this.f1212a = new b(this.f1213b);
                    }
                }
            }
            return this.f1212a;
        }
        return null;
    }
}
