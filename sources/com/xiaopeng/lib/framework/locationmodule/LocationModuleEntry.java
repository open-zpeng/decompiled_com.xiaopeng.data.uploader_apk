package com.xiaopeng.lib.framework.locationmodule;

import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationProvider;
/* loaded from: classes.dex */
public class LocationModuleEntry implements IModuleEntry {

    /* loaded from: classes.dex */
    private static final class LocationConsumerHolder {
        private static final ILocationConsumer INSTANCE = new LocationConsumerImpl();

        private LocationConsumerHolder() {
        }
    }

    /* loaded from: classes.dex */
    private static final class LocationProviderHolder {
        private static final ILocationProvider INSTANCE = new LocationProviderImpl();

        private LocationProviderHolder() {
        }
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == ILocationProvider.class) {
            return LocationProviderHolder.INSTANCE;
        }
        if (cls == ILocationConsumer.class) {
            return LocationConsumerHolder.INSTANCE;
        }
        return null;
    }
}
