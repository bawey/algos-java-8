package fr.free.bawej;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtoi {

    private static final BigDecimal MAX = BigDecimal.valueOf(Integer.MAX_VALUE);
    private static final BigDecimal MIN = BigDecimal.valueOf(Integer.MIN_VALUE);

    public int myAtoi(String s) {
        Pattern p = Pattern.compile("^(?: )*([+-]?[0-9]+)");
        Matcher m = p.matcher(s);
        if (m.find()) {
            BigDecimal bd = new BigDecimal(m.group(1));
            if (bd.compareTo(MIN) <= 0) {
                return MIN.intValue();
            }
            if (bd.compareTo(MAX) >= 0) {
                return MAX.intValue();
            }
            return bd.intValue();
        }
        return 0;
    }
}
