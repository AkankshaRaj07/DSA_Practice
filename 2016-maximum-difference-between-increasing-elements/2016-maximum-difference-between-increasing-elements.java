class Solution {
    public int maximumDifference(int[] nums) {
        int d = -1;
        int min = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > min) d = Math.max(d , nums[i] - min);
        }
        return d;
    }
}