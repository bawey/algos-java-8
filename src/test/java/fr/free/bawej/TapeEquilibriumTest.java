package fr.free.bawej;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class TapeEquilibriumTest {
    private TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

    @RequiredArgsConstructor
    static class TestCase {
        public final int[] input;
        public final int expected;

        public static TestCase fromString(String input) {
            String[] tokens = input.split(":");
            return new TestCase(
                    Arrays.stream(tokens[1].split(",")).map(String::trim).map(Integer::parseInt).mapToInt(Integer::intValue).toArray()
                    , Integer.parseInt(tokens[0]));
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0:1,1", "1:1,1,2,1", "1:1,3,4,6,3", "2:6,2,4,8,6", "6:1,7", "2:-1,1", "2000:-1000,1000", "0:-2,-3,-4,-1"
    })
    void test(String input) {
        TestCase testCase = TestCase.fromString(input);
        Assertions.assertThat(tapeEquilibrium.solution(testCase.input)).isEqualTo(testCase.expected);
    }

}