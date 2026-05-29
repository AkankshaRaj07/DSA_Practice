class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int curr = nums[0];
        for (int i = 2; i <= n; i++) {
            int ans = Math.max(nums[i-1]+prev,curr);
            prev = curr;
            curr = ans;
        }
        return curr;
    }
}