class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return lcs(s, rev, n, n, dp);
    }

    int lcs(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return dp[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, dp);

        return dp[n][m] = Math.max(
            lcs(s1, s2, n - 1, m, dp),
            lcs(s1, s2, n, m - 1, dp)
        );
    }
}