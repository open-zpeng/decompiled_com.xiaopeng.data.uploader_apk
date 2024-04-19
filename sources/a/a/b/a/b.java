package a.a.b.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class b extends g implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    private C0000b f144c;

    /* renamed from: d  reason: collision with root package name */
    private Context f145d;
    private ArgbEvaluator e;
    private Animator.AnimatorListener f;
    ArrayList<?> g;
    final Drawable.Callback h;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.a.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0000b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f147a;

        /* renamed from: b  reason: collision with root package name */
        h f148b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f149c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f150d;
        a.a.c.g.a<Animator, String> e;

        public C0000b(Context context, C0000b c0000b, Drawable.Callback callback, Resources resources) {
            if (c0000b != null) {
                this.f147a = c0000b.f147a;
                h hVar = c0000b.f148b;
                if (hVar != null) {
                    Drawable.ConstantState constantState = hVar.getConstantState();
                    if (resources != null) {
                        this.f148b = (h) constantState.newDrawable(resources);
                    } else {
                        this.f148b = (h) constantState.newDrawable();
                    }
                    h hVar2 = (h) this.f148b.mutate();
                    this.f148b = hVar2;
                    hVar2.setCallback(callback);
                    this.f148b.setBounds(c0000b.f148b.getBounds());
                    this.f148b.h(false);
                }
                ArrayList<Animator> arrayList = c0000b.f150d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f150d = new ArrayList<>(size);
                    this.e = new a.a.c.g.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0000b.f150d.get(i);
                        Animator clone = animator.clone();
                        String str = c0000b.e.get(animator);
                        clone.setTarget(this.f148b.d(str));
                        this.f150d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f149c == null) {
                this.f149c = new AnimatorSet();
            }
            this.f149c.playTogether(this.f150d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f147a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    b() {
        this(null, null, null);
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f144c.f148b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        C0000b c0000b = this.f144c;
        if (c0000b.f150d == null) {
            c0000b.f150d = new ArrayList<>();
            this.f144c.e = new a.a.c.g.a<>();
        }
        this.f144c.f150d.add(animator);
        this.f144c.e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                c(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.e == null) {
                    this.e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.e);
            }
        }
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f144c.f148b.draw(canvas);
        if (this.f144c.f149c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.c(drawable);
        }
        return this.f144c.f148b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f144c.f147a;
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f156b;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(drawable.getConstantState());
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
        return this.f144c.f148b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f144c.f148b.getIntrinsicWidth();
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
        return this.f144c.f148b.getOpacity();
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

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray i = a.a.c.a.c.g.i(resources, theme, attributeSet, a.a.b.a.a.e);
                    int resourceId = i.getResourceId(0, 0);
                    if (resourceId != 0) {
                        h b2 = h.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.h);
                        h hVar = this.f144c.f148b;
                        if (hVar != null) {
                            hVar.setCallback(null);
                        }
                        this.f144c.f148b = b2;
                    }
                    i.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.a.b.a.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f145d;
                        if (context != null) {
                            b(string, d.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f144c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.g(drawable);
        }
        return this.f144c.f148b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f144c.f149c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f144c.f148b.isStateful();
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
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f144c.f148b.setBounds(rect);
        }
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f144c.f148b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f144c.f148b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f144c.f148b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.i(drawable, z);
        } else {
            this.f144c.f148b.setAutoMirrored(z);
        }
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // a.a.b.a.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.l(drawable, i);
        } else {
            this.f144c.f148b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.m(drawable, colorStateList);
        } else {
            this.f144c.f148b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.n(drawable, mode);
        } else {
            this.f144c.f148b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f144c.f148b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f144c.f149c.isStarted()) {
        } else {
            this.f144c.f149c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f144c.f149c.end();
        }
    }

    private b(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f156b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f144c.f148b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f151a;

        public c(Drawable.ConstantState constantState) {
            this.f151a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f151a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f151a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.f151a.newDrawable();
            bVar.f156b = newDrawable;
            newDrawable.setCallback(bVar.h);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.f151a.newDrawable(resources);
            bVar.f156b = newDrawable;
            newDrawable.setCallback(bVar.h);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.f151a.newDrawable(resources, theme);
            bVar.f156b = newDrawable;
            newDrawable.setCallback(bVar.h);
            return bVar;
        }
    }

    private b(Context context, C0000b c0000b, Resources resources) {
        this.e = null;
        this.f = null;
        this.g = null;
        a aVar = new a();
        this.h = aVar;
        this.f145d = context;
        if (c0000b != null) {
            this.f144c = c0000b;
        } else {
            this.f144c = new C0000b(context, c0000b, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
