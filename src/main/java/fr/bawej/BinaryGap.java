package fr.bawej;

public class BinaryGap {
    public int solution(int n){
        int maxGap = 0;
        int currentGap = 0;
        boolean isInside = false;
        int mask = 1;
        while (mask != 0){
            if ((n & mask) != 0){
                maxGap = Math.max(maxGap, currentGap);
                currentGap = 0;
                isInside = true;
            } else {
                currentGap += (isInside ? 1 : 0);
            }
            mask = mask << 1;
        }
        return maxGap;
    }
}
