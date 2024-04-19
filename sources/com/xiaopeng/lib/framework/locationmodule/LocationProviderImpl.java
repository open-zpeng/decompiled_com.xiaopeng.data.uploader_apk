package com.xiaopeng.lib.framework.locationmodule;

import android.content.Context;
import com.xiaopeng.lib.framework.locationmodule.provider.ServiceProvider;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException;
/* loaded from: classes.dex */
public class LocationProviderImpl implements ILocationProvider {
    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider
    public ILocation buildLocation() {
        return new LocationImpl();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider
    public void publishLocation(ILocation iLocation) throws ILocationServiceException {
        if (ServiceProvider.getInstance().started()) {
            ServiceProvider.getInstance().publishLocation((LocationImpl) iLocation);
            return;
        }
        throw new LocationServiceException(1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider
    public boolean serviceStarted() {
        return ServiceProvider.getInstance().started();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider
    public void start(Context context) throws ILocationServiceException {
        if (!ServiceProvider.getInstance().started()) {
            ServiceProvider.getInstance().startService(context);
            return;
        }
        throw new LocationServiceException(2);
    }
}
