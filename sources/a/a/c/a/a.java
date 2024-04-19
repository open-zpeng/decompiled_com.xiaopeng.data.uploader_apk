package a.a.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
/* compiled from: ContextCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f176a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static TypedValue f177b;

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static Drawable b(Context context, int i) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            return context.getDrawable(i);
        }
        if (i3 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f176a) {
            if (f177b == null) {
                f177b = new TypedValue();
            }
            context.getResources().getValue(i, f177b, true);
            i2 = f177b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }
}
