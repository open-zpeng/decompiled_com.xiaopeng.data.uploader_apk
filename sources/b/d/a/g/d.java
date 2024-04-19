package b.d.a.g;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.Arrays;
import java.util.List;
/* compiled from: StatMqttDelegate.java */
/* loaded from: classes.dex */
public class d extends b.d.a.g.a implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    private Handler f1261c;

    /* compiled from: StatMqttDelegate.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IStatEvent f1262b;

        a(IStatEvent iStatEvent) {
            this.f1262b = iStatEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.d("StatMqttDelegate", "uploadCdu stat:" + this.f1262b.toString());
            d.this.j(this.f1262b.toJson());
        }
    }

    /* compiled from: StatMqttDelegate.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IMoleEvent f1264b;

        b(IMoleEvent iMoleEvent) {
            this.f1264b = iMoleEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.d("StatMqttDelegate", "uploadCdu mole:" + this.f1264b.toString());
            d.this.j(this.f1264b.toJson());
        }
    }

    /* compiled from: StatMqttDelegate.java */
    /* loaded from: classes.dex */
    private class c {

        /* renamed from: a  reason: collision with root package name */
        b.d.a.d f1266a;

        /* renamed from: b  reason: collision with root package name */
        List<String> f1267b;

        public c(b.d.a.d dVar, List<String> list) {
            this.f1266a = dVar;
            this.f1267b = list;
        }
    }

    public d(Context context) {
        super(context);
        b.d.a.g.b.p().q(context);
        HandlerThread handlerThread = new HandlerThread("StatMqttDelegate", 10);
        handlerThread.start();
        this.f1261c = new Handler(handlerThread.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (!b.d.a.g.b.p().s()) {
            this.f1261c.sendMessageDelayed(Message.obtain(this.f1261c, 2, str), 1000L);
            return;
        }
        this.f1261c.sendMessage(Message.obtain(this.f1261c, 2, str));
    }

    @Override // b.d.a.g.a
    public void a(String str) {
        if (!b.d.a.g.b.p().s()) {
            this.f1261c.sendMessageDelayed(Message.obtain(this.f1261c, 1, str), 1000L);
            return;
        }
        this.f1261c.sendMessage(Message.obtain(this.f1261c, 1, str));
    }

    @Override // b.d.a.g.a
    public void b(IMoleEvent iMoleEvent) {
        ThreadUtils.post(0, new b(iMoleEvent));
    }

    @Override // b.d.a.g.a
    public void c(IStatEvent iStatEvent) {
        ThreadUtils.post(0, new a(iStatEvent));
    }

    @Override // b.d.a.g.a
    public void d(IStatEvent iStatEvent, List<String> list) {
        c cVar = new c((b.d.a.d) iStatEvent, list);
        if (!b.d.a.g.b.p().s()) {
            this.f1261c.sendMessageDelayed(Message.obtain(this.f1261c, 4, cVar), 1000L);
            return;
        }
        this.f1261c.sendMessage(Message.obtain(this.f1261c, 4, cVar));
    }

    @Override // b.d.a.g.a
    public void e(List<String> list) {
        if (!b.d.a.g.b.p().s()) {
            this.f1261c.sendMessageDelayed(Message.obtain(this.f1261c, 5, list), 1000L);
            return;
        }
        this.f1261c.sendMessage(Message.obtain(this.f1261c, 5, list));
    }

    @Override // b.d.a.g.a
    public void f(String str, String str2) {
        List asList = Arrays.asList(str, str2);
        if (!b.d.a.g.b.p().s()) {
            this.f1261c.sendMessageDelayed(Message.obtain(this.f1261c, 3, asList), 1000L);
        } else {
            this.f1261c.sendMessage(Message.obtain(this.f1261c, 3, asList));
        }
    }

    @Override // b.d.a.g.a
    public void g(String str, String str2) {
        List asList = Arrays.asList(str, str2);
        if (!b.d.a.g.b.p().s()) {
            this.f1261c.sendMessageDelayed(Message.obtain(this.f1261c, 6, asList), 1000L);
        } else {
            this.f1261c.sendMessage(Message.obtain(this.f1261c, 6, asList));
        }
    }

    @Override // b.d.a.g.a
    public String h() {
        return b.d.a.g.b.p().A();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                b.d.a.g.b.p().t((String) message.obj);
                break;
            case 2:
                b.d.a.g.b.p().u((String) message.obj);
                break;
            case 3:
                List list = (List) message.obj;
                b.d.a.g.b.p().y((String) list.get(0), (String) list.get(1));
                break;
            case 4:
                c cVar = (c) message.obj;
                b.d.a.g.b.p().w(cVar.f1266a, cVar.f1267b);
                break;
            case 5:
                b.d.a.g.b.p().x((List) message.obj);
                break;
            case 6:
                List list2 = (List) message.obj;
                b.d.a.g.b.p().z((String) list2.get(0), (String) list2.get(1));
                break;
        }
        return true;
    }
}
