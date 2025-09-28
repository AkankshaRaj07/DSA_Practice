class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int dp [] [] = new int [n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);  
        }
        int res= rec(coins, amount, n-1,dp);
        if(res==(int)(1e9)) res=-1;
        return res;

    }
    public int rec(int [] coins, int amount, int n, int [][] dp){
        if(n==0){
            if((amount % coins[n] )==0){
                return dp[n][amount] = amount/coins[n];
            }
            return dp[n][amount] = (int) 1e9;
        }
        if(dp[n][amount] != -1) return dp[n][amount];
        int pick = (int) (1e9);
        if(coins[n] <= amount){
            pick= 1+ rec(coins, amount- coins[n], n,dp);
        }
        int noPick= rec(coins, amount, n-1,dp);
        return dp[n][amount] = Math.min(pick,noPick);

    }
}