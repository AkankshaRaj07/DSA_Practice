class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i=text1.length();
        int j=text2.length();
        int dp[][]= new int [i+1][j+1];
        for(int k=0; k<=i; k++){
            Arrays.fill(dp[k],-1);
        }
        return rec(i,j,text1,text2,dp);
    }
    public int rec(int i, int j, String text1, String text2, int[][] dp){
        if(i==0 || j==0){
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            return dp[i][j]= 1 + rec(i-1,j-1,text1,text2,dp);
        }
        else{
            return dp[i][j]= Math.max(rec(i-1,j,text1,text2,dp),rec(i,j-1,text1,text2,dp));
        }
    }
}