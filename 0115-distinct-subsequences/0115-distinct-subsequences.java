class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[][] dp = new long[n][m];
        for(long[] row : dp)Arrays.fill(row,-1);
        return (int)rec(s,t,n-1,m-1,dp);
    }
    long rec(String s,String t,int i,int j,long[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] =rec(s,t,i-1,j-1,dp) + rec(s,t,i-1,j,dp);
        }
        return dp[i][j] =rec(s,t,i-1,j,dp);
    }
}