class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return recur(n,cost,dp);
    }
    public int recur(int n,int cost[],int dp[]){
        if(n==0 || n==1) return 0;
        if(dp[n]!=-1) return dp[n];
        int step1=cost[n-1]+recur(n-1,cost,dp);
        int step2=cost[n-2]+recur(n-2,cost,dp);
        return dp[n]= Math.min(step1,step2);
    }
}