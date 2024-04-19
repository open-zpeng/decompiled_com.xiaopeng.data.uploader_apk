package com.ut.mini.internal;
/* loaded from: classes.dex */
public class CustomDNS {

    /* renamed from: a  reason: collision with root package name */
    private IDnsResolver f1853a;

    /* loaded from: classes.dex */
    public interface IDnsResolver {
        String[] resolveUrl(String str);
    }

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final CustomDNS f1854a = new CustomDNS();
    }

    public static CustomDNS instance() {
        return a.f1854a;
    }

    public String[] resolveUrl(String str) {
        IDnsResolver iDnsResolver = this.f1853a;
        if (iDnsResolver != null) {
            return iDnsResolver.resolveUrl(str);
        }
        return null;
    }

    public void setDnsResolver(IDnsResolver iDnsResolver) {
        this.f1853a = iDnsResolver;
    }

    private CustomDNS() {
        this.f1853a = null;
    }
}
