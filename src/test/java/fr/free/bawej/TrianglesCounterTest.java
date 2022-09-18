package fr.free.bawej;

import fr.free.bawej.cases.IntArrayToIntCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TrianglesCounterTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1,1,1:1",
            "1,1,2:0",
            "10,2,5,1,8,12:4",
            "2,5,8,10,12:4",
            "3,3,5,6:3"
    })
    void test(String input) {
        IntArrayToIntCase casus = IntArrayToIntCase.fromString(input);
        assertThat(new TrianglesCounter().solution(casus.data)).isEqualTo(casus.expected);
    }


    private int countBrutally(int[] edges) {
        int count = 0;
        for (int i = 0; i < edges.length - 2; ++i) {
            for (int j = i + 1; j < edges.length - 1; ++j) {
                for (int k = j + 1; k < edges.length; ++k) {
                    if (
                            edges[i] + edges[j] > edges[k] &&
                                    edges[j] + edges[k] > edges[i] &&
                                    edges[k] + edges[i] > edges[j]
                    ) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 9, 10, 100})
    void crossTest(int edgeCount) {
        int[] edges = Stream.generate(() -> 1 + (int) (Math.random() * 10)).limit(edgeCount).mapToInt(Integer::intValue).toArray();
        int actual = new TrianglesCounter().solution(edges);
        int expected = countBrutally(edges);
        assertThat(actual).overridingErrorMessage(() ->
                String.format("Expected %d, got %d for %s", expected, actual, IntStream.of(edges).boxed()
                        .map(Object::toString).collect(Collectors.joining(", ")))).isEqualTo(expected);
    }

}