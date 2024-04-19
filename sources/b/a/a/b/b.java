package b.a.a.b;

import java.util.Objects;
/* compiled from: $Gson$Preconditions.java */
/* loaded from: classes.dex */
public final class b {
    public static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
