class Solution {
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    q.offer(new Pair(i, j));
                } else
                    result[i][j] = -1;
            }
        }
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && result[nr][nc] == -1) {
                    result[nr][nc] = result[r][c] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
        return result;
    }
}