class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        return uniquePaths(m,n, obstacleGrid);
    }
    public int uniquePaths(int m, int n, int [][] obstacleGrid) {
        int prev[]= new int[m+1];
        for(int i=0; i<=m; i++){
            int cur[] = new int [n+1];
            for(int j=0; j<=n; j++){
                if(i==0 || j==0 || obstacleGrid[i-1][j-1]==1) cur[j]=0;
                else if(i==1 && j==1) cur[j]=1;
                else{
                    cur[j]= prev[j]+cur[j-1];    
                } 
            }
            prev=cur;
        }
        return prev[n];
    }
}