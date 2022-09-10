package fr.free.bawej;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class MissingInteger {

    private int guess = 1;

    private void considerNewFact(int fact){
        if (fact == guess) {
            ++guess;
        }
    }

    public int solution(int[] input) {
        IntStream.of(input).filter(i -> i > 0).sorted().forEach(this::considerNewFact);
        return this.guess;
    }
}

