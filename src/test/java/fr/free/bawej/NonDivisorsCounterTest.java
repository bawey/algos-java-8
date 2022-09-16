package fr.free.bawej;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NonDivisorsCounterTest {

    static class CasesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new int[]{3, 1, 2, 3, 6}, new int[]{2, 4, 3, 2, 0}),
                    Arguments.of(new int[]{1, 3, 6, 7, 14}, new int[]{4, 3, 2, 3, 2}),
                    Arguments.of(new int[]{1}, new int[]{0}),
                    Arguments.of(new int[]{3, 7}, new int[]{1, 1}),
                    Arguments.of(new int[]{3, 7, 21}, new int[]{2, 2, 0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CasesProvider.class)
    void test(int[] input, int[] expected) {
        assertThat(new NonDivisorsCounter().solution(input)).containsExactly(expected);
    }
}