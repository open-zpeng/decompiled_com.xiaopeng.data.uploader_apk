package b.b.a.b.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* compiled from: DeviceUtil.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f1057a;

    public static synchronized Map<String, String> a(Context context) {
        synchronized (d.class) {
            Map<String, String> map = f1057a;
            if (map != null) {
                map.put(b.b.a.b.g.a.CHANNEL.toString(), b.f());
                f1057a.put(b.b.a.b.g.a.APPKEY.toString(), b.c());
                b(f1057a, context);
                return f1057a;
            } else if (context != null) {
                f1057a = new HashMap();
                try {
                    String a2 = m.a(context);
                    String b2 = m.b(context);
                    if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2)) {
                        a2 = "";
                        b2 = "";
                    }
                    f1057a.put(b.b.a.b.g.a.IMEI.toString(), a2);
                    f1057a.put(b.b.a.b.g.a.IMSI.toString(), b2);
                    f1057a.put(b.b.a.b.g.a.BRAND.toString(), Build.BRAND);
                    f1057a.put(b.b.a.b.g.a.DEVICE_MODEL.toString(), Build.MODEL);
                    f1057a.put(b.b.a.b.g.a.RESOLUTION.toString(), d(context));
                    f1057a.put(b.b.a.b.g.a.CHANNEL.toString(), b.f());
                    f1057a.put(b.b.a.b.g.a.APPKEY.toString(), b.c());
                    f1057a.put(b.b.a.b.g.a.APPVERSION.toString(), e(context));
                    f1057a.put(b.b.a.b.g.a.LANGUAGE.toString(), c(context));
                    f1057a.put(b.b.a.b.g.a.OS.toString(), i());
                    f1057a.put(b.b.a.b.g.a.OSVERSION.toString(), h());
                    f1057a.put(b.b.a.b.g.a.SDKVERSION.toString(), "2.6.4.10_for_bc");
                    f1057a.put(b.b.a.b.g.a.SDKTYPE.toString(), "mini");
                    try {
                        f1057a.put(b.b.a.b.g.a.UTDID.toString(), UTDevice.getUtdid(context));
                    } catch (Throwable th) {
                        Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
                        th.printStackTrace();
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        String str = "";
                        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                            str = telephonyManager.getNetworkOperatorName();
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "Unknown";
                        }
                        f1057a.put(b.b.a.b.g.a.CARRIER.toString(), str);
                    } catch (Exception unused) {
                    }
                    b(f1057a, context);
                    return f1057a;
                } catch (Exception unused2) {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    private static void b(Map<String, String> map, Context context) {
        try {
            String[] f = l.f(context);
            map.put(b.b.a.b.g.a.ACCESS.toString(), f[0]);
            if (f[0].equals("2G/3G")) {
                map.put(b.b.a.b.g.a.ACCESS_SUBTYPE.toString(), f[1]);
            } else {
                map.put(b.b.a.b.g.a.ACCESS_SUBTYPE.toString(), "Unknown");
            }
        } catch (Exception unused) {
            map.put(b.b.a.b.g.a.ACCESS.toString(), "Unknown");
            map.put(b.b.a.b.g.a.ACCESS_SUBTYPE.toString(), "Unknown");
        }
    }

    private static String c(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    private static String d(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                int i3 = i ^ i2;
                i2 ^= i3;
                i = i3 ^ i2;
            }
            return i2 + "*" + i;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static String e(Context context) {
        String e = b.b.a.b.c.b().e();
        if (TextUtils.isEmpty(e)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    f1057a.put(b.b.a.b.g.a.APPVERSION.toString(), packageInfo.versionName);
                    return packageInfo.versionName;
                }
                return "Unknown";
            } catch (Throwable unused) {
                return "Unknown";
            }
        }
        return e;
    }

    public static boolean f() {
        try {
            if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(r.a("ro.yunos.build.version"))) {
                return g();
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean g() {
        return (TextUtils.isEmpty(r.a("ro.yunos.product.chip")) && TextUtils.isEmpty(r.a("ro.yunos.hardware"))) ? false : true;
    }

    private static String h() {
        String str = Build.VERSION.RELEASE;
        if (f()) {
            String property = System.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            str = l();
            if (!TextUtils.isEmpty(str)) {
            }
        }
        return str;
    }

    private static String i() {
        return (!f() || g()) ? "a" : "y";
    }

    public static String j() {
        String b2 = r.b("ro.aliyun.clouduuid", "false");
        if ("false".equals(b2)) {
            b2 = r.b("ro.sys.aliyun.clouduuid", "false");
        }
        return TextUtils.isEmpty(b2) ? k() : b2;
    }

    private static String k() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String l() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
