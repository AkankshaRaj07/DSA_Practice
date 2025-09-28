class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int [m+1][n+1];
        for(int i=0; i<=m; i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(m,n,dp);
    }
    public int rec(int m, int n,int [][]dp){
        if(m==0 || n==0){
            dp[m][n]=0;
            return 0;
        } 
        if(m==1 && n==1){
            dp[m][n]=1;
            return 1;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        dp[m][n]= rec(m-1,n,dp)+rec(m,n-1,dp);
        return dp[m][n];
    }
}