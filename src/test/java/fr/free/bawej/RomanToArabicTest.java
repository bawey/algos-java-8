package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RomanToArabicTest {

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(50, "L"),
                Arguments.of(1140, "MCXL"),
                Arguments.of(190, "CXC"),
                Arguments.of(0, ""),
                Arguments.of(2, "II"),
                Arguments.of(12, "XII"),
                Arguments.of(4, "IV"),
                Arguments.of(1994, "MCMXCIV")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void testConversion(int expected, String input) {
        assertThat(new RomanToArabic().romanToInt(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"IIX", "IVX"})
    void testDetectingInvalidLiterals(String input) {
        assertThatThrownBy(() -> new RomanToArabic().romanToInt(input)).isInstanceOf(IllegalArgumentException.class);
    }


}