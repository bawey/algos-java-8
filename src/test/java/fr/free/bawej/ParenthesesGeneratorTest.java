package fr.free.bawej;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParenthesesGeneratorTest {

    static Stream<Arguments> provideCases() {
        return Stream.of(
                Arguments.of(0, Collections.emptyList()),
                Arguments.of(1, Collections.singletonList("()")),
                Arguments.of(2, Arrays.asList("()()", "(())")),
                Arguments.of(3, Arrays.asList("()()()", "((()))", "(()())", "(())()", "()(())")),
                Arguments.of(4, Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    void test(int size, Collection<String> expectedAnswer) {
        assertThat(new ParenthesesGenerator().generateParenthesis(size)).containsExactlyInAnyOrderElementsOf(expectedAnswer);
    }
}