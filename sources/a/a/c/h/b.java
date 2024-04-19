package a.a.c.h;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final View.AccessibilityDelegate f308a = new View.AccessibilityDelegate();

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f309b = new a(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* loaded from: classes.dex */
    private static final class a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final b f310a;

        a(b bVar) {
            this.f310a = bVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f310a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            a.a.c.h.q.b b2 = this.f310a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f310a.d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f310a.e(view, a.a.c.h.q.a.x(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f310a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f310a.g(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f310a.h(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f310a.i(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f310a.j(view, accessibilityEvent);
        }
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return f308a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public a.a.c.h.q.b b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = f308a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new a.a.c.h.q.b(accessibilityNodeProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate c() {
        return this.f309b;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        f308a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void e(View view, a.a.c.h.q.a aVar) {
        f308a.onInitializeAccessibilityNodeInfo(view, aVar.w());
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        f308a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean g(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f308a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean h(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return f308a.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }

    public void i(View view, int i) {
        f308a.sendAccessibilityEvent(view, i);
    }

    public void j(View view, AccessibilityEvent accessibilityEvent) {
        f308a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
