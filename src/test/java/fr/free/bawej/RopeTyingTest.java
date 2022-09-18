package fr.free.bawej;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class RopeTyingTest {

    static class CasesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(3, 4, new int[]{1, 2, 3, 4, 1, 1, 3}),
                    Arguments.of(1, 3, new int[]{1, 1, 1, 1, 1}),
                    Arguments.of(0, 10, new int[]{1, 2, 3, 2}),
                    Arguments.of(2, 4, new int[]{3, 2, 1, 2, 3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CasesProvider.class)
    void test(int expected, int minLength, int[] input) {
        Assertions.assertThat(new RopeTying().solution(minLength, input)).isEqualTo(expected);
    }
}