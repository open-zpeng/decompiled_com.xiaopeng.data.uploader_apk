package com.xiaopeng.lib.framework.locationmodule;

import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException;
/* loaded from: classes.dex */
public class LocationServiceException extends ILocationServiceException {
    private static final long serialVersionUID = 100;
    private int mReasonCode;

    public LocationServiceException(int i) {
        super(null);
        this.mReasonCode = i;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException
    public int getReasonCode() {
        return this.mReasonCode;
    }

    public LocationServiceException(int i, String str) {
        super(str);
        this.mReasonCode = i;
    }
}
