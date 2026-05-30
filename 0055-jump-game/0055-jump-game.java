class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(0,nums,dp);
    }
    public boolean rec(int i , int [] nums,int [] dp){
        if(i>=nums.length-1) return true;
        if(dp[i]!=-1) return dp[i]==1;
        for(int j = 1; j<=nums[i];j++){
            if(rec(i + j, nums, dp)) {
                dp[i] = 1;
                return true;
            }
            dp[i]=0;
        }
        return false;
    }
}