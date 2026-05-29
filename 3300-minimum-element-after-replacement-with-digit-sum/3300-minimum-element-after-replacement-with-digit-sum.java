class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for(int a: nums){
            int sum = 0;
            while(a>0){
                sum+=(a%10);
                a/=10;
            }
            minSum= Math.min(sum, minSum);
        }
        return minSum;
    }
} 