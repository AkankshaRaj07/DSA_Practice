import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;

        // Add boundary fences
        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
        int[] v = Arrays.copyOf(vFences, vFences.length + 2);

        h[h.length - 2] = 1;
        h[h.length - 1] = m;
        v[v.length - 2] = 1;
        v[v.length - 1] = n;

        Arrays.sort(h);
        Arrays.sort(v);

        // All possible horizontal gaps
        Set<Long> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add((long) h[j] - h[i]);
            }
        }

        long maxSide = -1;

        // Check vertical gaps
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                long gap = (long) v[j] - v[i];
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
