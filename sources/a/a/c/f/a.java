package a.a.c.f;

import a.a.c.g.f;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class a implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f266b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Spannable f267c;

    /* renamed from: d  reason: collision with root package name */
    private final C0011a f268d;
    private final PrecomputedText e;

    public C0011a a() {
        return this.f268d;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f267c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f267c.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f267c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f267c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f267c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.e.getSpans(i, i2, cls);
        }
        return (T[]) this.f267c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f267c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f267c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.removeSpan(obj);
                return;
            } else {
                this.f267c.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.f267c.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f267c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f267c.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: a.a.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0011a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f269a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f270b;

        /* renamed from: c  reason: collision with root package name */
        private final int f271c;

        /* renamed from: d  reason: collision with root package name */
        private final int f272d;
        final PrecomputedText.Params e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: a.a.c.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0012a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f273a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f274b;

            /* renamed from: c  reason: collision with root package name */
            private int f275c;

            /* renamed from: d  reason: collision with root package name */
            private int f276d;

            public C0012a(TextPaint textPaint) {
                this.f273a = textPaint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.f275c = 1;
                    this.f276d = 1;
                } else {
                    this.f276d = 0;
                    this.f275c = 0;
                }
                if (i >= 18) {
                    this.f274b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f274b = null;
                }
            }

            public C0011a a() {
                return new C0011a(this.f273a, this.f274b, this.f275c, this.f276d);
            }

            public C0012a b(int i) {
                this.f275c = i;
                return this;
            }

            public C0012a c(int i) {
                this.f276d = i;
                return this;
            }

            public C0012a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f274b = textDirectionHeuristic;
                return this;
            }
        }

        C0011a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.e = null;
            }
            this.f269a = textPaint;
            this.f270b = textDirectionHeuristic;
            this.f271c = i;
            this.f272d = i2;
        }

        public int a() {
            return this.f271c;
        }

        public int b() {
            return this.f272d;
        }

        public TextDirectionHeuristic c() {
            return this.f270b;
        }

        public TextPaint d() {
            return this.f269a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof C0011a)) {
                return false;
            }
            C0011a c0011a = (C0011a) obj;
            PrecomputedText.Params params = this.e;
            if (params != null) {
                return params.equals(c0011a.e);
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 23 || (this.f271c == c0011a.a() && this.f272d == c0011a.b())) {
                if ((i < 18 || this.f270b == c0011a.c()) && this.f269a.getTextSize() == c0011a.d().getTextSize() && this.f269a.getTextScaleX() == c0011a.d().getTextScaleX() && this.f269a.getTextSkewX() == c0011a.d().getTextSkewX()) {
                    if ((i < 21 || (this.f269a.getLetterSpacing() == c0011a.d().getLetterSpacing() && TextUtils.equals(this.f269a.getFontFeatureSettings(), c0011a.d().getFontFeatureSettings()))) && this.f269a.getFlags() == c0011a.d().getFlags()) {
                        if (i >= 24) {
                            if (!this.f269a.getTextLocales().equals(c0011a.d().getTextLocales())) {
                                return false;
                            }
                        } else if (i >= 17 && !this.f269a.getTextLocale().equals(c0011a.d().getTextLocale())) {
                            return false;
                        }
                        if (this.f269a.getTypeface() == null) {
                            if (c0011a.d().getTypeface() != null) {
                                return false;
                            }
                        } else if (!this.f269a.getTypeface().equals(c0011a.d().getTypeface())) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return f.a(Float.valueOf(this.f269a.getTextSize()), Float.valueOf(this.f269a.getTextScaleX()), Float.valueOf(this.f269a.getTextSkewX()), Float.valueOf(this.f269a.getLetterSpacing()), Integer.valueOf(this.f269a.getFlags()), this.f269a.getTextLocales(), this.f269a.getTypeface(), Boolean.valueOf(this.f269a.isElegantTextHeight()), this.f270b, Integer.valueOf(this.f271c), Integer.valueOf(this.f272d));
            }
            if (i >= 21) {
                return f.a(Float.valueOf(this.f269a.getTextSize()), Float.valueOf(this.f269a.getTextScaleX()), Float.valueOf(this.f269a.getTextSkewX()), Float.valueOf(this.f269a.getLetterSpacing()), Integer.valueOf(this.f269a.getFlags()), this.f269a.getTextLocale(), this.f269a.getTypeface(), Boolean.valueOf(this.f269a.isElegantTextHeight()), this.f270b, Integer.valueOf(this.f271c), Integer.valueOf(this.f272d));
            }
            if (i >= 18) {
                return f.a(Float.valueOf(this.f269a.getTextSize()), Float.valueOf(this.f269a.getTextScaleX()), Float.valueOf(this.f269a.getTextSkewX()), Integer.valueOf(this.f269a.getFlags()), this.f269a.getTextLocale(), this.f269a.getTypeface(), this.f270b, Integer.valueOf(this.f271c), Integer.valueOf(this.f272d));
            }
            if (i >= 17) {
                return f.a(Float.valueOf(this.f269a.getTextSize()), Float.valueOf(this.f269a.getTextScaleX()), Float.valueOf(this.f269a.getTextSkewX()), Integer.valueOf(this.f269a.getFlags()), this.f269a.getTextLocale(), this.f269a.getTypeface(), this.f270b, Integer.valueOf(this.f271c), Integer.valueOf(this.f272d));
            }
            return f.a(Float.valueOf(this.f269a.getTextSize()), Float.valueOf(this.f269a.getTextScaleX()), Float.valueOf(this.f269a.getTextSkewX()), Integer.valueOf(this.f269a.getFlags()), this.f269a.getTypeface(), this.f270b, Integer.valueOf(this.f271c), Integer.valueOf(this.f272d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f269a.getTextSize());
            sb.append(", textScaleX=" + this.f269a.getTextScaleX());
            sb.append(", textSkewX=" + this.f269a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                sb.append(", letterSpacing=" + this.f269a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f269a.isElegantTextHeight());
            }
            if (i >= 24) {
                sb.append(", textLocale=" + this.f269a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f269a.getTextLocale());
            }
            sb.append(", typeface=" + this.f269a.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.f269a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f270b);
            sb.append(", breakStrategy=" + this.f271c);
            sb.append(", hyphenationFrequency=" + this.f272d);
            sb.append("}");
            return sb.toString();
        }

        public C0011a(PrecomputedText.Params params) {
            this.f269a = params.getTextPaint();
            this.f270b = params.getTextDirection();
            this.f271c = params.getBreakStrategy();
            this.f272d = params.getHyphenationFrequency();
            this.e = params;
        }
    }
}
