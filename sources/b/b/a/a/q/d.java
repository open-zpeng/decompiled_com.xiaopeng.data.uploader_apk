package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: DimensionValueSet.java */
/* loaded from: classes.dex */
public class d implements Parcelable, b.b.a.a.l.b {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    protected Map<String, String> f985b;

    /* compiled from: DimensionValueSet.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public d createFromParcel(Parcel parcel) {
            return d.c(parcel);
        }
    }

    @Deprecated
    public d() {
        if (this.f985b == null) {
            this.f985b = new LinkedHashMap();
        }
    }

    static d c(Parcel parcel) {
        d dVar;
        try {
            dVar = f();
            try {
                dVar.f985b = parcel.readHashMap(d.class.getClassLoader());
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return dVar;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
        return dVar;
    }

    public static d f() {
        return (d) b.b.a.a.l.a.a().b(d.class, new Object[0]);
    }

    @Override // b.b.a.a.l.b
    public void a() {
        this.f985b.clear();
    }

    @Override // b.b.a.a.l.b
    public void b(Object... objArr) {
        if (this.f985b == null) {
            this.f985b = new LinkedHashMap();
        }
    }

    public d d(d dVar) {
        Map<String, String> g;
        if (dVar != null && (g = dVar.g()) != null) {
            for (Map.Entry<String, String> entry : g.entrySet()) {
                this.f985b.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
            }
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e(String str) {
        return this.f985b.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            Map<String, String> map = this.f985b;
            if (map == null) {
                if (dVar.f985b != null) {
                    return false;
                }
            } else if (!map.equals(dVar.f985b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Map<String, String> g() {
        return this.f985b;
    }

    public String h(String str) {
        return this.f985b.get(str);
    }

    public int hashCode() {
        Map<String, String> map = this.f985b;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public void i(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f985b.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
    }

    public d j(String str, String str2) {
        Map<String, String> map = this.f985b;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f985b);
    }
}
