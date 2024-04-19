package b.b.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
/* compiled from: Transaction.java */
/* loaded from: classes.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    protected Integer f920b;

    /* renamed from: c  reason: collision with root package name */
    protected String f921c;

    /* renamed from: d  reason: collision with root package name */
    protected String f922d;
    protected b.b.a.a.q.d e;
    protected String f;
    protected Map<String, String> g;

    /* compiled from: Transaction.java */
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
            return g.a(parcel);
        }
    }

    static g a(Parcel parcel) {
        g gVar = new g();
        try {
            gVar.e = (b.b.a.a.q.d) parcel.readParcelable(g.class.getClassLoader());
            gVar.f920b = Integer.valueOf(parcel.readInt());
            gVar.f921c = parcel.readString();
            gVar.f922d = parcel.readString();
            gVar.f = parcel.readString();
            gVar.g = parcel.readHashMap(g.class.getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return gVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.e, i);
        parcel.writeInt(this.f920b.intValue());
        parcel.writeString(this.f921c);
        parcel.writeString(this.f922d);
        parcel.writeString(this.f);
        parcel.writeMap(this.g);
    }
}
