class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0;
        int ans=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1) j++;
            else {
                ans=Math.max(j,ans);
                j=0;
            }
        }
        return Math.max(j,ans);

    }
}