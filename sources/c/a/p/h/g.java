package c.a.p.h;
/* compiled from: Pow2.java */
/* loaded from: classes.dex */
public final class g {
    public static int a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
