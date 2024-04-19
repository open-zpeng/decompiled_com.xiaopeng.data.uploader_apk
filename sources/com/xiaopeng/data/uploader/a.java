package com.xiaopeng.data.uploader;

import com.xiaopeng.lib.utils.info.BuildInfoUtils;
/* compiled from: Config.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1868a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1869b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f1870c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f1871d;
    public static final String e;

    static {
        String str = BuildInfoUtils.isLanVersion() ? "xp-log-local" : "xp-log";
        f1868a = str;
        f1869b = BuildInfoUtils.isLanVersion() ? "http://10.0.13.27:8001/xmartData" : "https://xmartdata.xiaopeng.com/xmartData";
        f1870c = BuildInfoUtils.isLanVersion() ? "http://10.0.13.27:8081/xmartFileData" : "https://xmartdata.xiaopeng.com/xmartFileData";
        StringBuilder sb = new StringBuilder();
        sb.append(BuildInfoUtils.isLanVersion() ? "https://10.0.13.28:8553" : "https://xmart.xiaopeng.com");
        sb.append("/biz/v5/event/vehicleEvent");
        f1871d = sb.toString();
        e = "http://" + str + ".oss-cn-hangzhou.aliyuncs.com/";
    }
}
