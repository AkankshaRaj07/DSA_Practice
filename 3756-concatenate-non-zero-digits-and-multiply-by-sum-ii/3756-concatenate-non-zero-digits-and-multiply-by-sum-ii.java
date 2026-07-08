import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int m = s.length();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> dig = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                pos.add(i);
                dig.add(c - '0');
            }
        }

        int k = dig.size();

        long[] preNum = new long[k + 1];
        long[] preSum = new long[k + 1];
        long[] pow10 = new long[k + 1];

        pow10[0] = 1;

        for (int i = 0; i < k; i++) {
            preNum[i + 1] = (preNum[i] * 10 + dig.get(i)) % MOD;
            preSum[i + 1] = preSum[i] + dig.get(i);
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int L = lowerBound(pos, l);
            int R = upperBound(pos, r) - 1;

            if (L > R) {
                ans[i] = 0;
                continue;
            }

            int len = R - L + 1;

            long num = (preNum[R + 1] - preNum[L] * pow10[len]) % MOD;
            if (num < 0) num += MOD;

            long sum = preSum[R + 1] - preSum[L];

            ans[i] = (int) ((num * sum) % MOD);
        }

        return ans;
    }

    int lowerBound(ArrayList<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (a.get(mid) >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    int upperBound(ArrayList<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (a.get(mid) > x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}