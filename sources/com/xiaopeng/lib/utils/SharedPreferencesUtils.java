package com.xiaopeng.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
/* loaded from: classes.dex */
public class SharedPreferencesUtils {
    private static final String SP_NAME = "shared_pref";
    private static final String TAG = "SharedPreferencesUtils";
    private static int initCount;
    private static volatile SharedPreferencesUtils instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences sp;

    private SharedPreferencesUtils(Context context, String str, int i) {
        str = TextUtils.isEmpty(str) ? context.getPackageName() : str;
        str = TextUtils.isEmpty(str) ? SP_NAME : str;
        Log.v(TAG, "spName=" + str);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.sp = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.editor = edit;
        edit.apply();
    }

    @Deprecated
    public static int getInitCount() {
        return initCount;
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        init(context);
        return instance;
    }

    private static void init(Context context) {
        init(context, null);
    }

    public void clear() {
        this.editor.clear().commit();
    }

    public boolean contains(String str) {
        return this.sp.contains(str);
    }

    public Map<String, ?> getAll() {
        return this.sp.getAll();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public long getLong(String str) {
        return getLong(str, -1L);
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public void putBoolean(String str, boolean z) {
        this.editor.putBoolean(str, z).commit();
    }

    public void putFloat(String str, float f) {
        this.editor.putFloat(str, f).commit();
    }

    public void putInt(String str, int i) {
        this.editor.putInt(str, i).commit();
    }

    public void putLong(String str, long j) {
        this.editor.putLong(str, j).commit();
    }

    public void putString(String str, String str2) {
        this.editor.putString(str, str2).commit();
    }

    public void remove(String str) {
        this.editor.remove(str).commit();
    }

    private static void init(Context context, String str) {
        if (instance == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (instance == null) {
                    instance = new SharedPreferencesUtils(context.getApplicationContext(), str, 0);
                    initCount++;
                }
            }
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sp.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return this.sp.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        return this.sp.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.sp.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.sp.getString(str, str2);
    }

    public static SharedPreferencesUtils getInstance(Context context, String str) {
        init(context, str);
        return instance;
    }
}
