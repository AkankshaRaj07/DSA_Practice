class Solution {
    public int robLinear(int[] nums,int start,int end) {
        int money = 0;              // max money if we robbed i-2
        int maxMoney =0;     // max money till i-1

        for (int i = start; i<= end; i++) {
            int curr = Math.max(money + nums[i], maxMoney);
            money = maxMoney;
            maxMoney = curr;
        }

        return maxMoney;
    }
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robLinear(nums,0,nums.length-2),robLinear(nums,1,nums.length-1));
    }
}