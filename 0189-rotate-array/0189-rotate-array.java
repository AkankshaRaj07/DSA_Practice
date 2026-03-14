class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        r(nums,0, nums.length-1);
        r(nums,0,k-1);
        r(nums,k,nums.length-1);
    }
    public void r(int [] nums, int s, int e ){
        while(s<e){
            int temp = nums[e];
            nums[e]= nums[s];
            nums[s] = temp;
            e--;
            s++;   
        }
    }
}