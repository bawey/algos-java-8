package fr.free.bawej;

import java.util.stream.IntStream;

public class TapeEquilibrium {
    public int solution(int[] input) {
        if (input.length == 2) {
            return Math.abs(input[0] - input[1]);
        }

        int currDiff = IntStream.of(input).sum() - 2 * input[0];
        int minDiff = Math.abs(currDiff);
        for (int i = 1; i < input.length - 1; ++i) {
            currDiff -= (2 * input[i]);
            minDiff = Math.min(minDiff, Math.abs(currDiff));
        }
        return minDiff;
    }
}
