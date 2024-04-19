package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Dimension.java */
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    protected String f982b;

    /* renamed from: c  reason: collision with root package name */
    protected String f983c;

    /* compiled from: Dimension.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b createFromParcel(Parcel parcel) {
            return b.a(parcel);
        }
    }

    public b() {
        this.f983c = "null";
    }

    static b a(Parcel parcel) {
        try {
            return new b(parcel.readString(), parcel.readString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        return this.f983c;
    }

    public String c() {
        return this.f982b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            String str = this.f982b;
            if (str == null) {
                if (bVar.f982b != null) {
                    return false;
                }
            } else if (!str.equals(bVar.f982b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f982b;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f983c);
        parcel.writeString(this.f982b);
    }

    public b(String str, String str2) {
        this.f983c = "null";
        this.f982b = str;
        this.f983c = str2 == null ? "null" : str2;
    }
}
