package fr.free.bawej.cases;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class IntArrayToIntCase {
    public final int[] data;
    public final int expected;

    /**
     * @param input String of ints like "a1,a2,a3,a4:expected"
     * @return {@link IntArrayToIntCase} instance wrapping the test data and expected answer
     */
    public static IntArrayToIntCase fromString(String input) {
        List<Integer> ints = Arrays.stream(input.split("(,|:)")).sequential().map(Integer::parseInt).collect(Collectors.toList());
        return new IntArrayToIntCase(ints.subList(0, ints.size() - 1).stream().mapToInt(Integer::intValue).toArray(), ints.get(ints.size() - 1));
    }

}
