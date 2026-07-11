class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        sub(0,nums, curr, res);
        return res;
    }
    public void sub(int i, int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(i == nums.length) {
            res.add(new ArrayList<>(curr));
            return ;
        }
        curr.add(nums[i]);
        sub(i+1, nums, curr, res);
        curr.remove(curr.size()-1);
        while(i+1<nums.length && nums[i] == nums[i+1]) i++;
        sub(i+1, nums, curr, res);
    }
}