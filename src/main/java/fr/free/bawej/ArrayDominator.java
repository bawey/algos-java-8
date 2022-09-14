package fr.free.bawej;

import java.util.HashMap;
import java.util.Map;

public class ArrayDominator {


    public static class Ticker {
        public final int firstIndex;
        private int count = 0;

        public Ticker(int firstIndex) {
            this.firstIndex = firstIndex;
            this.count = 0;
        }

        public int tick() {
            return ++count;
        }
    }

    public int solution(int[] input) {
        Map<Integer, Ticker> occurrences = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            final int j = i;
            Ticker ticker = occurrences.computeIfAbsent(input[i], ignoredValue -> new Ticker(j));
            if (ticker.tick() > input.length / 2) {
                return ticker.firstIndex;
            }
        }
        return -1;
    }
}
