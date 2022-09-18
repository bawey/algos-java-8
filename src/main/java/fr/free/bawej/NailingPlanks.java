package fr.free.bawej;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NailingPlanks {


    static class Plank {
        public final int start;
        public final int end;
        boolean isNailed;

        public Plank(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean nail() {
            boolean answer = !this.isNailed;
            isNailed = true;
            return answer;
        }

    }

    static class Floor {
        private final Collection<Plank> empty = Stream.<Plank>of().collect(Collectors.toList());
        private final ArrayList<Collection<Plank>> grid;

        public Floor(int length) {
            this.grid = new ArrayList<>(length);
        }

        public Collection<Plank> planksAt(int x) {
            return grid.size() > x ? grid.get(x) : empty;
        }

        public void trackPlankAt(Plank p, int x) {
            for (int i = grid.size(); i <= x; grid.add(i++, new ArrayList<>())) {
            }
            grid.get(x).add(p);
        }
    }

    public int solution(int[] plankStarts, int[] plankEnds, int[] nailSpots) {
        final int planksCount = plankEnds.length;

        if (planksCount == 0) return 0;

        final int capacity = 2 * nailSpots.length;
        Floor floor = new Floor(capacity);

        int nailedPlanks = 0;

        for (int i = 0; i < planksCount; ++i) {
            Plank p = new Plank(plankStarts[i], plankEnds[i]);
            for (int x = p.start; x <= p.end; ++x) {
                floor.trackPlankAt(p, x);
            }
        }

        for (int i = 0; i < nailSpots.length; ++i) {
            int n = nailSpots[i];
            nailedPlanks += floor.planksAt(n).stream().map(Plank::nail).filter(Boolean.TRUE::equals).count();
            if (nailedPlanks == planksCount) {
                return i + 1;
            }
        }

        return -1;
    }
}
