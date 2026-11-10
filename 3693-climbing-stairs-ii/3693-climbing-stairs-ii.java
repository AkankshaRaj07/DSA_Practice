class Solution {
    public int climbStairs(int n, int[] costs) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n,costs, dp);
    }
    public int rec(int i, int[] costs, int[] dp){
        if(i==0) return dp[i] = 0;
        if(dp[i]!=-1) return dp[i];
        int first = rec(i-1,costs,dp) + costs[i-1]+1;
        int sec= Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        if(i>=2) sec = rec(i-2,costs,dp) + costs[i-1] + 4;
        if(i>=3) third = rec(i-3, costs,dp)+ costs[i-1] + 9;
        return dp[i] = Math.min(first,Math.min(sec, third));
    }
}