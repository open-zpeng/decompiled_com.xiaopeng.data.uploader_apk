package a.a.b.a;

import a.a.c.b.b;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class h extends a.a.b.a.g {

    /* renamed from: c  reason: collision with root package name */
    static final PorterDuff.Mode f157c = PorterDuff.Mode.SRC_IN;

    /* renamed from: d  reason: collision with root package name */
    private C0001h f158d;
    private PorterDuffColorFilter e;
    private ColorFilter f;
    private boolean g;
    private boolean h;
    private Drawable.ConstantState i;
    private final float[] j;
    private final Matrix k;
    private final Rect l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        private void f(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f165b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f164a = a.a.c.b.b.d(string2);
            }
        }

        @Override // a.a.b.a.h.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (a.a.c.a.c.g.h(xmlPullParser, "pathData")) {
                TypedArray i = a.a.c.a.c.g.i(resources, theme, attributeSet, a.a.b.a.a.f143d);
                f(i);
                i.recycle();
            }
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.a.b.a.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0001h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f171a;

        /* renamed from: b  reason: collision with root package name */
        g f172b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f173c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f174d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public C0001h(C0001h c0001h) {
            this.f173c = null;
            this.f174d = h.f157c;
            if (c0001h != null) {
                this.f171a = c0001h.f171a;
                g gVar = new g(c0001h.f172b);
                this.f172b = gVar;
                Paint paint = c0001h.f172b.f;
                if (paint != null) {
                    gVar.f = new Paint(paint);
                }
                Paint paint2 = c0001h.f172b.e;
                if (paint2 != null) {
                    this.f172b.e = new Paint(paint2);
                }
                this.f173c = c0001h.f173c;
                this.f174d = c0001h.f174d;
                this.e = c0001h.e;
            }
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.f173c && this.h == this.f174d && this.j == this.e && this.i == this.f172b.getRootAlpha();
        }

        public void c(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (f() || colorFilter != null) {
                if (this.l == null) {
                    Paint paint = new Paint();
                    this.l = paint;
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.f172b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean f() {
            return this.f172b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f172b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f171a;
        }

        public boolean h(int[] iArr) {
            boolean g = this.f172b.g(iArr);
            this.k |= g;
            return g;
        }

        public void i() {
            this.g = this.f173c;
            this.h = this.f174d;
            this.i = this.f172b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public void j(int i, int i2) {
            this.f.eraseColor(0);
            this.f172b.b(new Canvas(this.f), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }

        public C0001h() {
            this.f173c = null;
            this.f174d = h.f157c;
            this.f172b = new g();
        }
    }

    h() {
        this.h = true;
        this.j = new float[9];
        this.k = new Matrix();
        this.l = new Rect();
        this.f158d = new C0001h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static h b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            h hVar = new h();
            Drawable a2 = a.a.c.a.c.f.a(resources, i2, theme);
            hVar.f156b = a2;
            hVar.i = new i(a2.getConstantState());
            return hVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0001h c0001h = this.f158d;
        g gVar = c0001h.f172b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f161b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.q.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    c0001h.f171a = cVar.f166c | c0001h.f171a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f161b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.q.put(bVar.getPathName(), bVar);
                    }
                    c0001h.f171a = bVar.f166c | c0001h.f171a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f161b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.q.put(dVar2.getGroupName(), dVar2);
                    }
                    c0001h.f171a = dVar2.k | c0001h.f171a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && android.support.v4.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C0001h c0001h = this.f158d;
        g gVar = c0001h.f172b;
        c0001h.f174d = g(a.a.c.a.c.g.e(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0001h.f173c = colorStateList;
        }
        c0001h.e = a.a.c.a.c.g.a(typedArray, xmlPullParser, "autoMirrored", 5, c0001h.e);
        gVar.l = a.a.c.a.c.g.d(typedArray, xmlPullParser, "viewportWidth", 7, gVar.l);
        float d2 = a.a.c.a.c.g.d(typedArray, xmlPullParser, "viewportHeight", 8, gVar.m);
        gVar.m = d2;
        if (gVar.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (d2 > 0.0f) {
            gVar.j = typedArray.getDimension(3, gVar.j);
            float dimension = typedArray.getDimension(2, gVar.k);
            gVar.k = dimension;
            if (gVar.j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(a.a.c.a.c.g.d(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.o = string;
                    gVar.q.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.b(drawable);
            return false;
        }
        return false;
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f158d.f172b.q.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.l);
        if (this.l.width() <= 0 || this.l.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f;
        if (colorFilter == null) {
            colorFilter = this.e;
        }
        canvas.getMatrix(this.k);
        this.k.getValues(this.j);
        float abs = Math.abs(this.j[0]);
        float abs2 = Math.abs(this.j[4]);
        float abs3 = Math.abs(this.j[1]);
        float abs4 = Math.abs(this.j[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.l.width() * abs));
        int min2 = Math.min(2048, (int) (this.l.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.l;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.l.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.l.offsetTo(0, 0);
        this.f158d.c(min, min2);
        if (!this.h) {
            this.f158d.j(min, min2);
        } else if (!this.f158d.b()) {
            this.f158d.j(min, min2);
            this.f158d.i();
        }
        this.f158d.d(canvas, colorFilter, this.l);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.c(drawable);
        }
        return this.f158d.f172b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f158d.getChangingConfigurations();
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f156b;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new i(drawable.getConstantState());
        }
        this.f158d.f171a = getChangingConfigurations();
        return this.f158d;
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f158d.f172b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f158d.f172b.j;
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z) {
        this.h = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.g(drawable);
        }
        return this.f158d.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0001h c0001h;
        ColorStateList colorStateList;
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((c0001h = this.f158d) != null && (c0001h.g() || ((colorStateList = this.f158d.f173c) != null && colorStateList.isStateful())));
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.g && super.mutate() == this) {
            this.f158d = new C0001h(this.f158d);
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0001h c0001h = this.f158d;
        ColorStateList colorStateList = c0001h.f173c;
        if (colorStateList != null && (mode = c0001h.f174d) != null) {
            this.e = updateTintFilter(this.e, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (c0001h.g() && c0001h.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f158d.f172b.getRootAlpha() != i2) {
            this.f158d.f172b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.i(drawable, z);
        } else {
            this.f158d.e = z;
        }
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.l(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.m(drawable, colorStateList);
            return;
        }
        C0001h c0001h = this.f158d;
        if (c0001h.f173c != colorStateList) {
            c0001h.f173c = colorStateList;
            this.e = updateTintFilter(this.e, colorStateList, c0001h.f174d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.n(drawable, mode);
            return;
        }
        C0001h c0001h = this.f158d;
        if (c0001h.f174d != mode) {
            c0001h.f174d = mode;
            this.e = updateTintFilter(this.e, c0001h.f173c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected b.C0005b[] f164a;

        /* renamed from: b  reason: collision with root package name */
        String f165b;

        /* renamed from: c  reason: collision with root package name */
        int f166c;

        public f() {
            super();
            this.f164a = null;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            b.C0005b[] c0005bArr = this.f164a;
            if (c0005bArr != null) {
                b.C0005b.e(c0005bArr, path);
            }
        }

        public b.C0005b[] getPathData() {
            return this.f164a;
        }

        public String getPathName() {
            return this.f165b;
        }

        public void setPathData(b.C0005b[] c0005bArr) {
            if (!a.a.c.b.b.b(this.f164a, c0005bArr)) {
                this.f164a = a.a.c.b.b.f(c0005bArr);
            } else {
                a.a.c.b.b.j(this.f164a, c0005bArr);
            }
        }

        public f(f fVar) {
            super();
            this.f164a = null;
            this.f165b = fVar.f165b;
            this.f166c = fVar.f166c;
            this.f164a = a.a.c.b.b.f(fVar.f164a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f175a;

        public i(Drawable.ConstantState constantState) {
            this.f175a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f175a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f175a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h();
            hVar.f156b = (VectorDrawable) this.f175a.newDrawable();
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.f156b = (VectorDrawable) this.f175a.newDrawable(resources);
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.f156b = (VectorDrawable) this.f175a.newDrawable(resources, theme);
            return hVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0001h c0001h = this.f158d;
        c0001h.f172b = new g();
        TypedArray i2 = a.a.c.a.c.g.i(resources, theme, attributeSet, a.a.b.a.a.f140a);
        i(i2, xmlPullParser);
        i2.recycle();
        c0001h.f171a = getChangingConfigurations();
        c0001h.k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.e = updateTintFilter(this.e, c0001h.f173c, c0001h.f174d);
    }

    h(C0001h c0001h) {
        this.h = true;
        this.j = new float[9];
        this.k = new Matrix();
        this.l = new Rect();
        this.f158d = c0001h;
        this.e = updateTintFilter(this.e, c0001h.f173c, c0001h.f174d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: d  reason: collision with root package name */
        private int[] f159d;
        a.a.c.a.c.b e;
        float f;
        a.a.c.a.c.b g;
        float h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public c() {
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap e(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f159d = null;
            if (a.a.c.a.c.g.h(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f165b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f164a = a.a.c.b.b.d(string2);
                }
                this.g = a.a.c.a.c.g.c(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = a.a.c.a.c.g.d(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = e(a.a.c.a.c.g.e(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(a.a.c.a.c.g.e(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = a.a.c.a.c.g.d(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.e = a.a.c.a.c.g.c(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.h = a.a.c.a.c.g.d(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = a.a.c.a.c.g.d(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = a.a.c.a.c.g.d(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = a.a.c.a.c.g.d(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = a.a.c.a.c.g.d(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = a.a.c.a.c.g.e(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        @Override // a.a.b.a.h.e
        public boolean a() {
            return this.g.i() || this.e.i();
        }

        @Override // a.a.b.a.h.e
        public boolean b(int[] iArr) {
            return this.e.j(iArr) | this.g.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i = a.a.c.a.c.g.i(resources, theme, attributeSet, a.a.b.a.a.f142c);
            h(i, xmlPullParser, theme);
            i.recycle();
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.g.e();
        }

        float getStrokeAlpha() {
            return this.h;
        }

        int getStrokeColor() {
            return this.e.e();
        }

        float getStrokeWidth() {
            return this.f;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.g.k(i);
        }

        void setStrokeAlpha(float f) {
            this.h = f;
        }

        void setStrokeColor(int i) {
            this.e.k(i);
        }

        void setStrokeWidth(float f) {
            this.f = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }

        public c(c cVar) {
            super(cVar);
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f159d = cVar.f159d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.h = cVar.h;
            this.g = cVar.g;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private static final Matrix f167a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final Path f168b;

        /* renamed from: c  reason: collision with root package name */
        private final Path f169c;

        /* renamed from: d  reason: collision with root package name */
        private final Matrix f170d;
        Paint e;
        Paint f;
        private PathMeasure g;
        private int h;
        final d i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final a.a.c.g.a<String, Object> q;

        public g() {
            this.f170d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.a.c.g.a<>();
            this.i = new d();
            this.f168b = new Path();
            this.f169c = new Path();
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.f160a.set(matrix);
            dVar.f160a.preConcat(dVar.j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.f161b.size(); i3++) {
                e eVar = dVar.f161b.get(i3);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f160a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.l;
            float f2 = i2 / this.m;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.f160a;
            this.f170d.set(matrix);
            this.f170d.postScale(f, f2);
            float e = e(matrix);
            if (e == 0.0f) {
                return;
            }
            fVar.d(this.f168b);
            Path path = this.f168b;
            this.f169c.reset();
            if (fVar.c()) {
                this.f169c.addPath(path, this.f170d);
                canvas.clipPath(this.f169c);
                return;
            }
            c cVar = (c) fVar;
            float f3 = cVar.k;
            if (f3 != 0.0f || cVar.l != 1.0f) {
                float f4 = cVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (cVar.l + f4) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.f168b, false);
                float length = this.g.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.g.getSegment(f7, length, path, true);
                    this.g.getSegment(0.0f, f8, path, true);
                } else {
                    this.g.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f169c.addPath(path, this.f170d);
            if (cVar.g.l()) {
                a.a.c.a.c.b bVar = cVar.g;
                if (this.f == null) {
                    Paint paint = new Paint(1);
                    this.f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f;
                if (bVar.h()) {
                    Shader f9 = bVar.f();
                    f9.setLocalMatrix(this.f170d);
                    paint2.setShader(f9);
                    paint2.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint2.setColor(h.a(bVar.e(), cVar.j));
                }
                paint2.setColorFilter(colorFilter);
                this.f169c.setFillType(cVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f169c, paint2);
            }
            if (cVar.e.l()) {
                a.a.c.a.c.b bVar2 = cVar.e;
                if (this.e == null) {
                    Paint paint3 = new Paint(1);
                    this.e = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.e;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (bVar2.h()) {
                    Shader f10 = bVar2.f();
                    f10.setLocalMatrix(this.f170d);
                    paint4.setShader(f10);
                    paint4.setAlpha(Math.round(cVar.h * 255.0f));
                } else {
                    paint4.setColor(h.a(bVar2.e(), cVar.h));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f * min * e);
                canvas.drawPath(this.f169c, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c(this.i, f167a, canvas, i, i2, colorFilter);
        }

        public boolean f() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.i.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.n = i;
        }

        public g(g gVar) {
            this.f170d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            a.a.c.g.a<String, Object> aVar = new a.a.c.g.a<>();
            this.q = aVar;
            this.i = new d(gVar.i, aVar);
            this.f168b = new Path(gVar.f168b);
            this.f169c = new Path(gVar.f169c);
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.m = gVar.m;
            this.h = gVar.h;
            this.n = gVar.n;
            this.o = gVar.o;
            String str = gVar.o;
            if (str != null) {
                aVar.put(str, this);
            }
            this.p = gVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f160a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f161b;

        /* renamed from: c  reason: collision with root package name */
        float f162c;

        /* renamed from: d  reason: collision with root package name */
        private float f163d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d(d dVar, a.a.c.g.a<String, Object> aVar) {
            super();
            f bVar;
            this.f160a = new Matrix();
            this.f161b = new ArrayList<>();
            this.f162c = 0.0f;
            this.f163d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.f162c = dVar.f162c;
            this.f163d = dVar.f163d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<e> arrayList = dVar.f161b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.f161b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f161b.add(bVar);
                    String str2 = bVar.f165b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-this.f163d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f162c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f163d, this.i + this.e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f162c = a.a.c.a.c.g.d(typedArray, xmlPullParser, "rotation", 5, this.f162c);
            this.f163d = typedArray.getFloat(1, this.f163d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = a.a.c.a.c.g.d(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = a.a.c.a.c.g.d(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = a.a.c.a.c.g.d(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = a.a.c.a.c.g.d(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // a.a.b.a.h.e
        public boolean a() {
            for (int i = 0; i < this.f161b.size(); i++) {
                if (this.f161b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.a.b.a.h.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f161b.size(); i++) {
                z |= this.f161b.get(i).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i = a.a.c.a.c.g.i(resources, theme, attributeSet, a.a.b.a.a.f141b);
            e(i, xmlPullParser);
            i.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f163d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f162c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.f163d) {
                this.f163d = f;
                d();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                d();
            }
        }

        public void setRotation(float f) {
            if (f != this.f162c) {
                this.f162c = f;
                d();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                d();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                d();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                d();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                d();
            }
        }

        public d() {
            super();
            this.f160a = new Matrix();
            this.f161b = new ArrayList<>();
            this.f162c = 0.0f;
            this.f163d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }
}
