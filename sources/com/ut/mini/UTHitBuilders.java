package com.ut.mini;

import android.text.TextUtils;
import b.b.a.b.f.i;
import b.b.a.b.f.q;
import b.b.a.b.g.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class UTHitBuilders {

    /* loaded from: classes.dex */
    public static class UTCustomHitBuilder extends UTHitBuilder {
        public UTCustomHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "19999");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        @Override // com.ut.mini.UTHitBuilders.UTHitBuilder
        public Map<String, String> build() {
            Map<String, String> build = super.build();
            if (build != null) {
                a aVar = a.PAGE;
                String str = build.get(aVar.toString());
                a aVar2 = a.ARG1;
                String str2 = build.get(aVar2.toString());
                if (str2 != null) {
                    build.remove(aVar2.toString());
                    build.remove(aVar.toString());
                    Map<String, String> a2 = q.a(build);
                    a2.put(aVar2.toString(), str2);
                    a2.put(aVar.toString(), str);
                    return a2;
                }
                return build;
            }
            return build;
        }

        public UTCustomHitBuilder setDurationOnEvent(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j);
            return this;
        }

        public UTCustomHitBuilder setEventPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class UTHitBuilder {
        public static final String FIELD_ARG1 = "_field_arg1";
        public static final String FIELD_ARG2 = "_field_arg2";
        public static final String FIELD_ARG3 = "_field_arg3";
        public static final String FIELD_ARGS = "_field_args";
        public static final String FIELD_EVENT_ID = "_field_event_id";
        public static final String FIELD_PAGE = "_field_page";
        private Map<String, String> y;

        public UTHitBuilder() {
            HashMap hashMap = new HashMap();
            this.y = hashMap;
            if (hashMap.containsKey(FIELD_PAGE)) {
                return;
            }
            this.y.put(FIELD_PAGE, "UT");
        }

        private static boolean a(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(null)) {
                    map.remove(null);
                }
                if (map.containsKey("")) {
                    map.remove("");
                }
                if (map.containsKey(a.PAGE.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(a.EVENTID.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(a.ARG1.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(a.ARG2.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(a.ARG3.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else {
                    return true;
                }
            }
            return true;
        }

        private static void d(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(FIELD_PAGE)) {
                    map.remove(FIELD_PAGE);
                    map.put(a.PAGE.toString(), map.get(FIELD_PAGE));
                }
                if (map.containsKey(FIELD_ARG1)) {
                    map.remove(FIELD_ARG1);
                    map.put(a.ARG1.toString(), map.get(FIELD_ARG1));
                }
                if (map.containsKey(FIELD_ARG2)) {
                    map.remove(FIELD_ARG2);
                    map.put(a.ARG2.toString(), map.get(FIELD_ARG2));
                }
                if (map.containsKey(FIELD_ARG3)) {
                    map.remove(FIELD_ARG3);
                    map.put(a.ARG3.toString(), map.get(FIELD_ARG3));
                }
                if (map.containsKey(FIELD_ARGS)) {
                    map.remove(FIELD_ARGS);
                    map.put(a.ARGS.toString(), map.get(FIELD_ARGS));
                }
                if (map.containsKey(FIELD_EVENT_ID)) {
                    map.remove(FIELD_EVENT_ID);
                    map.put(a.EVENTID.toString(), map.get(FIELD_EVENT_ID));
                }
            }
        }

        private static void e(Map<String, String> map) {
            if (map != null) {
                a aVar = a.PAGE;
                if (map.containsKey(aVar.toString())) {
                    map.remove(aVar.toString());
                }
                a aVar2 = a.EVENTID;
                if (map.containsKey(aVar2.toString())) {
                    map.remove(aVar2.toString());
                }
                a aVar3 = a.ARG1;
                if (map.containsKey(aVar3.toString())) {
                    map.remove(aVar3.toString());
                }
                a aVar4 = a.ARG2;
                if (map.containsKey(aVar4.toString())) {
                    map.remove(aVar4.toString());
                }
                a aVar5 = a.ARG3;
                if (map.containsKey(aVar5.toString())) {
                    map.remove(aVar5.toString());
                }
                a aVar6 = a.ARGS;
                if (map.containsKey(aVar6.toString())) {
                    map.remove(aVar6.toString());
                }
            }
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.y);
            if (a(hashMap)) {
                e(hashMap);
                d(hashMap);
                if (hashMap.containsKey(a.EVENTID.toString())) {
                    return hashMap;
                }
                return null;
            }
            return null;
        }

        public String getProperty(String str) {
            if (str == null || !this.y.containsKey(str)) {
                return null;
            }
            return this.y.get(str);
        }

        public UTHitBuilder setProperties(Map<String, String> map) {
            if (map != null) {
                this.y.putAll(map);
            }
            return this;
        }

        public UTHitBuilder setProperty(String str, String str2) {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                if (this.y.containsKey(str)) {
                    this.y.remove(str);
                }
                this.y.put(str, str2);
            } else {
                i.a("setProperty", "key is null or key is empty or value is null,please check it!");
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class UTPageHitBuilder extends UTHitBuilder {
        public UTPageHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2001");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTPageHitBuilder setDurationOnPage(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j);
            return this;
        }

        public UTPageHitBuilder setReferPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class UTControlHitBuilder extends UTHitBuilder {
        public UTControlHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
                if (!TextUtils.isEmpty(currentPageName)) {
                    super.setProperty(UTHitBuilder.FIELD_PAGE, currentPageName);
                    super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
                    super.setProperty(UTHitBuilder.FIELD_ARG1, currentPageName + "_" + str);
                    return;
                }
                throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
            }
            throw new IllegalArgumentException("Control name can not be empty.");
        }

        public UTControlHitBuilder(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    super.setProperty(UTHitBuilder.FIELD_PAGE, str);
                    super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
                    super.setProperty(UTHitBuilder.FIELD_ARG1, str + "_" + str2);
                    return;
                }
                throw new IllegalArgumentException("Page name can not be empty.");
            }
            throw new IllegalArgumentException("Control name can not be empty.");
        }
    }
}
