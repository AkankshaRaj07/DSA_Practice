class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, sum = 0, ans = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left++];
            }
            if(sum==goal){
                if(right-left+1 > 0) ans++;
                int temp = left;
                while (temp < right && nums[temp] == 0) {
                    ans++;
                    temp++;
                }
            } 
        }
        return ans;
    }
}