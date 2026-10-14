package util;

import java.text.NumberFormat;
import java.util.Locale;

public final class CurrencyFormatter {
    private CurrencyFormatter() {

    }

    public static String format(long amount) {
        NumberFormat format = NumberFormat.getIntegerInstance(Locale.forLanguageTag("vi-VN"));

        return format.format(amount) + " VND";
    }
}
