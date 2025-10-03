class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List <Integer> curr= new ArrayList<>();
        rec(0,nums,curr,res);
        return res;
    }
    public void rec(int n, int [] nums, List <Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=n; i<nums.length; i++){
            curr.add(nums[i]);
            rec(i+1, nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}