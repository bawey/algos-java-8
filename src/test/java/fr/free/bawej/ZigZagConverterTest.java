package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZigZagConverterTest {

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("", 0, ""),
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 1, "PAYPALISHIRING"),
                Arguments.of("PAYPALISHIRING", 2, "PYAIHRNAPLSIIG"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void test(String input, int rows, String expected) {
        assertThat(new ZigZagConverter().convert(input, rows)).isEqualTo(expected);
    }
}