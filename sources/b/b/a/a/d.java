package b.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.sdk.android.oss_android_sdk.BuildConfig;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
/* compiled from: IMonitor.java */
/* loaded from: classes.dex */
public interface d extends IInterface {

    /* compiled from: IMonitor.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements d {

        /* compiled from: IMonitor.java */
        /* renamed from: b.b.a.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0035a implements d {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f917a;

            C0035a(IBinder iBinder) {
                this.f917a = iBinder;
            }

            @Override // b.b.a.a.d
            public void F(boolean z, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f917a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.b.a.a.d
            public void G() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f917a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.b.a.a.d
            public void K(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    this.f917a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.b.a.a.d
            public void R(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeMap(map);
                    this.f917a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f917a;
            }

            @Override // b.b.a.a.d
            public void c0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f917a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.b.a.a.d
            public void init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f917a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.b.a.a.d
            public void t(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i = 1;
                    if (fVar != null) {
                        obtain.writeInt(1);
                        fVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f917a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
        }

        public static d j0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0035a(iBinder);
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
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        init();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        p(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        F(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        K(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        G();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        h(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        V(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        S(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        M(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? b.b.a.a.q.f.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        h0(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? b.b.a.a.q.f.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        W(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? b.b.a.a.q.f.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? b.b.a.a.q.c.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        t(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? b.b.a.a.q.f.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? b.b.a.a.q.c.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        R(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        c0();
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        destroy();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        g(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        b0(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean i3 = i(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i3 ? 1 : 0);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        O(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        P(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        B(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        Q(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean f0 = f0(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(f0 ? 1 : 0);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        f(parcel.readString(), parcel.readString(), parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        T(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean v = v(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(v ? 1 : 0);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        w(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        n(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case MqttConnectOptions.CONNECTION_TIMEOUT_DEFAULT /* 30 */:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        N(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        Z(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        u(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case MessagingException.REASON_NOT_ALLOW_SUBSCRIBE /* 33 */:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        A(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        D(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        I(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean x = x(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(x ? 1 : 0);
                        return true;
                    case 37:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        L(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        U(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? b.b.a.a.q.d.CREATOR.createFromParcel(parcel) : null, parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        H(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? b.b.a.a.q.d.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? b.b.a.a.q.h.CREATOR.createFromParcel(parcel) : null, parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case BuildConfig.VERSION_CODE /* 40 */:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        y(parcel.readInt() != 0 ? g.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        q(parcel.readInt() != 0 ? g.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.alibaba.mtl.appmonitor.IMonitor");
            return true;
        }
    }

    void A(String str, String str2, String str3) throws RemoteException;

    void B(int i) throws RemoteException;

    void D(int i) throws RemoteException;

    void F(boolean z, String str, String str2, String str3) throws RemoteException;

    void G() throws RemoteException;

    void H(String str, String str2, b.b.a.a.q.d dVar, b.b.a.a.q.h hVar, Map map) throws RemoteException;

    void I(int i) throws RemoteException;

    void K(String str) throws RemoteException;

    void L(String str, String str2, double d2, Map map) throws RemoteException;

    void M(String str, String str2, b.b.a.a.q.f fVar) throws RemoteException;

    void N(String str, String str2, String str3, String str4, Map map) throws RemoteException;

    void O(String str, String str2, double d2, Map map) throws RemoteException;

    void P(String str, String str2, String str3, double d2, Map map) throws RemoteException;

    void Q(int i) throws RemoteException;

    void R(Map map) throws RemoteException;

    void S(int i, int i2) throws RemoteException;

    void T(int i) throws RemoteException;

    void U(String str, String str2, b.b.a.a.q.d dVar, double d2, Map map) throws RemoteException;

    void V(int i) throws RemoteException;

    void W(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar) throws RemoteException;

    void Z(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException;

    void b0(int i) throws RemoteException;

    void c0() throws RemoteException;

    void destroy() throws RemoteException;

    void f(String str, String str2, double d2) throws RemoteException;

    boolean f0(String str, String str2) throws RemoteException;

    void g(int i) throws RemoteException;

    void h(int i) throws RemoteException;

    void h0(String str, String str2, b.b.a.a.q.f fVar, boolean z) throws RemoteException;

    boolean i(String str, String str2) throws RemoteException;

    void init() throws RemoteException;

    void j(int i) throws RemoteException;

    void n(String str, String str2, String str3, Map map) throws RemoteException;

    void p(boolean z) throws RemoteException;

    void q(g gVar, String str) throws RemoteException;

    void t(String str, String str2, b.b.a.a.q.f fVar, b.b.a.a.q.c cVar, boolean z) throws RemoteException;

    void u(String str, String str2, String str3) throws RemoteException;

    boolean v(String str, String str2) throws RemoteException;

    void w(String str, String str2, Map map) throws RemoteException;

    boolean x(String str, String str2) throws RemoteException;

    void y(g gVar, String str) throws RemoteException;
}
