import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int rows = m - k + 1;
        int cols = n - k + 1;
        
        int[][] ans = new int[rows][cols];
        
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                
                List<Integer> list = new ArrayList<>();
                
                // collect k*k elements
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }
                
                Collections.sort(list);
                
                int minDiff = Integer.MAX_VALUE;
                
                for (int p = 1; p < list.size(); p++) {
                    if (!list.get(p).equals(list.get(p - 1))) {
                        minDiff = Math.min(minDiff,
                                list.get(p) - list.get(p - 1));
                    }
                }
                
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }
        
        return ans;
    }
}