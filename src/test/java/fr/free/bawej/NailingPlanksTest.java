package fr.free.bawej;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NailingPlanksTest {

    static class CasesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new int[]{1, 4, 5, 8}, new int[]{4, 5, 9, 10}, new int[]{4, 6, 7, 10, 2}, 4),
                    Arguments.of(new int[]{1}, new int[]{2}, new int[]{6, 7, 8}, -1),
                    Arguments.of(new int[]{}, new int[]{}, new int[]{}, 0),
                    Arguments.of(new int[]{1, 5}, new int[]{10, 15}, new int[]{3, 6, 11}, 2),
                    Arguments.of(new int[]{4}, new int[]{4}, new int[]{4}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CasesProvider.class)
    void test(int[] plankStarts, int[] plankEnds, int[] nailSpots, int expectedAnswer) {
        assertThat(new NailingPlanks().solution(plankStarts, plankEnds, nailSpots)).isEqualTo(expectedAnswer);
    }
}