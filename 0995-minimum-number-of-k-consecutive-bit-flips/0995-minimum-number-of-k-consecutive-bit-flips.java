class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCountFromPastFori = 0;
        for(int i =0; i<n ; i++){
            if(i>=k && nums[i-k]==2) flipCountFromPastFori--;
            if(flipCountFromPastFori % 2 == nums[i]){
                if(i + k > n) return -1;
                flipCountFromPastFori++;
                flips++;
                nums[i]=2;
            }
        }
        return flips;
    }
}