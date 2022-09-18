package fr.free.bawej;

public class AbsDistinct {

    static class Crawler {
        private final int[] data;
        private int h, t;
        private int count;
        public final int result;

        Crawler(int[] data) {
            this.data = data;
            this.h = data.length - 1;
            this.t = 0;
            this.result = crawl();
        }

        void retreatHead() {
            ++count;
            --h;
            while (h > 0 && data[h + 1] == data[h]) {
                --h;
            }
        }

        void advanceTail() {
            ++count;
            ++t;
            while (t < data.length - 1 && data[t] == data[t - 1]) {
                ++t;
            }
        }

        public int compareAbsAtEnds() {
            return Long.compare(Math.abs((long) data[t]), Math.abs((long) data[h]));
        }

        private int crawl() {
            while (h >= t) {
                if (compareAbsAtEnds() == 0) {
                    advanceTail();
                    retreatHead();
                    --count;
                } else if (compareAbsAtEnds() > 0) {
                    advanceTail();
                } else {
                    retreatHead();
                }
            }
            return count;
        }
    }

    public int solution(int[] in) {
        return new Crawler(in).result;
    }
}
