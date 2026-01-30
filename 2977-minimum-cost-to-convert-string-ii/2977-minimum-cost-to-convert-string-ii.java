import java.util.*;

class Solution {
    static final long INF = (long) 1e18;

    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {
        int n = source.length();

        // 1. Collect all unique strings
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) id.put(original[i], idx++);
            if (!id.containsKey(changed[i])) id.put(changed[i], idx++);
        }

        int m = idx;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 2. Add edges
        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // 3. Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 4. Group original strings by length
        Map<Integer, List<Integer>> byLength = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            byLength
                .computeIfAbsent(original[i].length(), k -> new ArrayList<>())
                .add(i);
        }

        // 5. DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            // Option 1: single character
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            } else {
                String s1 = String.valueOf(source.charAt(i));
                String s2 = String.valueOf(target.charAt(i));
                if (id.containsKey(s1) && id.containsKey(s2)) {
                    long c = dist[id.get(s1)][id.get(s2)];
                    if (c < INF) {
                        dp[i] = Math.min(dp[i], c + dp[i + 1]);
                    }
                }
            }

            // Option 2: substring replacement
            for (int len : byLength.keySet()) {
                if (i + len > n) continue;

                String subS = source.substring(i, i + len);
                String subT = target.substring(i, i + len);

                if (!id.containsKey(subS) || !id.containsKey(subT)) continue;

                long c = dist[id.get(subS)][id.get(subT)];
                if (c < INF && dp[i + len] < INF) {
                    dp[i] = Math.min(dp[i], c + dp[i + len]);
                }
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }
}
