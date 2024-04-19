package com.xiaopeng.data.uploader.b.d;

import android.content.Context;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
/* compiled from: MessagingChannel.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f1884a;

    /* renamed from: b  reason: collision with root package name */
    private ICounter f1885b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1886c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f1887d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessagingChannel.java */
    /* renamed from: com.xiaopeng.data.uploader.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0083a implements Runnable {
        RunnableC0083a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f1887d = false;
            try {
                ((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).initChannelWithContext(IMessaging.CHANNEL.REPORTING, App.c());
                a.this.f1887d = true;
            } catch (MessagingException e) {
                LogUtils.w("MessagingChannel", "Failed to initialize communication channel. Exception:" + e);
                e.printStackTrace();
            } catch (Exception e2) {
                LogUtils.w("MessagingChannel", "Failed to initialize communication channel. Exception:" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: MessagingChannel.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1889a;

        static {
            int[] iArr = new int[IEvent.TYPE.values().length];
            f1889a = iArr;
            try {
                iArr[IEvent.TYPE.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1889a[IEvent.TYPE.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1889a[IEvent.TYPE.DELIVERY_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: MessagingChannel.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* compiled from: MessagingChannel.java */
    /* loaded from: classes.dex */
    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        private static final a f1890a = new a(null);
    }

    /* synthetic */ a(RunnableC0083a runnableC0083a) {
        this();
    }

    private void b() {
        if (this.f1884a.size() > 0) {
            for (c cVar : this.f1884a) {
                cVar.a();
            }
        }
    }

    private void c() {
        if (this.f1884a.size() > 0) {
            for (c cVar : this.f1884a) {
                cVar.b();
            }
        }
    }

    public static a d() {
        return d.f1890a;
    }

    private void f() {
        ThreadUtils.postBackground(new RunnableC0083a());
    }

    public void e(Context context) {
        EventBus.getDefault().register(this);
        f();
        if (this.f1886c) {
            return;
        }
        ICounter createHourlyCounter = ((IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class)).counterFactory().createHourlyCounter(context, "data_mqtt_success_rate");
        this.f1885b = createHourlyCounter;
        createHourlyCounter.debug(false);
    }

    public boolean g() {
        if (this.f1887d) {
            return ((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).available();
        }
        return false;
    }

    public void h(String str, byte[] bArr) {
        try {
            ((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).publish(str, bArr);
            if (this.f1886c) {
                return;
            }
            this.f1885b.count("total");
        } catch (MessagingException e) {
            if (e.getReasonCode() == 32) {
                LogUtils.d("MessagingChannel", "Not allowed publish, check the assigned channel.");
            } else if (e.getReasonCode() == 17) {
                LogUtils.d("MessagingChannel", "Make sure the init() was called already.");
            }
        } catch (Exception unused) {
            LogUtils.d("MessagingChannel", "Not expected exception!");
        }
    }

    public void i() {
        f();
    }

    public void j(c cVar) {
        this.f1884a.add(cVar);
    }

    @l(threadMode = ThreadMode.POSTING)
    public void onMessageEventPosting(IEvent iEvent) {
        int i = b.f1889a[iEvent.type().ordinal()];
        if (i == 1) {
            b();
        } else if (i != 2) {
            if (i == 3 && !this.f1886c) {
                this.f1885b.count("success");
            }
        } else {
            c();
        }
    }

    private a() {
        this.f1887d = false;
        this.f1884a = new ArrayList();
        this.f1886c = com.xiaopeng.data.uploader.c.a.a();
    }
}
