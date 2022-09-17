package fr.free.bawej;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ChocolatesByNumbersTest {

    static class CasesProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(5, 10, 4),
                    Arguments.of(5, 5, 1),
                    Arguments.of(2, 2, 1),
                    Arguments.of(1, 1, 2),
                    Arguments.of(947853, 947853, 4453),
                    Arguments.of(1000000000, 1000000000, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CasesProvider.class)
    void test(int expected, int chocolates, int jump) {
        assertThat(new ChocolatesByNumbers().solution(chocolates, jump)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "100, 33",
            "12, 7",
            "15, 3",
            "15, 5",
            "12, 21",
            "947853, 4453",
            "1000000000, 1"
    })
    void test(String input) {
        int[] ints = Arrays.stream(input.split(",")).map(String::trim).map(Integer::valueOf)
                .mapToInt(Integer::intValue).toArray();
        int chocolates = ints[0];
        int jump = ints[1];
        assertThat(new ChocolatesByNumbers().solution(chocolates, jump)).isEqualTo(brutalSolution(chocolates, jump));
    }


    public int brutalSolution(int chocolates, int jump) {
        jump = jump % chocolates;
        boolean[] eaten = new boolean[chocolates];
        int counter = 0;
        int pointer = 0;
        while (!eaten[pointer]) {
            eaten[pointer] = true;
            pointer += jump;
            if (pointer >= chocolates) {
                pointer -= chocolates;
            }
            ++counter;
        }
        return counter;
    }

}