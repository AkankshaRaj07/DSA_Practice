class Solution {
    public boolean check(int[] nums) {
        int n =0;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) {
                if(nums[0]<nums[nums.length-1]) return false;
                n++;
            }
        }
        return n==1 || n==0;
    }
}