package a.a.c.g;

import java.util.Objects;
/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public class g {
    public static int a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
