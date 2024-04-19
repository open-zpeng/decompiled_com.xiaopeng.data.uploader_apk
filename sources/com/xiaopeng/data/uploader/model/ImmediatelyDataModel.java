package com.xiaopeng.data.uploader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.google.gson.Gson;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.data.uploader.a;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ImmediatelyDataModel {
    private static final int RETRY_INTERVAL = 5000;
    private static final int RETRY_MAX_INTERVAL = 300000;
    private static final String TAG = "ImmediatelyDataModel";
    private Gson mGson = new Gson();
    private Handler mHandler = new Handler(ThreadUtils.getLooper(2));

    public ImmediatelyDataModel() {
        debugBroadcast();
    }

    private void debugBroadcast() {
        if (BuildInfoUtils.isEngVersion()) {
            IntentFilter intentFilter = new IntentFilter("com.xiaopeng.action.DEBUG_IMMEDIATELY_EVENT");
            App.c().registerReceiver(new BroadcastReceiver() { // from class: com.xiaopeng.data.uploader.model.ImmediatelyDataModel.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    LogUtils.d(ImmediatelyDataModel.TAG, "onReceive com.xiaopeng.action.DEBUG_IMMEDIATELY_EVENT");
                    ImmediatelyDataModel.this.uploadLogImmediately("DEBUG_IMMEDIATELY_EVENT", "");
                }
            }, intentFilter);
            LogUtils.d(TAG, "register immediately event receiver");
        }
    }

    public void uploadLogImmediately(String str, String str2) {
        uploadLogImmediately(str, str2, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadLogImmediately(final String str, final String str2, final long j) {
        LogUtils.d(TAG, "uploadLogImmediately eventName:" + str + " startTime:" + j);
        if (System.currentTimeMillis() - j >= 300000) {
            LogUtils.d(TAG, "now - startTime >= RETRY_MAX_INTERVAL, return!");
        } else if (!NetUtils.isNetworkAvailable(App.c())) {
            LogUtils.d(TAG, "Network not available, post delayed and return!");
            this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.data.uploader.model.ImmediatelyDataModel.2
                @Override // java.lang.Runnable
                public void run() {
                    ImmediatelyDataModel.this.uploadLogImmediately(str, str2, j);
                }
            }, 5000L);
        } else {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("app_id", "xmart:appid:002");
            hashMap.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap.put("event", str);
            hashMap.put("params", str2);
            hashMap.put("ts", String.valueOf(j));
            hashMap.put("sign", Security.sign(App.c(), hashMap, currentTimeMillis));
            LogUtils.d(TAG, "secret:" + BizConstants.CAR_SECRET);
            ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper().post(a.f1871d, this.mGson.toJson(hashMap)).build().execute(new Callback() { // from class: com.xiaopeng.data.uploader.model.ImmediatelyDataModel.3
                @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
                public void onFailure(IResponse iResponse) {
                    LogUtils.i(ImmediatelyDataModel.TAG, "uploadLogImmediately response error:" + iResponse.body() + " eventName:" + str);
                    ImmediatelyDataModel.this.mHandler.postDelayed(new Runnable() { // from class: com.xiaopeng.data.uploader.model.ImmediatelyDataModel.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            ImmediatelyDataModel.this.uploadLogImmediately(str, str2, j);
                        }
                    }, 5000L);
                }

                @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
                public void onSuccess(IResponse iResponse) {
                    LogUtils.w(ImmediatelyDataModel.TAG, "uploadLogImmediately response success:" + iResponse.body() + " code:" + iResponse.code() + " exception:" + iResponse.getException());
                }
            });
        }
    }
}
