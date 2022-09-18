package fr.free.bawej;

public class RopeTying {
    public int solution(int minLength, int[] ropes) {
        int count = 0;
        int overflow = 0;
        for (int i : ropes) {
            if (i + overflow >= minLength) {
                ++count;
                overflow = 0;
            } else {
                overflow += i;
            }
        }
        return count;
    }
}
