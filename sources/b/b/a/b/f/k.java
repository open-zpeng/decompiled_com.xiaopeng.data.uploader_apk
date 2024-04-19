package b.b.a.b.f;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* compiled from: MutiProcessLock.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static File f1071a;

    /* renamed from: b  reason: collision with root package name */
    static FileChannel f1072b;

    /* renamed from: c  reason: collision with root package name */
    static FileLock f1073c;

    public static synchronized boolean a(Context context) {
        FileLock fileLock;
        synchronized (k.class) {
            if (f1071a == null) {
                f1071a = new File(context.getFilesDir() + File.separator + "ap.Lock");
            }
            boolean exists = f1071a.exists();
            if (!exists) {
                try {
                    exists = f1071a.createNewFile();
                } catch (IOException unused) {
                }
            }
            if (exists) {
                if (f1072b == null) {
                    try {
                        f1072b = new RandomAccessFile(f1071a, "rw").getChannel();
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                try {
                    fileLock = f1072b.tryLock();
                    if (fileLock != null) {
                        f1073c = fileLock;
                        return true;
                    }
                } catch (Throwable unused3) {
                    fileLock = null;
                }
                Log.d("TAG", "mLock:" + fileLock);
                return false;
            }
            return true;
        }
    }

    public static synchronized void b() {
        synchronized (k.class) {
            FileLock fileLock = f1073c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                }
                f1073c = null;
            }
            FileChannel fileChannel = f1072b;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                }
                f1072b = null;
            }
        }
    }
}
