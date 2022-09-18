package fr.free.bawej;

import java.util.stream.IntStream;

public class TrianglesCounter {

    private static class Caterpillar {
        public int head;
        public int leg;
        public int tail;

        private final int[] array;

        private Caterpillar(int[] array) {
            this.array = array;
            this.head = array.length - 1;
            this.tail = 0;
            this.leg = head - 1;
        }

        public boolean can3angle() {
            int a = array[head];
            int b = array[leg];
            int c = array[tail];
            return a + b > c && b + c > a && a + c > b;
        }
    }

    public int solution(int[] edges) {
        int count = 0;
        final int[] e = IntStream.of(edges).sorted().toArray();
        Caterpillar c = new Caterpillar(e);
        while (c.head - c.tail > 1) {
            while (c.leg > c.tail && c.can3angle()) {
                ++count;
                --c.leg;
            }
            if (c.head - c.tail > 2) {
                --c.head;
            } else {
                ++c.tail;
                c.head = e.length - 1;
            }
            c.leg = c.head - 1;
        }
        return count;
    }
}
