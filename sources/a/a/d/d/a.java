package a.a.d.d;

import a.a.d.a.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f381a;

    private a(Context context) {
        this.f381a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int b() {
        return this.f381a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f381a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i <= 960 || i2 <= 720) {
            if (i <= 720 || i2 <= 960) {
                if (i < 500) {
                    if (i <= 640 || i2 <= 480) {
                        if (i <= 480 || i2 <= 640) {
                            return i >= 360 ? 3 : 2;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 4;
            }
            return 5;
        }
        return 5;
    }

    public int d() {
        return this.f381a.getResources().getDimensionPixelSize(a.a.d.a.d.f339b);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f381a.obtainStyledAttributes(null, j.f355a, a.a.d.a.a.f335c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.i, 0);
        Resources resources = this.f381a.getResources();
        if (!f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.a.d.a.d.f338a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.f381a.getResources().getBoolean(a.a.d.a.b.f337a);
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f381a).hasPermanentMenuKey();
    }
}
