class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        for(int a : nums){
            if(a<pivot) smaller.add(a);
            else if(a>pivot) larger.add(a);
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i<smaller.size(); i++) ans[i] = smaller.get(i);
        int i = smaller.size();
        for(int a: nums) if(a==pivot) ans[i++]=a;
        for(int a: larger)ans[i++] = a;
        return ans;
    }
}