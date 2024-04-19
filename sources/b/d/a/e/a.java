package b.d.a.e;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
/* compiled from: CounterFactory.java */
/* loaded from: classes.dex */
public class a implements ICounterFactory {

    /* compiled from: CounterFactory.java */
    /* loaded from: classes.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f1226a = new a();
    }

    public static a a() {
        return b.f1226a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createDailyCounter(Context context, String str) {
        return new b.d.a.e.b(context, str, 86400000L);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createHourlyCounter(Context context, String str) {
        return new b.d.a.e.b(context, str, 3600000L);
    }

    private a() {
    }
}
