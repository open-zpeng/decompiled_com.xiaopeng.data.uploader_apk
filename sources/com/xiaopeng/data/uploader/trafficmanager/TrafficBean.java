package com.xiaopeng.data.uploader.trafficmanager;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;
@Table(name = "traffic_statistics_table")
/* loaded from: classes.dex */
public class TrafficBean extends Model {
    @SerializedName("APP")
    @Column(name = "APP")
    public String APP;
    @SerializedName("Wifi")
    @Column(name = "Wifi")
    public long Wifi = 0;
    @SerializedName("MobileDown")
    @Column(name = "MobileDown")
    public long MobileDown = 0;
    @SerializedName("MobileUp")
    @Column(name = "MobileUp")
    public long MobileUp = 0;
    @SerializedName("Moblie")
    @Column(name = "Moblie")
    public long Moblie = 0;
    @SerializedName("WifiDown")
    @Column(name = "WifiDown")
    public long WifiDown = 0;
    @SerializedName("WifiUp")
    @Column(name = "WifiUp")
    public long WifiUp = 0;
}
