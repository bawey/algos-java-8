package fr.free.bawej;

import java.util.stream.Stream;

public class LadderClimber {

    int[] mem = new int[50_000 + 1];
    int memLimit = 0;


    public int[] solution(int[] rungCounts, int[] precisionExponents) {
        memoize(1, 1);
        memoize(2, 2);
        return Stream.iterate(0, integer -> ++integer).limit(rungCounts.length).
                map(i -> countCombinations(rungCounts[i]) & ((1 << precisionExponents[i]) - 1))
                .mapToInt(Integer::intValue).toArray();
    }

    private int memoize(int rungs, int answer) {
        if (mem[rungs] == 0) {
            mem[rungs] = answer;
            memLimit = Math.max(rungs, memLimit);
        }
        return memLimit;
    }

    /**
     * To climb N rungs using only steps of size 2 or 1, one can start with either and recursively climb the remainder.
     * So f(N) = 1 * f(N-1) + 1 * f(N-2) and the rest is a typical Fibonacci stuff
     */
    public int countCombinations(int rungs) {
        if (mem[rungs] != 0) return mem[rungs];
        int moduloMask = Integer.MAX_VALUE;
        int r0 = 0, m1 = mem[this.memLimit] & moduloMask, m2 = mem[this.memLimit - 1] & moduloMask;
        for (int rung = this.memLimit + 1; rung <= rungs; ++rung) {
            r0 = (m1 + m2) & moduloMask;
            memoize(rung, r0);
            m2 = m1;
            m1 = r0;
        }
        return r0;
    }

}
