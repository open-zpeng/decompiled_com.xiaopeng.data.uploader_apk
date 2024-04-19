package b.a.a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Objects;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes.dex */
public abstract class d implements b.a.a.g {
    public static final d O000000o;
    public static final d O00000Oo;
    public static final d O00000o;
    public static final d O00000o0;
    public static final d O00000oO;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ d[] f864b;

    /* compiled from: FieldNamingPolicy.java */
    /* loaded from: classes.dex */
    enum a extends d {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.a.a.d, b.a.a.g
        public String O000000o(Field field) {
            return field.getName();
        }
    }

    /* compiled from: JsonReader.java */
    /* loaded from: classes.dex */
    public class f implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private static final char[] f865b = ")]}'\n".toCharArray();

        /* renamed from: c  reason: collision with root package name */
        private final Reader f866c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f867d = false;
        private final char[] e = new char[1024];
        private int f = 0;
        private int g = 0;
        private int h = 0;
        private int i = 0;
        private int j = 0;
        private long k;
        private int l;
        private String m;
        private int[] n;
        private int o;

        /* compiled from: JsonReader.java */
        /* loaded from: classes.dex */
        static class a extends b.a.a.b.f {
            a() {
            }

            @Override // b.a.a.b.f
            public void a(f fVar) throws IOException {
                int i;
                if (fVar instanceof b.a.a.b.a.c) {
                    ((b.a.a.b.a.c) fVar).Q();
                    return;
                }
                int i2 = fVar.j;
                if (i2 == 0) {
                    i2 = fVar.D();
                }
                if (i2 == 13) {
                    i = 9;
                } else if (i2 == 12) {
                    i = 8;
                } else if (i2 != 14) {
                    throw new IllegalStateException("Expected a name but was " + fVar.t() + "  at line " + fVar.I() + " column " + fVar.K());
                } else {
                    i = 10;
                }
                fVar.j = i;
            }
        }

        static {
            b.a.a.b.f.f841a = new a();
        }

        public f(Reader reader) {
            int[] iArr = new int[32];
            this.n = iArr;
            this.o = 0;
            this.o = 0 + 1;
            iArr[0] = 6;
            Objects.requireNonNull(reader, "in == null");
            this.f866c = reader;
        }

