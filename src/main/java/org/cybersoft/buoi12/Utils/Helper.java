package org.cybersoft.buoi12.Utils;

import java.text.DecimalFormat;

public class Helper {
    private static DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.##");

    public static String formatCurrency(double value) {
        return decimalFormat.format(value);
    }
}
