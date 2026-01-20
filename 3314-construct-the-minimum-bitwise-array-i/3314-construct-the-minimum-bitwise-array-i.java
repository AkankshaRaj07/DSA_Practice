class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans [] = new int [nums.size()];
        for(int i =0; i<nums.size(); i++){
            boolean found=false;
            for(int x=0; x<nums.get(i); x++){
                if((x|x+1) == nums.get(i)){
                    ans[i]=x;
                    found=true;
                    break;
                }
                if(!found) ans[i]=-1;
            }
        }
        return ans;
    }
}