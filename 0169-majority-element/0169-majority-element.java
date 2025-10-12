class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer> map= new HashMap<>();
        for(int i=0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxFreq = 0;
        int majority = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                majority = entry.getKey();
            }
        }
        return majority;
        
    }
}