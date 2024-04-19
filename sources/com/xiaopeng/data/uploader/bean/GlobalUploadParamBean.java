package com.xiaopeng.data.uploader.bean;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
@Table(name = "t_global_upload_param")
/* loaded from: classes.dex */
public class GlobalUploadParamBean extends Model {
    @Column(name = "filePath")
    String mFilePath;
    @Column(name = "uploadParam")
    String mUploadParam;

    public GlobalUploadParamBean() {
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getUploadParam() {
        return this.mUploadParam;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setUploadParam(String str) {
        this.mUploadParam = str;
    }

    @Override // com.activeandroid.Model
    public String toString() {
        return "GlobalObjectKeyBean{filePath='" + this.mFilePath + "', uploadParam='" + this.mUploadParam + "'}";
    }

    public GlobalUploadParamBean(String str, String str2) {
        this.mFilePath = str;
        this.mUploadParam = str2;
    }
}
