package com.xiaopeng.data.uploader.model;

import android.os.Handler;
import android.os.Message;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class SystemTrafficDataModel implements Handler.Callback {
    public static final String SYSTEM_TRAFFIC_STATISTICS_ACTION = "system.traffic.statistics.action";
    private static final String SYSTEM_TRAFFIC_STATISTICS_FILE = "/data/netstats";
    private static final String TAG = "TrafficBroadcastReceiver";
    private Handler mHandler = new Handler(ThreadUtils.getLooper(2), this);

    private void dealWithFile() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Exception e;
        FileInputStream fileInputStream;
        File[] listFiles = new File(SYSTEM_TRAFFIC_STATISTICS_FILE).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, XmartV1Constants.UTF8_ENCODING);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            try {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                }
                                uploadData(sb.toString());
                                file.delete();
                                try {
                                    fileInputStream.close();
                                    inputStreamReader.close();
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                LogUtils.d(TAG, file.getName(), e);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        bufferedReader = null;
                        e = e5;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } catch (Exception e6) {
                    bufferedReader = null;
                    e = e6;
                    inputStreamReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Exception e7) {
                inputStreamReader = null;
                bufferedReader = null;
                e = e7;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                bufferedReader = null;
            }
        }
    }

    private void uploadData(String str) {
        LogUtils.d(TAG, "data : " + str);
        CduDataModel.getInstance().uploadCduLogOrigin("data_traffic", str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        dealWithFile();
        return false;
    }

    public void sendMessage() {
        this.mHandler.sendEmptyMessage(0);
    }
}
