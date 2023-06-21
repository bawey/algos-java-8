package fr.free.bawej;

import java.util.*;

public class ParenthesesGenerator {

    private static final Map<Integer, List<String>> partials = new HashMap<>();

    static {
        partials.put(0, Collections.emptyList());
        partials.put(1, Collections.singletonList("()"));
    }

    public List<String> generateParenthesis(int n) {
        if (partials.containsKey(n)) return partials.get(n);

        List<String> results = new LinkedList<>();

        for (int pivot = 0; pivot < n; ++pivot) {
            List<String> upToPivot = pivot > 0 ? generateParenthesis(pivot) : Collections.singletonList("");
            List<String> afterPivot = pivot < n - 1 ? generateParenthesis(n - 1 - pivot) : Collections.singletonList("");
            for (String inner : upToPivot) {
                for (String outer : afterPivot) {
                    results.add(String.format("(%s)%s", inner, outer));
                }
            }
        }

        partials.put(n, results);
        return results;

    }

}
