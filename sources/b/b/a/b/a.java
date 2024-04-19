package b.b.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import b.b.a.a.n.j;
import b.b.a.b.f.i;
import b.b.a.b.f.l;
import b.b.a.b.f.p;
import b.b.a.b.f.s;
import com.xiaopeng.lib.framework.moduleinterface.accountmodule.IError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: UTDC.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f1001a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1002b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1003c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1004d = true;
    public static String e = String.valueOf(System.currentTimeMillis());
    public static final AtomicInteger f = new AtomicInteger(0);
    public static boolean g = true;
    public static b.b.a.b.h.b h = null;
    public static boolean i = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UTDC.java */
    /* renamed from: b.b.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0037a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1005b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1006c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f1007d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ HashMap g;

        RunnableC0037a(String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
            this.f1005b = str;
            this.f1006c = str2;
            this.f1007d = str3;
            this.e = str4;
            this.f = str5;
            this.g = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.c("UTDC", "[commit] page:", this.f1005b, "eventId:", this.f1006c, "arg1:", this.f1007d, "arg2:", this.e, "arg3:", this.f, "args:", this.g);
            try {
                b.b.a.b.b.a.h(this.f1006c);
                b.b.a.b.d.c.e().i(new b.b.a.b.g.b(this.f1005b, this.f1006c, this.f1007d, this.e, this.f, this.g));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: Config.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private static long f1008a = 300000;

        /* renamed from: b  reason: collision with root package name */
        private static long f1009b = 30000;

        /* renamed from: c  reason: collision with root package name */
        private static String f1010c = "";

        /* renamed from: d  reason: collision with root package name */
        private static String f1011d = "";
        public static boolean e = false;
        public static String f = null;
        public static volatile boolean g = false;
        private static boolean h = false;
        private static boolean i = false;
        static List<String> j = new ArrayList();
        static List<String> k = new ArrayList();
        static List<String> l = new ArrayList();
        static List<String> m = new ArrayList();
        static List<String> n = new ArrayList();
        static List<String> o = new ArrayList();
        private static String p = "net";
        private static boolean q;

        static {
            k.add("stm_bcx");
            l.add("stm_x");
            m.add("stm_p");
            n.add("stm_c");
            j.add("stm_d");
            o.add("stm_nc");
        }

        public static long a() {
            return f1009b;
        }

        private static String b(String str) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a.j());
            return defaultSharedPreferences.getString("ut_" + str + "_config", null);
        }

        public static List<String> c(String str) {
            int i2;
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                i2 = -1;
            }
            if (i2 == -1) {
                return j;
            }
            if (i2 == 1 || i2 == 61005 || i2 == 61006 || i2 == 65501 || i2 == 65502 || i2 == 65503 || i2 == 65133) {
                return k;
            }
            if ((i2 <= 1 || i2 >= 100) && ((i2 <= 15300 || i2 >= 15400) && ((i2 <= 21000 || i2 >= 30000) && ((i2 <= 61000 || i2 >= 61200) && (i2 <= 65000 || i2 >= 65300))))) {
                if (i2 <= 1000 || i2 >= 2100) {
                    if (i2 <= 2100 || i2 >= 2200) {
                        if (i2 != 19999 && ((i2 <= 4000 || i2 >= 10000) && ((i2 <= 64000 || i2 >= 65000) && ((i2 <= 65500 || i2 >= 65600) && (i2 <= 66000 || i2 >= 67000))))) {
                            return o;
                        }
                        return j;
                    }
                    return n;
                }
                return m;
            }
            return l;
        }

        public static synchronized void d(Context context) {
            synchronized (b.class) {
                if (!q) {
                    q = true;
                    try {
                        p();
                        j.a().b(context);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    c.a().b();
                }
            }
        }

        private static int e(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Integer.valueOf(str).intValue();
                } catch (Exception unused) {
                }
            }
            return -1;
        }

        public static long f() {
            return f1008a;
        }

        public static boolean g() {
            return e;
        }

        public static void h(String str) {
            f1011d = str;
        }

        public static boolean i() {
            return !g;
        }

        public static String j() {
            if (TextUtils.isEmpty(f1010c)) {
                k("adashbc.ut.taobao.com");
                if (!TextUtils.isEmpty(f1011d)) {
                    k(f1011d);
                }
                Context j2 = a.j();
                k(l(j2, "utanalytics_https_host"));
                k(p.b(j2, "utanalytics_https_host"));
            }
            return f1010c;
        }

        private static void k(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f1010c = "https://" + str + "/rest/sur";
        }

        private static String l(Context context, String str) {
            int identifier;
            if (context == null) {
                return null;
            }
            try {
                Resources resources = context.getResources();
                if (resources != null && (identifier = resources.getIdentifier(str, "string", context.getPackageName())) != 0) {
                    return context.getString(identifier);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        public static String m() {
            if ("l0".equalsIgnoreCase(p)) {
                i.c("Config", p, "l0 config");
                return "{\"SYSTEM\":{\"discardap\":\"1\"}}";
            } else if ("l1".equalsIgnoreCase(p)) {
                i.c("Config", p, "l1 config");
                return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":2500},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":2500},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":2500},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":2500},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":2500},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":2500}]},{\"module\":\"ACDS\",\"sampling\":250},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":250}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":2500},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":2500}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":2500},{\"monitorPoint\":\"LoadDesc\",\"sampling\":2500}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":2000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":2500}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":2500}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":2500}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":2500},{\"monitorPoint\":\"ShowCart\",\"sampling\":2500},{\"monitorPoint\":\"UpdateCart\",\"sampling\":2500}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":2500}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":2500},{\"monitorPoint\":\"CreateOrder\",\"sampling\":2500}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":2500},{\"monitorPoint\":\"refreshAttention\",\"sampling\":2500}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":2500}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":1250},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":1250},{\"monitorPoint\":\"Config\",\"sampling\":1250},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":1250},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":2500},{\"monitorPoint\":\"enviroment\",\"sampling\":2500},{\"monitorPoint\":\"jsBridge\",\"sampling\":2500},{\"monitorPoint\":\"streamModule\",\"sampling\":2500}]},{\"module\":\"ACDS\",\"sampling\":250,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":250}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":250},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":250},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":2500}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":250},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":250},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":2500}]}]}}";
            } else if ("l2".equalsIgnoreCase(p)) {
                i.c("Config", p, "l2 config");
                return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":5000},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":5000},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":5000},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":5000},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":5000},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":5000}]},{\"module\":\"ACDS\",\"sampling\":500},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":500}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":5000},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":5000}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":5000},{\"monitorPoint\":\"LoadDesc\",\"sampling\":5000}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":5000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":5000}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":5000}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":5000}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":5000},{\"monitorPoint\":\"ShowCart\",\"sampling\":5000},{\"monitorPoint\":\"UpdateCart\",\"sampling\":5000}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":5000}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":5000},{\"monitorPoint\":\"CreateOrder\",\"sampling\":5000}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":5000},{\"monitorPoint\":\"refreshAttention\",\"sampling\":5000}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":5000}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":2500},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":2500},{\"monitorPoint\":\"Config\",\"sampling\":2500},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":2500},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":5000},{\"monitorPoint\":\"enviroment\",\"sampling\":5000},{\"monitorPoint\":\"jsBridge\",\"sampling\":5000},{\"monitorPoint\":\"streamModule\",\"sampling\":5000}]},{\"module\":\"ACDS\",\"sampling\":500,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":500}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":500},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":500},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":5000}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":500},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":500},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":5000}]}]}}";
            } else if ("l3".equalsIgnoreCase(p)) {
                i.c("Config", p, "l3 config");
                return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":10000},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":10000},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":10000},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":10000},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":10000},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":10000}]},{\"module\":\"ACDS\",\"sampling\":1000},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":1000}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":10000},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":10000}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":10000},{\"monitorPoint\":\"LoadDesc\",\"sampling\":10000}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":10000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":10000}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":10000}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":10000}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":10000},{\"monitorPoint\":\"ShowCart\",\"sampling\":10000},{\"monitorPoint\":\"UpdateCart\",\"sampling\":10000}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":10000}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":10000},{\"monitorPoint\":\"CreateOrder\",\"sampling\":10000}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":10000},{\"monitorPoint\":\"refreshAttention\",\"sampling\":10000}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":10000}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":5000},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":5000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":10000},{\"monitorPoint\":\"enviroment\",\"sampling\":10000},{\"monitorPoint\":\"jsBridge\",\"sampling\":10000},{\"monitorPoint\":\"streamModule\",\"sampling\":10000}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":1000}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":1000},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":1000},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":10000}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":1000},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":1000},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":10000}]}]}}";
            } else {
                i.c("Config", p, "net config");
                String b2 = b("b01na");
                if (b2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(b2).getJSONObject("content");
                        if (jSONObject != null) {
                            return jSONObject.getString("c_content");
                        }
                        return null;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }

        public static void n(String str) {
            int e2;
            if (i || (e2 = e(str)) == -1) {
                return;
            }
            f1008a = e2 * IError.ERR_SERVICE_DISCONNECTED;
        }

        public static void o(String str) {
            int e2;
            if (h || (e2 = e(str)) == -1) {
                return;
            }
            f1009b = e2 * IError.ERR_SERVICE_DISCONNECTED;
        }

        public static void p() {
            try {
                String m2 = m();
                j.a().g(m2);
                f.b(m2);
                e.a().c(b("b01n15"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public static void q(Map<String, String> map) {
            i.c("Config", "[turnOnRealTimeDebug] params:", map);
            if (map != null) {
                String str = map.get("debug_api_url");
                String str2 = map.get("debug_key");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    f1010c = str;
                    e = true;
                    f = str2;
                }
                if (map.containsKey("debug_sampling_option")) {
                    b.b.a.a.b.f913a = true;
                    a.m();
                }
            }
        }
    }

    /* compiled from: GcConfigChannelMgr.java */
    @Deprecated
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private static c f1012a = new c();

        public static c a() {
            return f1012a;
        }

        public void b() {
        }
    }

    /* compiled from: HostConfig.java */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public String f1013a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f1014b;

        /* renamed from: c  reason: collision with root package name */
        public String f1015c;
    }

    /* compiled from: HostConfigMgr.java */
    /* loaded from: classes.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        private static e f1016a = new e();

        /* renamed from: b  reason: collision with root package name */
        private Map<String, d> f1017b = Collections.synchronizedMap(new HashMap());

        /* renamed from: c  reason: collision with root package name */
        private String f1018c;

        public static e a() {
            return f1016a;
        }

        public Map<String, d> b() {
            return this.f1017b;
        }

        public void c(String str) {
            JSONObject jSONObject;
            i.c("HostConfigMgr", "host config:" + str);
            if (str != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                    if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("hosts")) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (next != null) {
                                d dVar = new d();
                                JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                                if (jSONObject4 != null) {
                                    dVar.f1015c = next.substring(1);
                                    dVar.f1013a = jSONObject4.getString("host");
                                    JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                    if (jSONArray != null) {
                                        dVar.f1014b = new ArrayList<>();
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            dVar.f1014b.add(jSONArray.getString(i));
                                        }
                                    }
                                }
                                this.f1017b.put(dVar.f1015c + "", dVar);
                            }
                        }
                    }
                    this.f1018c = jSONObject2.getString("timestamp");
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: SystemConfig.java */
    /* loaded from: classes.dex */
    public class f {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SystemConfig.java */
        /* renamed from: b.b.a.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class RunnableC0038a implements Runnable {
            RunnableC0038a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.b.a.b.d.c.e().j();
            }
        }

        public static int a() {
            JSONObject jSONObject;
            String m = b.m();
            if (TextUtils.isEmpty(m)) {
                return 0;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(m);
                if (jSONObject2.has("SYSTEM") && (jSONObject = jSONObject2.getJSONObject("SYSTEM")) != null && jSONObject.has("cdb")) {
                    return jSONObject.getInt("cdb");
                }
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }

        public static void b(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SYSTEM")) {
                    i.c("SystemConfig", "server system config ", str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("SYSTEM");
                    if (optJSONObject != null) {
                        try {
                            if (optJSONObject.has("bg_interval")) {
                                b.n(optJSONObject.getInt("bg_interval") + "");
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (optJSONObject.has("fg_interval")) {
                                b.o(optJSONObject.getInt("fg_interval") + "");
                            }
                        } catch (Throwable unused2) {
                        }
                        i.c("SystemConfig", "UTDC.bSendToNewLogStore:", Boolean.valueOf(a.g));
                        i.c("SystemConfig", "Config.BACKGROUND_PERIOD:", Long.valueOf(b.f()));
                        i.c("SystemConfig", "Config.FOREGROUND_PERIOD:", Long.valueOf(b.a()));
                        try {
                            if (optJSONObject.has("discard")) {
                                int i = optJSONObject.getInt("discard");
                                if (i == 1) {
                                    b.g = true;
                                    b.b.a.b.i.a.d().g();
                                } else if (i == 0) {
                                    b.g = false;
                                    b.b.a.b.i.a.d().f();
                                }
                            } else if (b.g) {
                                b.g = false;
                                b.b.a.b.i.a.d().f();
                            }
                        } catch (Throwable unused3) {
                        }
                        try {
                            if (!optJSONObject.has("cdb") || optJSONObject.getInt("cdb") <= a()) {
                                return;
                            }
                            s.a().g(new RunnableC0038a());
                        } catch (Throwable unused4) {
                        }
                    }
                }
            } catch (Throwable th) {
                i.b("SystemConfig", "updateconfig", th);
            }
        }
    }

    public static b.b.a.b.h.b a() {
        b.b.a.b.h.b bVar = h;
        if (bVar == null || TextUtils.isEmpty(bVar.getAppkey())) {
            if (!i.g()) {
                Log.w("UTDC", "please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            } else {
                throw new RuntimeException("please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            }
        }
        return h;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (context == null) {
                i.a("UTDC", "UTDC init failed ,context:" + context);
                return;
            }
            if (!f1002b) {
                f1002b = true;
                f1001a = context.getApplicationContext();
                b.b.a.b.i.a.d().f();
            }
        }
    }

    public static void c(b.b.a.b.h.b bVar) {
        h = bVar;
        if (bVar != null) {
            b.b.a.b.f.b.j(bVar.getAppkey());
        }
    }

    public static void d(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (f1001a == null) {
            i.a("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
        } else if (h == null) {
            i.a("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
        } else {
            f(str, str2, str3, str4, str5, map);
        }
    }

    public static String e() {
        try {
            return l.f(j())[0];
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    private static void f(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        s.a().g(new RunnableC0037a(str, str2, str3, str4, str5, new HashMap(map)));
    }

    public static String g() {
        try {
            String[] f2 = l.f(j());
            return f2[0].equals("2G/3G") ? f2[1] : "Unknown";
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static String h() {
        return "";
    }

    public static String i() {
        return "";
    }

    public static Context j() {
        return f1001a;
    }

    public static void k() {
        i.c("UTDC", "[onBackground]");
        f1003c = true;
        b.b.a.b.b.a.c();
    }

    public static void l() {
        i.c("UTDC", "[onForeground]");
        f1003c = false;
        b.b.a.b.i.a.d().f();
    }

    public static void m() {
        b.b.a.b.i.a.d().f();
    }

    public static void n(String str) {
        b.b.a.b.f.b.i(str);
    }
}
