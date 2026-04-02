class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        Integer[][][] dp = new Integer[m][n][3];
        return rec(coins, m - 1, n - 1, 2, dp);
    }

    public int rec(int[][] coins, int i, int j, int k, Integer[][][] dp) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE;

        if (i == 0 && j == 0) {
            if (coins[0][0] >= 0) return coins[0][0];
            else return k > 0 ? 0 : coins[0][0];
        }

        if (dp[i][j][k] != null) return dp[i][j][k];

        int up = rec(coins, i - 1, j, k, dp);
        int left = rec(coins, i, j - 1, k, dp);
        int bestPrev = Math.max(up, left);

        int take = Integer.MIN_VALUE;
        if (bestPrev != Integer.MIN_VALUE) {
            take = bestPrev + coins[i][j];
        }

        int neutralize = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && k > 0) {
            int up2 = rec(coins, i - 1, j, k - 1, dp);
            int left2 = rec(coins, i, j - 1, k - 1, dp);
            int bestPrev2 = Math.max(up2, left2);

            if (bestPrev2 != Integer.MIN_VALUE) {
                neutralize = bestPrev2;
            }
        }

        return dp[i][j][k] = Math.max(take, neutralize);
    }
}