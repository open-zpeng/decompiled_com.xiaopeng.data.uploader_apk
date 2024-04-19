package b.d.a.f;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.utils.DateUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.MD5Utils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: DataBackupHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f1233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* renamed from: b.d.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0053a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1234b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1235c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f1236d;

        RunnableC0053a(String str, String str2, Context context) {
            this.f1234b = str;
            this.f1235c = str2;
            this.f1236d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("vehicleId", String.valueOf(SystemPropertyUtil.getVehicleId()));
            jsonObject.addProperty("message", this.f1234b);
            jsonObject.addProperty("md5", MD5Utils.getMD5(this.f1234b));
            byte[] bytes = new Gson().toJson((JsonElement) jsonObject).getBytes();
            a.this.k(this.f1235c, this.f1236d);
            a.this.e(this.f1235c, this.f1236d);
            a.this.o(this.f1235c, bytes, this.f1236d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* loaded from: classes.dex */
    public class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1237a;

        b(String str) {
            this.f1237a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1237a) && str.endsWith(".log");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* loaded from: classes.dex */
    public class c implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1239a;

        c(String str) {
            this.f1239a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1239a) && str.contains(".log");
        }
    }

    private a() {
    }

    private File d(String str, Context context) {
        String formatDate10 = DateUtils.formatDate10(System.currentTimeMillis());
        return new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str + "_" + formatDate10 + ".log");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list(new b(str));
        if (list == null) {
            return;
        }
        Arrays.sort(list);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (l(str2)) {
                arrayList.add(str2);
                boolean delete = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2).delete();
                StringBuilder sb = new StringBuilder();
                sb.append("file: ");
                sb.append(str2);
                sb.append(" is expired, deleted ");
                sb.append(delete);
                LogUtils.d("DataBackupHelper", sb.toString());
            }
        }
        if (arrayList.size() > 0) {
            m(arrayList, list);
        }
    }

    private String f(String str) {
        return str.replace(".log", ".zip");
    }

    private File g(String str, Context context) {
        File[] listFiles = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName()).listFiles(new c(str));
        if (listFiles != null && listFiles.length != 0) {
            Arrays.sort(listFiles);
            File file = listFiles[listFiles.length - 1];
            return (!j(file) || file.length() >= CommonConfig.MAX_LOG_LENGTH) ? d(str, context) : file;
        }
        LogUtils.d("DataBackupHelper", "create a new File");
        return d(str, context);
    }

    public static a h() {
        if (f1233a == null) {
            synchronized (a.class) {
                if (f1233a == null) {
                    f1233a = new a();
                }
            }
        }
        return f1233a;
    }

    private String i(String str) {
        return str.substring(str.lastIndexOf("_") - 8, str.lastIndexOf("."));
    }

    private boolean j(File file) {
        String name = file.getName();
        String formatDate10 = DateUtils.formatDate10(System.currentTimeMillis());
        return name.contains(formatDate10.substring(0, formatDate10.indexOf("_")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName());
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private boolean l(String str) {
        int lastIndexOf = str.lastIndexOf("_");
        String str2 = str.substring(lastIndexOf - 8, lastIndexOf) + "_000000";
        String formatDate10 = DateUtils.formatDate10(System.currentTimeMillis());
        if (DateUtils.dateToStamp(formatDate10.substring(0, 8) + "_000000") - DateUtils.dateToStamp(str2) > 604800000) {
            LogUtils.d("DataBackupHelper", str + " EXPIRED!");
            return true;
        }
        return false;
    }

    private void m(List<String> list, String[] strArr) {
        String i;
        int size = list.size();
        String i2 = i(list.get(0));
        if (strArr.length > size) {
            i = i(strArr[size]);
        } else {
            i = i(list.get(size - 1));
        }
        IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("data_expire").setProperty("startTime", i2).setProperty("endTime", i).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void o(String str, byte[] bArr, Context context) {
        RandomAccessFile randomAccessFile;
        File g = g(str, context);
        File file = new File(f(g.getPath()));
        if (file.exists()) {
            LogUtils.i("DataBackupHelper", "zipFile exists, delete .zip and write .log");
            file.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(g, "rw");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(bArr);
                randomAccessFile.writeBytes("\n");
                randomAccessFile.getFD().sync();
                StringBuilder sb = new StringBuilder();
                sb.append("write ");
                sb.append(g);
                sb.append(" success, data.length:");
                sb.append(bArr.length);
                LogUtils.i("DataBackupHelper", sb.toString());
                randomAccessFile.close();
                randomAccessFile2 = sb;
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = randomAccessFile;
                LogUtils.w("DataBackupHelper", "write file fail!", e);
                randomAccessFile2 = randomAccessFile2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                    randomAccessFile2 = randomAccessFile2;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    public void n(String str, String str2, Context context) {
        ThreadUtils.post(0, new RunnableC0053a(str2, str, context));
    }
}
