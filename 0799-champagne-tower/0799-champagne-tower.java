class Solution {

    double[][] memo = new double[101][101];

    double dfs(int r, int c, int poured){
        if(c < 0 || c > r) return 0.0;
        if(r == 0 && c == 0) return poured;

        if(memo[r][c] != -1) return memo[r][c];

        double left = dfs(r-1, c-1, poured);
        double right = dfs(r-1, c, poured);

        double ans = 0.0;

        if(left > 1) ans += (left - 1) / 2.0;
        if(right > 1) ans += (right - 1) / 2.0;

        return memo[r][c] = ans;
    }

    public double champagneTower(int poured, int query_row, int query_glass) {

        for(double[] row : memo)
            java.util.Arrays.fill(row, -1);

        return Math.min(1.0, dfs(query_row, query_glass, poured));
    }
}
