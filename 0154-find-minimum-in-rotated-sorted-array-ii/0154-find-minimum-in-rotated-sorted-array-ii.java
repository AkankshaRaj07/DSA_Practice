class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        for(int i =1; i<nums.length-1; i++){
            if(nums[i]<nums[nums.length-1])return nums[i];
        }
        return nums[nums.length-1];
    }
}