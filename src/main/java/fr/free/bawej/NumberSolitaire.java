package fr.free.bawej;

public class NumberSolitaire {
    public int solution(int[] tiles) {
        int[] partials = new int[tiles.length];
        partials[0] = tiles[0];
        for (int i = 1; i < tiles.length; ++i) {
            int bestPrecedent = partials[i - 1];
            for (int p = i - 2; p >= 0 && p >= i - 6; --p) {
                bestPrecedent = Math.max(partials[p], bestPrecedent);
            }
            partials[i] = bestPrecedent + tiles[i];
        }
        return partials[tiles.length - 1];
    }
}
