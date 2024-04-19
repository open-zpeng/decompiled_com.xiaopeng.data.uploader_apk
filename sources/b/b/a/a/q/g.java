package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: MeasureValue.java */
/* loaded from: classes.dex */
public class g implements Parcelable, b.b.a.a.l.b {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private boolean f990b;

    /* renamed from: c  reason: collision with root package name */
    private Double f991c;

    /* renamed from: d  reason: collision with root package name */
    private double f992d;

    /* compiled from: MeasureValue.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<g> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i) {
            return new g[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public g createFromParcel(Parcel parcel) {
            return g.c(parcel);
        }
    }

    static g c(Parcel parcel) {
        g gVar = null;
        try {
            boolean z = parcel.readInt() != 0;
            Double valueOf = Double.valueOf(parcel.readDouble());
            double readDouble = parcel.readDouble();
            gVar = d();
            gVar.f990b = z;
            gVar.f991c = valueOf;
            gVar.f992d = readDouble;
            return gVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return gVar;
        }
    }

    public static g d() {
        return (g) b.b.a.a.l.a.a().b(g.class, new Object[0]);
    }

    @Override // b.b.a.a.l.b
    public synchronized void a() {
        this.f992d = 0.0d;
        this.f991c = null;
        this.f990b = false;
    }

    @Override // b.b.a.a.l.b
    public synchronized void b(Object... objArr) {
        if (objArr == null) {
            return;
        }
        if (objArr.length > 0) {
            this.f992d = ((Double) objArr[0]).doubleValue();
        }
        if (objArr.length > 1) {
            this.f991c = (Double) objArr[1];
            this.f990b = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Double e() {
        return this.f991c;
    }

    public double f() {
        return this.f992d;
    }

    public boolean g() {
        return this.f990b;
    }

    public synchronized void h(g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            this.f992d += gVar.f();
            if (gVar.e() != null) {
                if (this.f991c == null) {
                    this.f991c = Double.valueOf(0.0d);
                }
                this.f991c = Double.valueOf(this.f991c.doubleValue() + gVar.e().doubleValue());
            }
        } catch (Throwable unused) {
        }
    }

    public void i(boolean z) {
        this.f990b = z;
    }

    public void j(double d2) {
        this.f991c = Double.valueOf(d2);
    }

    public void k(double d2) {
        this.f992d = d2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.f990b ? 1 : 0);
            Double d2 = this.f991c;
            parcel.writeDouble(d2 == null ? 0.0d : d2.doubleValue());
            parcel.writeDouble(this.f992d);
        } catch (Throwable unused) {
        }
    }
}
