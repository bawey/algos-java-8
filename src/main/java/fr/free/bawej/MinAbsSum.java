package fr.free.bawej;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MinAbsSum {


    public int solution(int[] input) {
        ArrayList<Integer> foo = new ArrayList<>();
        AtomicInteger total = new AtomicInteger(0);
        IntStream.of(input).map(Math::abs).sorted().forEach(i -> {
            foo.add(i);
            total.addAndGet(i);
        });
        int sum = total.get();
        for (int i = foo.size() - 1; i >= 0; --i) {
            int number = foo.get(i);
            if (sum >= number) {
                sum -= (2 * number);
            }
        }
        return Math.abs(sum);
    }
}
