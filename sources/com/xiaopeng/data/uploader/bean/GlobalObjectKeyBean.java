package com.xiaopeng.data.uploader.bean;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
@Table(name = "t_global_objectkey")
/* loaded from: classes.dex */
public class GlobalObjectKeyBean extends Model {
    @Column(name = "filePath")
    String mFilePath;
    @Column(name = "objectKey")
    String mObjectKey;

    public GlobalObjectKeyBean() {
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getObjectKey() {
        return this.mObjectKey;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setObjectKey(String str) {
        this.mObjectKey = str;
    }

    @Override // com.activeandroid.Model
    public String toString() {
        return "GlobalObjectKeyBean{mFilePath='" + this.mFilePath + "', mObjectKey='" + this.mObjectKey + "'}";
    }

    public GlobalObjectKeyBean(String str, String str2) {
        this.mFilePath = str;
        this.mObjectKey = str2;
    }
}
