package fr.free.bawej;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneKeypadDigitsSubstitutor {

    private static final String[] lookup = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        final List<Integer> inputNumbers = digits.chars().map(c -> Integer.parseInt(String.valueOf((char) c)))
                .boxed().collect(Collectors.toList());
        final int length = digits.length();
        final int totalCombinations = inputNumbers.stream().map(i -> lookup[i].length())
                .reduce(1, (soFar, newOne) -> soFar * newOne);

        char[][] answers = new char[totalCombinations][length];

        // used to track the combinations up to the current position
        int combosUpToTheCursor = 1;
        for (int pos = 0; pos < digits.length(); ++pos) {
            final int digit = inputNumbers.get(pos);
            int charVariantNo = 0;
            for (int i = 0; i < totalCombinations; i += combosUpToTheCursor) {
                for (int j = 0; j < combosUpToTheCursor; ++j) {
                    answers[i + j][pos] = lookup[digit].charAt(charVariantNo);
                }
                charVariantNo = (charVariantNo + 1) % lookup[digit].length();
            }
            combosUpToTheCursor *= lookup[digit].length();
        }

        List<String> result = new ArrayList<>(totalCombinations);
        for (int i = 0; i < totalCombinations; ++i) {
            result.add(i, new String(answers[i]));
        }
        return result;
    }


}
