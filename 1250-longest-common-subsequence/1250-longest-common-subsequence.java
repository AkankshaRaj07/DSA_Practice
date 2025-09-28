class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i=text1.length();
        int j=text2.length();
        int dp[][]= new int [i][j];
        for(int p=0; p<i; p++){
            Arrays.fill(dp[p],-1);
        }
        return rec(i-1,j-1,text1,text2,dp);
    }
    public int rec(int i, int j, String text1, String text2, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]= 1 + rec(i-1,j-1,text1,text2,dp);
        }
        else{
            return dp[i][j]= Math.max(rec(i-1,j,text1,text2,dp),rec(i,j-1,text1,text2,dp));
        }
    }
}