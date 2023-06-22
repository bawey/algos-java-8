package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RomanIntegerWriterTest {

    static Stream<Arguments> provideCases() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(44, "XLIV"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    void test(int integer, String string) {
        assertThat(new RomanIntegerWriter().intToRoman(integer)).isEqualTo(string);
    }
}