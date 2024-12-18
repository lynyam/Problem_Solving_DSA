class Solution {
    int[][] dp;
    int n;
    int m;
    int[][] grid;
    public int minPathSum(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        dp = new int[n][m];
        this.grid = grid;
        int i = 0;
        while (i < n) {
            Arrays.fill(dp[i++], Integer.MAX_VALUE);
        }
        return (helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i >= n || j >= m)
            return (Integer.MAX_VALUE);
        if (i == n - 1 && j == m - 1)
            return (grid[i][j]);
        if (dp[i][j] != Integer.MAX_VALUE)
            return (dp[i][j]);
        int max = Math.min(helper(i + 1, j), helper(i, j + 1));
        max = max == Integer.MAX_VALUE ? 0 : max;
        dp[i][j] = grid[i][j] + max;
        return (dp[i][j]);
    }
}