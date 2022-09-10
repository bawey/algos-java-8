package fr.free.bawej;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FrogJumpTest {

    @RequiredArgsConstructor
    public static class TestCase {
        public final int expected;
        public final int x;
        public final int y;
        public final int d;

        public static TestCase fromString(String input) {
            List<Integer> ints = Arrays.stream(input.split(",")).sequential().map(Integer::valueOf).collect(Collectors.toList());
            return new TestCase(ints.get(0), ints.get(1), ints.get(2), ints.get(3));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0,10,10,100",
            "1,10,11,100",
            "1,10,17,7",
            "2,10,24,7",
            "1000000000,0,1000000000,1"
    })
    void test(String testCaseString) {
        TestCase testCase = TestCase.fromString(testCaseString);
        Assertions.assertThat(new FrogJump().solution(testCase.x, testCase.y, testCase.d)).isEqualTo(testCase.expected);
    }
}