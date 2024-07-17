class Solution {
    boolean[][] seen;
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        int i = 0;
        int j = 0;
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        while (i < m) {
            j = 0;
            while (j < n) {
                if (!seen[i][j] && grid[i][j] == 1) {
                    seen[i][j] = true;
                    ans = Math.max(ans, dfs(i, j, grid) + 1);
                }
                j++;
            }
            i++;
        }
        return (ans);
    }

    public int dfs(int row, int col, int [][] grid) {
        int ans = 0;
        if (row - 1 >= 0 && !seen[row - 1][col] && grid[row - 1][col] == 1) {
            seen[row - 1][col] = true;
            ans += (1 + dfs(row - 1, col, grid));
        }
        if (row + 1 < m && !seen[row + 1][col] && grid[row + 1][col] == 1) {
            seen[row + 1][col] = true;
            ans += (1 + dfs(row + 1, col, grid));
        }
        if (col - 1 >= 0 && !seen[row][col - 1] && grid[row][col - 1] == 1) {
            seen[row][col - 1] = true;
            ans += (1 + dfs(row, col - 1, grid));
        }
        if (col + 1 < n && !seen[row][col + 1] && grid[row][col + 1] == 1) {
            seen[row][col + 1] = true;
            ans += (1 + dfs(row, col + 1, grid));
        }
        return (ans);
    }
}