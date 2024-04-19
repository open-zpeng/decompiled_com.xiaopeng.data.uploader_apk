package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.i;
/* loaded from: classes.dex */
public class UTDevice {
    public static String getUtdid(Context context) {
        a b2 = b.b(context);
        return (b2 == null || i.m58a(b2.f())) ? "ffffffffffffffffffffffff" : b2.f();
    }

    public static String getUtdidForUpdate(Context context) {
        String h = c.a(context).h();
        return (h == null || i.m58a(h)) ? "ffffffffffffffffffffffff" : h;
    }
}
