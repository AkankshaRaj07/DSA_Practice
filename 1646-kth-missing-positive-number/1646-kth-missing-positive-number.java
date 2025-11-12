class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0, current = 1, i = 0;
        while (missing < k) {
            if (i < arr.length && arr[i] == current) i++;
            else missing++;
            current++;
        }
        return current - 1;
    }
}
