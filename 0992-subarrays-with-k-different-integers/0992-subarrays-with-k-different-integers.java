class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
    public int atMostK(int [] nums, int k){
        if (k < 1) return 0;
        int n = nums.length;
        int res = 0, j = 0, distinct = 0;
        int[] count = new int[n + 1]; // instead of HashMap
        for (int i = 0; i < n; i++) {
            if (count[nums[i]] == 0) distinct++;
            count[nums[i]]++;
            while (distinct > k) {
                count[nums[j]]--;
                if (count[nums[j]] == 0) distinct--;
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}