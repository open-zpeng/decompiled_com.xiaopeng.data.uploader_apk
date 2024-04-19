package a.a.c.d;

import a.a.c.d.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ResultReceiver.java */
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final boolean f224b = false;

    /* renamed from: c  reason: collision with root package name */
    final Handler f225c = null;

    /* renamed from: d  reason: collision with root package name */
    a.a.c.d.a f226d;

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: a.a.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class BinderC0008b extends a.AbstractBinderC0006a {
        BinderC0008b() {
        }

        @Override // a.a.c.d.a
        public void g0(int i, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f225c;
            if (handler != null) {
                handler.post(new c(i, bundle));
            } else {
                bVar.a(i, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final int f228b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f229c;

        c(int i, Bundle bundle) {
            this.f228b = i;
            this.f229c = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f228b, this.f229c);
        }
    }

    b(Parcel parcel) {
        this.f226d = a.AbstractBinderC0006a.j0(parcel.readStrongBinder());
    }

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f226d == null) {
                this.f226d = new BinderC0008b();
            }
            parcel.writeStrongBinder(this.f226d.asBinder());
        }
    }
}
