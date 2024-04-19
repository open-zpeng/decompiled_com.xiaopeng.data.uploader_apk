package com.xiaopeng.data.uploader.b.c;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.data.uploader.model.ObjectKeyModel;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.utils.FileUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.ZipUtils;
import com.xiaopeng.lib.utils.config.EnvConfig;
import com.xiaopeng.lib.utils.crypt.AESUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: OfflineFileClient.java */
/* loaded from: classes.dex */
public class a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f1876b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f1877c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f1878d;
    private ICounter e;
    private Boolean f;
    boolean g;
    private AtomicInteger h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineFileClient.java */
    /* renamed from: com.xiaopeng.data.uploader.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0082a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1879a;

        C0082a(String str) {
            this.f1879a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1879a) && str.endsWith(".log");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineFileClient.java */
    /* loaded from: classes.dex */
    public class b implements Callback {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1881b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1882c;

        b(String str, String str2) {
            this.f1881b = str;
            this.f1882c = str2;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onFailure(String str, String str2, StorageException storageException) {
            a.this.f(this.f1881b, storageException);
            LogUtils.e("OfflineFileClient", "error :" + storageException.getMessage());
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onStart(String str, String str2) {
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onSuccess(String str, String str2) {
            a.this.g(this.f1881b);
            if (BuildInfoUtils.isEngVersion()) {
                LogUtils.d("OfflineFileClient", "callbackbody--->" + this.f1882c);
            }
        }
    }

    private a() {
        boolean a2 = com.xiaopeng.data.uploader.c.a.a();
        this.g = a2;
        if (!a2) {
            ICounter createHourlyCounter = ((IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class)).counterFactory().createHourlyCounter(App.c(), "data_oss_success_rate");
            this.e = createHourlyCounter;
            createHourlyCounter.debug(true);
        }
        this.f1877c = new CopyOnWriteArrayList();
        HandlerThread handlerThread = new HandlerThread("OfflineFileClient", 10);
        handlerThread.start();
        this.f1878d = new Handler(handlerThread.getLooper(), this);
        this.h = new AtomicInteger(-1);
        if (NetUtils.isNetworkAvailable(App.c())) {
            q("candata", false);
            q("cdudata", false);
        }
    }

    private void c(int i) {
        if (this.f1878d.hasMessages(2)) {
            return;
        }
        this.f1878d.sendEmptyMessageDelayed(2, i);
    }

    private boolean d() {
        boolean z;
        Boolean bool = this.f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!BuildInfoUtils.isEngVersion()) {
            LogUtils.d("OfflineFileClient", "!BuildInfoUtils.isEngVersion(), mDisableOfflineFile = false;");
            Boolean bool2 = Boolean.FALSE;
            this.f = bool2;
            return bool2.booleanValue();
        }
        boolean isLanVersion = BuildInfoUtils.isLanVersion();
        boolean hasValidConfig = EnvConfig.hasValidConfig();
        if (!isLanVersion && !hasValidConfig) {
            LogUtils.d("OfflineFileClient", "!isLanVersion && !isPreVersion, mDisableOfflineFile = false;");
            Boolean bool3 = Boolean.FALSE;
            this.f = bool3;
            return bool3.booleanValue();
        }
        try {
            z = new File("/sdcard/ENABLE_OFFLINE.xp").exists();
        } catch (Exception e) {
            LogUtils.w("OfflineFileClient", "DEBUG_OFFLINE_FILE_PATH.exists() error!", e);
            z = false;
        }
        this.f = Boolean.valueOf(!z);
        StringBuilder sb = new StringBuilder();
        sb.append("mDisableOfflineFile = !isDebugFileExists = ");
        sb.append(!z);
        LogUtils.d("OfflineFileClient", sb.toString());
        return this.f.booleanValue();
    }

    public static a e() {
        if (f1876b == null) {
            synchronized (a.class) {
                if (f1876b == null) {
                    f1876b = new a();
                }
            }
        }
        return f1876b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006b A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:8:0x0015, B:10:0x0067, B:12:0x006b, B:9:0x003e), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void f(java.lang.String r4, java.lang.Exception r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicInteger r4 = r3.h     // Catch: java.lang.Throwable -> L74
            int r4 = r4.incrementAndGet()     // Catch: java.lang.Throwable -> L74
            r5 = 5
            if (r4 >= r5) goto L3e
            com.xiaopeng.data.uploader.App r5 = com.xiaopeng.data.uploader.App.c()     // Catch: java.lang.Throwable -> L74
            boolean r5 = com.xiaopeng.lib.utils.NetUtils.isNetworkAvailable(r5)     // Catch: java.lang.Throwable -> L74
            if (r5 != 0) goto L15
            goto L3e
        L15:
            int r5 = r4 * 20000
            r3.c(r5)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "OfflineFileClient"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = "upload history DataFile failed "
            r1.append(r2)     // Catch: java.lang.Throwable -> L74
            r1.append(r4)     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = " times; and retry to upload file after "
            r1.append(r4)     // Catch: java.lang.Throwable -> L74
            r1.append(r5)     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = "ms"
            r1.append(r4)     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L74
            com.xiaopeng.lib.utils.LogUtils.d(r0, r4)     // Catch: java.lang.Throwable -> L74
            goto L67
        L3e:
            java.lang.String r5 = "OfflineFileClient"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r0.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "cancel the upload history DataFile task! failedCount-->"
            r0.append(r1)     // Catch: java.lang.Throwable -> L74
            r0.append(r4)     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = ";netWork-->"
            r0.append(r4)     // Catch: java.lang.Throwable -> L74
            com.xiaopeng.data.uploader.App r4 = com.xiaopeng.data.uploader.App.c()     // Catch: java.lang.Throwable -> L74
            boolean r4 = com.xiaopeng.lib.utils.NetUtils.isNetworkAvailable(r4)     // Catch: java.lang.Throwable -> L74
            r0.append(r4)     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L74
            com.xiaopeng.lib.utils.LogUtils.d(r5, r4)     // Catch: java.lang.Throwable -> L74
            r3.s()     // Catch: java.lang.Throwable -> L74
        L67:
            boolean r4 = r3.g     // Catch: java.lang.Throwable -> L74
            if (r4 != 0) goto L72
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter r4 = r3.e     // Catch: java.lang.Throwable -> L74
            java.lang.String r5 = "fail"
            r4.count(r5)     // Catch: java.lang.Throwable -> L74
        L72:
            monitor-exit(r3)
            return
        L74:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.data.uploader.b.c.a.f(java.lang.String, java.lang.Exception):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (!this.g) {
            this.e.count("success");
        }
        LogUtils.d("OfflineFileClient", "upload " + str + " successful");
        p(str);
        ObjectKeyModel.getInstance().removeObjectKeyFromDB(str);
        if (this.f1877c.isEmpty()) {
            return;
        }
        c(0);
    }

    private void h(String str, boolean z) {
        LogUtils.d("OfflineFileClient", "internalScan, tag:" + str + " needUploadFirstFile:" + z);
        StringBuilder sb = new StringBuilder();
        sb.append("/sdcard/Log/");
        sb.append(str);
        String sb2 = sb.toString();
        File[] listFiles = new File(sb2).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".zip")) {
                        m(file);
                    } else {
                        o(str, sb2, file);
                    }
                } else if (file.isDirectory()) {
                    n(str, z, sb2, file);
                }
            }
            return;
        }
        LogUtils.d("OfflineFileClient", "tagFiles is empty, return!");
    }

    private void i() {
        if (this.f1877c.isEmpty()) {
            LogUtils.i("OfflineFileClient", "internalUpload mUploadPaths.isEmpty(). Break!");
            return;
        }
        if (!NetUtils.isNetworkAvailable(App.c())) {
            LogUtils.i("OfflineFileClient", "internalUpload network not available. Break!");
        }
        if (v()) {
            LogUtils.i("OfflineFileClient", "continue uploading...");
            this.f1878d.sendEmptyMessage(2);
        }
    }

    private String j(String str, String str2, List<String> list) throws IOException {
        String str3 = str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2 + "-" + SystemPropertyUtil.getHardwareId() + "-" + System.currentTimeMillis() + ".zip";
        File file = new File(str3);
        if (file.exists()) {
            file.delete();
        }
        ZipUtils.zipMultiFilesWithThrow(str3, list);
        String replace = str3.replace(".zip", "_en.zip");
        if (!AESUtils.encrypt(file, new File(replace), "@!chxpzi#0109$+/")) {
            LogUtils.w("OfflineFileClient", "encrypt " + str3 + "failed");
            FileUtils.deleteFile(replace);
            file.delete();
            return null;
        }
        for (String str4 : list) {
            FileUtils.deleteFile(str4);
        }
        FileUtils.deleteFile(str3);
        return replace;
    }

    private void m(File file) {
        if (System.currentTimeMillis() - file.lastModified() > 604800000) {
            LogUtils.d("OfflineFileClient", "Expired! File: " + file.getAbsolutePath());
            FileUtils.deleteFile(file.getAbsolutePath());
            ObjectKeyModel.getInstance().removeObjectKeyFromDB(file.getAbsolutePath());
            return;
        }
        r(file.getAbsolutePath());
    }

    private void n(String str, boolean z, String str2, File file) {
        String j;
        File[] listFiles = file.listFiles(new C0082a(str));
        if (listFiles != null && listFiles.length != 0) {
            int i = !z ? 1 : 0;
            if (listFiles.length <= i) {
                LogUtils.d("OfflineFileClient", "subFiles.length <= " + i + ", return!");
                return;
            }
            Arrays.sort(listFiles);
            for (File file2 : Arrays.asList(listFiles).subList(i, listFiles.length)) {
                try {
                    j = j(str2, str, Collections.singletonList(file2.getAbsolutePath()));
                } catch (IOException e) {
                    LogUtils.w("OfflineFileClient", "internalZip error, path:" + file2.getAbsolutePath(), e);
                }
                if (j == null) {
                    return;
                }
                r(j);
            }
            return;
        }
        LogUtils.d("OfflineFileClient", file.getAbsolutePath() + " is empty, return!");
        file.delete();
    }

    private void o(String str, String str2, File file) {
        if (file.getName().endsWith(".log")) {
            try {
                r(j(str2, str, Collections.singletonList(file.getAbsolutePath())));
                return;
            } catch (IOException e) {
                LogUtils.w("OfflineFileClient", "zip logs error, path:" + file.getAbsolutePath(), e);
                return;
            }
        }
        FileUtils.deleteFile(file.getAbsolutePath());
    }

    private void p(String str) {
        this.f1877c.remove(str);
        if (this.f1877c.isEmpty()) {
            LogUtils.d("OfflineFileClient", "upload file complete, return!");
            this.h.set(-1);
        }
        FileUtils.deleteFile(str);
    }

    private void q(String str, boolean z) {
        this.f1878d.sendMessage(Message.obtain(this.f1878d, 1, !z ? 1 : 0, 0, str));
    }

    private void r(String str) {
        if (str != null && !this.f1877c.contains(str)) {
            this.f1877c.add(str);
            if (1 == this.f1877c.size()) {
                LogUtils.d("OfflineFileClient", "Start to upload files...");
                this.f1878d.sendEmptyMessage(2);
                this.h.set(0);
                return;
            }
            return;
        }
        LogUtils.d("OfflineFileClient", "already in the uploadingList:" + str);
    }

    private void s() {
        this.f1877c.clear();
        this.h.set(-1);
        if (this.f1878d.hasMessages(2)) {
            this.f1878d.removeMessages(2);
        }
    }

    private synchronized void u(String str, int i) {
        Log.i("OfflineFileClient", "upload2RemoteStorageInternal:\t" + str + "\t" + i);
        String str2 = com.xiaopeng.data.uploader.a.f1868a;
        String str3 = com.xiaopeng.data.uploader.a.e;
        try {
            if (this.g) {
                str2 = "fra-xp-log";
                str3 = "http://fra-xp-log.oss-eu-central-1.aliyuncs.com/";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str4 = str2;
        if (!this.g) {
            this.e.count("total");
        }
        LogUtils.d("OfflineFileClient", "start to upload file:" + str);
        IRemoteStorage iRemoteStorage = (IRemoteStorage) Module.get(NetworkChannelsEntry.class).get(IRemoteStorage.class);
        try {
            iRemoteStorage.initWithContext(App.c());
            String generateObjectKey = ObjectKeyModel.getInstance().generateObjectKey(str, com.xiaopeng.data.uploader.b.a.CAN_CDU_OFFLINE);
            if (TextUtils.isEmpty(generateObjectKey)) {
                f(str, new IllegalArgumentException("Empty Object Key"));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("callbackUrl", this.g ? "https://fra-bd-callback.xiaopeng.com/oss/xmartData/xmartOssFile" : "https://bd-callback.xiaopeng.com/oss/xmartData/xmartOssFile");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("file", str3 + generateObjectKey);
            Log.i("OfflineFileClient", "bucketEndPoint = " + str3);
            hashMap2.put("type", String.valueOf(i));
            hashMap2.put("v", String.valueOf(2));
            long currentTimeMillis = System.currentTimeMillis();
            hashMap2.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap2.put("app_id", "xmart:appid:002");
            hashMap2.put("sign", Security.sign(App.c(), hashMap2, currentTimeMillis));
            String json = new Gson().toJson(hashMap2);
            hashMap.put("callbackBody", json);
            hashMap.put("callbackBodyType", BizConstants.CONTENT_TYPE_JSON);
            try {
                LogUtils.i("OfflineFileClient", "start upload with bucket name " + str4 + ", object key " + generateObjectKey + ", file path " + str);
                iRemoteStorage.uploadWithPathAndCallback(str4, generateObjectKey, str, new b(str, json), hashMap);
            } catch (Exception e2) {
                f(str, e2);
            }
        } catch (Exception e3) {
            LogUtils.e("OfflineFileClient", "Failed to initialize the remote storage:" + e3);
            f(str, e3);
        }
    }

    private boolean v() {
        int i;
        if (this.f1877c.isEmpty()) {
            return false;
        }
        String str = this.f1877c.get(0);
        if (str.contains("candata")) {
            i = 1;
        } else if (!str.contains("cdudata")) {
            p(str);
            return true;
        } else {
            i = 2;
        }
        File file = new File(str);
        if (!d() && file.exists() && file.length() != 0) {
            u(str, i);
            return false;
        }
        LogUtils.d("OfflineFileClient", "No need to do real uploading, due to disableOfflineFile:" + d());
        LogUtils.d("OfflineFileClient", " or file " + str + " is already uploaded or empty. Continue");
        p(str);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        LogUtils.i("OfflineFileClient", "handleMessage what:" + message.what);
        int i = message.what;
        if (i == 1) {
            h((String) message.obj, message.arg1 == 0);
        } else if (i == 2) {
            i();
        } else {
            throw new IllegalArgumentException("invalid msg what:" + message.what);
        }
        return true;
    }

    public void k() {
        LogUtils.d("OfflineFileClient", "onMqttRecovery, start upload can history file...");
        q("candata", true);
        q("cdudata", true);
    }

    public void l(NetworkInfo networkInfo) {
        if (!(networkInfo != null && networkInfo.isAvailable())) {
            LogUtils.i("OfflineFileClient", "Network not available, clear uploadPaths and remove upload task!");
            s();
            return;
        }
        LogUtils.d("OfflineFileClient", "Network available, start upload all history file");
        q("candata", false);
        q("cdudata", false);
    }

    public void t(String str, String str2) {
        if (d()) {
            LogUtils.i("OfflineFileClient", "disableOfflineFile, updateFile return!");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            LogUtils.d("OfflineFileClient", "updateFile tag:" + str + " data.length:" + str2.length());
            b.d.a.f.a.h().n(str, str2, App.c());
        } else {
            LogUtils.w("OfflineFileClient", "tag or data can't be empty!");
        }
    }
}
