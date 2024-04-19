package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: MeasureValueSet.java */
/* loaded from: classes.dex */
public class h implements Parcelable, b.b.a.a.l.b {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, g> f993b = new LinkedHashMap();

    /* compiled from: MeasureValueSet.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<h> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h[] newArray(int i) {
            return new h[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public h createFromParcel(Parcel parcel) {
            return h.c(parcel);
        }
    }

    static h c(Parcel parcel) {
        try {
            h e = e();
            try {
                e.f993b = parcel.readHashMap(d.class.getClassLoader());
                return e;
            } catch (Throwable unused) {
                return e;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static h e() {
        return (h) b.b.a.a.l.a.a().b(h.class, new Object[0]);
    }

    @Override // b.b.a.a.l.b
    public void a() {
        for (g gVar : this.f993b.values()) {
            b.b.a.a.l.a.a().d(gVar);
        }
        this.f993b.clear();
    }

    @Override // b.b.a.a.l.b
    public void b(Object... objArr) {
        if (this.f993b == null) {
            this.f993b = new LinkedHashMap();
        }
    }

    public boolean d(String str) {
        return this.f993b.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, g> f() {
        return this.f993b;
    }

    public g g(String str) {
        return this.f993b.get(str);
    }

    public void h(h hVar) {
        for (String str : this.f993b.keySet()) {
            this.f993b.get(str).h(hVar.g(str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h i(String str, double d2) {
        this.f993b.put(str, b.b.a.a.l.a.a().b(g.class, Double.valueOf(d2)));
        return this;
    }

    public void j(String str, g gVar) {
        this.f993b.put(str, gVar);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f993b);
    }
}
