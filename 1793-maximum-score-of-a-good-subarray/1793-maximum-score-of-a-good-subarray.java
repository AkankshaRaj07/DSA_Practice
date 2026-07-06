class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, left = k, right = k, ans = nums[k], currMin = nums[k];
        while(left>0 || right<n-1){
            if ((left > 0 ? nums[left - 1]: 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                right++;
                if(nums[right]<currMin)currMin = nums[right];
            }else {
                left--;
                currMin = Math.min(currMin, nums[left]);
            }
            ans = Math.max(ans, currMin * (right - left + 1));
        }
        return ans; 
    }
}