class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for (int i : nums) high = Math.max(high, i);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (result(nums, mid, threshold) <= threshold) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public int result(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int i : nums) {
            sum += (i + divisor - 1) / divisor;
            if (sum > threshold) return sum;
        }
        return sum;
    }
}
