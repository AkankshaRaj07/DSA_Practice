class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int [] ans = new int [nums.size()];
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i)==2) {
                ans[i]=-1;
                continue;
            }
            boolean found = false;
            for(int j=1; j<32; j++){
                if((nums.get(i) & (1<<j)) > 0) continue;
                ans[i]=nums.get(i) ^ (1<<(j-1));
                found=true;
                break;
            }
            if(!found) ans[i]=-1;
        }
        return ans;
    }
}