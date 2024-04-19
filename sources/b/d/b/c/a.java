package b.d.b.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: IDataUploadInterface.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IDataUploadInterface.java */
    /* renamed from: b.d.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0056a extends Binder implements a {

        /* compiled from: IDataUploadInterface.java */
        /* renamed from: b.d.b.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0057a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f1271a;

            C0057a(IBinder iBinder) {
                this.f1271a = iBinder;
            }

            @Override // b.d.b.c.a
            public void Y(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeStringList(list);
                    this.f1271a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.c.a
            public void a0(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.f1271a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1271a;
            }

            @Override // b.d.b.c.a
            public void l(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1271a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.c.a
            public void o(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.f1271a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.c.a
            public void r(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1271a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.c.a
            public void z(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.f1271a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0056a() {
            attachInterface(this, "com.xiaopeng.lib.bughunter.IDataUploadInterface");
        }

        public static a j0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0057a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        z(parcel.readString());
                        return true;
                    case 2:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        l(parcel.readString(), parcel.readString());
                        return true;
                    case 3:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        o(parcel.readString());
                        return true;
                    case 4:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        r(parcel.readString(), parcel.readString());
                        return true;
                    case 5:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        Y(parcel.createStringArrayList());
                        return true;
                    case 6:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        a0(parcel.readString());
                        return true;
                    case 7:
                        parcel.enforceInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                        J(parcel.createStringArrayList(), parcel.readString());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            return true;
        }
    }

    void J(List<String> list, String str) throws RemoteException;

    void Y(List<String> list) throws RemoteException;

    void a0(String str) throws RemoteException;

    void l(String str, String str2) throws RemoteException;

    void o(String str) throws RemoteException;

    void r(String str, String str2) throws RemoteException;

    void z(String str) throws RemoteException;
}
