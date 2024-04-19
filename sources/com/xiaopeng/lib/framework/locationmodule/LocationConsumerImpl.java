package com.xiaopeng.lib.framework.locationmodule;

import android.content.Context;
import com.xiaopeng.lib.framework.locationmodule.consumer.ServiceProxy;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException;
/* loaded from: classes.dex */
public class LocationConsumerImpl implements ILocationConsumer {
    private ServiceProxy mServiceProxy;

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer
    public boolean connected() {
        ServiceProxy serviceProxy = this.mServiceProxy;
        return serviceProxy != null && serviceProxy.connected();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer
    public ILocation getLocation() throws ILocationServiceException {
        ServiceProxy serviceProxy = this.mServiceProxy;
        if (serviceProxy != null) {
            return serviceProxy.getLastDrLocation();
        }
        throw new LocationServiceException(5);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer
    public void init(Context context, String str) throws ILocationServiceException {
        ServiceProxy serviceProxy = this.mServiceProxy;
        if (serviceProxy == null) {
            this.mServiceProxy = new ServiceProxy(context, str);
        } else if (!serviceProxy.connected()) {
            this.mServiceProxy.bindToLocationService();
        } else {
            throw new LocationServiceException(3);
        }
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer
    public void subscribe(ILocation.Category category) throws ILocationServiceException {
        ServiceProxy serviceProxy = this.mServiceProxy;
        if (serviceProxy != null) {
            serviceProxy.subscribe(category);
            return;
        }
        throw new LocationServiceException(5);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer
    public void unsubscribe() throws ILocationServiceException {
        ServiceProxy serviceProxy = this.mServiceProxy;
        if (serviceProxy != null) {
            serviceProxy.unsubscribe();
            return;
        }
        throw new LocationServiceException(5);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer
    public void init(Context context) throws ILocationServiceException {
        init(context, null);
    }
}
