package com.xiaopeng.lib.framework.locationmodule.consumer;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.xiaopeng.lib.framework.locationmodule.LocationImpl;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Persistence {
    private static final String KEY_ACCURACY = "LASTLOCATION_ACCURACY";
    private static final String KEY_ACCURATE_SPEED = "LASTLOCATION_ACCU_SPEED";
    private static final String KEY_ADCODE = "LASTLOCATION_ADCODE";
    private static final String KEY_ALTITUDE = "LASTLOCATION_ALTITUDE";
    private static final String KEY_ANGLE = "LASTLOCATION_ANGLE";
    private static final String KEY_CATEGORY = "LASTLOCATION_CATEGORY";
    private static final String KEY_CITY = "LASTLOCATION_CITY";
    private static final String KEY_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    private static final String KEY_LATITUDE = "LASTLOCATION_LATITUDE";
    private static final String KEY_LONGITUDE = "LASTLOCATION_LONGITUDE";
    private static final String KEY_RAW_LATITUDE = "LASTLOCATION_RAWLATITUDE";
    private static final String KEY_RAW_LONGITUDE = "LASTLOCATION_RAWLONGITUDE";
    private static final String KEY_SATELLITES = "LASTLOCATION_SATELLITES";
    private static final String KEY_SOURCETYPE = "LASTLOCATION_SOURCETYPE";
    private static final String KEY_TIME = "LASTLOCATION_TIME";
    private long mLastUpdateTime;
    private SharedPreferences.Editor mSharePreferenceEditor;
    private SharedPreferences mSharedPreference;

    public Persistence(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mSharedPreference = defaultSharedPreferences;
        this.mSharePreferenceEditor = defaultSharedPreferences.edit();
    }

    private float getFloat(String str, float f) {
        try {
            return this.mSharedPreference.getFloat(str, f);
        } catch (Exception e) {
            Log.i("Persistence", "getFloat:" + e.getMessage());
            return f;
        }
    }

    private int getInt(String str, int i) {
        try {
            return this.mSharedPreference.getInt(str, i);
        } catch (Exception e) {
            Log.i("Persistence", "getInt:" + e.getMessage());
            return i;
        }
    }

    private long getLong(String str, long j) {
        try {
            return this.mSharedPreference.getLong(str, j);
        } catch (Exception e) {
            Log.i("Persistence", "getLong:" + e.getMessage());
            return j;
        }
    }

    private String getString(String str, String str2) {
        try {
            return this.mSharedPreference.getString(str, str2);
        } catch (Exception e) {
            Log.i("Persistence", "getString:" + e.getMessage());
            return str2;
        }
    }

    public long getLastUpdateTime() {
        return this.mLastUpdateTime;
    }

    public ILocation read() {
        int i = getInt(KEY_CATEGORY, ILocation.Category.values().length);
        if (i == ILocation.Category.values().length) {
            return null;
        }
        this.mLastUpdateTime = getLong(KEY_LAST_UPDATE_TIME, -1L);
        LocationImpl locationImpl = new LocationImpl();
        locationImpl.category(ILocation.Category.values()[i]).latitude(getFloat(KEY_LATITUDE, 0.0f)).longitude(getFloat(KEY_LONGITUDE, 0.0f)).rawLatitude(getFloat(KEY_RAW_LATITUDE, 0.0f)).rawLongitude(getFloat(KEY_RAW_LONGITUDE, 0.0f)).speed(getFloat(KEY_ACCURATE_SPEED, 0.0f)).angle(getFloat(KEY_ANGLE, 0.0f)).accuracy(getInt(KEY_ACCURACY, 0)).satellites(getInt(KEY_SATELLITES, 0)).altitude(getInt(KEY_ALTITUDE, 0)).time(getLong(KEY_TIME, 0L)).sourceType(getInt(KEY_SOURCETYPE, 0)).city(getString(KEY_CITY, "")).adCode(getString(KEY_ADCODE, ""));
        locationImpl.seal();
        return locationImpl;
    }

    public void updateLastTime() {
        this.mLastUpdateTime = System.currentTimeMillis();
    }

    public void write(ILocation iLocation) {
        this.mSharePreferenceEditor.putInt(KEY_CATEGORY, iLocation.category().ordinal());
        this.mSharePreferenceEditor.putFloat(KEY_LATITUDE, iLocation.latitude());
        this.mSharePreferenceEditor.putFloat(KEY_LONGITUDE, iLocation.longitude());
        this.mSharePreferenceEditor.putFloat(KEY_RAW_LATITUDE, iLocation.rawLatitude());
        this.mSharePreferenceEditor.putFloat(KEY_RAW_LONGITUDE, iLocation.rawLongitude());
        this.mSharePreferenceEditor.putFloat(KEY_ACCURATE_SPEED, iLocation.speed());
        this.mSharePreferenceEditor.putFloat(KEY_ANGLE, iLocation.angle());
        this.mSharePreferenceEditor.putInt(KEY_ACCURACY, iLocation.accuracy());
        this.mSharePreferenceEditor.putInt(KEY_SATELLITES, iLocation.satellites());
        this.mSharePreferenceEditor.putInt(KEY_ALTITUDE, iLocation.altitude());
        this.mSharePreferenceEditor.putLong(KEY_TIME, iLocation.time());
        this.mSharePreferenceEditor.putInt(KEY_SOURCETYPE, iLocation.sourceType());
        this.mSharePreferenceEditor.putString(KEY_CITY, iLocation.city());
        this.mSharePreferenceEditor.putString(KEY_ADCODE, iLocation.adCode());
        this.mSharePreferenceEditor.putLong(KEY_LAST_UPDATE_TIME, this.mLastUpdateTime);
        this.mSharePreferenceEditor.apply();
    }
}
