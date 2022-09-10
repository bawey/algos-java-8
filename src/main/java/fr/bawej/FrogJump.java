package fr.bawej;

public class FrogJump {
    public int solution(int x, int y, int d) {
        int answer = (y  - x) / d;
        x += d * answer;
        if (x < y) {
            ++answer;
            x += d;
        }
        return answer;
    }
}
