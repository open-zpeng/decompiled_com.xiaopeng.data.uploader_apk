package b.b.a.a.p;
/* compiled from: ParseUtils.java */
/* loaded from: classes.dex */
public class a {
    public static int a(String str) {
        if (b.a(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return 0;
    }
}
