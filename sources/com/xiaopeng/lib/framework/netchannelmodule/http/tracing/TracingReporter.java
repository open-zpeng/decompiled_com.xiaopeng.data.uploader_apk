package com.xiaopeng.lib.framework.netchannelmodule.http.tracing;

import b.d.a.a;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.utils.LogUtils;
import zipkin2.Span;
import zipkin2.reporter.Reporter;
/* loaded from: classes.dex */
public class TracingReporter implements Reporter<Span> {
    private static final String TAG = "Tracer";

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracingReporter() {
        Module.register(a.class, new a(GlobalConfig.getApplicationContext()));
    }

    @Override // zipkin2.reporter.Reporter
    public void report(Span span) {
        String span2 = span.toString();
        LogUtils.d(TAG, "report:" + span2);
        IDataLog iDataLog = (IDataLog) Module.get(a.class).get(IDataLog.class);
        IStatEventBuilder eventName = iDataLog.buildStat().setEventName("data_tracing");
        iDataLog.sendStatData(eventName.setProperty("data", "[" + span2 + "]").build());
    }
}
