package fr.free.bawej.cases;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringToIntCase {
    public final String provided;
    public final int expected;

    public static StringToIntCase fromString(String input) {
        String[] tokens = input.split(":");
        return new StringToIntCase(tokens[0], Integer.parseInt(tokens[1]));
    }
}
