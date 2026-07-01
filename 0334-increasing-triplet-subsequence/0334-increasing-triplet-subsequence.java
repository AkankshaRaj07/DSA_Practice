class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int c : nums){
            if (c <= a) {
                a = c;
            } else if (c <= b) {
                b = c;
            } else {
                return true;   // a < b < c
            }
        }
        return false;
    }
}