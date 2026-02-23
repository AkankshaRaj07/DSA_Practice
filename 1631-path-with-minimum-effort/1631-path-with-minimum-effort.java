class Solution {
    class Pair {
        int i;
        int j;
        int diff;
        Pair(int a, int b, int difference) {
            this.i = a;
            this.j = b;
            this.diff = difference;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int r = cur.i;
            int c = cur.j;
            int effort = cur.diff;
            if (r == n - 1 && c == m - 1) return effort;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}