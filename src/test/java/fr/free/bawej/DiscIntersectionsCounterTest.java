package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiscIntersectionsCounterTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1,5,2,1,4,0:11",
            "0,0,0:0",
            "10:0",
            "10,1:1",
            "1,1:1",
            "1,2,1:3",
            "1,3,1:3",
            "1,0,1:3",
            "1,2147483647,0:2"
    })
    void test(String testData) {
        IntArrayToIntCase tc = IntArrayToIntCase.fromString(testData);
        Assertions.assertThat(new DiscIntersectionsCounter().solution(tc.data)).isEqualTo(tc.expected);
    }
}