package a.a.d.d;

import a.a.d.a.i;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class c extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f382a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f383b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f384c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f385d;
    private Resources e;

    public c(Context context, int i) {
        super(context);
        this.f382a = i;
    }

    private Resources a() {
        if (this.e == null) {
            Configuration configuration = this.f385d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    private void b() {
        boolean z = this.f383b == null;
        if (z) {
            this.f383b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f383b.setTo(theme);
            }
        }
        c(this.f383b, this.f382a, z);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    protected void c(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f384c == null) {
                this.f384c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f384c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f383b;
        if (theme != null) {
            return theme;
        }
        if (this.f382a == 0) {
            this.f382a = i.f354b;
        }
        b();
        return this.f383b;
    }

    public int getThemeResId() {
        return this.f382a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f382a != i) {
            this.f382a = i;
            b();
        }
    }

    public c(Context context, Resources.Theme theme) {
        super(context);
        this.f383b = theme;
    }
}
