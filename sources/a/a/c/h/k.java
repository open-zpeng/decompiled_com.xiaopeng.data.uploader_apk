package a.a.c.h;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f318a;

    /* renamed from: b  reason: collision with root package name */
    private int f319b;

    public k(ViewGroup viewGroup) {
        this.f318a = viewGroup;
    }

    public int a() {
        return this.f319b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        this.f319b = i;
    }

    public void d(View view, int i) {
        this.f319b = 0;
    }
}
