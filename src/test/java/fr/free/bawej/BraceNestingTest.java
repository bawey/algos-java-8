package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

;

class BraceNestingTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "[()]", "", "()", "{[()()]}"
    })
    void testValid(String input) {
        assertThat(new BraceNesting().solution(input)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "[({)}]", "[", "[}", "([)()]", "}{"
    })
    void testInvalid(String input) {
        assertThat(new BraceNesting().solution(input)).isEqualTo(0);
    }
}