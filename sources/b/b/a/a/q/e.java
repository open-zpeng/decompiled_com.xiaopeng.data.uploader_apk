package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Measure.java */
/* loaded from: classes.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    protected Double f986b;

    /* renamed from: c  reason: collision with root package name */
    protected Double f987c;

    /* renamed from: d  reason: collision with root package name */
    protected String f988d;
    protected Double e;

    /* compiled from: Measure.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<e> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e[] newArray(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public e createFromParcel(Parcel parcel) {
            return e.a(parcel);
        }
    }

    public e(String str, Double d2, Double d3, Double d4) {
        Double valueOf = Double.valueOf(0.0d);
        this.f986b = valueOf;
        this.f987c = valueOf;
        this.e = valueOf;
        this.f986b = d3;
        this.f987c = d4;
        this.f988d = str;
        this.e = Double.valueOf(d2 != null ? d2.doubleValue() : 0.0d);
    }

    static e a(Parcel parcel) {
        try {
            boolean z = true;
            Double valueOf = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                z = false;
            }
            return new e(readString, !z ? Double.valueOf(parcel.readDouble()) : null, valueOf2, valueOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Double b() {
        return this.e;
    }

    public Double c() {
        return this.f987c;
    }

    public String d() {
        return this.f988d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e(g gVar) {
        Double valueOf = Double.valueOf(gVar.f());
        return valueOf != null && (this.f986b == null || valueOf.doubleValue() >= this.f986b.doubleValue()) && (this.f987c == null || valueOf.doubleValue() <= this.f987c.doubleValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            String str = this.f988d;
            if (str == null) {
                if (eVar.f988d != null) {
                    return false;
                }
            } else if (!str.equals(eVar.f988d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f988d;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            int i2 = 0;
            parcel.writeInt(this.f987c == null ? 0 : 1);
            Double d2 = this.f987c;
            if (d2 != null) {
                parcel.writeDouble(d2.doubleValue());
            }
            parcel.writeInt(this.f986b == null ? 0 : 1);
            Double d3 = this.f986b;
            if (d3 != null) {
                parcel.writeDouble(d3.doubleValue());
            }
            parcel.writeString(this.f988d);
            if (this.e != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            Double d4 = this.e;
            if (d4 != null) {
                parcel.writeDouble(d4.doubleValue());
            }
        } catch (Throwable unused) {
        }
    }
}
