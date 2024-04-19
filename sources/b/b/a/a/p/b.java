package b.b.a.a.p;
/* compiled from: StringUtils.java */
/* loaded from: classes.dex */
public class b {
    public static boolean a(String str) {
        return !b(str);
    }

    public static boolean b(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
