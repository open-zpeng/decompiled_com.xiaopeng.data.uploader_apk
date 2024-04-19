package com.xiaopeng.lib.utils;

import android.annotation.SuppressLint;
import android.util.Log;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
/* loaded from: classes.dex */
public class NumberUtils {
    private static final String TAG = "com.xiaopeng.lib.utils.NumberUtils";
    private static DecimalFormatSymbols sSymbols = new DecimalFormatSymbols();
    private static String sPattern = "#,###.00";
    private static DecimalFormat sDecimalFormat = new DecimalFormat(sPattern, sSymbols);

    @SuppressLint({"LongLogTag"})
    public static String getCountryNumberFormat(Locale locale, double d2) {
        String country = locale.getCountry();
        country.hashCode();
        char c2 = 65535;
        switch (country.hashCode()) {
            case 2099:
                if (country.equals("AT")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2115:
                if (country.equals("BE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2149:
                if (country.equals("CH")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2177:
                if (country.equals("DE")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2183:
                if (country.equals("DK")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2252:
                if (country.equals("FR")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2494:
                if (country.equals("NL")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2497:
                if (country.equals("NO")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2642:
                if (country.equals("SE")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 6:
                sSymbols.setGroupingSeparator('.');
                sSymbols.setDecimalSeparator(',');
                break;
            case 2:
                sSymbols.setGroupingSeparator('\'');
                sSymbols.setDecimalSeparator('.');
                break;
            case 5:
            case 7:
            case '\b':
                sSymbols.setGroupingSeparator(' ');
                sSymbols.setDecimalSeparator(',');
                break;
            default:
                Log.d(TAG, "The country is not considered");
                sSymbols.setGroupingSeparator(' ');
                sSymbols.setDecimalSeparator(',');
                break;
        }
        sDecimalFormat.setDecimalFormatSymbols(sSymbols);
        return sDecimalFormat.format(d2);
    }
}
