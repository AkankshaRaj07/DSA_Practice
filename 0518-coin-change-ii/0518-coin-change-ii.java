class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int [n][amount+1];
        for(int [] a : dp) Arrays.fill(a,-1);
        int ans = rec(coins, amount, n-1,dp);
        return ans ;
    }
    public int rec(int [] coins, int amount, int i, int[][]dp){
        if (i == 0) {
            return dp[i][amount] = (amount % coins[0] == 0) ? 1 : 0;
        }
        if(dp[i][amount] != -1) return dp[i][amount] ;
        int pick = 0;
        if(amount >= coins[i]){
            pick =rec(coins, amount - coins[i], i,dp);
        }
        int noPick = rec(coins, amount, i-1,dp);
        return dp[i][amount] = pick+noPick;
    }
}
