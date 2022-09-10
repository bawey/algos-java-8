package fr.free.bawej;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MinAvgSliceTest {

    @RequiredArgsConstructor
    static class TestCase {
        public final int expected;
        public final int[] data;

        public static MissingIntegerTest.TestCase fromString(String input) {
            List<Integer> ints = Arrays.stream(input.split("(,|:)")).sequential().map(Integer::parseInt).collect(Collectors.toList());
            return new MissingIntegerTest.TestCase(ints.get(0), ints.subList(1, ints.size()).stream().mapToInt(Integer::intValue).toArray());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0:-1,-2",
            "9:-1,5,6,7,8,9,11,4,3,2,1",
            "1:4,2,2,5,1,5,8",
            "2:7,8,1,3,1,3,1,9,7",
            "2:-3,-5,-8,-4,-10",
            "1:7,2,9,1"
    })
    void test(String testData) {
        MissingIntegerTest.TestCase testCase = MissingIntegerTest.TestCase.fromString(testData);
        Assertions.assertThat(new MinAvgSlice().solution(testCase.data)).isEqualTo(testCase.expected);
    }

}