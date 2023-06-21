package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneKeypadDigitsSubstitutorTest {

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("2", Arrays.asList("a", "b", "c")),
                Arguments.of("92", Arrays.asList("wa", "xa", "ya", "za", "wb", "xb", "yb", "zb", "wc", "xc", "yc", "zc")),
                Arguments.of("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("", Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void test(String input, List<String> expectedResults) {
        assertThat(new PhoneKeypadDigitsSubstitutor().letterCombinations(input)).containsExactlyInAnyOrderElementsOf(expectedResults);
    }
}