        private int A() throws IOException {
            int i;
            String str;
            String str2;
            char c2 = this.e[this.f];
            if (c2 == 't' || c2 == 'T') {
                i = 5;
                str = "true";
                str2 = "TRUE";
            } else if (c2 == 'f' || c2 == 'F') {
                i = 6;
                str = "false";
                str2 = "FALSE";
            } else if (c2 != 'n' && c2 != 'N') {
                return 0;
            } else {
                i = 7;
                str = "null";
                str2 = "NULL";
            }
            int length = str.length();
            for (int i2 = 1; i2 < length; i2++) {
                if (this.f + i2 >= this.g && !m(i2 + 1)) {
                    return 0;
                }
                char c3 = this.e[this.f + i2];
                if (c3 != str.charAt(i2) && c3 != str2.charAt(i2)) {
                    return 0;
                }
            }
            if ((this.f + length < this.g || m(length + 1)) && f(this.e[this.f + length])) {
                return 0;
            }
            this.f += length;
            this.j = i;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int D() throws IOException {
            int i;
            int i2;
            int[] iArr = this.n;
            int i3 = this.o;
            int i4 = iArr[i3 - 1];
            if (i4 == 1) {
                iArr[i3 - 1] = 2;
            } else if (i4 != 2) {
                if (i4 == 3 || i4 == 5) {
                    iArr[i3 - 1] = 4;
                    if (i4 == 5 && (i2 = i(true)) != 44) {
                        if (i2 != 59) {
                            if (i2 == 125) {
                                this.j = 2;
                                return 2;
                            }
                            throw j("Unterminated object");
                        }
                        J();
                    }
                    int i5 = i(true);
                    if (i5 == 34) {
                        i = 13;
                    } else if (i5 == 39) {
                        J();
                        i = 12;
                    } else if (i5 == 125) {
                        if (i4 != 5) {
                            this.j = 2;
                            return 2;
                        }
                        throw j("Expected name");
                    } else {
                        J();
                        this.f--;
                        if (!f((char) i5)) {
                            throw j("Expected name");
                        }
                        i = 14;
                    }
                } else if (i4 == 4) {
                    iArr[i3 - 1] = 5;
                    int i6 = i(true);
                    if (i6 != 58) {
                        if (i6 != 61) {
                            throw j("Expected ':'");
                        }
                        J();
                        if (this.f < this.g || m(1)) {
                            char[] cArr = this.e;
                            int i7 = this.f;
                            if (cArr[i7] == '>') {
                                this.f = i7 + 1;
                            }
                        }
                    }
                } else if (i4 == 6) {
                    if (this.f867d) {
                        N();
                    }
                    this.n[this.o - 1] = 7;
                } else if (i4 == 7) {
                    if (i(false) == -1) {
                        i = 17;
                    } else {
                        J();
                        this.f--;
                    }
                } else if (i4 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.j = i;
                return i;
            } else {
                int i8 = i(true);
                if (i8 != 44) {
                    if (i8 != 59) {
                        if (i8 == 93) {
                            this.j = 4;
                            return 4;
                        }
                        throw j("Unterminated array");
                    }
                    J();
                }
            }
            int i9 = i(true);
            if (i9 != 34) {
                if (i9 == 39) {
                    J();
                    this.j = 8;
                    return 8;
                }
                if (i9 != 44 && i9 != 59) {
                    if (i9 == 91) {
                        this.j = 3;
                        return 3;
                    } else if (i9 != 93) {
                        if (i9 == 123) {
                            this.j = 1;
                            return 1;
                        }
                        this.f--;
                        if (this.o == 1) {
                            J();
                        }
                        int A = A();
                        if (A != 0) {
                            return A;
                        }
                        int G = G();
                        if (G != 0) {
                            return G;
                        }
                        if (!f(this.e[this.f])) {
                            throw j("Expected value");
                        }
                        J();
                        i = 10;
                    } else if (i4 == 1) {
                        this.j = 4;
                        return 4;
                    }
                }
                if (i4 == 1 || i4 == 2) {
                    J();
                    this.f--;
                    this.j = 7;
                    return 7;
                }
                throw j("Unexpected value");
            }
            if (this.o == 1) {
                J();
            }
            i = 9;
            this.j = i;
            return i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
            J();
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.lang.String F() throws java.io.IOException {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
            L2:
                r2 = r0
            L3:
                int r3 = r6.f
                int r4 = r3 + r2
                int r5 = r6.g
                if (r4 >= r5) goto L4e
                char[] r4 = r6.e
                int r3 = r3 + r2
                char r3 = r4[r3]
                r4 = 9
                if (r3 == r4) goto L5c
                r4 = 10
                if (r3 == r4) goto L5c
                r4 = 12
                if (r3 == r4) goto L5c
                r4 = 13
                if (r3 == r4) goto L5c
                r4 = 32
                if (r3 == r4) goto L5c
                r4 = 35
                if (r3 == r4) goto L4a
                r4 = 44
                if (r3 == r4) goto L5c
                r4 = 47
                if (r3 == r4) goto L4a
                r4 = 61
                if (r3 == r4) goto L4a
                r4 = 123(0x7b, float:1.72E-43)
                if (r3 == r4) goto L5c
                r4 = 125(0x7d, float:1.75E-43)
                if (r3 == r4) goto L5c
                r4 = 58
                if (r3 == r4) goto L5c
                r4 = 59
                if (r3 == r4) goto L4a
                switch(r3) {
                    case 91: goto L5c;
                    case 92: goto L4a;
                    case 93: goto L5c;
                    default: goto L47;
                }
            L47:
                int r2 = r2 + 1
                goto L3
            L4a:
                r6.J()
                goto L5c
            L4e:
                char[] r3 = r6.e
                int r3 = r3.length
                if (r2 >= r3) goto L5e
                int r3 = r2 + 1
                boolean r3 = r6.m(r3)
                if (r3 == 0) goto L5c
                goto L3
            L5c:
                r0 = r2
                goto L78
            L5e:
                if (r1 != 0) goto L65
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
            L65:
                char[] r3 = r6.e
                int r4 = r6.f
                r1.append(r3, r4, r2)
                int r3 = r6.f
                int r3 = r3 + r2
                r6.f = r3
                r2 = 1
                boolean r2 = r6.m(r2)
                if (r2 != 0) goto L2
            L78:
                if (r1 != 0) goto L84
                java.lang.String r1 = new java.lang.String
                char[] r2 = r6.e
                int r3 = r6.f
                r1.<init>(r2, r3, r0)
                goto L8f
            L84:
                char[] r2 = r6.e
                int r3 = r6.f
                r1.append(r2, r3, r0)
                java.lang.String r1 = r1.toString()
            L8f:
                int r2 = r6.f
                int r2 = r2 + r0
                r6.f = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.F():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
            if (f(r14) != false) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
            if (r9 != 2) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
            if (r10 == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
            if (r11 != Long.MIN_VALUE) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
            if (r13 == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
            if (r13 == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:
            r11 = -r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00a5, code lost:
            r18.k = r11;
            r18.f += r8;
            r1 = 15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
            r18.j = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00b0, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
            if (r9 == 2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00b4, code lost:
            if (r9 == 4) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
            if (r9 != 7) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
            return 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00bc, code lost:
            r18.l = r8;
            r1 = 16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00c1, code lost:
            return 0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int G() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.G():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
            J();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void H() throws java.io.IOException {
            /*
                r4 = this;
            L0:
                r0 = 0
            L1:
                int r1 = r4.f
                int r2 = r1 + r0
                int r3 = r4.g
                if (r2 >= r3) goto L51
                char[] r2 = r4.e
                int r1 = r1 + r0
                char r1 = r2[r1]
                r2 = 9
                if (r1 == r2) goto L4b
                r2 = 10
                if (r1 == r2) goto L4b
                r2 = 12
                if (r1 == r2) goto L4b
                r2 = 13
                if (r1 == r2) goto L4b
                r2 = 32
                if (r1 == r2) goto L4b
                r2 = 35
                if (r1 == r2) goto L48
                r2 = 44
                if (r1 == r2) goto L4b
                r2 = 47
                if (r1 == r2) goto L48
                r2 = 61
                if (r1 == r2) goto L48
                r2 = 123(0x7b, float:1.72E-43)
                if (r1 == r2) goto L4b
                r2 = 125(0x7d, float:1.75E-43)
                if (r1 == r2) goto L4b
                r2 = 58
                if (r1 == r2) goto L4b
                r2 = 59
                if (r1 == r2) goto L48
                switch(r1) {
                    case 91: goto L4b;
                    case 92: goto L48;
                    case 93: goto L4b;
                    default: goto L45;
                }
            L45:
                int r0 = r0 + 1
                goto L1
            L48:
                r4.J()
            L4b:
                int r1 = r4.f
                int r1 = r1 + r0
                r4.f = r1
                return
            L51:
                int r1 = r1 + r0
                r4.f = r1
                r0 = 1
                boolean r0 = r4.m(r0)
                if (r0 != 0) goto L0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.H():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int I() {
            return this.h + 1;
        }

        private void J() throws IOException {
            if (!this.f867d) {
                throw j("Use JsonReader.setLenient(true) to accept malformed JSON");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int K() {
            return (this.f - this.i) + 1;
        }

        private void L() throws IOException {
            char c2;
            do {
                if (this.f >= this.g && !m(1)) {
                    return;
                }
                char[] cArr = this.e;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                c2 = cArr[i];
                if (c2 == '\n') {
                    this.h++;
                    this.i = i2;
                    return;
                }
            } while (c2 != '\r');
        }

        private char M() throws IOException {
            int i;
            int i2;
            if (this.f != this.g || m(1)) {
                char[] cArr = this.e;
                int i3 = this.f;
                int i4 = i3 + 1;
                this.f = i4;
                char c2 = cArr[i3];
                if (c2 == '\n') {
                    this.h++;
                    this.i = i4;
                } else if (c2 == 'b') {
                    return '\b';
                } else {
                    if (c2 == 'f') {
                        return '\f';
                    }
                    if (c2 == 'n') {
                        return '\n';
                    }
                    if (c2 == 'r') {
                        return '\r';
                    }
                    if (c2 == 't') {
                        return '\t';
                    }
                    if (c2 == 'u') {
                        if (i4 + 4 <= this.g || m(4)) {
                            char c3 = 0;
                            int i5 = this.f;
                            int i6 = i5 + 4;
                            while (i5 < i6) {
                                char c4 = this.e[i5];
                                char c5 = (char) (c3 << 4);
                                if (c4 < '0' || c4 > '9') {
                                    if (c4 >= 'a' && c4 <= 'f') {
                                        i = c4 - 'a';
                                    } else if (c4 < 'A' || c4 > 'F') {
                                        throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                                    } else {
                                        i = c4 - 'A';
                                    }
                                    i2 = i + 10;
                                } else {
                                    i2 = c4 - '0';
                                }
                                c3 = (char) (c5 + i2);
                                i5++;
                            }
                            this.f += 4;
                            return c3;
                        }
                        throw j("Unterminated escape sequence");
                    }
                }
                return c2;
            }
            throw j("Unterminated escape sequence");
        }

        private void N() throws IOException {
            i(true);
            int i = this.f - 1;
            this.f = i;
            char[] cArr = f865b;
            if (i + cArr.length > this.g && !m(cArr.length)) {
                return;
            }
            int i2 = 0;
            while (true) {
                char[] cArr2 = f865b;
                if (i2 >= cArr2.length) {
                    this.f += cArr2.length;
                    return;
                } else if (this.e[this.f + i2] != cArr2[i2]) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        private void d(int i) {
            int i2 = this.o;
            int[] iArr = this.n;
            if (i2 == iArr.length) {
                int[] iArr2 = new int[i2 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.n = iArr2;
            }
            int[] iArr3 = this.n;
            int i3 = this.o;
            this.o = i3 + 1;
            iArr3[i3] = i;
        }

        private boolean f(char c2) throws IOException {
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                return false;
            }
            if (c2 != '#') {
                if (c2 == ',') {
                    return false;
                }
                if (c2 != '/' && c2 != '=') {
                    if (c2 == '{' || c2 == '}' || c2 == ':') {
                        return false;
                    }
                    if (c2 != ';') {
                        switch (c2) {
                            case '[':
                            case ']':
                                return false;
                            case '\\':
                                break;
                            default:
                                return true;
                        }
                    }
                }
            }
            J();
            return false;
        }

        private boolean g(String str) throws IOException {
            while (true) {
                if (this.f + str.length() > this.g && !m(str.length())) {
                    return false;
                }
                char[] cArr = this.e;
                int i = this.f;
                if (cArr[i] != '\n') {
                    for (int i2 = 0; i2 < str.length(); i2++) {
                        if (this.e[this.f + i2] != str.charAt(i2)) {
                            break;
                        }
                    }
                    return true;
                }
                this.h++;
                this.i = i + 1;
                this.f++;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
            if (r1 != '/') goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
            r7.f = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            if (r4 != r2) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
            r7.f = r4 - 1;
            r2 = m(2);
            r7.f++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
            if (r2 != false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
            J();
            r2 = r7.f;
            r3 = r0[r2];
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
            if (r3 == '*') goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
            if (r3 == '/') goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
            r7.f = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
            r7.f = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
            if (g("*\/") == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a4, code lost:
            throw j("Unterminated comment");
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
            r7.f = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
            if (r1 != '#') goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
            J();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00af, code lost:
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int i(boolean r8) throws java.io.IOException {
            /*
                r7 = this;
                char[] r0 = r7.e
            L2:
                int r1 = r7.f
            L4:
                int r2 = r7.g
            L6:
                r3 = 1
                if (r1 != r2) goto L40
                r7.f = r1
                boolean r1 = r7.m(r3)
                if (r1 != 0) goto L3c
                if (r8 != 0) goto L15
                r8 = -1
                return r8
            L15:
                java.io.EOFException r8 = new java.io.EOFException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "End of input at line "
                r0.append(r1)
                int r1 = r7.I()
                r0.append(r1)
                java.lang.String r1 = " column "
                r0.append(r1)
                int r1 = r7.K()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L3c:
                int r1 = r7.f
                int r2 = r7.g
            L40:
                int r4 = r1 + 1
                char r1 = r0[r1]
                r5 = 10
                if (r1 != r5) goto L50
                int r1 = r7.h
                int r1 = r1 + r3
                r7.h = r1
                r7.i = r4
                goto Lb0
            L50:
                r5 = 32
                if (r1 == r5) goto Lb0
                r5 = 13
                if (r1 == r5) goto Lb0
                r5 = 9
                if (r1 != r5) goto L5d
                goto Lb0
            L5d:
                r5 = 47
                if (r1 != r5) goto La5
                r7.f = r4
                r6 = 2
                if (r4 != r2) goto L76
                int r4 = r4 + (-1)
                r7.f = r4
                boolean r2 = r7.m(r6)
                int r4 = r7.f
                int r4 = r4 + r3
                r7.f = r4
                if (r2 != 0) goto L76
                return r1
            L76:
                r7.J()
                int r2 = r7.f
                char r3 = r0[r2]
                r4 = 42
                if (r3 == r4) goto L8d
                if (r3 == r5) goto L84
                return r1
            L84:
                int r2 = r2 + 1
                r7.f = r2
            L88:
                r7.L()
                goto L2
            L8d:
                int r2 = r2 + 1
                r7.f = r2
            */
            //  java.lang.String r1 = "*/"
            /*
                boolean r1 = r7.g(r1)
                if (r1 == 0) goto L9e
                int r1 = r7.f
                int r1 = r1 + r6
                goto L4
            L9e:
                java.lang.String r8 = "Unterminated comment"
                java.io.IOException r8 = r7.j(r8)
                throw r8
            La5:
                r2 = 35
                r7.f = r4
                if (r1 != r2) goto Laf
                r7.J()
                goto L88
            Laf:
                return r1
            Lb0:
                r1 = r4
                goto L6
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.i(boolean):int");
        }

        private IOException j(String str) throws IOException {
            throw new i(str + " at line " + I() + " column " + K());
        }

        private String k(char c2) throws IOException {
            char[] cArr = this.e;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = this.f;
                int i2 = this.g;
                while (true) {
                    if (i < i2) {
                        int i3 = i + 1;
                        char c3 = cArr[i];
                        if (c3 == c2) {
                            this.f = i3;
                            sb.append(cArr, i, (i3 - i) - 1);
                            return sb.toString();
                        } else if (c3 == '\\') {
                            this.f = i3;
                            sb.append(cArr, i, (i3 - i) - 1);
                            sb.append(M());
                            break;
                        } else {
                            if (c3 == '\n') {
                                this.h++;
                                this.i = i3;
                            }
                            i = i3;
                        }
                    } else {
                        sb.append(cArr, i, i - i);
                        this.f = i;
                        if (!m(1)) {
                            throw j("Unterminated string");
                        }
                    }
                }
            }
        }

        private boolean m(int i) throws IOException {
            int i2;
            int i3;
            char[] cArr = this.e;
            int i4 = this.i;
            int i5 = this.f;
            this.i = i4 - i5;
            int i6 = this.g;
            if (i6 != i5) {
                int i7 = i6 - i5;
                this.g = i7;
                System.arraycopy(cArr, i5, cArr, 0, i7);
            } else {
                this.g = 0;
            }
            this.f = 0;
            do {
                Reader reader = this.f866c;
                int i8 = this.g;
                int read = reader.read(cArr, i8, cArr.length - i8);
                if (read == -1) {
                    return false;
                }
                i2 = this.g + read;
                this.g = i2;
                if (this.h == 0 && (i3 = this.i) == 0 && i2 > 0 && cArr[0] == 65279) {
                    this.f++;
                    this.i = i3 + 1;
                    i++;
                    continue;
                }
            } while (i2 < i);
            return true;
        }

        private void r(char c2) throws IOException {
            char[] cArr = this.e;
            while (true) {
                int i = this.f;
                int i2 = this.g;
                while (true) {
                    if (i < i2) {
                        int i3 = i + 1;
                        char c3 = cArr[i];
                        if (c3 == c2) {
                            this.f = i3;
                            return;
                        } else if (c3 == '\\') {
                            this.f = i3;
                            M();
                            break;
                        } else {
                            if (c3 == '\n') {
                                this.h++;
                                this.i = i3;
                            }
                            i = i3;
                        }
                    } else {
                        this.f = i;
                        if (!m(1)) {
                            throw j("Unterminated string");
                        }
                    }
                }
            }
        }

        public void B() throws IOException {
            char c2;
            int i = 0;
            do {
                int i2 = this.j;
                if (i2 == 0) {
                    i2 = D();
                }
                if (i2 == 3) {
                    d(1);
                } else if (i2 == 1) {
                    d(3);
                } else {
                    if (i2 == 4 || i2 == 2) {
                        this.o--;
                        i--;
                    } else if (i2 == 14 || i2 == 10) {
                        H();
                    } else {
                        if (i2 == 8 || i2 == 12) {
                            c2 = '\'';
                        } else if (i2 == 9 || i2 == 13) {
                            c2 = '\"';
                        } else if (i2 == 16) {
                            this.f += this.l;
                        }
                        r(c2);
                    }
                    this.j = 0;
                }
                i++;
                this.j = 0;
            } while (i != 0);
        }

        public int C() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 15) {
                long j = this.k;
                int i2 = (int) j;
                if (j == i2) {
                    this.j = 0;
                    return i2;
                }
                throw new NumberFormatException("Expected an int but was " + this.k + " at line " + I() + " column " + K());
            }
            if (i == 16) {
                this.m = new String(this.e, this.f, this.l);
                this.f += this.l;
            } else if (i != 8 && i != 9) {
                throw new IllegalStateException("Expected an int but was " + t() + " at line " + I() + " column " + K());
            } else {
                String k = k(i == 8 ? '\'' : '\"');
                this.m = k;
                try {
                    int parseInt = Integer.parseInt(k);
                    this.j = 0;
                    return parseInt;
                } catch (NumberFormatException unused) {
                }
            }
            this.j = 11;
            double parseDouble = Double.parseDouble(this.m);
            int i3 = (int) parseDouble;
            if (i3 == parseDouble) {
                this.m = null;
                this.j = 0;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.m + " at line " + I() + " column " + K());
        }

        public final boolean E() {
            return this.f867d;
        }

        public void c() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 3) {
                d(1);
                this.j = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + t() + " at line " + I() + " column " + K());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.j = 0;
            this.n[0] = 8;
            this.o = 1;
            this.f866c.close();
        }

        public final void e(boolean z) {
            this.f867d = z;
        }

        public void l() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 4) {
                this.o--;
                this.j = 0;
                return;
            }
            throw new IllegalStateException("Expected END_ARRAY but was " + t() + " at line " + I() + " column " + K());
        }

        public void o() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 2) {
                this.o--;
                this.j = 0;
                return;
            }
            throw new IllegalStateException("Expected END_OBJECT but was " + t() + " at line " + I() + " column " + K());
        }

        public void q() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 1) {
                d(3);
                this.j = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + t() + " at line " + I() + " column " + K());
        }

        public boolean s() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            return (i == 2 || i == 4) ? false : true;
        }

        public g t() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            switch (i) {
                case 1:
                    return g.BEGIN_OBJECT;
                case 2:
                    return g.END_OBJECT;
                case 3:
                    return g.BEGIN_ARRAY;
                case 4:
                    return g.END_ARRAY;
                case 5:
                case 6:
                    return g.BOOLEAN;
                case 7:
                    return g.NULL;
                case 8:
                case 9:
                case 10:
                case 11:
                    return g.STRING;
                case 12:
                case 13:
                case 14:
                    return g.NAME;
                case 15:
                case 16:
                    return g.NUMBER;
                case 17:
                    return g.END_DOCUMENT;
                default:
                    throw new AssertionError();
            }
        }

        public String toString() {
            return getClass().getSimpleName() + " at line " + I() + " column " + K();
        }

        public String u() throws IOException {
            char c2;
            String k;
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 14) {
                k = F();
            } else {
                if (i == 12) {
                    c2 = '\'';
                } else if (i != 13) {
                    throw new IllegalStateException("Expected a name but was " + t() + " at line " + I() + " column " + K());
                } else {
                    c2 = '\"';
                }
                k = k(c2);
            }
            this.j = 0;
            return k;
        }

        public String v() throws IOException {
            String str;
            char c2;
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 10) {
                str = F();
            } else {
                if (i == 8) {
                    c2 = '\'';
                } else if (i == 9) {
                    c2 = '\"';
                } else if (i == 11) {
                    str = this.m;
                    this.m = null;
                } else if (i == 15) {
                    str = Long.toString(this.k);
                } else if (i != 16) {
                    throw new IllegalStateException("Expected a string but was " + t() + " at line " + I() + " column " + K());
                } else {
                    str = new String(this.e, this.f, this.l);
                    this.f += this.l;
                }
                str = k(c2);
            }
            this.j = 0;
            return str;
        }

        public void w() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 7) {
                this.j = 0;
                return;
            }
            throw new IllegalStateException("Expected null but was " + t() + " at line " + I() + " column " + K());
        }

        public boolean x() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 5) {
                this.j = 0;
                return true;
            } else if (i == 6) {
                this.j = 0;
                return false;
            } else {
                throw new IllegalStateException("Expected a boolean but was " + t() + " at line " + I() + " column " + K());
            }
        }

        public double y() throws IOException {
            String k;
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 15) {
                this.j = 0;
                return this.k;
            }
            if (i == 16) {
                this.m = new String(this.e, this.f, this.l);
                this.f += this.l;
            } else {
                if (i == 8 || i == 9) {
                    k = k(i == 8 ? '\'' : '\"');
                } else if (i == 10) {
                    k = F();
                } else if (i != 11) {
                    throw new IllegalStateException("Expected a double but was " + t() + " at line " + I() + " column " + K());
                }
                this.m = k;
            }
            this.j = 11;
            double parseDouble = Double.parseDouble(this.m);
            if (this.f867d || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.m = null;
                this.j = 0;
                return parseDouble;
            }
            throw new i("JSON forbids NaN and infinities: " + parseDouble + " at line " + I() + " column " + K());
        }

        public long z() throws IOException {
            int i = this.j;
            if (i == 0) {
                i = D();
            }
            if (i == 15) {
                this.j = 0;
                return this.k;
            }
            if (i == 16) {
                this.m = new String(this.e, this.f, this.l);
                this.f += this.l;
            } else if (i != 8 && i != 9) {
                throw new IllegalStateException("Expected a long but was " + t() + " at line " + I() + " column " + K());
            } else {
                String k = k(i == 8 ? '\'' : '\"');
                this.m = k;
                try {
                    long parseLong = Long.parseLong(k);
                    this.j = 0;
                    return parseLong;
                } catch (NumberFormatException unused) {
                }
            }
            this.j = 11;
            double parseDouble = Double.parseDouble(this.m);
            long j = (long) parseDouble;
            if (j == parseDouble) {
                this.m = null;
                this.j = 0;
                return j;
            }
            throw new NumberFormatException("Expected a long but was " + this.m + " at line " + I() + " column " + K());
        }
    }

    /* compiled from: JsonToken.java */
    /* loaded from: classes.dex */
    public enum g {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* compiled from: JsonWriter.java */
    /* loaded from: classes.dex */
    public class h implements Closeable, Flushable {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f869b = new String[128];

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f870c;

        /* renamed from: d  reason: collision with root package name */
        private final Writer f871d;
        private int[] e = new int[32];
        private int f = 0;
        private String g;
        private String h;
        private boolean i;
        private boolean j;
        private String k;
        private boolean l;

        static {
            for (int i = 0; i <= 31; i++) {
                f869b[i] = String.format("\\u%04x", Integer.valueOf(i));
            }
            String[] strArr = f869b;
            strArr[34] = "\\\"";
            strArr[92] = "\\\\";
            strArr[9] = "\\t";
            strArr[8] = "\\b";
            strArr[10] = "\\n";
            strArr[13] = "\\r";
            strArr[12] = "\\f";
            String[] strArr2 = (String[]) strArr.clone();
            f870c = strArr2;
            strArr2[60] = "\\u003c";
            strArr2[62] = "\\u003e";
            strArr2[38] = "\\u0026";
            strArr2[61] = "\\u003d";
            strArr2[39] = "\\u0027";
        }

        public h(Writer writer) {
            h(6);
            this.h = ":";
            this.l = true;
            Objects.requireNonNull(writer, "out == null");
            this.f871d = writer;
        }

        private void A() throws IOException {
            int a2 = a();
            if (a2 == 5) {
                this.f871d.write(44);
            } else if (a2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            z();
            k(4);
        }

        private int a() {
            int i = this.f;
            if (i != 0) {
                return this.e[i - 1];
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }

        private h b(int i, int i2, String str) throws IOException {
            int a2 = a();
            if (a2 == i2 || a2 == i) {
                if (this.k != null) {
                    throw new IllegalStateException("Dangling name: " + this.k);
                }
                this.f--;
                if (a2 == i2) {
                    z();
                }
                this.f871d.write(str);
                return this;
            }
            throw new IllegalStateException("Nesting problem.");
        }

        private h c(int i, String str) throws IOException {
            t(true);
            h(i);
            this.f871d.write(str);
            return this;
        }

        private void h(int i) {
            int i2 = this.f;
            int[] iArr = this.e;
            if (i2 == iArr.length) {
                int[] iArr2 = new int[i2 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.e = iArr2;
            }
            int[] iArr3 = this.e;
            int i3 = this.f;
            this.f = i3 + 1;
            iArr3[i3] = i;
        }

        private void k(int i) {
            this.e[this.f - 1] = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void n(java.lang.String r9) throws java.io.IOException {
            /*
                r8 = this;
                boolean r0 = r8.j
                if (r0 == 0) goto L7
                java.lang.String[] r0 = b.a.a.d.h.f870c
                goto L9
            L7:
                java.lang.String[] r0 = b.a.a.d.h.f869b
            L9:
                java.io.Writer r1 = r8.f871d
                java.lang.String r2 = "\""
                r1.write(r2)
                int r1 = r9.length()
                r3 = 0
                r4 = r3
            L16:
                if (r3 >= r1) goto L45
                char r5 = r9.charAt(r3)
                r6 = 128(0x80, float:1.794E-43)
                if (r5 >= r6) goto L25
                r5 = r0[r5]
                if (r5 != 0) goto L32
                goto L42
            L25:
                r6 = 8232(0x2028, float:1.1535E-41)
                if (r5 != r6) goto L2c
                java.lang.String r5 = "\\u2028"
                goto L32
            L2c:
                r6 = 8233(0x2029, float:1.1537E-41)
                if (r5 != r6) goto L42
                java.lang.String r5 = "\\u2029"
            L32:
                if (r4 >= r3) goto L3b
                java.io.Writer r6 = r8.f871d
                int r7 = r3 - r4
                r6.write(r9, r4, r7)
            L3b:
                java.io.Writer r4 = r8.f871d
                r4.write(r5)
                int r4 = r3 + 1
            L42:
                int r3 = r3 + 1
                goto L16
            L45:
                if (r4 >= r1) goto L4d
                java.io.Writer r0 = r8.f871d
                int r1 = r1 - r4
                r0.write(r9, r4, r1)
            L4d:
                java.io.Writer r9 = r8.f871d
                r9.write(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.h.n(java.lang.String):void");
        }

        private void t(boolean z) throws IOException {
            int a2 = a();
            if (a2 == 1) {
                k(2);
            } else if (a2 != 2) {
                if (a2 == 4) {
                    this.f871d.append((CharSequence) this.h);
                    k(5);
                    return;
                }
                if (a2 != 6) {
                    if (a2 != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.i) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                if (!this.i && !z) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                k(7);
                return;
            } else {
                this.f871d.append(',');
            }
            z();
        }

        private void x() throws IOException {
            if (this.k != null) {
                A();
                n(this.k);
                this.k = null;
            }
        }

        private void z() throws IOException {
            if (this.g == null) {
                return;
            }
            this.f871d.write("\n");
            int i = this.f;
            for (int i2 = 1; i2 < i; i2++) {
                this.f871d.write(this.g);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f871d.close();
            int i = this.f;
            if (i > 1 || (i == 1 && this.e[i - 1] != 7)) {
                throw new IOException("Incomplete document");
            }
            this.f = 0;
        }

        public h d(long j) throws IOException {
            x();
            t(false);
            this.f871d.write(Long.toString(j));
            return this;
        }

        public h e(Number number) throws IOException {
            if (number == null) {
                return u();
            }
            x();
            String obj = number.toString();
            if (this.i || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
                t(false);
                this.f871d.append((CharSequence) obj);
                return this;
            }
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }

        public h f(String str) throws IOException {
            Objects.requireNonNull(str, "name == null");
            if (this.k == null) {
                if (this.f != 0) {
                    this.k = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }

        public void flush() throws IOException {
            if (this.f == 0) {
                throw new IllegalStateException("JsonWriter is closed.");
            }
            this.f871d.flush();
        }

        public h g(boolean z) throws IOException {
            x();
            t(false);
            this.f871d.write(z ? "true" : "false");
            return this;
        }

        public h i() throws IOException {
            x();
            return c(1, "[");
        }

        public h j(String str) throws IOException {
            if (str == null) {
                return u();
            }
            x();
            t(false);
            n(str);
            return this;
        }

        public final void l(boolean z) {
            this.i = z;
        }

        public h m() throws IOException {
            x();
            return c(3, "{");
        }

        public final void o(boolean z) {
            this.l = z;
        }

        public h p() throws IOException {
            return b(1, 2, "]");
        }

        public final void q(String str) {
            String str2;
            if (str.length() == 0) {
                this.g = null;
                str2 = ":";
            } else {
                this.g = str;
                str2 = ": ";
            }
            this.h = str2;
        }

        public final void r(boolean z) {
            this.j = z;
        }

        public h s() throws IOException {
            return b(3, 5, "}");
        }

        public h u() throws IOException {
            if (this.k != null) {
                if (!this.l) {
                    this.k = null;
                    return this;
                }
                x();
            }
            t(false);
            this.f871d.write("null");
            return this;
        }

        public boolean v() {
            return this.i;
        }

        public final boolean w() {
            return this.j;
        }

        public final boolean y() {
            return this.l;
        }
    }

    /* compiled from: MalformedJsonException.java */
    /* loaded from: classes.dex */
    public final class i extends IOException {
        public i(String str) {
            super(str);
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        O000000o = aVar;
        d dVar = new d("UPPER_CAMEL_CASE", 1) { // from class: b.a.a.d.b
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.d(field.getName());
            }
        };
        O00000Oo = dVar;
        d dVar2 = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: b.a.a.d.c
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.d(d.e(field.getName(), " "));
            }
        };
        O00000o0 = dVar2;
        d dVar3 = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: b.a.a.d.d
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.e(field.getName(), "_").toLowerCase();
            }
        };
        O00000o = dVar3;
        d dVar4 = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: b.a.a.d.e
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.e(field.getName(), "-").toLowerCase();
            }
        };
        O00000oO = dVar4;
        f864b = new d[]{aVar, dVar, dVar2, dVar3, dVar4};
    }

    private d(String str, int i2) {
    }

    /* synthetic */ d(String str, int i2, a aVar) {
        this(str, i2);
    }

    private static String a(char c2, String str, int i2) {
        if (i2 < str.length()) {
            return c2 + str.substring(i2);
        }
        return String.valueOf(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            charAt = str.charAt(i2);
            if (i2 >= str.length() - 1 || Character.isLetter(charAt)) {
                break;
            }
            sb.append(charAt);
            i2++;
        }
        if (i2 == str.length()) {
            return sb.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(a(Character.toUpperCase(charAt), str, i2 + 1));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f864b.clone();
    }

    @Override // b.a.a.g
    public abstract /* synthetic */ String O000000o(Field field);
}
