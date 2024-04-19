package com.xiaopeng.data.uploader.model;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.xiaopeng.data.uploader.bean.GlobalUploadParamBean;
import com.xiaopeng.lib.utils.LogUtils;
/* loaded from: classes.dex */
public enum UploadParamModel {
    INSTANCE;
    
    private static final String TAG = "UploadParamModel";

    public synchronized void removeParamFromDB(String str) {
        try {
            new Delete().from(GlobalUploadParamBean.class).where("filePath = ?", str).execute();
        } catch (Exception unused) {
            LogUtils.w(TAG, "remove the param for " + str + " failed");
        }
    }

    public synchronized void saveFileParams2DB(String str, String str2) {
        try {
            new GlobalUploadParamBean(str, str2).save();
        } catch (Exception e) {
            LogUtils.w(TAG, "save param for file " + str + " failed;exception details-->" + e.getMessage());
        }
    }

    public String selectParamFromDB(String str) {
        try {
            GlobalUploadParamBean globalUploadParamBean = (GlobalUploadParamBean) new Select().from(GlobalUploadParamBean.class).where("filePath = ?", str).executeSingle();
            if (globalUploadParamBean != null) {
                LogUtils.d(TAG, "DB has param for file " + str);
                return globalUploadParamBean.getUploadParam();
            }
            return null;
        } catch (Exception e) {
            LogUtils.w(TAG, "exception occurs when select the DB, exception details-->" + e.getMessage());
            return null;
        }
    }
}
