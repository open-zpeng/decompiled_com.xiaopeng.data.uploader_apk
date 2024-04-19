package b.b.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DimensionSet.java */
/* loaded from: classes.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private List<b> f984b = new ArrayList(3);

    /* compiled from: DimensionSet.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public c createFromParcel(Parcel parcel) {
            return c.a(parcel);
        }
    }

    private c() {
    }

    static c a(Parcel parcel) {
        c b2 = b();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(c.class.getClassLoader());
            if (readParcelableArray != null) {
                if (b2.f984b == null) {
                    b2.f984b = new ArrayList();
                }
                for (int i = 0; i < readParcelableArray.length; i++) {
                    if (readParcelableArray[i] == null || !(readParcelableArray[i] instanceof b)) {
                        b.b.a.b.f.i.c("DimensionSet", "parcelables[i]:", readParcelableArray[i]);
                    } else {
                        b2.f984b.add((b) readParcelableArray[i]);
                    }
                }
            }
        } catch (Throwable th) {
            b.b.a.b.f.i.b("DimensionSet", "[readFromParcel]", th);
        }
        return b2;
    }

    public static c b() {
        return new c();
    }

    public void c(d dVar) {
        List<b> list = this.f984b;
        if (list == null || dVar == null) {
            return;
        }
        for (b bVar : list) {
            if (bVar.b() != null && dVar.h(bVar.c()) == null) {
                dVar.j(bVar.c(), bVar.b());
            }
        }
    }

    public boolean d(d dVar) {
        List<b> list = this.f984b;
        if (list != null) {
            if (dVar != null) {
                for (b bVar : list) {
                    if (!dVar.e(bVar.c())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<b> list = this.f984b;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                b[] bVarArr = null;
                if (array != null) {
                    bVarArr = new b[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        bVarArr[i2] = (b) array[i2];
                    }
                }
                parcel.writeParcelableArray(bVarArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
