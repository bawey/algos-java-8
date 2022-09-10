package fr.free.bawej;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class UnpairedElement {
    public int solution(int[] input) {
        Set<Integer> intSet = IntStream.of(input).boxed().collect(HashSet::new,
                (set, integer) -> {
                    if (set.contains(integer)) {
                        set.remove(integer);
                    } else {
                        set.add(integer);
                    }
                }, (a, b) -> {
                    Set<Integer> common = new HashSet<>(a);
                    common.retainAll(b);
                    a.addAll(b);
                    a.removeAll(common);
                });
        return intSet.iterator().next();
    }
}
