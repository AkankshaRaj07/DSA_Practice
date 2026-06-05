class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;
        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;
        int req = (sum + target) / 2;
        int[][] dp = new int[nums.length][req + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return rec(nums, nums.length - 1, req, dp);
    }

    private int rec(int[] nums, int i, int target, int[][] dp) {
        if (i == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }
        if (dp[i][target] != -1) return dp[i][target];
        int notPick = rec(nums, i - 1, target, dp);
        int pick = 0;
        if (nums[i] <= target) {
            pick = rec(nums, i - 1, target - nums[i], dp);
        }
        return dp[i][target] = pick + notPick;
    }
}