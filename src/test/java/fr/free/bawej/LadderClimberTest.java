package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderClimberTest {

    @Test
    void testSample() {
        assertThat(new LadderClimber().solution(
                new int[]{4, 4, 5, 5, 1},
                new int[]{3, 2, 4, 3, 1}
        )).containsExactly(5, 1, 8, 0, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1, 10: 1",
            "2, 10: 2",
            "3, 10: 3",
            "4, 10: 5",
            "4, 1: 1",
            "4, 2: 1",
            "4, 3: 5",
            "5, 10: 8",
            "5, 1: 0",
            "5, 2: 0",
            "5, 3: 0"
    })
    void testSingletons(String caseString) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(caseString);
        int rungs = casus.data[0];
        int precision = casus.data[1];
        assertThat(new LadderClimber().solution(new int[]{rungs}, new int[]{precision})).containsExactly(casus.expected);
    }
}