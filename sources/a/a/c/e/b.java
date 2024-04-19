package a.a.c.e;

import a.a.c.a.c.f;
import a.a.c.b.i;
import a.a.c.e.c;
import a.a.c.g.h;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final a.a.c.g.d<String, Typeface> f235a = new a.a.c.g.d<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final a.a.c.e.c f236b = new a.a.c.e.c("fonts", 10, com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.r);

    /* renamed from: c  reason: collision with root package name */
    static final Object f237c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final h<String, ArrayList<c.d<g>>> f238d = new h<>();
    private static final Comparator<byte[]> e = new d();

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    static class a implements Callable<g> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f239b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.a.c.e.a f240c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f241d;
        final /* synthetic */ String e;

        a(Context context, a.a.c.e.a aVar, int i, String str) {
            this.f239b = context;
            this.f240c = aVar;
            this.f241d = i;
            this.e = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public g call() throws Exception {
            g f = b.f(this.f239b, this.f240c, this.f241d);
            Typeface typeface = f.f251a;
            if (typeface != null) {
                b.f235a.e(this.e, typeface);
            }
            return f;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.a.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0009b implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Handler f243b;

        C0009b(f.a aVar, Handler handler) {
            this.f242a = aVar;
            this.f243b = handler;
        }

        @Override // a.a.c.e.c.d
        /* renamed from: b */
        public void a(g gVar) {
            if (gVar == null) {
                this.f242a.a(1, this.f243b);
                return;
            }
            int i = gVar.f252b;
            if (i == 0) {
                this.f242a.b(gVar.f251a, this.f243b);
            } else {
                this.f242a.a(i, this.f243b);
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    static class c implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f244a;

        c(String str) {
            this.f244a = str;
        }

        @Override // a.a.c.e.c.d
        /* renamed from: b */
        public void a(g gVar) {
            synchronized (b.f237c) {
                h<String, ArrayList<c.d<g>>> hVar = b.f238d;
                ArrayList<c.d<g>> arrayList = hVar.get(this.f244a);
                if (arrayList == null) {
                    return;
                }
                hVar.remove(this.f244a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(gVar);
                }
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    static class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final int f245a;

        /* renamed from: b  reason: collision with root package name */
        private final f[] f246b;

        public e(int i, f[] fVarArr) {
            this.f245a = i;
            this.f246b = fVarArr;
        }

        public f[] a() {
            return this.f246b;
        }

        public int b() {
            return this.f245a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f247a;

        /* renamed from: b  reason: collision with root package name */
        private final int f248b;

        /* renamed from: c  reason: collision with root package name */
        private final int f249c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f250d;
        private final int e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            this.f247a = (Uri) a.a.c.g.g.b(uri);
            this.f248b = i;
            this.f249c = i2;
            this.f250d = z;
            this.e = i3;
        }

        public int a() {
            return this.e;
        }

        public int b() {
            return this.f248b;
        }

        public Uri c() {
            return this.f247a;
        }

        public int d() {
            return this.f249c;
        }

        public boolean e() {
            return this.f250d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f251a;

        /* renamed from: b  reason: collision with root package name */
        final int f252b;

        g(Typeface typeface, int i) {
            this.f251a = typeface;
            this.f252b = i;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, a.a.c.e.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo h = h(context.getPackageManager(), aVar, context.getResources());
        if (h == null) {
            return new e(1, null);
        }
        return new e(0, e(context, aVar, h.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(a.a.c.e.a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return a.a.c.a.c.c.c(resources, aVar.b());
    }

    static f[] e(Context context, a.a.c.e.a aVar, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new f(withAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    static g f(Context context, a.a.c.e.a aVar, int i) {
        try {
            e c2 = c(context, null, aVar);
            if (c2.b() == 0) {
                Typeface a2 = a.a.c.b.c.a(context, null, c2.a(), i);
                return new g(a2, a2 != null ? 0 : -3);
            }
            return new g(null, c2.b() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface g(Context context, a.a.c.e.a aVar, f.a aVar2, Handler handler, boolean z, int i, int i2) {
        String str = aVar.c() + "-" + i2;
        Typeface d2 = f235a.d(str);
        if (d2 != null) {
            if (aVar2 != null) {
                aVar2.d(d2);
            }
            return d2;
        } else if (z && i == -1) {
            g f2 = f(context, aVar, i2);
            if (aVar2 != null) {
                int i3 = f2.f252b;
                if (i3 == 0) {
                    aVar2.b(f2.f251a, handler);
                } else {
                    aVar2.a(i3, handler);
                }
            }
            return f2.f251a;
        } else {
            a aVar3 = new a(context, aVar, i2, str);
            if (z) {
                try {
                    return ((g) f236b.e(aVar3, i)).f251a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            C0009b c0009b = aVar2 == null ? null : new C0009b(aVar2, handler);
            synchronized (f237c) {
                h<String, ArrayList<c.d<g>>> hVar = f238d;
                if (hVar.containsKey(str)) {
                    if (c0009b != null) {
                        hVar.get(str).add(c0009b);
                    }
                    return null;
                }
                if (c0009b != null) {
                    ArrayList<c.d<g>> arrayList = new ArrayList<>();
                    arrayList.add(c0009b);
                    hVar.put(str, arrayList);
                }
                f236b.d(aVar3, new c(str));
                return null;
            }
        }
    }

    public static ProviderInfo h(PackageManager packageManager, a.a.c.e.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(aVar.e())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, e);
                List<List<byte[]>> d3 = d(aVar, resources);
                for (int i = 0; i < d3.size(); i++) {
                    ArrayList arrayList = new ArrayList(d3.get(i));
                    Collections.sort(arrayList, e);
                    if (b(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, i.f(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
