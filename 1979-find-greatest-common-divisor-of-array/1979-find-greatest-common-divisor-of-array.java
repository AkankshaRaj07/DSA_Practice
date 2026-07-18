class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int j = min;
        while(j>0){
            if(min%j == 0 && max%j == 0) return j;
            j--;
        }
        return 1;
    }
}