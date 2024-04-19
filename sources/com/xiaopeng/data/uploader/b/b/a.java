package com.xiaopeng.data.uploader.b.b;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.data.uploader.model.ObjectKeyModel;
import com.xiaopeng.data.uploader.model.UploadParamModel;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.utils.FileUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.NetUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FileOssClient.java */
/* loaded from: classes.dex */
public class a implements Handler.Callback, Callback {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f1873b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f1874c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f1875d;

    private a() {
        HandlerThread handlerThread = new HandlerThread(OSSConstants.RESOURCE_NAME_OSS, 10);
        handlerThread.start();
        this.f1874c = new Handler(handlerThread.getLooper(), this);
        this.f1875d = new CopyOnWriteArrayList();
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/sdcard/Log/upload-zip/")) {
            try {
                return str.substring(23, str.substring(23).indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 23);
            } catch (Exception e) {
                LogUtils.w("FileOssClient", "generateBucketName fail! path:" + str, e);
                return null;
            }
        }
        LogUtils.w("FileOssClient", "invalid filePath:'" + str + "', return");
        return null;
    }

    public static a b() {
        if (f1873b == null) {
            synchronized (a.class) {
                if (f1873b == null) {
                    f1873b = new a();
                }
            }
        }
        return f1873b;
    }

    private void c() {
        if (this.f1875d.isEmpty()) {
            LogUtils.i("FileOssClient", "internalUpload mUploadFilePaths.isEmpty, return...");
        } else if (!NetUtils.isNetworkAvailable(App.c())) {
            LogUtils.i("FileOssClient", "network not available, clear files and return!");
            this.f1875d.clear();
        } else {
            String remove = this.f1875d.remove(0);
            LogUtils.d("FileOssClient", "internalUpload filePath:" + remove);
            if (!new File(remove).exists()) {
                LogUtils.i("FileOssClient", "file not exists, continue!");
                if (this.f1874c.hasMessages(2)) {
                    this.f1874c.removeMessages(2);
                }
                this.f1874c.sendEmptyMessageDelayed(2, 10000L);
                return;
            }
            String a2 = a(remove);
            String generateObjectKey = ObjectKeyModel.getInstance().generateObjectKey(remove, com.xiaopeng.data.uploader.b.a.BUG_FEEDBACK_OFFLINE);
            String selectParamFromDB = UploadParamModel.INSTANCE.selectParamFromDB(remove);
            Map<String, String> j = j(selectParamFromDB);
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(generateObjectKey)) {
                IRemoteStorage iRemoteStorage = (IRemoteStorage) Module.get(NetworkChannelsEntry.class).get(IRemoteStorage.class);
                try {
                    LogUtils.i("FileOssClient", "start upload with bucket name " + a2 + ", object key " + generateObjectKey + ", file path " + remove + ", param " + selectParamFromDB);
                    iRemoteStorage.initWithCategoryAndContext(App.c());
                    iRemoteStorage.uploadWithPathAndCallback(a2, generateObjectKey, remove, this, j);
                    return;
                } catch (Exception e) {
                    LogUtils.e("FileOssClient", e);
                    g(e, new File(remove));
                    return;
                }
            }
            LogUtils.i("FileOssClient", "bucketName or objectKey can't be empty, delete file and continue!");
            new File(remove).delete();
            if (this.f1874c.hasMessages(2)) {
                this.f1874c.removeMessages(2);
            }
            this.f1874c.sendEmptyMessageDelayed(2, 10000L);
        }
    }

    private void e(File file) {
        if (com.xiaopeng.data.uploader.c.a.a()) {
            return;
        }
        IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("oss_success").setProperty("fileSize", Long.valueOf(file.exists() ? file.length() >> 10 : -1L)).setProperty("fileName", file.getAbsolutePath()).build());
    }

    private boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            boolean z = false;
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (FileUtils.getDirSize(file2) == 0) {
                        FileUtils.deleteFile(file2.getAbsolutePath());
                    }
                    z |= f(file2.getAbsolutePath());
                } else if (file2.getAbsolutePath().endsWith(".zip")) {
                    LogUtils.v("FileOssClient", "### Found zip file:" + file2.getAbsolutePath());
                    this.f1875d.add(file2.getAbsolutePath());
                    z = true;
                }
            }
            return z;
        }
        LogUtils.d("FileOssClient", "scanUploadFiles root is empty, return");
        return false;
    }

    private void g(Exception exc, File file) {
        int i;
        String message;
        if (exc instanceof StorageException) {
            StorageException storageException = (StorageException) exc;
            i = storageException.getReasonCode();
            message = storageException.toString();
        } else {
            i = 600;
            message = exc.getMessage();
        }
        if (com.xiaopeng.data.uploader.c.a.a()) {
            return;
        }
        IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("oss_failed").setProperty("code", Integer.valueOf(i)).setProperty("reason", message).setProperty("fileSize", Long.valueOf(file.exists() ? file.length() >> 10 : -1L)).setProperty("fileName", file.getAbsolutePath()).build());
    }

    private Map<String, String> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, null);
                if (optString != null) {
                    hashMap.put(next, optString);
                }
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void d(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable()) {
            if (!this.f1874c.hasMessages(2) && f("/sdcard/Log/upload-zip/")) {
                LogUtils.i("FileOssClient", "Network recovery and start to upload after 10s...");
                if (this.f1874c.hasMessages(2)) {
                    this.f1874c.removeMessages(2);
                }
                this.f1874c.sendEmptyMessageDelayed(2, 10000L);
            }
        } else if (this.f1874c.hasMessages(2)) {
            this.f1874c.removeMessages(2);
        }
    }

    public void h(List<String> list) {
        i(list, null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 2) {
            c();
        } else if (i == 3) {
            Object[] objArr = (Object[]) message.obj;
            List<String> list = (List) objArr[0];
            String str = (String) objArr[1];
            if (list != null && !list.isEmpty()) {
                for (String str2 : list) {
                    try {
                        File file = new File(str2);
                        if (file.isFile() && file.exists()) {
                            this.f1875d.add(str2);
                            if (!TextUtils.isEmpty(str)) {
                                UploadParamModel.INSTANCE.saveFileParams2DB(str2, str);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!this.f1874c.hasMessages(2)) {
                this.f1874c.sendEmptyMessage(2);
            }
        }
        return true;
    }

    public void i(List<String> list, String str) {
        if (list != null && !list.isEmpty()) {
            Message obtain = Message.obtain(this.f1874c);
            obtain.obj = new Object[]{list, str};
            obtain.what = 3;
            obtain.sendToTarget();
            return;
        }
        LogUtils.e("FileOssClient", "files is empty, return!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
    public void onFailure(String str, String str2, StorageException storageException) {
        LogUtils.d("FileOssClient", "upload fail, type:" + str + " message:" + storageException);
        this.f1875d.clear();
        g(storageException, new File(str2));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
    public void onStart(String str, String str2) {
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
    public void onSuccess(String str, String str2) {
        ObjectKeyModel.getInstance().removeObjectKeyFromDB(str2);
        UploadParamModel.INSTANCE.removeParamFromDB(str2);
        File file = new File(str2);
        e(file);
        LogUtils.d("FileOssClient", "upload success, file:" + file + " remote url " + str);
        FileUtils.deleteFile(file.getAbsolutePath());
        if (this.f1875d.isEmpty()) {
            return;
        }
        if (this.f1874c.hasMessages(2)) {
            this.f1874c.removeMessages(2);
        }
        this.f1874c.sendEmptyMessageDelayed(2, 10000L);
    }
}
