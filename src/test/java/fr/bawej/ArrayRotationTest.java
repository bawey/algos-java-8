package fr.bawej;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class ArrayRotationTest {

    @RequiredArgsConstructor
    static class Case {
        public final int[] expected;
        public final int[] provided;
        public final int rotations;
    }

    static class Suite implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new Case(new int[]{}, new int[]{}, 1000)),
                    Arguments.of(new Case(new int[]{4, 4, 2}, new int[]{4, 4, 2}, 0)),
                    Arguments.of(new Case(new int[]{2, 4, 4}, new int[]{4, 4, 2}, 1)),
                    Arguments.of(new Case(new int[]{4, 2, 4}, new int[]{4, 4, 2}, 2)),
                    Arguments.of(new Case(new int[]{4, 2, 4}, new int[]{4, 4, 2}, 5)),
                    Arguments.of(new Case(new int[]{4, 4, 2}, new int[]{4, 4, 2}, 3)),
                    Arguments.of(new Case(new int[]{4, 4, 2}, new int[]{4, 4, 2}, 33))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(Suite.class)
    void testFoo(Case testCase) {
        Assertions.assertThat(new ArrayRotation().solution(testCase.provided, testCase.rotations)).containsExactly(testCase.expected);
    }
}