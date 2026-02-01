class Solution {
    public int minimumCost(int[] nums) {
        int sum=nums[0];
        int mini = Math.min(nums[1], nums[2]);
        int sec  = Math.max(nums[1], nums[2]);
        for(int i = 3; i<nums.length; i++){
            if(nums[i]<mini){
                sec=mini;
                mini=nums[i];
            }else if (nums[i] < sec) {
                sec = nums[i];
            }
        }
        return sum+mini+sec;
    }
}