package fr.bawej;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoProblemTest {

    static class Wisdom implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(0, new int[]{0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(Wisdom.class)
    void testFoo(int expected, int[] input) {
        assertEquals(expected, new DemoProblem().getSolution(input));
    }
}