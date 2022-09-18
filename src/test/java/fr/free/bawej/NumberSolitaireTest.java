package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSolitaireTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1:1",
            "1,2:3",
            "1,-2,0,9,-1,-2:8",
            "0,-4,-5,-2,-7,-9,-3,-10:-12"
    })
    void test(String input) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(input);
        assertThat(new NumberSolitaire().solution(casus.data)).isEqualTo(casus.expected);
    }

}