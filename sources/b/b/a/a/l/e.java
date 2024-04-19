package b.b.a.a.l;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ReuseJSONObject.java */
/* loaded from: classes.dex */
public class e extends JSONObject implements b {
    @Override // b.b.a.a.l.b
    public void a() {
        Iterator<String> keys = keys();
        if (keys != null) {
            while (keys.hasNext()) {
                try {
                    Object obj = get(keys.next());
                    if (obj != null && (obj instanceof b)) {
                        a.a().d((b) obj);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // b.b.a.a.l.b
    public void b(Object... objArr) {
    }
}
