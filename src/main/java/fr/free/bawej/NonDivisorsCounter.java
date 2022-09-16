package fr.free.bawej;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NonDivisorsCounter {
    public int[] solution(int[] input) {

        Map<Integer, Long> counts = IntStream.of(input).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int n = counts.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
        int[] sieve = new int[n + 1];

        for (Map.Entry<Integer, Long> count : counts.entrySet()) {
            for (int j = count.getKey(); j <= n; j += count.getKey()) {
                sieve[j] += count.getValue();
            }
        }

        return IntStream.of(input).map(inputInt -> input.length - sieve[inputInt]).toArray();
    }
}
