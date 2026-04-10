class Solution {
    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        if(nums.length < 3) return -1;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        int diff = Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i);
                        ans = Math.min(diff, ans);
                    }
                    
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans; 
    }
}