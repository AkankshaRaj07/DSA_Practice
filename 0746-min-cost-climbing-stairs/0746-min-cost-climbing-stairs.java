class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return rec(0,dp,cost);
    }
    public int rec(int i, int [] dp,int [] cost){
        if(i==cost.length || i == cost.length-1) {
            dp[i] = 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        return  dp[i] = Math.min(cost[i] + rec(i+1,dp,cost), cost[i+1] + rec(i+2,dp,cost));
    }
}