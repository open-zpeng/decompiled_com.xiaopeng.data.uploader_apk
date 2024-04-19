package d.a.a.a.a.b;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* compiled from: SevenZArchiveEntry.java */
/* loaded from: classes.dex */
public class f implements d.a.a.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    private String f1923a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1924b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1925c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1926d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private long i;
    private long j;
    private boolean k;
    private int l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;
    private Iterable<? extends i> r;

    public static long r(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.set(1601, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return (date.getTime() - calendar.getTimeInMillis()) * 1000 * 10;
    }

    public static Date s(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.set(1601, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return new Date(calendar.getTimeInMillis() + (j / 10000));
    }

    public void A(String str) {
        this.f1923a = str;
    }

    public void B(long j) {
        this.p = j;
    }

    public Date a() {
        if (this.g) {
            return s(this.j);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.q;
    }

    public Iterable<? extends i> d() {
        return this.r;
    }

    public long e() {
        return this.n;
    }

    public Date f() {
        if (this.e) {
            return s(this.h);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.k;
    }

    public Date k() {
        if (this.f) {
            return s(this.i);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public String l() {
        return this.f1923a;
    }

    public long m() {
        return this.p;
    }

    public int n() {
        return this.l;
    }

    public boolean o() {
        return this.f1924b;
    }

    public boolean p() {
        return this.f1926d;
    }

    public boolean q() {
        return this.f1925c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(long j) {
        this.o = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(long j) {
        this.q = j;
    }

    public void v(long j) {
        this.n = j;
    }

    public void w(boolean z) {
        this.f1925c = z;
    }

    public void x(boolean z) {
        this.m = z;
    }

    public void y(boolean z) {
        this.f1924b = z;
    }

    public void z(Date date) {
        boolean z = date != null;
        this.f = z;
        if (z) {
            this.i = r(date);
        }
    }
}
