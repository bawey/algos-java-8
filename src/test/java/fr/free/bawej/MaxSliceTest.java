package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MaxSliceTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1:1",
            "1,-1,1:1",
            "1,2,-1,4:6",
            "1,2,-4,5,1:6",
            "4,-3,7,-5,9:12",
            "1,2,3,-1,-2,-3:6",
            "3,2,-6,4,0:5",
            "-1:-1",
            "-8,-6,-1,-5:-1"
    })
    void test(String input) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(input);
        Assertions.assertThat(new MaxSlice().solution(casus.data)).isEqualTo(casus.expected);
    }

}