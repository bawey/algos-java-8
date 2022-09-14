package fr.free.bawej;

import java.util.Optional;
import java.util.stream.IntStream;

public class FlaggingPeaks {
    public int solution(int[] input) {
        int[] peaks = IntStream.range(1, input.length - 1).filter(idx -> input[idx] > input[idx + 1] && input[idx] > input[idx - 1]).toArray();
        if (peaks.length < 2) {
            return peaks.length;
        }
        int maxSpan = peaks[peaks.length - 1] - peaks[0];
        int upperBound = Math.min(1 + (int) Math.sqrt(maxSpan), peaks.length);
        while (upperBound > 2) {
            // remove peaks that violate the bound by making a copy (aggressive filtering might
            Optional<Integer> lastPeak = Optional.empty();
            int filteredCount = 0;
            for (int peak : peaks) {
                if (!lastPeak.isPresent() || peak - lastPeak.get() >= upperBound) {
                    ++filteredCount;
                    lastPeak = Optional.of(peak);
                }
            }
            if (filteredCount >= upperBound) return upperBound;
            --upperBound;
        }
        return upperBound;
    }

}
