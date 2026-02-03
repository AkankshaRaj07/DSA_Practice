class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length<4) return false;
        if (nums[1] <= nums[0]) return false;
        int ch=0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]==nums[i-1]) return false;
            if(ch==0){
                if(nums[i]<nums[i-1]) ch=1;
            }
            else if(ch==1){
                if(nums[i]>nums[i-1]) ch=2;
            }
            else{
                if(nums[i]<nums[i-1]) return false;
            }
        } 
        return ch==2;
    }
}