package fr.free.bawej;

// source: https://stackoverflow.com/questions/4801242/algorithm-to-calculate-number-of-intersecting-discs/16814894#16814894
public class DiscIntersectionsCounter {
    private static final int LIMIT = 10_000_000;

    public int solution(int[] input) {
        int count = 0;
        int[] startCounts = new int[input.length];
        int[] endCounts = new int[input.length];

        for (int i = 0; i < input.length; ++i) {
            int start = Math.max(0, i - input[i]);
            int end = (int) Math.min((long) i + input[i], input.length - 1);
            startCounts[start] += 1;
            endCounts[end] += 1;
        }

        int active = 0;
        for (int i = 0; i < input.length; ++i) {
            if (startCounts[i] > 0) {
                count += active * startCounts[i];
                count += startCounts[i] * (startCounts[i] - 1) / 2;
                if (count > LIMIT) {
                    return -1;
                }
                active += startCounts[i];
            }
            active -= endCounts[i];
        }
        return count;
    }
}
