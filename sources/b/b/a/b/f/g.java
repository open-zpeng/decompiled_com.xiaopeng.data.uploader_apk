package b.b.a.b.f;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: KeyArraySorter.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f1062a = new g();

    /* renamed from: b  reason: collision with root package name */
    private c f1063b = new c();

    /* renamed from: c  reason: collision with root package name */
    private b f1064c = new b();

    /* compiled from: KeyArraySorter.java */
    /* loaded from: classes.dex */
    private class b implements Comparator<String> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: KeyArraySorter.java */
    /* loaded from: classes.dex */
    private class c implements Comparator<String> {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private g() {
    }

    public static g a() {
        return f1062a;
    }

    public String[] b(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.f1064c;
        } else {
            comparator = this.f1063b;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
