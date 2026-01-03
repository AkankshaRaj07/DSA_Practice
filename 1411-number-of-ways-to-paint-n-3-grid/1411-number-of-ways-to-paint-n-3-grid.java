class Solution {
    private static final int MOD = (int)1e9+7;

    public int numOfWays(int n) {
        if (n == 0) return 0;

        long a = 6; // ABA
        long b = 6; // ABC

        for (int i = 2; i <= n; i++) {
            long newA = (3 * a + 2 * b) % MOD;
            long newB = (2 * a + 2 * b) % MOD;
            a = newA;
            b = newB;
        }

        return (int) ((a + b) % MOD);
    }
}
