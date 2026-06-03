class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a: nums) sum+=a;
        if(sum%2 != 0) return false;
        int target = sum/2;
        int [][] dp =  new int [nums.length][target+1];
        return rec(dp, nums, target, nums.length-1);
    }
    public boolean rec(int [][] dp, int [] nums, int sum, int i){
        if(sum == 0) {
            dp[i][sum]=1;
            return true;
        }
        if(i == 0){
            if(sum == nums[i]) {
                dp[i][sum]=1;
                return true;
            }
            dp[i][sum]=2;
            return false;
        }
        if(dp[i][sum] != 0){
        return dp[i][sum] == 1;
}
        if(nums[i]<=sum){
            boolean pick = rec(dp, nums, sum-nums[i], i-1);
            if(pick) {
                dp[i][sum]=1;
                return true;
            }
        }
        boolean noPick = rec(dp, nums, sum, i-1);
        dp[i][sum] = noPick ? 1 : 2;
        return noPick;
    }
}