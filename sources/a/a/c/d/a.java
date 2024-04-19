package a.a.c.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IResultReceiver.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IResultReceiver.java */
    /* renamed from: a.a.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0006a extends Binder implements a {

        /* compiled from: IResultReceiver.java */
        /* renamed from: a.a.c.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0007a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f223a;

            C0007a(IBinder iBinder) {
                this.f223a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f223a;
            }
        }

        public AbstractBinderC0006a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a j0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0007a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                g0(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    void g0(int i, Bundle bundle) throws RemoteException;
}
