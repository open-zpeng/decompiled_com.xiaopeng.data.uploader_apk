package com.ta.utdid2.a;

import android.content.Context;
import android.util.Log;
import com.ta.utdid2.b.a.f;
import com.ta.utdid2.b.a.i;
import com.ta.utdid2.b.a.j;
import com.xiaopeng.lib.framework.moduleinterface.appresourcemodule.IAppResourceException;
/* compiled from: AidManager.java */
/* loaded from: classes.dex */
public class a {
    private static final String TAG = "com.ta.utdid2.a.a";

    /* renamed from: a  reason: collision with root package name */
    private static a f1798a;
    private Context mContext;

    private a(Context context) {
        this.mContext = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f1798a == null) {
                f1798a = new a(context);
            }
            aVar = f1798a;
        }
        return aVar;
    }

    private synchronized String b(String str, String str2, String str3) {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "no context!");
            return "";
        }
        String a2 = f.m57a(context) ? b.a(this.mContext).a(str, str2, str3, c.m55a(this.mContext, str, str2)) : "";
        c.a(this.mContext, str, a2, str2);
        return a2;
    }

    public void a(String str, String str2, String str3, com.ut.device.a aVar) {
        if (aVar == null) {
            Log.e(TAG, "callback is null!");
        } else if (this.mContext != null && !i.m58a(str) && !i.m58a(str2)) {
            String m55a = c.m55a(this.mContext, str, str2);
            if (!i.m58a(m55a) && j.a(c.a(this.mContext, str, str2), 1)) {
                aVar.a(1001, m55a);
            } else if (f.m57a(this.mContext)) {
                b.a(this.mContext).a(str, str2, str3, m55a, aVar);
            } else {
                aVar.a(IAppResourceException.REASON_PARAM_ERROR, m55a);
            }
        } else {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("mContext:");
            sb.append(this.mContext);
            sb.append("; callback:");
            sb.append(aVar);
            sb.append("; has appName:");
            sb.append(!i.m58a(str));
            sb.append("; has token:");
            sb.append(!i.m58a(str2));
            Log.e(str4, sb.toString());
            aVar.a(1002, "");
        }
    }

    public String a(String str, String str2, String str3) {
        if (this.mContext != null && !i.m58a(str) && !i.m58a(str2)) {
            String m55a = c.m55a(this.mContext, str, str2);
            return ((i.m58a(m55a) || !j.a(c.a(this.mContext, str, str2), 1)) && f.m57a(this.mContext)) ? b(str, str2, str3) : m55a;
        }
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("mContext:");
        sb.append(this.mContext);
        sb.append("; has appName:");
        sb.append(!i.m58a(str));
        sb.append("; has token:");
        sb.append(!i.m58a(str2));
        Log.e(str4, sb.toString());
        return "";
    }
}
