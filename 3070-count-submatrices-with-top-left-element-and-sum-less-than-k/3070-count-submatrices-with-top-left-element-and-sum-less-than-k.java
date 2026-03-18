class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long ans = 0;
        
        for (int i = 0; i < m; i++) {
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                
                rowSum += grid[i][j];
                
                if (i > 0)
                    grid[i][j] = (int)(grid[i-1][j] + rowSum);
                else
                    grid[i][j] = (int)rowSum;
                
                if (grid[i][j] <= k)
                    ans++;
            }
        }
        return (int)ans;
    }
}