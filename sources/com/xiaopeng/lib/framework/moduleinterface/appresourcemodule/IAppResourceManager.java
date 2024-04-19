package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import c.a.e;
/* loaded from: classes.dex */
public interface IAppResourceManager {

    /* loaded from: classes.dex */
    public interface IResourceObserver {
        void onChange(String str, AppResourceResponse appResourceResponse);
    }

    /* loaded from: classes.dex */
    public enum Status {
        NOT_REGISTER(0),
        NOT_AUTH(1),
        NOT_AVAILABLE(2),
        OK(3),
        ERROR(4);
        
        final int mId;

        Status(int i) {
            this.mId = i;
        }

        public int id() {
            return this.mId;
        }
    }

    /* loaded from: classes.dex */
    public enum UpdatePolicy {
        LOCAL(0),
        SYNC(1),
        ASYNC(2);
        
        final int mId;

        UpdatePolicy(int i) {
            this.mId = i;
        }

        public int id() {
            return this.mId;
        }
    }

    boolean addResource(AppResourceRequest appResourceRequest);

    e<AppResourceResponse> addResourceObSource(AppResourceRequest appResourceRequest);

    void checkUpdate(String str);

    e<AppResourceResponse> checkUpdateObSource(String str);

    e<AppResourceResponse> clearResourceObSource();

    void clearResources();

    boolean deleteResource(String str);

    e<AppResourceResponse> deleteResourceObSource(String str);

    AssetFileDescriptor getFileDescriptor(String str);

    e<AssetFileDescriptor> getFileDescriptorObSource(String str);

    Uri getFullUri(String str);

    e<Uri> getFullUrlObSource(String str);

    Status getStatus(String str);

    e<Status> getStatusObSource(String str);

    void subscribeChanges(IResourceObserver iResourceObserver);

    void unSubscribeChanges(IResourceObserver iResourceObserver);
}
