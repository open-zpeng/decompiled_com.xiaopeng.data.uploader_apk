package com.xiaopeng.lib.utils;

import d.a.a.a.a.b.j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public class Zip7zUtils {
    public static void zip7z(String str, String str2) {
        File file;
        j jVar;
        j jVar2 = null;
        try {
            try {
                File file2 = new File(str2);
                file = new File(str);
                jVar = new j(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            if (file.isDirectory()) {
                zip7zDirectory(file, jVar, "");
            } else {
                zip7zFile(file, jVar, "");
            }
            FileUtils.closeQuietly(jVar);
        } catch (IOException e2) {
            e = e2;
            jVar2 = jVar;
            System.out.println(e.toString());
            FileUtils.closeQuietly(jVar2);
        } catch (Throwable th2) {
            th = th2;
            jVar2 = jVar;
            FileUtils.closeQuietly(jVar2);
            throw th;
        }
    }

    private static void zip7zDirectory(File file, j jVar, String str) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                zip7zDirectory(file2, jVar, str + file2.getName() + MqttTopic.TOPIC_LEVEL_SEPARATOR);
            } else {
                zip7zFile(file2, jVar, str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zip7zFile(File file, j jVar, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(file.getName());
            jVar.k(jVar.g(file, sb.toString()));
            byte[] bArr = new byte[4096];
            BufferedInputStream bufferedInputStream3 = sb;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                bufferedInputStream3 = null;
                jVar.m(bArr, 0, read);
            }
            FileUtils.closeQuietly(bufferedInputStream);
            bufferedInputStream2 = bufferedInputStream3;
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (jVar == null) {
                return;
            }
            jVar.f();
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (jVar == null) {
                return;
            }
            jVar.f();
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            FileUtils.closeQuietly(bufferedInputStream2);
            if (jVar != null) {
                jVar.f();
            }
            throw th;
        }
        jVar.f();
    }
}
