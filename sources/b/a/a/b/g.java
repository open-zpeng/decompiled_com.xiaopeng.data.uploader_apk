package b.a.a.b;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes.dex */
public final class g extends Number {

    /* renamed from: b  reason: collision with root package name */
    private final String f842b;

    public g(String str) {
        this.f842b = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f842b);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f842b);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f842b);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f842b);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f842b).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f842b);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f842b).longValue();
        }
    }

    public String toString() {
        return this.f842b;
    }
}
