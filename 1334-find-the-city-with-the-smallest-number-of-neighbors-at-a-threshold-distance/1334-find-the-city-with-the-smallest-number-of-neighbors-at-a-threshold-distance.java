class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for (int[] arr : dis) 
            Arrays.fill(arr, (int) (1e9));
        for (int i = 0; i < n; i++)
            dis[i][i] = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dis[u][v] = w;
            dis[v][u] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        int city = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dis[i][j] <= distanceThreshold) count++;
            }
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }
        return city;
    }
}