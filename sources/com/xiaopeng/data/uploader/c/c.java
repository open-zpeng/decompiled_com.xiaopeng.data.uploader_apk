package com.xiaopeng.data.uploader.c;

import android.os.Environment;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.lib.utils.LogUtils;
import java.io.File;
/* compiled from: StorageHelper.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        LogUtils.d("DataUploader-StorageHelper", "checkAvailableStorage path: " + externalStorageDirectory);
        if (externalStorageDirectory != null) {
            long freeSpace = externalStorageDirectory.getFreeSpace();
            LogUtils.i("DataUploader-StorageHelper", "checkAvailableStorage free:" + freeSpace + ",limit is:" + OSSConstants.DEFAULT_FILE_SIZE_LIMIT, Boolean.FALSE);
            return freeSpace <= OSSConstants.DEFAULT_FILE_SIZE_LIMIT;
        }
        return false;
    }
}
