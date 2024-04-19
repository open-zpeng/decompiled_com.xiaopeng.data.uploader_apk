package b.b.a.b.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.util.Random;
/* compiled from: PhoneInfoUtils.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f1078a = new Random();

    public static String a(Context context) {
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_ie", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new String(c.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
        }
        String c2 = TextUtils.isEmpty(null) ? c() : null;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_ie", new String(c.c(c2.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return c2;
    }

    public static String b(Context context) {
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_is", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new String(c.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
        }
        String c2 = TextUtils.isEmpty(null) ? c() : null;
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_is", new String(c.c(c2.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return c2;
    }

    public static final String c() {
        Random random = f1078a;
        int nextInt = random.nextInt();
        int nextInt2 = random.nextInt();
        byte[] a2 = f.a((int) (System.currentTimeMillis() / 1000));
        byte[] a3 = f.a((int) System.nanoTime());
        byte[] a4 = f.a(nextInt);
        byte[] a5 = f.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a2, 0, bArr, 0, 4);
        System.arraycopy(a3, 0, bArr, 4, 4);
        System.arraycopy(a4, 0, bArr, 8, 4);
        System.arraycopy(a5, 0, bArr, 12, 4);
        return c.e(bArr, 2);
    }
}
