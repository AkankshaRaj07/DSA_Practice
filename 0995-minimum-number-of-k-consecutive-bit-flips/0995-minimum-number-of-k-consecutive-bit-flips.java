class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCountFromPastFori = 0;
        Deque<Integer> flipQueue = new LinkedList<>();
        for(int i =0; i<n ; i++){
            if(i>=k ){
                flipCountFromPastFori-= flipQueue.pollFirst();
            } 
            if(flipCountFromPastFori % 2 == nums[i]){
                if(i + k > n) return -1;
                flipCountFromPastFori++;
                flips++;
                flipQueue.addLast(1);

            }else{
                flipQueue.addLast(0);
            }
        }
        return flips;
    }
}