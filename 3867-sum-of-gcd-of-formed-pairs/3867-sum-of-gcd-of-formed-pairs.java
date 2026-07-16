class Solution {
    public long gcdSum(int[] nums) {
        int [] prefixGcd= new int [nums.length];
        int mx = nums[0];
        for(int i =0; i< nums.length; i++){
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        long sum =0;
        int i =0, j=nums.length-1;
        while(i<j){
            sum+=gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    public int gcd(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}