package fr.free.bawej;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class UnpairedElementTest {

    static class Provider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(1, new int[]{1}),
                    Arguments.of(22, new int[]{1, 22, 1}),
                    Arguments.of(7, new int[]{9, 3, 9, 3, 9, 7, 9}),
                    Arguments.of(7, new int[]{9, 7, 3, 9, 3, 9, 7, 9, 7})
            );
        }
    }


    @ParameterizedTest
    @ArgumentsSource(Provider.class)
    void test(int expected, int[] provided) {
        Assertions.assertThat(new UnpairedElement().solution(provided)).isEqualTo(expected);
    }

}