package a.a.c.a.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0003c[] f192a;

        public b(C0003c[] c0003cArr) {
            this.f192a = c0003cArr;
        }

        public C0003c[] a() {
            return this.f192a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.a.c.a.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0003c {

        /* renamed from: a  reason: collision with root package name */
        private final String f193a;

        /* renamed from: b  reason: collision with root package name */
        private int f194b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f195c;

        /* renamed from: d  reason: collision with root package name */
        private String f196d;
        private int e;
        private int f;

        public C0003c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f193a = str;
            this.f194b = i;
            this.f195c = z;
            this.f196d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.f193a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.f196d;
        }

        public int e() {
            return this.f194b;
        }

        public boolean f() {
            return this.f195c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final a.a.c.e.a f197a;

        /* renamed from: b  reason: collision with root package name */
        private final int f198b;

        /* renamed from: c  reason: collision with root package name */
        private final int f199c;

        public d(a.a.c.e.a aVar, int i, int i2) {
            this.f197a = aVar;
            this.f199c = i;
            this.f198b = i2;
        }

        public int a() {
            return this.f199c;
        }

        public a.a.c.e.a b() {
            return this.f197a;
        }

        public int c() {
            return this.f198b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.a.a.b.e);
        String string = obtainAttributes.getString(a.a.a.b.f);
        String string2 = obtainAttributes.getString(a.a.a.b.j);
        String string3 = obtainAttributes.getString(a.a.a.b.k);
        int resourceId = obtainAttributes.getResourceId(a.a.a.b.g, 0);
        int integer = obtainAttributes.getInteger(a.a.a.b.h, 1);
        int integer2 = obtainAttributes.getInteger(a.a.a.b.i, IInputController.KEYCODE_KNOB_WIND_SPD_UP);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new a.a.c.e.a(string, string2, string3, c(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0003c[]) arrayList.toArray(new C0003c[arrayList.size()]));
    }

    private static C0003c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.a.a.b.l);
        int i = a.a.a.b.u;
        if (!obtainAttributes.hasValue(i)) {
            i = a.a.a.b.n;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = a.a.a.b.s;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = a.a.a.b.o;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = a.a.a.b.v;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = a.a.a.b.p;
        }
        int i5 = a.a.a.b.t;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = a.a.a.b.q;
        }
        String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = a.a.a.b.r;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = a.a.a.b.m;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0003c(string2, i2, z, string, i6, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
