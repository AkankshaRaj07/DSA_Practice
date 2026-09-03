class Solution {
    public boolean uniformArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int x : nums) {
            min = Math.min(min, x);
            if (x % 2 == 1) hasOdd = true;
        }

        if (min % 2 == 0 && hasOdd) return false;
        return true;
    }
}