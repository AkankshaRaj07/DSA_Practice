class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;

        int asc = ascendingShift(nums);
        if (asc != -1) {
            ans = Math.min(ans, Math.min(asc, 2 + (n - asc) % n));
        }

        int desc = descendingShift(nums);
        if (desc != -1) {
            ans = Math.min(ans, Math.min(1 + desc, 1 + (n - desc) % n));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int ascendingShift(int[] arr) {
        int n = arr.length;

        int k = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                k = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[(i + k) % n] != i) {
                return -1;
            }
        }

        return k;
    }

    private int descendingShift(int[] arr) {
        int n = arr.length;

        int k = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == n - 1) {
                k = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[(i + k) % n] != n - 1 - i) {
                return -1;
            }
        }

        return k;
    }
}