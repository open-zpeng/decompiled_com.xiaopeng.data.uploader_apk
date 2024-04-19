package b.b.a.a.n;

import android.text.TextUtils;
import java.util.Set;
/* compiled from: AccurateSampleCondition.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f961a;

    /* renamed from: b  reason: collision with root package name */
    private a f962b;

    /* compiled from: AccurateSampleCondition.java */
    /* loaded from: classes.dex */
    private enum a {
        IN,
        NOT_IN
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f961a.contains(str);
        return this.f962b == a.IN ? contains : !contains;
    }
}
