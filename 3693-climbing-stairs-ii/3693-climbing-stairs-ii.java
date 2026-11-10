class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int first = dp[i-1] + costs[i - 1] + 1;
            int sec =(i >= 2)? dp[i-2] + costs[i - 1] + 4 : Integer.MAX_VALUE;
            int third = (i >= 3) ? dp[i-3] + costs[i - 1] + 9: Integer.MAX_VALUE;
            dp[i] = Math.min(first, Math.min(sec,third));
        }
        return dp[n];
    }
}