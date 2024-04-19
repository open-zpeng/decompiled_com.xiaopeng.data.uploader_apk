package b.b.a.b.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
/* compiled from: AppInfoUtil.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f1048a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f1049b;

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String c() {
        return f1049b;
    }

    public static String d() {
        if (b.b.a.b.a.j() == null) {
            return "";
        }
        try {
            String string = b.b.a.b.a.j().getSharedPreferences("UTCommon", 0).getString("_lun", "");
            return !TextUtils.isEmpty(string) ? new String(c.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (b.b.a.b.a.j() == null) {
            return "";
        }
        try {
            String string = b.b.a.b.a.j().getSharedPreferences("UTCommon", 0).getString("_luid", "");
            return !TextUtils.isEmpty(string) ? new String(c.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f() {
        return f1048a;
    }

    public static String g() {
        return "";
    }

    public static String h() {
        return "";
    }

    public static void i(String str) {
        i.c("AppInfoUtil", "[setChannle]", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        if (indexOf == -1) {
            f1048a = str;
        } else {
            f1048a = str.substring(0, indexOf);
        }
    }

    public static void j(String str) {
        i.c("AppInfoUtil", "set Appkey:", str);
        f1049b = str;
    }
}
