class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> map = new HashSet<>();
            int even = 0;
            int odd = 0;
            for (int j = i; j < nums.length; j++) {
                if (!map.contains(nums[j])) {
                    if (nums[j] % 2 == 0) even++;
                    else odd++;
                    map.add(nums[j]);
                }
                if(even==odd) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}