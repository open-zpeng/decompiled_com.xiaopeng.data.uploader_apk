package com.xiaopeng.data.uploader.d;

import android.util.Log;
import com.xiaopeng.data.uploader.App;
import com.xiaopeng.lib.framework.locationmodule.LocationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationConsumer;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocationServiceException;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.IStateEvent;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
/* compiled from: GpsDrPresenter.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ScheduledExecutorService f1898a;

    /* renamed from: b  reason: collision with root package name */
    com.xiaopeng.data.uploader.b.e.a f1899b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1900c = false;

    /* renamed from: d  reason: collision with root package name */
    Runnable f1901d = new RunnableC0085a();

    /* compiled from: GpsDrPresenter.java */
    /* renamed from: com.xiaopeng.data.uploader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0085a implements Runnable {
        RunnableC0085a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaopeng.data.uploader.b.e.a aVar = a.this.f1899b;
            if (aVar != null) {
                a.this.f1899b.a(aVar.b());
            }
        }
    }

    public a() {
        Log.i("GpsDrPresenter", "GpsDrPresenter init");
    }

    private void c() {
        Log.i("GpsDrPresenter", "subscribeLocation:\t" + this.f1900c);
        if (this.f1900c) {
            return;
        }
        try {
            ((ILocationConsumer) Module.get(LocationModuleEntry.class).get(ILocationConsumer.class)).subscribe(ILocation.Category.DR_LOCATION);
            Log.i("GpsDrPresenter", "subscribeLocation execute!");
            this.f1900c = true;
        } catch (ILocationServiceException e) {
            LogUtils.e("GpsDrPresenter", "Failed to subscribe location, exception:" + e);
            e.printStackTrace();
        }
    }

    public void a() {
        Log.i("GpsDrPresenter", "init");
        EventBus.getDefault().register(this);
        Module.register(LocationModuleEntry.class, new LocationModuleEntry());
        try {
            ((ILocationConsumer) Module.get(LocationModuleEntry.class).get(ILocationConsumer.class)).init(App.c().getApplicationContext());
        } catch (ILocationServiceException unused) {
            LogUtils.d("GpsDrPresenter", "init mLocationConsumer  server connected failed!");
        }
        this.f1898a = new ScheduledThreadPoolExecutor(2);
    }

    public void b(com.xiaopeng.data.uploader.b.e.a aVar) {
        this.f1899b = aVar;
    }

    @l(threadMode = ThreadMode.POSTING)
    public void onMessageEventPosting(IStateEvent iStateEvent) {
        Log.i("GpsDrPresenter", "Service State changed:" + iStateEvent.type() + ":\tmSubscribedLocation" + this.f1900c);
        if (iStateEvent.type() == IStateEvent.TYPE.BOUND) {
            Log.i("GpsDrPresenter", "onMessageEventPosting");
            c();
            this.f1898a.scheduleAtFixedRate(this.f1901d, 2000L, 3000L, TimeUnit.MILLISECONDS);
            return;
        }
        this.f1900c = false;
    }
}
