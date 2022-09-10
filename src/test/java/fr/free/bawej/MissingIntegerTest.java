package fr.free.bawej;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MissingIntegerTest {

    @RequiredArgsConstructor
    static class TestCase {
        public final int expected;
        public final int[] data;

        public static TestCase fromString(String input) {
            List<Integer> ints = Arrays.stream(input.split("(,|:)")).sequential().map(Integer::parseInt).collect(Collectors.toList());
            return new TestCase(ints.get(0), ints.subList(1, ints.size()).stream().mapToInt(Integer::intValue).toArray());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1:-1,-2",
            "10:-1,5,6,7,8,9,11,4,3,2,1"
    })
    void test(String testData) {
        TestCase testCase = TestCase.fromString(testData);
        Assertions.assertThat(new MissingInteger().solution(testCase.data)).isEqualTo(testCase.expected);
    }
}