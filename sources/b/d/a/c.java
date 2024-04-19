package b.d.a;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MoleEvent.java */
/* loaded from: classes.dex */
public class c implements IMoleEvent {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f1219a;

    /* compiled from: MoleEvent.java */
    /* loaded from: classes.dex */
    class a extends TypeToken<Map<String, Object>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f1219a = concurrentHashMap;
        concurrentHashMap.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.f1219a.put(IStatEvent.CUSTOM_MODULE_VERSION, d.d(context));
        this.f1219a.put(IStatEvent.CUSTOM_NETWORK, d.c(context));
        this.f1219a.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.f1219a.put(IStatEvent.CUSTOM_DEVICE_MCUVER, d.a());
        this.f1219a.put(IStatEvent.CUSTOM_UID, Long.valueOf(SystemPropertyUtil.getAccountUid()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f1219a.containsKey("page_id")) {
            if (this.f1219a.containsKey("button_id")) {
                if (!this.f1219a.containsKey(IStatEvent.CUSTOM_MODULE)) {
                    throw new IllegalArgumentException("Please call setModule() first");
                }
                return;
            }
            throw new IllegalArgumentException("Please call setButtonId() first");
        }
        throw new IllegalArgumentException("Please call setPageId() first");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.f1219a.put(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.f1219a.put(str, ch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.f1219a.put(str, number);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f1219a.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent
    public String toJson() {
        return b.d.a.f.b.b().a().toJson(this.f1219a, new a().getType());
    }
}
