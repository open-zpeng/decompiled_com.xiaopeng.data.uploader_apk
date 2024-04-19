package b.b.a.b.f;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiResponseParse.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: ApiResponseParse.java */
    /* renamed from: b.b.a.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040a {

        /* renamed from: a  reason: collision with root package name */
        public static C0040a f1045a = new C0040a();

        /* renamed from: b  reason: collision with root package name */
        public boolean f1046b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f1047c = null;

        public boolean a() {
            return "E0102".equalsIgnoreCase(this.f1047c);
        }

        public boolean b() {
            return "E0111".equalsIgnoreCase(this.f1047c) || "E0112".equalsIgnoreCase(this.f1047c);
        }
    }

    public static C0040a a(String str) {
        C0040a c0040a = new C0040a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    c0040a.f1046b = true;
                }
            }
            if (jSONObject.has("ret")) {
                c0040a.f1047c = jSONObject.getString("ret");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c0040a;
    }
}
