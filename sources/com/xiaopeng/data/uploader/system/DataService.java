package com.xiaopeng.data.uploader.system;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import b.d.b.c.a;
import com.xiaopeng.data.uploader.b.d.a;
import com.xiaopeng.data.uploader.model.CduDataModel;
import com.xiaopeng.data.uploader.model.ImmediatelyDataModel;
import com.xiaopeng.data.uploader.model.SystemLogModel;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class DataService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1903b = new File("/sdcard/DATA_UPLOAD_DEBUG").exists();

    /* renamed from: c  reason: collision with root package name */
    private Handler f1904c = new Handler(ThreadUtils.getLooper(0), new a());

    /* renamed from: d  reason: collision with root package name */
    private ImmediatelyDataModel f1905d;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return true;
            }
            com.xiaopeng.data.uploader.b.c.a.e().k();
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class b implements a.c {
        private b() {
        }

        @Override // com.xiaopeng.data.uploader.b.d.a.c
        public void a() {
            DataService.this.f1904c.removeMessages(0);
            DataService.this.f1904c.sendEmptyMessageDelayed(0, 10000L);
        }

        @Override // com.xiaopeng.data.uploader.b.d.a.c
        public void b() {
        }

        /* synthetic */ b(DataService dataService, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class c extends a.AbstractBinderC0056a {
        private c() {
        }

        @Override // b.d.b.c.a
        public void J(List<String> list, String str) throws RemoteException {
            if (DataService.f1903b) {
                LogUtils.d("UploaderDataService", "uploadFiles:" + list + ", with params " + str);
            }
            com.xiaopeng.data.uploader.b.b.a.b().i(list, str);
        }

        @Override // b.d.b.c.a
        public void Y(List<String> list) throws RemoteException {
            if (DataService.f1903b) {
                LogUtils.d("UploaderDataService", "uploadFiles:" + list);
            }
            com.xiaopeng.data.uploader.b.b.a.b().h(list);
        }

        @Override // b.d.b.c.a
        public void a0(String str) throws RemoteException {
            if (DataService.f1903b) {
                LogUtils.d("UploaderDataService", "upload system log, oss url is :" + str);
            }
            SystemLogModel.INSTANCE.uploadSystemLog(str);
        }

        @Override // b.d.b.c.a
        public void l(String str, String str2) throws RemoteException {
            if (DataService.f1903b) {
                LogUtils.d("UploaderDataService", "uploadLogOrigin:" + str + "|" + str2);
            }
            CduDataModel.getInstance().uploadCduLogOrigin(str, str2);
        }

        @Override // b.d.b.c.a
        public void o(String str) throws RemoteException {
        }

        @Override // b.d.b.c.a
        public void r(String str, String str2) throws RemoteException {
            if (DataService.f1903b) {
                LogUtils.d("UploaderDataService", "uploadLogImmediately:" + str + "|" + str2);
            }
            DataService.this.f1905d.uploadLogImmediately(str, str2);
        }

        @Override // b.d.b.c.a
        public void z(String str) throws RemoteException {
            if (DataService.f1903b) {
                LogUtils.d("UploaderDataService", "uploadLog:" + str);
            }
            CduDataModel.getInstance().uploadCduLog(str);
        }

        /* synthetic */ c(DataService dataService, a aVar) {
            this();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtils.d("UploaderDataService", "onBind");
        return new c(this, null);
    }

    @Override // android.app.Service
    public void onCreate() {
        LogUtils.d("UploaderDataService", "onCreate");
        super.onCreate();
        this.f1905d = new ImmediatelyDataModel();
        com.xiaopeng.data.uploader.b.d.a.d().j(new b(this, null));
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtils.d("UploaderDataService", "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        LogUtils.d("UploaderDataService", "onRebind");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        LogUtils.d("UploaderDataService", "onStartCommand");
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LogUtils.d("UploaderDataService", "onUnbind");
        return super.onUnbind(intent);
    }
}
