package com.xiaopeng.data.uploader.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DriveModel implements Serializable {
    public float angle;
    public int coorValid;
    public int coordType;
    public double latitude;
    public double longitude;
    public float speed;

    public String toString() {
        return "Drive{speed=" + this.speed + ", angle=" + this.angle + ", latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }
}
