package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import b.b.a.b.f.i;
import b.b.a.b.f.q;
import b.b.a.b.g.a;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UTTracker {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f1845a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private String g;
    private String aq = null;
    private Map<String, String> D = new HashMap();

    private static String b(String str) {
        return d(str);
    }

    private static String d(String str) {
        return (str == null || "".equals(str)) ? str : f1845a.matcher(str).replaceAll("");
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            a aVar = a.IMEI;
            if (map.containsKey(aVar.toString())) {
                map.remove(aVar.toString());
            }
            a aVar2 = a.IMSI;
            if (map.containsKey(aVar2.toString())) {
                map.remove(aVar2.toString());
            }
            a aVar3 = a.CARRIER;
            if (map.containsKey(aVar3.toString())) {
                map.remove(aVar3.toString());
            }
            a aVar4 = a.ACCESS;
            if (map.containsKey(aVar4.toString())) {
                map.remove(aVar4.toString());
            }
            a aVar5 = a.ACCESS_SUBTYPE;
            if (map.containsKey(aVar5.toString())) {
                map.remove(aVar5.toString());
            }
            a aVar6 = a.CHANNEL;
            if (map.containsKey(aVar6.toString())) {
                map.remove(aVar6.toString());
            }
            a aVar7 = a.LL_USERNICK;
            if (map.containsKey(aVar7.toString())) {
                map.remove(aVar7.toString());
            }
            a aVar8 = a.USERNICK;
            if (map.containsKey(aVar8.toString())) {
                map.remove(aVar8.toString());
            }
            a aVar9 = a.LL_USERID;
            if (map.containsKey(aVar9.toString())) {
                map.remove(aVar9.toString());
            }
            a aVar10 = a.USERID;
            if (map.containsKey(aVar10.toString())) {
                map.remove(aVar10.toString());
            }
            a aVar11 = a.SDKVERSION;
            if (map.containsKey(aVar11.toString())) {
                map.remove(aVar11.toString());
            }
            a aVar12 = a.START_SESSION_TIMESTAMP;
            if (map.containsKey(aVar12.toString())) {
                map.remove(aVar12.toString());
            }
            a aVar13 = a.UTDID;
            if (map.containsKey(aVar13.toString())) {
                map.remove(aVar13.toString());
            }
            a aVar14 = a.SDKTYPE;
            if (map.containsKey(aVar14.toString())) {
                map.remove(aVar14.toString());
            }
            a aVar15 = a.RESERVE2;
            if (map.containsKey(aVar15.toString())) {
                map.remove(aVar15.toString());
            }
            a aVar16 = a.RESERVE3;
            if (map.containsKey(aVar16.toString())) {
                map.remove(aVar16.toString());
            }
            a aVar17 = a.RESERVE4;
            if (map.containsKey(aVar17.toString())) {
                map.remove(aVar17.toString());
            }
            a aVar18 = a.RESERVE5;
            if (map.containsKey(aVar18.toString())) {
                map.remove(aVar18.toString());
            }
            a aVar19 = a.RESERVES;
            if (map.containsKey(aVar19.toString())) {
                map.remove(aVar19.toString());
            }
            a aVar20 = a.RECORD_TIMESTAMP;
            if (map.containsKey(aVar20.toString())) {
                map.remove(aVar20.toString());
            }
        }
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = map.keySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        hashMap.put(next, b(map.get(next)));
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    private static void h(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(a.RESERVES.toString(), q.c(hashMap));
        }
        a aVar = a.PAGE;
        if (map.containsKey(aVar.toString())) {
            return;
        }
        map.put(aVar.toString(), "UT");
    }

    public synchronized String getGlobalProperty(String str) {
        if (str != null) {
            return this.D.get(str);
        }
        return null;
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        this.aq = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(String str) {
        this.g = str;
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.D.containsKey(str)) {
                this.D.remove(str);
            }
        }
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.D);
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(a.APPKEY.toString(), this.g);
            }
            Map<String, String> g = g((Map<String, String>) hashMap);
            if (!TextUtils.isEmpty(this.aq)) {
                g.put(UTFields.TRACK_ID, this.aq);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(g);
            d(g);
            m70g(g);
            h(g);
            b.b.a.b.a.d(g.remove(a.PAGE.toString()), g.remove(a.EVENTID.toString()), g.remove(a.ARG1.toString()), g.remove(a.ARG2.toString()), g.remove(a.ARG3.toString()), g);
        }
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.D.put(str, str2);
        } else {
            i.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        }
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(UTFields.OS)) {
                map.remove(UTFields.OS);
                map.put(a.OS.toString(), map.get(UTFields.OS));
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                map.remove(UTFields.OS_VERSION);
                map.put(a.OSVERSION.toString(), map.get(UTFields.OS_VERSION));
            }
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private static void m70g(Map<String, String> map) {
        map.put(a.SDKTYPE.toString(), "mini");
    }
}
