package fr.free.bawej;

public class MinAvgSlice {
    public int solution(int[] input){
        int answer = 0;
        double answerScore = Double.MAX_VALUE;
        for (int sliceStart=0; sliceStart< input.length -1; ++sliceStart){
            int sliceTotal = input[sliceStart] + input[sliceStart + 1];
            double sliceAvg = sliceTotal / 2.0;
            int sliceEnd = sliceStart + 1;
            while(sliceEnd < input.length-1 && input[sliceEnd + 1] < sliceAvg){
                ++sliceEnd;
                sliceTotal += input[sliceEnd];
                sliceAvg = sliceTotal / (1.0 + (sliceEnd - sliceStart));
            }
            if (sliceAvg < answerScore){
                answerScore = sliceAvg;
                answer = sliceStart;
            }
        }
        return answer;
    }
}
