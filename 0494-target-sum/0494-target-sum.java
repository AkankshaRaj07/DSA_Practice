class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, target, nums.length-1);
    }
    public int rec(int[] nums, int target, int i){
        if (i < 0) {
            return target == 0 ? 1 : 0;
        }
        if(i<0) return 0;
        int pick = rec(nums,target+nums[i], i-1);
        int noPick = rec(nums, target-nums[i], i-1);
        return pick + noPick;
    }
}