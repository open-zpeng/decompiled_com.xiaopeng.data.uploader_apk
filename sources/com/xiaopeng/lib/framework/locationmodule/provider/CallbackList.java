package com.xiaopeng.lib.framework.locationmodule.provider;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.locationmodule.ILocationServiceCallback;
import com.xiaopeng.lib.framework.locationmodule.LocationImpl;
import com.xiaopeng.lib.framework.locationmodule.common.Debug;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class CallbackList {
    private static final int CATEGORY_COUNT = ILocation.Category.values().length;
    private static final String TAG = "Subscribed.CallbackList";
    private ConcurrentHashMap<String, Integer> mBindingClientMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, IBinder> mSubscribedClientMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<IBinder, CallbackDeathRecipientImpl> mCallBackDeathRecipientMap = new ConcurrentHashMap<>();
    private Object[] mCallbacks = new Object[CATEGORY_COUNT];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CallbackDeathRecipientImpl implements IBinder.DeathRecipient {
        private ILocationServiceCallback mCallback;
        private int mPid;

        public CallbackDeathRecipientImpl(int i, ILocationServiceCallback iLocationServiceCallback) {
            this.mPid = i;
            this.mCallback = iLocationServiceCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            IBinder asBinder = this.mCallback.asBinder();
            asBinder.unlinkToDeath(this, 0);
            CallbackList.this.mSubscribedClientMap.remove(Integer.valueOf(this.mPid));
            CallbackList.this.mCallBackDeathRecipientMap.remove(asBinder);
            LogUtils.i(CallbackList.TAG, "<<<< binder: %d died, client [ pid: %d, %s ]", Integer.valueOf(asBinder.hashCode()), Integer.valueOf(this.mPid), CallbackList.this.findBindingClientPkgName(Integer.valueOf(this.mPid)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackList() {
        for (int i = 0; i < CATEGORY_COUNT; i++) {
            this.mCallbacks[i] = new RemoteCallbackList();
        }
    }

    private void removeDeathRecipient(IBinder iBinder) {
        CallbackDeathRecipientImpl remove;
        if (iBinder == null || (remove = this.mCallBackDeathRecipientMap.remove(iBinder)) == null) {
            return;
        }
        iBinder.unlinkToDeath(remove, 0);
    }

    private void unregister(ILocationServiceCallback iLocationServiceCallback, int i) {
        ((RemoteCallbackList) this.mCallbacks[i]).unregister(iLocationServiceCallback);
    }

    public void clearSubscribedCallback() {
        for (Map.Entry<IBinder, CallbackDeathRecipientImpl> entry : this.mCallBackDeathRecipientMap.entrySet()) {
            IBinder key = entry.getKey();
            CallbackDeathRecipientImpl value = entry.getValue();
            if (key != null && value != null) {
                key.unlinkToDeath(value, 0);
            }
        }
        this.mCallBackDeathRecipientMap.clear();
        this.mSubscribedClientMap.clear();
        this.mBindingClientMap.clear();
    }

    public String findBindingClientPkgName(Integer num) {
        if (num == null) {
            return null;
        }
        for (Map.Entry<String, Integer> entry : this.mBindingClientMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value != null && value.equals(num)) {
                return key;
            }
        }
        return null;
    }

    public ConcurrentHashMap<Integer, IBinder> getSubscribedClientMap() {
        return this.mSubscribedClientMap;
    }

    public void onBind(int i, String str) {
        this.mBindingClientMap.put(str, Integer.valueOf(i));
    }

    public void onSubscribe(int i, ILocationServiceCallback iLocationServiceCallback, int i2) {
        IBinder asBinder = iLocationServiceCallback.asBinder();
        IBinder put = this.mSubscribedClientMap.put(Integer.valueOf(i), asBinder);
        if (put == asBinder) {
            LogUtils.i(TAG, "<<<< binder: " + asBinder.hashCode() + " has subscribed location category: " + i2 + " by pid: " + i);
            return;
        }
        if (put != null) {
            removeDeathRecipient(put);
        }
        try {
            CallbackDeathRecipientImpl callbackDeathRecipientImpl = new CallbackDeathRecipientImpl(i, iLocationServiceCallback);
            iLocationServiceCallback.asBinder().linkToDeath(callbackDeathRecipientImpl, 0);
            this.mCallBackDeathRecipientMap.put(asBinder, callbackDeathRecipientImpl);
            LogUtils.i(TAG, "<<<< binder: %d subscribed category: %d with client [ pid: %d, %s ]", Integer.valueOf(asBinder.hashCode()), Integer.valueOf(i2), Integer.valueOf(i), findBindingClientPkgName(Integer.valueOf(i)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onUnbind(String str) {
        Integer remove;
        if (str == null || (remove = this.mBindingClientMap.remove(str)) == null) {
            return;
        }
        removeSubscribedCallback(remove.intValue());
    }

    public void publishLocation(LocationImpl locationImpl) {
        RemoteCallbackList remoteCallbackList = (RemoteCallbackList) this.mCallbacks[locationImpl.category().ordinal()];
        int beginBroadcast = remoteCallbackList.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                ((ILocationServiceCallback) remoteCallbackList.getBroadcastItem(i)).locationChanged(locationImpl);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        remoteCallbackList.finishBroadcast();
    }

    public void register(int i, ILocationServiceCallback iLocationServiceCallback, int i2) {
        Debug.assertion(i2 < CATEGORY_COUNT);
        ((RemoteCallbackList) this.mCallbacks[i2]).register(iLocationServiceCallback);
        onSubscribe(i, iLocationServiceCallback, i2);
    }

    public void removeSubscribedCallback(int i) {
        removeDeathRecipient(this.mSubscribedClientMap.remove(Integer.valueOf(i)));
    }

    public void unregister(int i, ILocationServiceCallback iLocationServiceCallback) {
        unregister(iLocationServiceCallback, ILocation.Category.GPS_LOCATION.ordinal());
        unregister(iLocationServiceCallback, ILocation.Category.DR_LOCATION.ordinal());
        removeSubscribedCallback(i);
        LogUtils.i(TAG, "<<<< binder: %d is unsubscribed with client [ pid: %d, %s ]", Integer.valueOf(iLocationServiceCallback.asBinder().hashCode()), Integer.valueOf(i), findBindingClientPkgName(Integer.valueOf(i)));
    }
}
