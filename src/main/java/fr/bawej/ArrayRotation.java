package fr.bawej;

public class ArrayRotation {
    public int[] solution(int[] input, int rotations) {
        int[] output = new int[input.length];
        for (int i=0; i<input.length; output[(i+rotations % input.length) % output.length] = input[i++]);
        return output;
    }
}
