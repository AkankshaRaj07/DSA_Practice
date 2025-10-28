class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> map= new HashMap<>();
        map.put(0,1);
        int prefix=0;
        int count=0;
        for(int i=0; i<nums.length ; i++){
            prefix += nums[i];
            int diff= prefix-k;
            count+=map.getOrDefault(diff,0);
            map.put(prefix, map.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}