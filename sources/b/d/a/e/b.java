package b.d.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CounterImpl.java */
/* loaded from: classes.dex */
public class b implements ICounter, Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final String f1227b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1228c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, AtomicInteger> f1229d;
    private boolean e;
    private AtomicLong f;
    private Handler g;
    private final SharedPreferences h;
    private final SharedPreferences.Editor i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CounterImpl.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f1230b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f1231c;

        a(Map map, long j) {
            this.f1230b = map;
            this.f1231c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.i("CounterImpl", "[" + b.this.f1227b + " counter] send count event, name:" + b.this.f1227b + " values:" + this.f1230b);
            IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
            IMoleEventBuilder event = iDataLog.buildMoleEvent().setPageId("P00012").setButtonId("B001").setEvent(b.this.f1227b);
            for (String str : this.f1230b.keySet()) {
                event.setProperty(str, (Number) this.f1230b.get(str));
            }
            event.setProperty("time", Long.valueOf(this.f1231c));
            IMoleEvent build = event.build();
            LogUtils.d("CounterImpl", "start sendStatData:" + build.toJson());
            iDataLog.sendStatData(build);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f1227b = str;
            this.f1228c = j;
            this.f1229d = new HashMap();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            this.h = defaultSharedPreferences;
            this.i = defaultSharedPreferences.edit();
            this.f = new AtomicLong(defaultSharedPreferences.getLong(c("time"), System.currentTimeMillis()));
            this.g = new Handler(ThreadUtils.getLooper(0), this);
            d();
            e(false);
            return;
        }
        throw new IllegalArgumentException("name can't be empty!");
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f1227b + "_";
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    private String c(String str) {
        return this.f1227b + "_" + str;
    }

    private void d() {
        Map<String, ?> all = this.h.getAll();
        LogUtils.d("CounterImpl", "initValuesFromPref prefMap:" + all);
        for (String str : all.keySet()) {
            String b2 = b(str);
            if (!TextUtils.isEmpty(b2) && !b2.equals("time")) {
                Object obj = all.get(str);
                if (obj instanceof Integer) {
                    LogUtils.d("CounterImpl", "initValuesFromPref key:" + b2 + " value:" + obj);
                    this.f1229d.put(b2, new AtomicInteger(((Integer) obj).intValue()));
                }
            }
        }
    }

    private void e(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f.get();
        long j2 = this.f1228c;
        if (j / j2 < currentTimeMillis / j2 || z) {
            HashMap hashMap = new HashMap();
            for (String str : this.f1229d.keySet()) {
                AtomicInteger atomicInteger = this.f1229d.get(str);
                hashMap.put(str, Integer.valueOf(atomicInteger.get()));
                atomicInteger.set(0);
                this.i.putInt(c(str), 0);
            }
            ThreadUtils.post(2, new a(hashMap, j));
            if (!this.g.hasMessages(1)) {
                this.g.sendEmptyMessageDelayed(1, 10000L);
            }
        }
        this.f.set(currentTimeMillis);
        this.i.putLong(c("time"), currentTimeMillis);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str) {
        return count(str, 1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public void debug(boolean z) {
        this.e = z;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (this.e) {
                LogUtils.d("CounterImpl", "mEditor.apply()");
            }
            this.i.apply();
        }
        return true;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str, int i) {
        int i2;
        int i3;
        AtomicInteger atomicInteger = this.f1229d.get(str);
        String c2 = c(str);
        if (atomicInteger == null) {
            try {
                i2 = this.h.getInt(c2, 0);
            } catch (ClassCastException e) {
                LogUtils.w("CounterImpl", "mPreferences.getInt(" + c2 + ") error!", e);
                i2 = 0;
            }
            if (this.e) {
                LogUtils.v("CounterImpl", "count " + this.f1227b + ", load key:" + c2 + " from pref, value is " + i2);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(i2);
            this.f1229d.put(str, atomicInteger2);
            atomicInteger = atomicInteger2;
        }
        i3 = atomicInteger.get() + i;
        atomicInteger.set(i3);
        this.i.putInt(c2, i3);
        if (this.e) {
            LogUtils.v("CounterImpl", "count " + this.f1227b + " " + str + ":" + i3 + ", cache is:" + this.f1229d);
        }
        if (!this.g.hasMessages(1)) {
            this.g.sendEmptyMessageDelayed(1, 10000L);
        }
        e(i3 == Integer.MAX_VALUE);
        return i3;
    }
}
