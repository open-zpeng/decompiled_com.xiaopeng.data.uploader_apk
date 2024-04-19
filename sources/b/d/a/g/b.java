package b.d.a.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import b.d.b.c.a;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.datalog.bean.LogEvent;
import com.xiaopeng.lib.utils.DateUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.ZipUtils;
import com.xiaopeng.lib.utils.crypt.AESUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: DataCollectorHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f1244a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1245b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f1246c;

    /* renamed from: d  reason: collision with root package name */
    private b.d.b.c.a f1247d;
    private Context e;
    private final List<String> f = new CopyOnWriteArrayList();
    private final List<Map<String, Object>> g = new CopyOnWriteArrayList();
    private Gson h = new Gson();
    private Handler i = new Handler(ThreadUtils.getLooper(0), new a());
    private ServiceConnection j = new ServiceConnectionC0055b();

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                LogUtils.v("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CAN");
                b.this.k();
            } else if (i == 2) {
                LogUtils.d("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CDU");
                b.this.l();
            } else if (i == 3) {
                LogUtils.d("DataCollectorHelper", "handleMessage MESSAGE_CHECK_CONNECTION");
                if (b.this.f1247d == null) {
                    b.this.g();
                }
            }
            return true;
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* renamed from: b.d.a.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ServiceConnectionC0055b implements ServiceConnection {

        /* compiled from: DataCollectorHelper.java */
        /* renamed from: b.d.a.g.b$b$a */
        /* loaded from: classes.dex */
        class a implements IBinder.DeathRecipient {
            a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                if (b.this.f1247d == null) {
                    return;
                }
                b.this.f1247d.asBinder().unlinkToDeath(this, 0);
                b.this.f1247d = null;
                b.this.g();
            }
        }

        ServiceConnectionC0055b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtils.d("DataCollectorHelper", "onServiceConnected");
            b.this.f1247d = a.AbstractBinderC0056a.j0(iBinder);
            a aVar = new a();
            try {
                if (b.this.f1247d == null) {
                    return;
                }
                b.this.f1247d.asBinder().linkToDeath(aVar, 0);
            } catch (RemoteException e) {
                LogUtils.w("DataCollectorHelper", "RemoteException occurs when reLink to Service, exception:", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.d("DataCollectorHelper", "onServiceDisconnected");
            b.this.f1247d = null;
            b.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    public class c extends TypeToken<Map<String, Object>> {
        c() {
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class d extends TypeToken<Map<String, Object>> {
        d() {
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f1253b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f1254c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b.d.a.d f1255d;

        e(String[] strArr, List list, b.d.a.d dVar) {
            this.f1253b = strArr;
            this.f1254c = list;
            this.f1255d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.B(this.f1253b[1], this.f1254c);
            this.f1255d.put("address", this.f1253b[0]);
            String json = this.f1255d.toJson();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1253b[1].replace(".zip", "_en.zip"));
            b.this.u(json);
            b.this.x(arrayList);
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1256b;

        /* compiled from: DataCollectorHelper.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                b.this.r(fVar.f1256b);
            }
        }

        f(String str) {
            this.f1256b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.s()) {
                b.this.r(this.f1256b);
            } else {
                ThreadUtils.postBackground(new a(), 1000L);
            }
        }
    }

    static {
        String str = BuildInfoUtils.isLanVersion() ? "xp-log-local" : "xp-log";
        f1245b = str;
        f1246c = "http://" + str + ".oss-cn-hangzhou.aliyuncs.com/";
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, List<String> list) {
        File file;
        try {
            file = ZipUtils.zipMultiFiles(str, list);
        } catch (IOException e2) {
            e2.printStackTrace();
            file = null;
        }
        j(file, AESUtils.encrypt(file, new File(str.replace(".zip", "_en.zip")), "@!chxpzi#0109$+/"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Intent intent = new Intent("com.xiaopeng.service.DATA_SERVICE");
        intent.setPackage("com.xiaopeng.data.uploader");
        this.e.startServiceAsUser(intent, UserHandle.CURRENT);
        this.e.bindServiceAsUser(intent, this.j, 1, UserHandle.CURRENT);
        if (this.i.hasMessages(3)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(3, 10000L);
    }

    private String h() {
        LogEvent create = LogEvent.create(LogEvent.a.CAN);
        try {
            create.setV(Integer.valueOf(SystemPropertyUtil.getDBCVersion()).intValue());
        } catch (Exception e2) {
            LogUtils.w("DataCollectorHelper", "parse dbcVersion error!", e2);
            create.setV(0);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data", this.h.toJson(this.f));
        this.f.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(jsonObject);
        create.setMsg(arrayList);
        String json = this.h.toJson(create);
        arrayList.clear();
        return json;
    }

    private String i() {
        LogEvent create = LogEvent.create(LogEvent.a.CDU);
        try {
            create.setV(Integer.valueOf(SystemPropertyUtil.getDBCVersion()).intValue());
        } catch (Exception e2) {
            LogUtils.w("DataCollectorHelper", "parse dbcVersion error!", e2);
            create.setV(0);
        }
        ArrayList arrayList = new ArrayList(this.g);
        this.g.clear();
        create.setMsg(arrayList);
        return this.h.toJson(create);
    }

    private void j(File file, boolean z) {
        if (z) {
            try {
                file.delete();
                System.gc();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f.isEmpty()) {
            LogUtils.d("DataCollectorHelper", "mCanDataCache.isEmpty(), return!");
            return;
        }
        b.d.a.f.a.h().n("candata", ZipUtils.compressForGzipAndBase64NoWrap(h()), this.e);
        this.i.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.g.isEmpty()) {
            LogUtils.d("DataCollectorHelper", "mCduDataCache.isEmpty(), return!");
        }
        b.d.a.f.a.h().n("cdudata", ZipUtils.compressForGzipAndBase64NoWrap(i()), this.e);
        this.i.removeMessages(2);
    }

    private String m(long j, String str) {
        String str2 = "/sdcard/Log/upload-zip/" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + j + ".zip";
    }

    private String n(long j, String str) {
        return f1246c + (str.substring(str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + j + "_en.zip");
    }

    private String[] o() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = f1245b + "/log/" + BuildInfoUtils.getSystemVersion() + MqttTopic.TOPIC_LEVEL_SEPARATOR + DateUtils.formatDate7(currentTimeMillis) + MqttTopic.TOPIC_LEVEL_SEPARATOR + SystemPropertyUtil.getVehicleId();
        return new String[]{n(currentTimeMillis, str), m(currentTimeMillis, str)};
    }

    public static b p() {
        if (f1244a == null) {
            synchronized (b.class) {
                if (f1244a == null) {
                    f1244a = new b();
                }
            }
        }
        return f1244a;
    }

    private void v(Map<String, Object> map) {
        this.g.add(map);
        if (this.g.size() >= 20) {
            l();
        } else if (this.i.hasMessages(2)) {
        } else {
            this.i.sendEmptyMessageDelayed(2, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A() {
        String str = o()[0];
        ThreadUtils.postBackground(new f(str));
        return str;
    }

    public void q(Context context) {
        this.e = context;
        g();
    }

    void r(String str) {
        b.d.b.c.a aVar = this.f1247d;
        if (aVar != null) {
            try {
                aVar.a0(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f1247d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(java.lang.String r5) {
        /*
            r4 = this;
            b.d.b.c.a r0 = r4.f1247d
            r1 = 1
            if (r0 == 0) goto L19
            r0.o(r5)     // Catch: android.os.RemoteException -> L15
            java.util.List<java.lang.String> r0 = r4.f     // Catch: android.os.RemoteException -> L15
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L15
            if (r0 <= 0) goto L13
            r4.k()     // Catch: android.os.RemoteException -> L15
        L13:
            r0 = r1
            goto L1a
        L15:
            r0 = move-exception
            r0.printStackTrace()
        L19:
            r0 = 0
        L1a:
            if (r0 != 0) goto L3f
            java.util.List<java.lang.String> r0 = r4.f
            r0.add(r5)
            java.util.List<java.lang.String> r5 = r4.f
            int r5 = r5.size()
            r0 = 20
            if (r5 < r0) goto L2f
            r4.k()
            goto L3f
        L2f:
            android.os.Handler r5 = r4.i
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto L3f
            android.os.Handler r5 = r4.i
            r2 = 60000(0xea60, double:2.9644E-319)
            r5.sendEmptyMessageDelayed(r1, r2)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.t(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(java.lang.String r4) {
        /*
            r3 = this;
            b.d.b.c.a r0 = r3.f1247d
            if (r0 == 0) goto L1c
            r0.z(r4)     // Catch: android.os.RemoteException -> L14
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r3.g     // Catch: android.os.RemoteException -> L14
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L14
            if (r0 <= 0) goto L12
            r3.l()     // Catch: android.os.RemoteException -> L14
        L12:
            r0 = 1
            goto L1d
        L14:
            r0 = move-exception
            java.lang.String r1 = "DataCollectorHelper"
            java.lang.String r2 = "uploadCdu error!"
            com.xiaopeng.lib.utils.LogUtils.w(r1, r2, r0)
        L1c:
            r0 = 0
        L1d:
            if (r0 != 0) goto L33
            com.google.gson.Gson r0 = r3.h
            b.d.a.g.b$c r1 = new b.d.a.g.b$c
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r4 = r0.fromJson(r4, r1)
            java.util.Map r4 = (java.util.Map) r4
            r3.v(r4)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.u(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(b.d.a.d dVar, List<String> list) {
        ThreadUtils.postBackground(new e(o(), list, dVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(List<String> list) {
        b.d.b.c.a aVar = this.f1247d;
        if (aVar != null) {
            try {
                aVar.Y(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            b.d.b.c.a r0 = r2.f1247d
            java.lang.String r1 = "DataCollectorHelper"
            if (r0 == 0) goto L11
            r0.r(r3, r4)     // Catch: android.os.RemoteException -> Lb
            r3 = 1
            goto L12
        Lb:
            r3 = move-exception
            java.lang.String r4 = "uploadLogImmediately error!"
            com.xiaopeng.lib.utils.LogUtils.w(r1, r4, r3)
        L11:
            r3 = 0
        L12:
            if (r3 != 0) goto L19
            java.lang.String r3 = "uploadLogImmediately fail and ignore!"
            com.xiaopeng.lib.utils.LogUtils.w(r1, r3)
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.y(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            b.d.b.c.a r0 = r2.f1247d
            if (r0 == 0) goto L18
            r0.l(r3, r4)     // Catch: android.os.RemoteException -> L14
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r2.g     // Catch: android.os.RemoteException -> L14
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L14
            if (r0 <= 0) goto L12
            r2.l()     // Catch: android.os.RemoteException -> L14
        L12:
            r0 = 1
            goto L19
        L14:
            r0 = move-exception
            r0.printStackTrace()
        L18:
            r0 = 0
        L19:
            if (r0 != 0) goto L53
            java.lang.Class<b.d.a.a> r0 = b.d.a.a.class
            com.xiaopeng.lib.framework.module.IModuleEntry r0 = com.xiaopeng.lib.framework.module.Module.get(r0)
            java.lang.Class<com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog> r1 = com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog.class
            java.lang.Object r0 = r0.get(r1)
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog r0 = (com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog) r0
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r0 = r0.buildStat()
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r3 = r0.setEventName(r3)
            java.lang.String r0 = "data"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r3 = r3.setProperty(r0, r4)
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent r3 = r3.build()
            java.lang.String r3 = r3.toJson()
            com.google.gson.Gson r4 = r2.h
            b.d.a.g.b$d r0 = new b.d.a.g.b$d
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.Object r3 = r4.fromJson(r3, r0)
            java.util.Map r3 = (java.util.Map) r3
            r2.v(r3)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.z(java.lang.String, java.lang.String):void");
    }
}
