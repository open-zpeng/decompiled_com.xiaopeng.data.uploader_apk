package b.c.a.g;
/* compiled from: CacheException.java */
/* loaded from: classes.dex */
public class a extends Exception {
    private static final long serialVersionUID = 845628123701073013L;

    public a(String str) {
        super(str);
    }

    public static a a(String str) {
        return new a("the http response code is 304, but the cache with cacheKey = " + str + " is null or expired!");
    }
}
