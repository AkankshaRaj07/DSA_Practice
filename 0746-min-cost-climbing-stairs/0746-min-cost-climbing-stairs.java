class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev =0;
        int curr =0;
        for(int i = 2; i<=n; i++){
            int ans = Math.min(curr+cost[i-1], prev+cost[i-2]);
            prev = curr;
            curr = ans;
        }
        return curr;
    }
    
}