package a.a.c.h.q;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import brave.internal.InternalPropagation;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f325a;

    /* renamed from: b  reason: collision with root package name */
    public int f326b = -1;

    private a(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f325a = accessibilityNodeInfo;
    }

    private static String b(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case InternalPropagation.FLAG_LOCAL_ROOT /* 64 */:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case IRadioController.TEF663x_PCHANNEL /* 256 */:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case OSSConstants.DEFAULT_STREAM_BUFFER_SIZE /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static a x(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new a(accessibilityNodeInfo);
    }

    public void a(int i) {
        this.f325a.addAction(i);
    }

    public int c() {
        return this.f325a.getActions();
    }

    public void d(Rect rect) {
        this.f325a.getBoundsInParent(rect);
    }

    public void e(Rect rect) {
        this.f325a.getBoundsInScreen(rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f325a;
            if (accessibilityNodeInfo == null) {
                if (aVar.f325a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(aVar.f325a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public CharSequence f() {
        return this.f325a.getClassName();
    }

    public CharSequence g() {
        return this.f325a.getContentDescription();
    }

    public CharSequence h() {
        return this.f325a.getPackageName();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f325a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public CharSequence i() {
        return this.f325a.getText();
    }

    public String j() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f325a.getViewIdResourceName();
        }
        return null;
    }

    public boolean k() {
        return this.f325a.isCheckable();
    }

    public boolean l() {
        return this.f325a.isChecked();
    }

    public boolean m() {
        return this.f325a.isClickable();
    }

    public boolean n() {
        return this.f325a.isEnabled();
    }

    public boolean o() {
        return this.f325a.isFocusable();
    }

    public boolean p() {
        return this.f325a.isFocused();
    }

    public boolean q() {
        return this.f325a.isLongClickable();
    }

    public boolean r() {
        return this.f325a.isPassword();
    }

    public boolean s() {
        return this.f325a.isScrollable();
    }

    public boolean t() {
        return this.f325a.isSelected();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        d(rect);
        sb.append("; boundsInParent: " + rect);
        e(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(h());
        sb.append("; className: ");
        sb.append(f());
        sb.append("; text: ");
        sb.append(i());
        sb.append("; contentDescription: ");
        sb.append(g());
        sb.append("; viewId: ");
        sb.append(j());
        sb.append("; checkable: ");
        sb.append(k());
        sb.append("; checked: ");
        sb.append(l());
        sb.append("; focusable: ");
        sb.append(o());
        sb.append("; focused: ");
        sb.append(p());
        sb.append("; selected: ");
        sb.append(t());
        sb.append("; clickable: ");
        sb.append(m());
        sb.append("; longClickable: ");
        sb.append(q());
        sb.append("; enabled: ");
        sb.append(n());
        sb.append("; password: ");
        sb.append(r());
        sb.append("; scrollable: " + s());
        sb.append("; [");
        int c2 = c();
        while (c2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(c2);
            c2 &= ~numberOfTrailingZeros;
            sb.append(b(numberOfTrailingZeros));
            if (c2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u(CharSequence charSequence) {
        this.f325a.setClassName(charSequence);
    }

    public void v(boolean z) {
        this.f325a.setScrollable(z);
    }

    public AccessibilityNodeInfo w() {
        return this.f325a;
    }
}
