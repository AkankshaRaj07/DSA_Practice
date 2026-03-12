class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCountFromPastFori = 0;
        boolean [] isFlipped = new boolean [n];
        for(int i =0; i<n ; i++){
            if(i>=k && isFlipped[i-k]) flipCountFromPastFori--;
            if(flipCountFromPastFori % 2 == nums[i]){
                if(i + k > n) return -1;
                flipCountFromPastFori++;
                flips++;
                isFlipped[i] = true;
            }
        }
        return flips;
    }
}