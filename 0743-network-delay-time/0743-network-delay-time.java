class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int INF = (int)1e9;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        
        dist[k] = 0;

        // Bellman Ford
        for(int i = 1; i <= n - 1; i++) {
            for(int[] e : times) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if(dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        int maxTime = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == INF) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}