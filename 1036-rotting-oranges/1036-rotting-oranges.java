class Pair{
    int row, col, time; 
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <Pair> q = new LinkedList<>();
        int n= grid.length;
        int m= grid[0].length;
        boolean[][] vis = new boolean [n][m];
        int count= 0;
        for(int i= 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if (grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1) count++;
            }

        }
        int maxi = 0;
        int cnt = 0; 
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            maxi = Math.max(maxi, time);
            for(int k = 0; k < 4; k++) {
                int nRow = row + dRow[k];
                int nCol = col + dCol[k];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol, time + 1));
                    vis[nRow][nCol] = true;
                    cnt++;
                }
            }
        }
        if(cnt != count) return -1;
        return maxi;
    }
}