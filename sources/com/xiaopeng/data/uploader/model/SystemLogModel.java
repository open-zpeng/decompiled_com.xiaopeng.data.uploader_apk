package com.xiaopeng.data.uploader.model;

import android.car.Car;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.data.uploader.a;
import com.xiaopeng.data.uploader.c.c;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.ZipUtils;
import com.xiaopeng.lib.utils.crypt.AESUtils;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.xapp.XAppManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONObject;
/* loaded from: classes.dex */
public enum SystemLogModel {
    INSTANCE;
    
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SEPEARATOR = "#";
    private static final String TAG = "SystemLogModel";
    private static String sMcuVersion;
    private Handler mHandler = new Handler(ThreadUtils.getLooper(0));
    private XUIManager mXUIManager;

    SystemLogModel() {
    }

    private void deleteLocalFile(File file, boolean z) {
        if (z) {
            try {
                file.delete();
                System.gc();
            } catch (Exception e) {
                LogUtils.e(TAG, e);
            }
        }
    }

    private void forceGrantFolderPermission(final String str) {
        XUIManager createXUIManager = XUIManager.createXUIManager(App.c(), new ServiceConnection() { // from class: com.xiaopeng.data.uploader.model.SystemLogModel.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LogUtils.d(SystemLogModel.TAG, "xuiservice onServiceConnected");
                try {
                    ((XAppManager) SystemLogModel.this.mXUIManager.getXUIServiceManager("xapp")).forceGrantFolderPermission("/data/Log");
                    SystemLogModel.this.mHandler.post(new Runnable() { // from class: com.xiaopeng.data.uploader.model.SystemLogModel.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            SystemLogModel.this.uploadFiles(str);
                        }
                    });
                } catch (Exception e) {
                    LogUtils.e(SystemLogModel.TAG, "err: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LogUtils.d(SystemLogModel.TAG, "xuiservice onServiceDisconnected");
            }
        });
        this.mXUIManager = createXUIManager;
        createXUIManager.connect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b1  */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getHealthData() {
        /*
            Method dump skipped, instructions count: 693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.data.uploader.model.SystemLogModel.getHealthData():java.lang.String");
    }

    private String getMCUVer() {
        String str = SystemProperties.get("sys.mcu.version");
        sMcuVersion = str;
        return str;
    }

    private String getOssParam(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("callbackUrl", "https://v-callback.xiaopeng.com/oss/vehicle/oss/callback/feedback");
            HashMap hashMap = new HashMap();
            hashMap.put("address", str);
            hashMap.put(SSUtils.O0000Ooo, SystemPropertyUtil.getVIN());
            hashMap.put("vid", String.valueOf(SystemPropertyUtil.getVehicleId()));
            hashMap.put("device", SystemPropertyUtil.getHardwareId());
            hashMap.put("mcu_ver", TextUtils.isEmpty(sMcuVersion) ? getMCUVer() : sMcuVersion);
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap.put("app_id", "xmart:appid:002");
            hashMap.put("timer", String.valueOf(currentTimeMillis));
            hashMap.put("type", String.valueOf(1));
            hashMap.put("sid", SystemPropertyUtil.getSoftwareId());
            hashMap.put("network", String.valueOf(NetUtils.getNetworkType(App.c())));
            hashMap.put("msg", getHealthData());
            hashMap.put("sign", Security.sign(App.c(), hashMap, currentTimeMillis));
            jSONObject.put("callbackBody", new Gson().toJson(hashMap));
            jSONObject.put("callbackBodyType", BizConstants.CONTENT_TYPE_JSON);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            return null;
        }
    }

    private int getProcNum(String[] strArr, int i) {
        String str = strArr[i];
        int lastIndexOf = str.lastIndexOf(" ");
        if (lastIndexOf > 0) {
            str = str.substring(lastIndexOf).trim();
        }
        return Integer.parseInt(str);
    }

    private boolean isInternational() {
        try {
            return Car.isExportVersion();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFiles(String str) {
        String str2;
        int indexOf;
        if (c.a()) {
            LogUtils.e(TAG, "UploadFiles failed, storage is not enough!");
            return;
        }
        String str3 = a.f1868a;
        boolean isInternational = isInternational();
        String replace = str.replace("_en.zip", ".zip");
        if (isInternational) {
            str3 = "fra-xp-log";
        }
        if (replace.indexOf(isInternational ? ".oss-eu-central-1.aliyuncs.com/" : ".oss-cn-hangzhou.aliyuncs.com/") < 0) {
            Log.d(TAG, "not valid oss url " + str);
            return;
        }
        String str4 = "/sdcard/Log/upload-zip/" + str3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + replace.substring(indexOf + str2.length());
        File parentFile = new File(str4).getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            Log.d(TAG, "mkdirs error " + str4);
            return;
        }
        zipAndEncrypt(str4, Collections.singletonList("/data/Log/log0/"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str4.replace(".zip", "_en.zip"));
        com.xiaopeng.data.uploader.b.b.a.b().i(arrayList, getOssParam(str));
    }

    private void zipAndEncrypt(String str, List<String> list) {
        File file;
        try {
            file = ZipUtils.zipMultiFiles(str, list);
        } catch (IOException e) {
            LogUtils.e(TAG, e);
            file = null;
        }
        deleteLocalFile(file, AESUtils.encrypt(file, new File(str.replace(".zip", "_en.zip")), "@!chxpzi#0109$+/"));
    }

    public void uploadSystemLog(String str) {
        try {
            forceGrantFolderPermission(str);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
    }
}
