package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class ArrayDominatorTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1:0",
            "1,2,3,1,2,1,3,1,1,1:0",
            "1,2:-1",
            ":-1"
    })
    void test(String input) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(input);
        Assertions.assertThat(new ArrayDominator().solution(casus.data)).isEqualTo(casus.expected);
    }
}