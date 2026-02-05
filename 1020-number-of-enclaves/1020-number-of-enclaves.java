class Solution {
    public int numEnclaves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int count=0;
        boolean [][] vis = new boolean [m][n];
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] ==1 && (i==0 || j==0 ||i==m-1 || j==n-1)){
                    dfs(grid, vis, i, j, m, n);
                }
            }
        }
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, boolean [][] vis, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0 || vis[i][j]) return ;
        vis[i][j] = true;
        dfs(grid, vis, i+1, j, m, n);
        dfs(grid, vis, i, j+1, m, n);
        dfs(grid, vis, i-1, j, m, n);
        dfs(grid, vis, i, j-1, m, n);
    }
}