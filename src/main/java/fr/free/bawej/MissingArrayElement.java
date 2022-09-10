package fr.free.bawej;

public class MissingArrayElement {
    public int solution(int[] input) {
        boolean[] ticks = new boolean[input.length + 1];
        for (int i : input) {
            ticks[i - 1] = true;
        }
        for (int i = 0; i < ticks.length; ++i) {
            if (!ticks[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}
