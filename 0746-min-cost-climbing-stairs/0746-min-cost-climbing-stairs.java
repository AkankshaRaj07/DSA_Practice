class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return rec(cost.length,dp,cost);
    }
    public int rec(int i, int [] dp,int [] cost){
        if(i== 0 || i == 1) return  0;
        if(dp[i] != -1)return dp[i];
        return  dp[i] = Math.min(cost[i-1] + rec(i-1,dp,cost), cost[i-2] + rec(i-2,dp,cost));
    }
}