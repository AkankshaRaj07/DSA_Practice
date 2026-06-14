class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int len = 0;
        int count  = 0, ans = 0;
        for(int right = 0; right<nums.length; right++){
            if(nums[right] % 2 != 0) count++;
            while(count>k){
                if(nums[left] % 2 !=0) count--;
                left++;
            }
            if(count == k) {
                ans++;
                int temp = left;
                while(temp < right && nums[temp]%2==0){
                    ans++;
                    temp++;
                }
            }
        }
        return ans;
    }
}