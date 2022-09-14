package fr.free.bawej;

public class MaxSlice {
    public int solution(int[] input){
        int sliceSum = 0;
        int maxSumEver = input[0];
        for (int i : input){
            sliceSum += i;
            maxSumEver = Math.max(maxSumEver, sliceSum);
            sliceSum = Math.max(0, sliceSum);
        }
        return maxSumEver;
    }
}
