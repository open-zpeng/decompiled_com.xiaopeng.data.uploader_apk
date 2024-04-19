package d.c.a.w;
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean[] f2021a = {true, true, true, false, true, false, false, false};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2022b = {0, 1, 2, 2, 3, 3, 3, 3};

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2023c;

    /* renamed from: d  reason: collision with root package name */
    private int f2024d;
    private int e = 0;

    public g(boolean z, int i) {
        this.f2023c = z;
        this.f2024d = i + 5;
    }

    private static boolean b(byte b2) {
        int i = b2 & 255;
        return i == 0 || i == 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (b(r11[(r1 + 4) - d.c.a.w.g.f2022b[r0]]) != false) goto L26;
     */
    @Override // d.c.a.w.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.w.g.a(byte[], int, int):int");
    }
}
