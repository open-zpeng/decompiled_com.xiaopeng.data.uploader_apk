package b.b.a.b.f;

import java.util.Map;
import org.eclipse.paho.android.service.MqttServiceConstants;
/* compiled from: UTAdapter.java */
/* loaded from: classes.dex */
public class t {
    public static void a(Map<String, String> map) {
        Object b2;
        try {
            Object d2 = o.d("com.ut.mini.UTAnalytics", "getInstance");
            if (d2 == null || (b2 = o.b(d2, "getDefaultTracker")) == null) {
                return;
            }
            o.c(b2, MqttServiceConstants.SEND_ACTION, new Object[]{map}, Map.class);
        } catch (Exception unused) {
        }
    }
}
