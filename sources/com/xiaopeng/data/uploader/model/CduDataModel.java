package com.xiaopeng.data.uploader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.data.uploader.b.d.a;
import com.xiaopeng.datalog.bean.LogEvent;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.ZipUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CduDataModel {
    private static final String ACTION_UPLOAD_FILE = "com.xiaopeng.broadcast.ACTION_UPLOAD_FILE";
    private static final int MAX_NUM_PER_ZIP_CDU_DATA_LOCAL = 20;
    private static final int MAX_NUM_PER_ZIP_CDU_DATA_REAL_TIME = 5;
    private static final String TAG = "CduDataModel";
    private ICounter mCounter;
    private List<Map<String, Object>> mDataCache;
    private Gson mGson;
    private boolean mIsInternational;

    /* loaded from: classes.dex */
    private static final class Holder {
        private static final CduDataModel INSTANCE = new CduDataModel();

        private Holder() {
        }
    }

    private String buildCduDataZipJson() {
        LogEvent create = LogEvent.create(LogEvent.a.CDU);
        if (!this.mIsInternational) {
            create.setPackageId(this.mCounter.count("package_id"));
        }
        create.setMsg(new ArrayList(this.mDataCache));
        String json = this.mGson.toJson(create);
        this.mDataCache.clear();
        return json;
    }

    public static CduDataModel getInstance() {
        return Holder.INSTANCE;
    }

    private synchronized void uploadCduLogInternal(String str) {
        Map<String, Object> map = (Map) this.mGson.fromJson(str, new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.data.uploader.model.CduDataModel.2
        }.getType());
        if (!this.mIsInternational) {
            map.put("_seq", Integer.valueOf(this.mCounter.count("count")));
        }
        this.mDataCache.add(map);
        if (this.mDataCache.size() >= 5) {
            boolean isNetworkAvailable = NetUtils.isNetworkAvailable(App.c());
            boolean g = a.d().g();
            if (isNetworkAvailable && g) {
                String buildCduDataZipJson = buildCduDataZipJson();
                byte[] compressForUpload = ZipUtils.compressForUpload(buildCduDataZipJson);
                if (compressForUpload == null) {
                    return;
                }
                a.d().h("Xmart/Log/StatPack", compressForUpload);
                LogUtils.d(TAG, "Upload cdu by mqtt, data.length:" + buildCduDataZipJson.length());
            } else if (this.mDataCache.size() >= 20) {
                com.xiaopeng.data.uploader.b.c.a.e().t("cdudata", ZipUtils.compressForGzipAndBase64NoWrap(buildCduDataZipJson()));
                LogUtils.d(TAG, "Save cdu data local reached MAX_NUM_PER_ZIP_CDU_DATA_LOCAL!");
            }
        }
    }

    public void uploadCduLog(IStatEvent iStatEvent) {
        uploadCduLogInternal(iStatEvent.toJson());
    }

    public void uploadCduLogOrigin(String str, String str2) {
        LogUtils.d(TAG, "uploadCduLogOrigin eventName:" + str);
        uploadCduLogInternal(((IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class)).buildStat().setEventName(str).setProperty("data", str2).build().toJson());
    }

    public void uploadLogImmediately(final String str, String str2) {
        LogUtils.d(TAG, "uploadLogImmediately eventName:" + str);
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("app_id", "xmart:appid:002");
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("event", str);
        hashMap.put("params", str2);
        hashMap.put("sign", Security.sign(App.c(), hashMap, currentTimeMillis));
        ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper().post(com.xiaopeng.data.uploader.a.f1871d, this.mGson.toJson(hashMap)).build().execute(new Callback() { // from class: com.xiaopeng.data.uploader.model.CduDataModel.3
            @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
            public void onFailure(IResponse iResponse) {
                LogUtils.i(CduDataModel.TAG, "uploadLogImmediately response error:" + iResponse.body() + " eventName:" + str);
            }

            @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
            public void onSuccess(IResponse iResponse) {
                LogUtils.w(CduDataModel.TAG, "uploadLogImmediately response success:" + iResponse.body() + " code:" + iResponse.code() + " exception:" + iResponse.getException());
            }
        });
    }

    private CduDataModel() {
        this.mGson = new Gson();
        this.mDataCache = new ArrayList();
        boolean a2 = com.xiaopeng.data.uploader.c.a.a();
        this.mIsInternational = a2;
        if (!a2) {
            ICounter createHourlyCounter = ((IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class)).counterFactory().createHourlyCounter(App.c(), "data_count_cdu");
            this.mCounter = createHourlyCounter;
            createHourlyCounter.debug(false);
        }
        if (BuildInfoUtils.isEngVersion()) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.data.uploader.model.CduDataModel.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    LogUtils.d(CduDataModel.TAG, "onReceive action:" + action);
                    if (TextUtils.isEmpty(action)) {
                        return;
                    }
                    action.hashCode();
                    if (action.equals(CduDataModel.ACTION_UPLOAD_FILE)) {
                        LogUtils.d(CduDataModel.TAG, "ACTION_UPLOAD_FILE runs...");
                        com.xiaopeng.data.uploader.b.b.a.b().h(Arrays.asList("/sdcard/Log/log0/logcat.txt"));
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_UPLOAD_FILE);
            App.c().registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public void uploadCduLog(String str) {
        uploadCduLogInternal(str);
    }
}
