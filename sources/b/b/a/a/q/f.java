package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MeasureSet.java */
/* loaded from: classes.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private List<e> f989b = new ArrayList(3);

    /* compiled from: MeasureSet.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f createFromParcel(Parcel parcel) {
            return f.a(parcel);
        }
    }

    private f() {
    }

    static f a(Parcel parcel) {
        f c2 = c();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(f.class.getClassLoader());
            if (readParcelableArray != null) {
                ArrayList arrayList = new ArrayList(readParcelableArray.length);
                for (Parcelable parcelable : readParcelableArray) {
                    arrayList.add((e) parcelable);
                }
                c2.f989b = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return c2;
    }

    public static f c() {
        return new f();
    }

    public f b(e eVar) {
        if (!this.f989b.contains(eVar)) {
            this.f989b.add(eVar);
        }
        return this;
    }

    public e d(String str) {
        for (e eVar : this.f989b) {
            if (eVar.d().equals(str)) {
                return eVar;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<e> e() {
        return this.f989b;
    }

    public void f(h hVar) {
        List<e> list = this.f989b;
        if (list == null || hVar == null) {
            return;
        }
        for (e eVar : list) {
            if (eVar.b() != null && hVar.g(eVar.d()) == null) {
                hVar.i(eVar.d(), eVar.b().doubleValue());
            }
        }
    }

    public boolean g(h hVar) {
        if (this.f989b != null) {
            if (hVar != null) {
                for (int i = 0; i < this.f989b.size(); i++) {
                    e eVar = this.f989b.get(i);
                    if (eVar != null) {
                        String d2 = eVar.d();
                        if (!hVar.d(d2) || !eVar.e(hVar.g(d2))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<e> list = this.f989b;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                e[] eVarArr = null;
                if (array != null) {
                    eVarArr = new e[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        eVarArr[i2] = (e) array[i2];
                    }
                }
                parcel.writeParcelableArray(eVarArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
