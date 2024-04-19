package d.a.a.a.a.b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
/* compiled from: SevenZOutputFile.java */
/* loaded from: classes.dex */
public class j implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final RandomAccessFile f1931b;
    private d.a.a.a.c.a i;
    private d.a.a.a.c.a[] j;

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f1932c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f1933d = 0;
    private final CRC32 e = new CRC32();
    private final CRC32 f = new CRC32();
    private long g = 0;
    private boolean h = false;
    private Iterable<? extends i> k = Collections.singletonList(new i(h.LZMA2));
    private final Map<f, long[]> l = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SevenZOutputFile.java */
    /* loaded from: classes.dex */
    public class b extends OutputStream {
        private b() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            j.this.f1931b.write(i);
            j.this.f.update(i);
            j.d(j.this);
        }

        /* synthetic */ b(j jVar, a aVar) {
            this();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            j.this.f1931b.write(bArr, i, i2);
            j.this.f.update(bArr, i, i2);
            j.e(j.this, i2);
        }
    }

    public j(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f1931b = randomAccessFile;
        randomAccessFile.seek(32L);
    }

    private void A(i iVar, OutputStream outputStream) throws IOException {
        byte[] a2 = iVar.a().a();
        byte[] c2 = c.b(iVar.a()).c(iVar.b());
        int length = a2.length;
        if (c2.length > 0) {
            length |= 32;
        }
        outputStream.write(length);
        outputStream.write(a2);
        if (c2.length > 0) {
            outputStream.write(c2.length);
            outputStream.write(c2);
        }
    }

    private void B(DataOutput dataOutput) throws IOException {
        if (this.f1933d > 0) {
            z(dataOutput);
            E(dataOutput);
        }
        C(dataOutput);
        dataOutput.write(0);
    }

    private void C(DataOutput dataOutput) throws IOException {
        dataOutput.write(8);
        dataOutput.write(0);
    }

    private void D(DataOutput dataOutput, long j) throws IOException {
        int i = 0;
        int i2 = 128;
        int i3 = 0;
        while (true) {
            if (i >= 8) {
                break;
            }
            int i4 = i + 1;
            if (j < (1 << (i4 * 7))) {
                i3 = (int) (i3 | (j >>> (i * 8)));
                break;
            }
            i3 |= i2;
            i2 >>>= 1;
            i = i4;
        }
        dataOutput.write(i3);
        while (i > 0) {
            dataOutput.write((int) (255 & j));
            j >>>= 8;
            i--;
        }
    }

    private void E(DataOutput dataOutput) throws IOException {
        dataOutput.write(7);
        dataOutput.write(11);
        D(dataOutput, this.f1933d);
        dataOutput.write(0);
        for (f fVar : this.f1932c) {
            if (fVar.o()) {
                x(dataOutput, fVar);
            }
        }
        dataOutput.write(12);
        for (f fVar2 : this.f1932c) {
            if (fVar2.o()) {
                long[] jArr = this.l.get(fVar2);
                if (jArr != null) {
                    for (long j : jArr) {
                        D(dataOutput, j);
                    }
                }
                D(dataOutput, fVar2.m());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (f fVar3 : this.f1932c) {
            if (fVar3.o()) {
                dataOutput.writeInt(Integer.reverseBytes((int) fVar3.e()));
            }
        }
        dataOutput.write(0);
    }

    static /* synthetic */ long d(j jVar) {
        long j = jVar.g;
        jVar.g = 1 + j;
        return j;
    }

    static /* synthetic */ long e(j jVar, long j) {
        long j2 = jVar.g + j;
        jVar.g = j2;
        return j2;
    }

    private Iterable<? extends i> i(f fVar) {
        Iterable<? extends i> d2 = fVar.d();
        return d2 == null ? this.k : d2;
    }

    private OutputStream j() throws IOException {
        if (this.i == null) {
            this.i = l();
        }
        return this.i;
    }

    private d.a.a.a.c.a l() throws IOException {
        if (!this.f1932c.isEmpty()) {
            d.a.a.a.c.a bVar = new b(this, null);
            ArrayList arrayList = new ArrayList();
            List<f> list = this.f1932c;
            boolean z = true;
            for (i iVar : i(list.get(list.size() - 1))) {
                if (!z) {
                    d.a.a.a.c.a aVar = new d.a.a.a.c.a(bVar);
                    arrayList.add(aVar);
                    bVar = aVar;
                }
                bVar = c.a(bVar, iVar.a(), iVar.b());
                z = false;
            }
            if (!arrayList.isEmpty()) {
                this.j = (d.a.a.a.c.a[]) arrayList.toArray(new d.a.a.a.c.a[arrayList.size()]);
            }
            return new a(bVar);
        }
        throw new IllegalStateException("No current 7z entry");
    }

    private void n(DataOutput dataOutput, BitSet bitSet, int i) throws IOException {
        int i2 = 7;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 |= (bitSet.get(i4) ? 1 : 0) << i2;
            i2--;
            if (i2 < 0) {
                dataOutput.write(i3);
                i2 = 7;
                i3 = 0;
            }
        }
        if (i2 != 7) {
            dataOutput.write(i3);
        }
    }

    private void o(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (f fVar : this.f1932c) {
            if (fVar.g()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(19);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.f1932c.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.f1932c.size());
                for (int i2 = 0; i2 < this.f1932c.size(); i2++) {
                    bitSet.set(i2, this.f1932c.get(i2).g());
                }
                n(dataOutputStream, bitSet, this.f1932c.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (f fVar2 : this.f1932c) {
                if (fVar2.g()) {
                    dataOutputStream.writeLong(Long.reverseBytes(f.r(fVar2.a())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void p(DataOutput dataOutput) throws IOException {
        boolean z = false;
        BitSet bitSet = new BitSet(0);
        int i = 0;
        for (f fVar : this.f1932c) {
            if (!fVar.o()) {
                boolean p = fVar.p();
                bitSet.set(i, p);
                z |= p;
                i++;
            }
        }
        if (z) {
            dataOutput.write(16);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            n(dataOutputStream, bitSet, i);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void q(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (f fVar : this.f1932c) {
            if (fVar.h()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(18);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.f1932c.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.f1932c.size());
                for (int i2 = 0; i2 < this.f1932c.size(); i2++) {
                    bitSet.set(i2, this.f1932c.get(i2).h());
                }
                n(dataOutputStream, bitSet, this.f1932c.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (f fVar2 : this.f1932c) {
                if (fVar2.h()) {
                    dataOutputStream.writeLong(Long.reverseBytes(f.r(fVar2.f())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void r(DataOutput dataOutput) throws IOException {
        boolean z = false;
        BitSet bitSet = new BitSet(0);
        int i = 0;
        for (f fVar : this.f1932c) {
            if (!fVar.o()) {
                boolean q = fVar.q();
                bitSet.set(i, !q);
                z |= !q;
                i++;
            }
        }
        if (z) {
            dataOutput.write(15);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            n(dataOutputStream, bitSet, i);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void s(DataOutput dataOutput) throws IOException {
        int i;
        boolean z;
        Iterator<f> it = this.f1932c.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().o()) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            dataOutput.write(14);
            BitSet bitSet = new BitSet(this.f1932c.size());
            for (i = 0; i < this.f1932c.size(); i++) {
                bitSet.set(i, !this.f1932c.get(i).o());
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            n(dataOutputStream, bitSet, this.f1932c.size());
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void t(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (f fVar : this.f1932c) {
            if (fVar.i()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(20);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.f1932c.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.f1932c.size());
                for (int i2 = 0; i2 < this.f1932c.size(); i2++) {
                    bitSet.set(i2, this.f1932c.get(i2).i());
                }
                n(dataOutputStream, bitSet, this.f1932c.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (f fVar2 : this.f1932c) {
                if (fVar2.i()) {
                    dataOutputStream.writeLong(Long.reverseBytes(f.r(fVar2.k())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void u(DataOutput dataOutput) throws IOException {
        dataOutput.write(17);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(0);
        for (f fVar : this.f1932c) {
            dataOutputStream.write(fVar.l().getBytes("UTF-16LE"));
            dataOutputStream.writeShort(0);
        }
        dataOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        D(dataOutput, byteArray.length);
        dataOutput.write(byteArray);
    }

    private void v(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (f fVar : this.f1932c) {
            if (fVar.j()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(21);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.f1932c.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.f1932c.size());
                for (int i2 = 0; i2 < this.f1932c.size(); i2++) {
                    bitSet.set(i2, this.f1932c.get(i2).j());
                }
                n(dataOutputStream, bitSet, this.f1932c.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (f fVar2 : this.f1932c) {
                if (fVar2.j()) {
                    dataOutputStream.writeInt(Integer.reverseBytes(fVar2.n()));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            D(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void w(DataOutput dataOutput) throws IOException {
        dataOutput.write(5);
        D(dataOutput, this.f1932c.size());
        s(dataOutput);
        r(dataOutput);
        p(dataOutput);
        u(dataOutput);
        q(dataOutput);
        o(dataOutput);
        t(dataOutput);
        v(dataOutput);
        dataOutput.write(0);
    }

    private void x(DataOutput dataOutput, f fVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        for (i iVar : i(fVar)) {
            i2++;
            A(iVar, byteArrayOutputStream);
        }
        D(dataOutput, i2);
        dataOutput.write(byteArrayOutputStream.toByteArray());
        while (i < i2 - 1) {
            int i3 = i + 1;
            D(dataOutput, i3);
            D(dataOutput, i);
            i = i3;
        }
    }

    private void y(DataOutput dataOutput) throws IOException {
        dataOutput.write(1);
        dataOutput.write(4);
        B(dataOutput);
        w(dataOutput);
        dataOutput.write(0);
    }

    private void z(DataOutput dataOutput) throws IOException {
        dataOutput.write(6);
        D(dataOutput, 0L);
        D(dataOutput, this.f1933d & 4294967295L);
        dataOutput.write(9);
        for (f fVar : this.f1932c) {
            if (fVar.o()) {
                D(dataOutput, fVar.c());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (f fVar2 : this.f1932c) {
            if (fVar2.o()) {
                dataOutput.writeInt(Integer.reverseBytes((int) fVar2.b()));
            }
        }
        dataOutput.write(0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.h) {
            h();
        }
        this.f1931b.close();
    }

    public void f() throws IOException {
        d.a.a.a.c.a aVar = this.i;
        if (aVar != null) {
            aVar.flush();
            this.i.close();
        }
        List<f> list = this.f1932c;
        f fVar = list.get(list.size() - 1);
        int i = 0;
        if (this.g > 0) {
            fVar.y(true);
            this.f1933d++;
            fVar.B(this.i.b());
            fVar.u(this.g);
            fVar.v(this.e.getValue());
            fVar.t(this.f.getValue());
            fVar.x(true);
            d.a.a.a.c.a[] aVarArr = this.j;
            if (aVarArr != null) {
                long[] jArr = new long[aVarArr.length];
                while (true) {
                    d.a.a.a.c.a[] aVarArr2 = this.j;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    jArr[i] = aVarArr2[i].b();
                    i++;
                }
                this.l.put(fVar, jArr);
            }
        } else {
            fVar.y(false);
            fVar.B(0L);
            fVar.u(0L);
            fVar.x(false);
        }
        this.i = null;
        this.j = null;
        this.e.reset();
        this.f.reset();
        this.g = 0L;
    }

    public f g(File file, String str) throws IOException {
        f fVar = new f();
        fVar.w(file.isDirectory());
        fVar.A(str);
        fVar.z(new Date(file.lastModified()));
        return fVar;
    }

    public void h() throws IOException {
        if (!this.h) {
            this.h = true;
            long filePointer = this.f1931b.getFilePointer();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            y(dataOutputStream);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f1931b.write(byteArray);
            CRC32 crc32 = new CRC32();
            this.f1931b.seek(0L);
            this.f1931b.write(g.f1927b);
            this.f1931b.write(0);
            this.f1931b.write(2);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream2.writeLong(Long.reverseBytes(filePointer - 32));
            dataOutputStream2.writeLong(Long.reverseBytes(4294967295L & byteArray.length));
            crc32.reset();
            crc32.update(byteArray);
            dataOutputStream2.writeInt(Integer.reverseBytes((int) crc32.getValue()));
            dataOutputStream2.flush();
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            crc32.reset();
            crc32.update(byteArray2);
            this.f1931b.writeInt(Integer.reverseBytes((int) crc32.getValue()));
            this.f1931b.write(byteArray2);
            return;
        }
        throw new IOException("This archive has already been finished");
    }

    public void k(d.a.a.a.a.a aVar) throws IOException {
        this.f1932c.add((f) aVar);
    }

    public void m(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            j().write(bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SevenZOutputFile.java */
    /* loaded from: classes.dex */
    public class a extends d.a.a.a.c.a {
        a(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // d.a.a.a.c.a, java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            super.write(i);
            j.this.e.update(i);
        }

        @Override // d.a.a.a.c.a, java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            super.write(bArr);
            j.this.e.update(bArr);
        }

        @Override // d.a.a.a.c.a, java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            super.write(bArr, i, i2);
            j.this.e.update(bArr, i, i2);
        }
    }
}
