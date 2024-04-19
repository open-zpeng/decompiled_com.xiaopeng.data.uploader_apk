package com.xiaopeng.data.uploader.model;

import android.text.TextUtils;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.xiaopeng.data.uploader.b.a;
import com.xiaopeng.data.uploader.bean.GlobalObjectKeyBean;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import java.text.SimpleDateFormat;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public class ObjectKeyModel {
    private static final String TAG = "ObjectKeyModel";

    /* renamed from: com.xiaopeng.data.uploader.model.ObjectKeyModel$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$data$uploader$channel$EventType;

        static {
            int[] iArr = new int[a.values().length];
            $SwitchMap$com$xiaopeng$data$uploader$channel$EventType = iArr;
            try {
                iArr[a.CAN_CDU_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$data$uploader$channel$EventType[a.BUG_FEEDBACK_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    private static class Holder {
        static final ObjectKeyModel INSTANCE = new ObjectKeyModel();

        private Holder() {
        }
    }

    private String generateFormatTime(long j) {
        return new SimpleDateFormat("yyyy/MM/dd/HHmm").format(Long.valueOf(j));
    }

    private String getBugFeedbackObjectKey(String str) {
        String selectObjectKeyFromDB = selectObjectKeyFromDB(str);
        if (TextUtils.isEmpty(selectObjectKeyFromDB)) {
            if (!TextUtils.isEmpty(str) && str.startsWith("/sdcard/Log/upload-zip/")) {
                try {
                    String substring = str.substring(23 + str.substring(23).indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
                    saveObjectKey2DB(str, substring);
                    return substring;
                } catch (Exception e) {
                    LogUtils.w(TAG, "generateObjectKey fail! path:" + str, e);
                    return null;
                }
            }
            LogUtils.w(TAG, "invalid filePath:'" + str + "', return");
            return null;
        }
        return selectObjectKeyFromDB;
    }

    private String getCanCduObjectKey(String str) {
        String str2 = "candata";
        if (!str.contains("candata")) {
            if (str.contains("cdudata")) {
                str2 = "cdudata";
            } else {
                str2 = str.contains("acclccdata") ? "acclccdata" : null;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        String generateFormatTime = generateFormatTime(currentTimeMillis);
        String hardwareId = SystemPropertyUtil.getHardwareId();
        if (TextUtils.isEmpty(hardwareId)) {
            hardwareId = "-1";
        }
        String str3 = "xmart-file-data/" + hardwareId + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + generateFormatTime + MqttTopic.TOPIC_LEVEL_SEPARATOR + hardwareId + "-" + str2 + "-" + currentTimeMillis + ".zip";
        LogUtils.d(TAG, "bucket : " + str3);
        saveObjectKey2DB(str, str3);
        return str3;
    }

    public static ObjectKeyModel getInstance() {
        return Holder.INSTANCE;
    }

    private synchronized void saveObjectKey2DB(String str, String str2) {
        try {
            new GlobalObjectKeyBean(str, str2).save();
        } catch (Exception e) {
            LogUtils.w(TAG, "save objectKey for file " + str + " failed;exception details-->" + e.getMessage());
        }
    }

    private String selectObjectKeyFromDB(String str) {
        try {
            GlobalObjectKeyBean globalObjectKeyBean = (GlobalObjectKeyBean) new Select().from(GlobalObjectKeyBean.class).where("filePath = ?", str).executeSingle();
            if (globalObjectKeyBean != null) {
                LogUtils.d(TAG, "DB has objectKey for file " + str + ", so it is a resumable uploadTask");
                return globalObjectKeyBean.getObjectKey();
            }
            return null;
        } catch (Exception e) {
            LogUtils.w(TAG, "exception occurs when select the DB, exception details-->" + e.getMessage());
            return null;
        }
    }

    public synchronized String generateObjectKey(String str, a aVar) {
        String selectObjectKeyFromDB = selectObjectKeyFromDB(str);
        if (TextUtils.isEmpty(selectObjectKeyFromDB)) {
            int i = AnonymousClass1.$SwitchMap$com$xiaopeng$data$uploader$channel$EventType[aVar.ordinal()];
            if (i == 1) {
                return getCanCduObjectKey(str);
            } else if (i != 2) {
                return null;
            } else {
                return getBugFeedbackObjectKey(str);
            }
        }
        return selectObjectKeyFromDB;
    }

    public synchronized void removeObjectKeyFromDB(String str) {
        try {
            new Delete().from(GlobalObjectKeyBean.class).where("filePath = ?", str).execute();
        } catch (Exception unused) {
            LogUtils.w(TAG, "remove the objectKey for " + str + " failed");
        }
    }
}
