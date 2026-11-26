class Solution {

    long base = 911382323;
    long mod = 972663749;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] pow = new long[n + 1];
        long[] prefix = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * base) % mod;
        }
        for (int i = 0; i < n; i++) {
            prefix[i + 1] =
                (prefix[i] * base + nums[i] + 1) % mod;
        }
        int low = 1;
        int high = n;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUnique(mid, nums, prefix, pow)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUnique(int len,
                              int[] nums,
                              long[] prefix,
                              long[] pow) {

        int n = nums.length;

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            long hash =
                (prefix[i + len]
                - (prefix[i] * pow[len]) % mod
                + mod) % mod;

            freq.put(hash,
                    freq.getOrDefault(hash, 0) + 1);
        }

        for (int val : freq.values()) {
            if (val == 1) {
                return true;
            }
        }

        return false;
    }
}