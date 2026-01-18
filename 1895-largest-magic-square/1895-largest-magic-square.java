class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag = new int[m + 1][n + 1];
        int[][] anti = new int[m + 1][n + 1];

        // Prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag[i + 1][j + 1] = diag[i][j] + grid[i][j];
                anti[i + 1][j] = anti[i][j + 1] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        for (int size = maxSize; size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int sum = row[i][j + size] - row[i][j];
                    boolean valid = true;

                    // Check rows
                    for (int r = i; r < i + size; r++) {
                        if (row[r][j + size] - row[r][j] != sum) {
                            valid = false;
                            break;
                        }
                    }

                    // Check columns
                    for (int c = j; c < j + size && valid; c++) {
                        if (col[i + size][c] - col[i][c] != sum) {
                            valid = false;
                            break;
                        }
                    }

                    // Check diagonals
                    int d1 = diag[i + size][j + size] - diag[i][j];
                    int d2 = anti[i + size][j] - anti[i][j + size];
                    if (d1 != sum || d2 != sum) valid = false;

                    if (valid) return size;
                }
            }
        }
        return 1;
    }
}
