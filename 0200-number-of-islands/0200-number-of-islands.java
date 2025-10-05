class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        boolean[][] vis = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, vis, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int i, int j, char[][] grid, boolean [][]vis, int rows, int cols){
        if(i<0 || j<0 || i>=rows || j>= cols || vis[i][j] || grid[i][j] == '0') return ;
        vis[i][j]= true;
        int adjList [][] = {{i-1,j},{i,j-1},{i+1,j},{i,j+1}};
        for(int n[] : adjList){
            int u= n[0];
            int v= n[1];
            dfs(u,v,grid,vis, rows, cols);
        }
    }
}