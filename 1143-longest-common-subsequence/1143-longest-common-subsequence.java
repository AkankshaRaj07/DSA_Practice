class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] dp = new int [m][n];
        for(int[] a: dp) Arrays.fill(a,-1);
        return rec(text1,text2,m-1,n-1,dp);
    }
    public int rec(String t1, String t2, int i , int j, int[][] dp){
        if (i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j] ;
        if (t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = 1 + rec(t1, t2, i - 1, j - 1,dp);
        }
        return dp[i][j] = Math.max(
            rec(t1, t2, i - 1, j,dp),
            rec(t1, t2, i, j - 1,dp)
        );
    }
    
}