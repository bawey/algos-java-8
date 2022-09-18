package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MinAbsSumTest {

    public static int solveSlowly(int[] elements) {
        Set<Integer> partials = new HashSet<>();
        Set<Integer> previousPartials;
        partials.add(0);
        for (int element : elements) {
            previousPartials = partials;
            partials = new HashSet<>();
            for (int previousPartial : previousPartials) {
                partials.add(Math.abs(previousPartial + element));
                partials.add(Math.abs(previousPartial - element));
            }
        }
        return partials.stream().min(Integer::compare).orElse(-1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1, 5, 2, -2 : 0",
            "1 : 1",
            "8, 9: 1",
            "3, 3, 3, 4, 5 : 0",
            "36, 38, 41: 33",
            "31, 29, 61, 79: 6",
            // 212 total:
            "34, -79, 37, -62: 14",
            "9, 38, -15, -92, 45: 3",
            "9, 8, 4, 3, 1 : 1",
            "9, 7, 5, 4: 1"
    })
    void test(String casusString) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(casusString);
        Assertions.assertThat(new MinAbsSum().solution(casus.data)).isEqualTo(casus.expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1, 10, 20, 1, -8", "9, 7, 5, 4", "34, -79, 37, -62"
    })
    void crossTest(String inputString) {
        int[] input = Arrays.stream(inputString.split(",")).map(String::trim).mapToInt(Integer::valueOf).toArray();
        Assertions.assertThat(new MinAbsSum().solution(input)).isEqualTo(solveSlowly(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void randomizedCrossTest(int size) {
        int[] input = Stream.generate(() -> (int) (Math.random() * 200 - 100)).limit(size).mapToInt(Integer::intValue).toArray();
        int actual = new MinAbsSum().solution(input);
        int expected = solveSlowly(input);
        Assertions.assertThat(actual).overridingErrorMessage(
                        () -> "Did not work for " + IntStream.of(input).boxed().collect(Collectors.toList())
                                + String.format(". Got %d instead of %d", actual, expected))
                .isEqualTo(expected);
    }


}