package com.xiaopeng.lib.framework.locationmodule;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.xiaopeng.lib.framework.locationmodule.common.Debug;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
@Keep
/* loaded from: classes.dex */
public final class LocationImpl implements ILocation {
    public static final Parcelable.Creator<LocationImpl> CREATOR = new Parcelable.Creator<LocationImpl>() { // from class: com.xiaopeng.lib.framework.locationmodule.LocationImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationImpl createFromParcel(Parcel parcel) {
            return new LocationImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationImpl[] newArray(int i) {
            return new LocationImpl[i];
        }
    };
    private static final boolean DEBUG = false;
    private int mAccuracy;
    private String mAdCode;
    private int mAltitude;
    private float mAngle;
    private ILocation.Category mCategory;
    private String mCity;
    private float mLatitude;
    private float mLongitude;
    private boolean mMutable;
    private float mRawLatitude;
    private float mRawLongitude;
    private int mSatellites;
    private int mSourceType;
    private float mSpeed;
    private long mTime;

    private void checkMutable() {
        if (!this.mMutable) {
            throw new RuntimeException("Not allow any modification if sealed!");
        }
    }

    private void readFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < ILocation.Category.values().length) {
            this.mCategory = ILocation.Category.values()[readInt];
        } else {
            Debug.assertion(false, "Wrong Location Data!!!");
        }
        this.mLatitude = parcel.readFloat();
        this.mLongitude = parcel.readFloat();
        this.mRawLatitude = parcel.readFloat();
        this.mRawLongitude = parcel.readFloat();
        this.mSpeed = parcel.readFloat();
        this.mAngle = parcel.readFloat();
        this.mAccuracy = parcel.readInt();
        this.mSatellites = parcel.readInt();
        this.mAltitude = parcel.readInt();
        this.mTime = parcel.readLong();
        this.mSourceType = parcel.readInt();
        this.mCity = parcel.readString();
        try {
            this.mAdCode = parcel.readString();
        } catch (Exception unused) {
            this.mAdCode = "";
        }
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation accuracy(int i) {
        checkMutable();
        this.mAccuracy = i;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation adCode(String str) {
        checkMutable();
        this.mAdCode = str;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation altitude(int i) {
        checkMutable();
        this.mAltitude = i;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation city(String str) {
        checkMutable();
        this.mCity = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation satellites(int i) {
        checkMutable();
        this.mSatellites = i;
        return this;
    }

    public void seal() {
        this.mMutable = false;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation sourceType(int i) {
        checkMutable();
        this.mSourceType = i;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation time(long j) {
        checkMutable();
        this.mTime = j;
        return this;
    }

    public String toString() {
        return "<HIDDEN>";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCategory.ordinal());
        parcel.writeFloat(this.mLatitude);
        parcel.writeFloat(this.mLongitude);
        parcel.writeFloat(this.mRawLatitude);
        parcel.writeFloat(this.mRawLongitude);
        parcel.writeFloat(this.mSpeed);
        parcel.writeFloat(this.mAngle);
        parcel.writeInt(this.mAccuracy);
        parcel.writeInt(this.mSatellites);
        parcel.writeInt(this.mAltitude);
        parcel.writeLong(this.mTime);
        parcel.writeInt(this.mSourceType);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mAdCode);
    }

    public LocationImpl() {
        this.mMutable = true;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl angle(float f) {
        checkMutable();
        this.mAngle = f;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl category(ILocation.Category category) {
        checkMutable();
        this.mCategory = category;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl latitude(float f) {
        checkMutable();
        this.mLatitude = f;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl longitude(float f) {
        checkMutable();
        this.mLongitude = f;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl rawLatitude(float f) {
        checkMutable();
        this.mRawLatitude = f;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl rawLongitude(float f) {
        checkMutable();
        this.mRawLongitude = f;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public LocationImpl speed(float f) {
        checkMutable();
        this.mSpeed = f;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public int accuracy() {
        return this.mAccuracy;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public String adCode() {
        return this.mAdCode;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public int altitude() {
        return this.mAltitude;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public String city() {
        return this.mCity;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public int satellites() {
        return this.mSatellites;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public int sourceType() {
        return this.mSourceType;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public long time() {
        return this.mTime;
    }

    private LocationImpl(Parcel parcel) {
        readFromParcel(parcel);
        this.mMutable = false;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public float angle() {
        return this.mAngle;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public ILocation.Category category() {
        return this.mCategory;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public float latitude() {
        return this.mLatitude;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public float longitude() {
        return this.mLongitude;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public float rawLatitude() {
        return this.mRawLatitude;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public float rawLongitude() {
        return this.mRawLongitude;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation
    public float speed() {
        return this.mSpeed;
    }
}
