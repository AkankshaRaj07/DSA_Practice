class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        int left = 0;
        int right = 0;
        for(int a : nums) right +=a;
        for(int i = 0; i<nums.length; i++){
            if(i!=0) left+= nums[i-1];
            right-=nums[i];
            ans[i] = Math.abs(right-left);
        }
        return ans;
    }
}