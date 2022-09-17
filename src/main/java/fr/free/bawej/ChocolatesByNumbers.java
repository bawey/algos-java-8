package fr.free.bawej;

public class ChocolatesByNumbers {
    public int solution(int chocolates, int jump) {
        return (int) (lowestCommonMultiple(chocolates, jump) / jump);
    }

    public long lowestCommonMultiple(int a, int b) {
        return ((long) a) / greatestCommonDivisor(a, b) * b;
    }

    public int greatestCommonDivisor(int a, int b) {
        int c;
        while (a != b) {
            c = b;
            if (b > a) {
                b = a;
            } else {
                if (b == 1) return 1;
                b = a - b;
            }
            a = c;
        }
        return b;
    }
}
