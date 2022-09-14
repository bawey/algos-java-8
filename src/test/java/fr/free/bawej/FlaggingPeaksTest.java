package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class FlaggingPeaksTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2: 3",
            "2, 2, 4, 1, 3, 2, 4, 5, 4, 4: 2",
            "0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0: 3",
            "5: 0",
            "0, 1, 1, 0: 0",
            "0, 1, 1, 2: 0",
            "0, 1, 0: 1",
            "0, 0, 0, 0, 0, 1, 0, 1, 0, 1: 2",
            "0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 : 4",
            "0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 : 4"

    })
    void test(String caseString) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(caseString);
        Assertions.assertThat(new FlaggingPeaks().solution(casus.data)).isEqualTo(casus.expected);


    }
}