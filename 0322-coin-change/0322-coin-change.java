class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        for(int []a: dp) Arrays.fill(a,-1);
        int ans = rec(coins, amount, n-1, dp);
        return ans == (int) 1e9 ? -1:ans;
    }
    public int rec(int [] coins, int amount, int i, int [][] dp){
        if(i == 0){
            if (amount % coins[0] == 0) {
                return dp[i][amount] = amount / coins[0];
            }
            return dp[i][amount] = (int) 1e9;
        }
        if(dp[i][amount] !=-1) return dp[i][amount] ;
        int pick = (int) 1e9;
        if(amount >= coins[i]){
            pick =1+ rec(coins, amount - coins[i], i,dp);
        }
        int noPick = rec(coins, amount, i-1,dp);
        return dp[i][amount] = Math.min(pick, noPick);
    }
}