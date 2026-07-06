class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMin = -1, lastMax = -1, lastInvalid = -1;
        long ans = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==minK) lastMin = i;
            if(nums[i]==maxK)  lastMax = i;
            if(nums[i]>maxK || nums[i]<minK) lastInvalid = i;
            int count = Math.max(0,Math.min(lastMin, lastMax)-lastInvalid);
            ans+=count;
        }
        return ans;
    }
}