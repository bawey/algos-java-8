package fr.bawej;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {
    private final BinaryGap binaryGap = new BinaryGap();


    static class Wisdom implements ArgumentsProvider {
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(0, 0),
                    Arguments.of(1, 0),
                    Arguments.of(2, 0),
                    Arguments.of(3, 0),
                    Arguments.of(5, 1),
                    Arguments.of(4, 0),
                    Arguments.of(8, 0),
                    Arguments.of(12, 0),
                    Arguments.of(18, 2),
                    Arguments.of(69, 3),
                    Arguments.of(77, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(Wisdom.class)
    void test(int input, int expected) {
        assertEquals(expected, binaryGap.solution(input));
    }
}