package fr.free.bawej;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */

public class ZigZagConverter {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> builders = Stream.generate(StringBuilder::new).limit(s.length()).collect(Collectors.toList());
        for (int vector = 1, row = 0, i = 0; i < s.length(); ++i, row += vector) {
            builders.get(row).append(s.charAt(i));
            // bouncing off the edges
            if (row == numRows - 1) vector = -1;
            if (row == 0) vector = 1;
        }
        return builders.stream().map(StringBuilder::toString).collect(Collectors.joining());
    }
}
