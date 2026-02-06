class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0; // same i
        int j = 0; // reuse j as right pointer
        int ans = 0;
        int n = nums.length;
        while (j < n) {
            while (i <= j && (long) nums[i] * k < nums[j]) {
                i++; // remove from front logically
            }
            ans = Math.max(ans, j - i + 1); // max valid window
            j++;
        }

        return n - ans;
    }
}