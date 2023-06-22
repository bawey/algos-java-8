package fr.free.bawej;

import java.util.Arrays;

public class RomanIntegerParser {

    private static final char[] symbols = {'C', 'D', 'I', 'L', 'M', 'V', 'X'};
    private static final int[] values = {100, 500, 1, 50, 1000, 5, 10};


    public boolean isValidRomanLiteral(String input) {

        for (int i = 1; i < input.length(); ++i) {
            final int symbolValue = evaluateCharacter(input.charAt(i));
            final int previousValue = evaluateCharacter(input.charAt(i - 1));
            if (symbolValue >= previousValue) {
                if (i + 1 < input.length() && evaluateCharacter(input.charAt(i + 1)) > symbolValue) {
                    return false;
                }
            }
        }
        return true;
    }

    public int romanToInt(String input) {
        if (!isValidRomanLiteral(input)) {
            throw new IllegalArgumentException("String " + input + " is not a valid roman number!");
        }
        String roman = input.toUpperCase();
        int total = 0;
        int buffered = 0;
        for (int i = 0; i <= roman.length(); ++i) {
            if (i == roman.length()) {
                total += buffered;
            } else {
                int value = evaluateCharacter(roman.charAt(i));
                if (value <= buffered) {
                    total += buffered;
                    buffered = value;
                } else {
                    buffered = value - buffered;
                }
            }
        }
        return total;
    }

    private static int evaluateCharacter(char c) {
        final int idx = Arrays.binarySearch(symbols, c);
        return idx >= 0 ? values[idx] : 0;
    }
}
