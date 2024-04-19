package b.d.c.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
import com.xiaopeng.lib.utils.LogUtils;
/* compiled from: SystemDelegateService.java */
/* loaded from: classes.dex */
public class b implements ISystemDelegate {

    /* renamed from: a  reason: collision with root package name */
    private Context f1274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f1274a = context;
        Module.register(a.class, new a(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public String getCertificate() throws RemoteException {
        LogUtils.d("SystemDelegateService", "start getCertificate!");
        Cursor query = this.f1274a.getContentResolver().query(Uri.parse("content://com.xiaopeng.system.delegate/cert/ssl"), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    LogUtils.w("SystemDelegateService", "query result success");
                    query.close();
                    return string;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        LogUtils.w("SystemDelegateService", "cursor is empty!");
        return null;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public void setSystemProperty(String str, String str2) throws RemoteException {
        LogUtils.d("SystemDelegateService", "setSystemProperty " + str + ":" + str2);
        Uri parse = Uri.parse("content://com.xiaopeng.system.delegate/sysprop/set");
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        this.f1274a.getContentResolver().update(parse, contentValues, null, null);
    }
}
