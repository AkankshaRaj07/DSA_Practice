class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length, dp0 = 0;
        long cost0 = 0;
        int dp1 = -1000000000;
        long cost1 = (long)1e18;
        for (int i = 1; i <= n - 2; i++) {
            long need = Math.max(nums[i - 1], nums[i + 1]) + 1L;
            long c = Math.max(0L, need - nums[i]);
            int ndp0;
            long ncost0;
            if (dp0 > dp1) {
                ndp0 = dp0;
                ncost0 = cost0;
            } else if (dp0 < dp1) {
                ndp0 = dp1;
                ncost0 = cost1;
            } else {
                ndp0 = dp0;
                ncost0 = Math.min(cost0, cost1);
            }
            int ndp1 = dp0 + 1;
            long ncost1 = cost0 + c;
            dp0 = ndp0;
            cost0 = ncost0;
            dp1 = ndp1;
            cost1 = ncost1;
        }
        if (dp0 > dp1) return cost0;
        if (dp1 > dp0) return cost1;
        return Math.min(cost0, cost1);
    }
}