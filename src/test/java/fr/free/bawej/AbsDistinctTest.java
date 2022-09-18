package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class AbsDistinctTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "-5,-3,-1,0,3,6:5",
            "-1,-1, 1, 1: 1",
            "-1, 1, 1, 1: 1",
            "1,2:2",
            "-2147483648, -1, 0, 1: 3"
    })
    void test(String input) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(input);
        assertThat(new AbsDistinct().solution(casus.data)).isEqualTo(casus.expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 8, 10, 100, 100, 100, 100, 100, 100, 1000, 10000})
    void randomizedTest(int size) {
        int[] input = IntStream.generate(() -> (int) (Math.random() * 100_000 - 50_000)).limit(size).sorted().toArray();
        int referenceAbsDistinct = (int) IntStream.of(input).boxed().map(Math::abs).distinct().count();
        assertThat(new AbsDistinct().solution(input)).isEqualTo(referenceAbsDistinct);
    }
}