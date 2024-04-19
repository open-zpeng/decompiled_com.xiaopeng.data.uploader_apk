package a.a.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.xiaopeng.lib.utils.config.RemoteControlConfig;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public class f implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float[] f154a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f155b;

    public f(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min((int) RemoteControlConfig.SERVICE_TYPE_TRANSPORT_MODE_BEGIN, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f154a = new float[min];
            this.f155b = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((i2 * length) / (min - 1), fArr, null);
                this.f154a[i2] = fArr[0];
                this.f155b[i2] = fArr[1];
            }
            if (Math.abs(this.f154a[0]) <= 1.0E-5d && Math.abs(this.f155b[0]) <= 1.0E-5d) {
                int i3 = min - 1;
                if (Math.abs(this.f154a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f155b[i3] - 1.0f) <= 1.0E-5d) {
                    float f = 0.0f;
                    int i4 = 0;
                    while (i < min) {
                        float[] fArr2 = this.f154a;
                        int i5 = i4 + 1;
                        float f2 = fArr2[i4];
                        if (f2 >= f) {
                            fArr2[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f154a[0]);
            sb.append(",");
            sb.append(this.f155b[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.f154a[i6]);
            sb.append(",");
            sb.append(this.f155b[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void c(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (a.a.c.a.c.g.h(xmlPullParser, "pathData")) {
            String g = a.a.c.a.c.g.g(typedArray, xmlPullParser, "pathData", 4);
            Path e = a.a.c.b.b.e(g);
            if (e != null) {
                b(e);
                return;
            }
            throw new InflateException("The path is null, which is created from " + g);
        } else if (a.a.c.a.c.g.h(xmlPullParser, "controlX1")) {
            if (a.a.c.a.c.g.h(xmlPullParser, "controlY1")) {
                float d2 = a.a.c.a.c.g.d(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
                float d3 = a.a.c.a.c.g.d(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
                boolean h = a.a.c.a.c.g.h(xmlPullParser, "controlX2");
                if (h != a.a.c.a.c.g.h(xmlPullParser, "controlY2")) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                }
                if (!h) {
                    c(d2, d3);
                    return;
                } else {
                    a(d2, d3, a.a.c.a.c.g.d(typedArray, xmlPullParser, "controlX2", 2, 0.0f), a.a.c.a.c.g.d(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
                    return;
                }
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        } else {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f154a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f154a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f154a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f155b[i];
        }
        float[] fArr2 = this.f155b;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }

    public f(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray i = a.a.c.a.c.g.i(resources, theme, attributeSet, a.l);
        d(i, xmlPullParser);
        i.recycle();
    }
}
