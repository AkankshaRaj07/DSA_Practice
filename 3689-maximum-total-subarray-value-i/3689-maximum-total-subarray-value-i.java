class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a: nums){
            if(a>max) max = a;
            if(a<min) min = a;
        }
        return (long) k * (max - min);
    }
}