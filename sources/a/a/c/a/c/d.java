package a.a.c.a.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
public final class d {
    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i, i3, i2);
        }
        return new a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray i = g.i(resources, theme, attributeSet, a.a.a.b.w);
            float d2 = g.d(i, xmlPullParser, "startX", a.a.a.b.F, 0.0f);
            float d3 = g.d(i, xmlPullParser, "startY", a.a.a.b.G, 0.0f);
            float d4 = g.d(i, xmlPullParser, "endX", a.a.a.b.H, 0.0f);
            float d5 = g.d(i, xmlPullParser, "endY", a.a.a.b.I, 0.0f);
            float d6 = g.d(i, xmlPullParser, "centerX", a.a.a.b.A, 0.0f);
            float d7 = g.d(i, xmlPullParser, "centerY", a.a.a.b.B, 0.0f);
            int e = g.e(i, xmlPullParser, "type", a.a.a.b.z, 0);
            int b2 = g.b(i, xmlPullParser, "startColor", a.a.a.b.x, 0);
            boolean h = g.h(xmlPullParser, "centerColor");
            int b3 = g.b(i, xmlPullParser, "centerColor", a.a.a.b.E, 0);
            int b4 = g.b(i, xmlPullParser, "endColor", a.a.a.b.y, 0);
            int e2 = g.e(i, xmlPullParser, "tileMode", a.a.a.b.D, 0);
            float d8 = g.d(i, xmlPullParser, "gradientRadius", a.a.a.b.C, 0.0f);
            i.recycle();
            a a2 = a(c(resources, xmlPullParser, attributeSet, theme), b2, b4, h, b3);
            if (e != 1) {
                if (e != 2) {
                    return new LinearGradient(d2, d3, d4, d5, a2.f200a, a2.f201b, d(e2));
                }
                return new SweepGradient(d6, d7, a2.f200a, a2.f201b);
            } else if (d8 > 0.0f) {
                return new RadialGradient(d6, d7, d8, a2.f200a, a2.f201b, d(e2));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static a.a.c.a.c.d.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L86
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L86
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = a.a.a.b.J
            android.content.res.TypedArray r3 = a.a.c.a.c.g.i(r9, r12, r11, r3)
            int r5 = a.a.a.b.K
            boolean r6 = r3.hasValue(r5)
            int r7 = a.a.a.b.L
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' "
            r11.append(r10)
            java.lang.String r10 = "attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L86:
            int r9 = r4.size()
            if (r9 <= 0) goto L92
            a.a.c.a.c.d$a r9 = new a.a.c.a.c.d$a
            r9.<init>(r4, r2)
            return r9
        L92:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.c.a.c.d.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):a.a.c.a.c.d$a");
    }

    private static Shader.TileMode d(int i) {
        if (i != 1) {
            if (i != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f200a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f201b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f200a = new int[size];
            this.f201b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f200a[i] = list.get(i).intValue();
                this.f201b[i] = list2.get(i).floatValue();
            }
        }

        a(int i, int i2) {
            this.f200a = new int[]{i, i2};
            this.f201b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.f200a = new int[]{i, i2, i3};
            this.f201b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
