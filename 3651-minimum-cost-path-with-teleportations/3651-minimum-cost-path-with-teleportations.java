import java.util.*;

class Solution {

    static class State {
        int r, c, t;
        int cost;
        State(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE / 4;

        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        // Cells sorted by value ASC
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});
        cells.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        // For each teleport layer, remember how many cells are unlocked
        int[] ptr = new int[k + 1];
        boolean[][][] unlocked = new boolean[m][n][k + 1];

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int r = cur.r, c = cur.c, t = cur.t, cost = cur.cost;

            if (cost != dist[r][c][t]) continue;
            if (r == m - 1 && c == n - 1) return cost;

            // Normal moves
            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < m && nc < n) {
                    int ncst = cost + grid[nr][nc];
                    if (ncst < dist[nr][nc][t]) {
                        dist[nr][nc][t] = ncst;
                        pq.offer(new State(nr, nc, t, ncst));
                    }
                }
            }

            // Teleport (optimized)
            if (t < k) {
                while (ptr[t] < cells.size() &&
                       cells.get(ptr[t])[0] <= grid[r][c]) {

                    int nr = cells.get(ptr[t])[1];
                    int nc = cells.get(ptr[t])[2];

                    if (!unlocked[nr][nc][t + 1] && cost < dist[nr][nc][t + 1]) {
                        unlocked[nr][nc][t + 1] = true;
                        dist[nr][nc][t + 1] = cost;
                        pq.offer(new State(nr, nc, t + 1, cost));
                    }
                    ptr[t]++;
                }
            }
        }

        return -1;
    }
}
