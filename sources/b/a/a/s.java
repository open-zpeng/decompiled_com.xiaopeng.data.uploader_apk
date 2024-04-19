package b.a.a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* loaded from: classes.dex */
public abstract class s {
    public static final s O000000o;
    public static final s O00000Oo;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ s[] f891b;

    /* compiled from: LongSerializationPolicy.java */
    /* loaded from: classes.dex */
    enum a extends s {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.a.a.s
        public v O000000o(Long l) {
            return new p(l);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        O000000o = aVar;
        s sVar = new s("STRING", 1) { // from class: b.a.a.s.b
            @Override // b.a.a.s
            public v O000000o(Long l) {
                return new p(String.valueOf(l));
            }
        };
        O00000Oo = sVar;
        f891b = new s[]{aVar, sVar};
    }

    private s(String str, int i) {
    }

    /* synthetic */ s(String str, int i, a aVar) {
        this(str, i);
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f891b.clone();
    }

    public abstract v O000000o(Long l);
}
