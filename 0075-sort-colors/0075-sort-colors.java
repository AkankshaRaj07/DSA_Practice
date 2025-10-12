class Solution {
    // Brute Force Approach
    // public void sortColors(int[] nums) {
    //    Arrays.sort(nums); 
    // }

    //Better Approach
    public void sortColors(int[] nums){
        int count0=0;
        int count1=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) count0++;
            else if(nums[i] == 1) count1++;
        }
        for(int i=0; i<count0; i++ ) nums[i]=0;
        for(int i=count0; i<count1+count0; i++ ) nums[i]=1;
        for(int i=count1+count0; i<nums.length; i++ ) nums[i]=2;
    }
}