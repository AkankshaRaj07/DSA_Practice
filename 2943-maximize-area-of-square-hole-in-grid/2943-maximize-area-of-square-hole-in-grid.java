import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = longestConsecutive(hBars);
        int maxV = longestConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }

    private int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int maxLen = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }
}
