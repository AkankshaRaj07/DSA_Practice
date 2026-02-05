class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;
        boolean [][] vis = new boolean [m][n];
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O' && (i==0|| j==0 ||i==m-1 || j==n-1)){
                    dfs(board, vis, i, j,m , n);
                }
            }
        }
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char[][] board,boolean [][] vis , int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='X' || vis[i][j]) return; 
        vis[i][j] = true;
        dfs(board, vis, i+1, j,m,n);
        dfs(board, vis, i, j+1,m,n);
        dfs(board, vis, i-1, j,m,n);
        dfs(board, vis, i, j-1,m,n);
    }
}