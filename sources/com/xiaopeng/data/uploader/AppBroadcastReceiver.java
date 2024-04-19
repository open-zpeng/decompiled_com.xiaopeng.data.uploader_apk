package com.xiaopeng.data.uploader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.xiaopeng.data.uploader.model.SystemTrafficDataModel;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
/* loaded from: classes.dex */
public class AppBroadcastReceiver extends BroadcastReceiver implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    private Handler f1867c = new Handler(ThreadUtils.getLooper(2), this);

    /* renamed from: b  reason: collision with root package name */
    private SystemTrafficDataModel f1866b = new SystemTrafficDataModel();

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            LogUtils.i("DataUploaderReceiver", "receive CONNECTIVITY_ACTION");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) App.c().getSystemService("connectivity")).getActiveNetworkInfo();
            com.xiaopeng.data.uploader.b.c.a.e().l(activeNetworkInfo);
            com.xiaopeng.data.uploader.b.b.a.b().d(activeNetworkInfo);
        } else if (i == 2) {
            LogUtils.d("DataUploaderReceiver", "receive ACTION_BROADCAST_TOKEN_GOTTEN, init messaging channel.");
            com.xiaopeng.data.uploader.b.d.a.d().i();
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("DataUploaderReceiver", "AppBroadcastReceiver action:" + action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f1867c.sendEmptyMessage(1);
        } else if (CommonConfig.ACTION_BROADCAST_TOKEN_GOTTEN.equals(action)) {
            this.f1867c.sendEmptyMessage(2);
        } else if (SystemTrafficDataModel.SYSTEM_TRAFFIC_STATISTICS_ACTION.equals(action)) {
            this.f1866b.sendMessage();
        }
    }
}
