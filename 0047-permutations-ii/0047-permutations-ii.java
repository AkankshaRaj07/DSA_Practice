class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        perm(nums, curr, res,vis);
        return res;
    }
    public void perm(int nums[], List<Integer> curr, List<List<Integer>> res, boolean [] vis){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return ;
        }
        for(int i = 0; i<nums.length; i++){
            if(vis[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !vis[i-1]) continue;
            vis[i] = true;
            curr.add(nums[i]);
            perm(nums,curr,res, vis);
            curr.remove(curr.size()-1);
            vis[i] = false;
        }
    }
}