package a.a.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f178a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static b f179b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f180c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f181d = new HashMap<>();
    private final HashMap<String, ArrayList<c>> e = new HashMap<>();
    private final ArrayList<C0002b> f = new ArrayList<>();
    private final Handler g;

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                b.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: a.a.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0002b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f183a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<c> f184b;

        C0002b(Intent intent, ArrayList<c> arrayList) {
            this.f183a = intent;
            this.f184b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f185a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f186b;

        /* renamed from: c  reason: collision with root package name */
        boolean f187c;

        /* renamed from: d  reason: collision with root package name */
        boolean f188d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f185a = intentFilter;
            this.f186b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f186b);
            sb.append(" filter=");
            sb.append(this.f185a);
            if (this.f188d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private b(Context context) {
        this.f180c = context;
        this.g = new a(context.getMainLooper());
    }

    public static b b(Context context) {
        b bVar;
        synchronized (f178a) {
            if (f179b == null) {
                f179b = new b(context.getApplicationContext());
            }
            bVar = f179b;
        }
        return bVar;
    }

    void a() {
        int size;
        C0002b[] c0002bArr;
        while (true) {
            synchronized (this.f181d) {
                size = this.f.size();
                if (size <= 0) {
                    return;
                }
                c0002bArr = new C0002b[size];
                this.f.toArray(c0002bArr);
                this.f.clear();
            }
            for (int i = 0; i < size; i++) {
                C0002b c0002b = c0002bArr[i];
                int size2 = c0002b.f184b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = c0002b.f184b.get(i2);
                    if (!cVar.f188d) {
                        cVar.f186b.onReceive(this.f180c, c0002b.f183a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f181d) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f181d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f181d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f181d) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f180c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f185a);
                    }
                    if (cVar.f187c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f185a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f187c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((c) arrayList5.get(i3)).f187c = false;
                    }
                    this.f.add(new C0002b(intent, arrayList5));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f181d) {
            ArrayList<c> remove = this.f181d.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.f188d = true;
                for (int i = 0; i < cVar.f185a.countActions(); i++) {
                    String action = cVar.f185a.getAction(i);
                    ArrayList<c> arrayList = this.e.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f186b == broadcastReceiver) {
                                cVar2.f188d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.e.remove(action);
                        }
                    }
                }
            }
        }
    }
}
