class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int [] result = new int[nums.length];
        for(int i = 0 ; i< nums.length; i++){
            if(nums[i]==0) result[i]=0;
            else{
                int steps= (nums[i]+i) % nums.length;
                if(steps<0) steps+=nums.length;
                result[i]=nums[steps];
            }
        }
        return result;
    }
}