package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MyAtoiTest {

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("    -42", -42),
                Arguments.of("     5x", 5),
                Arguments.of("foo and     5x", 0),
                Arguments.of(BigDecimal.valueOf(Integer.MAX_VALUE).add(BigDecimal.TEN).toString(), Integer.MAX_VALUE),
                Arguments.of(BigDecimal.valueOf(Integer.MIN_VALUE).subtract(BigDecimal.TEN).toString(), Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void test(String input, int result) {
        assertThat(new MyAtoi().myAtoi(input)).isEqualTo(result);
    }
}