class Solution {
    int[][] grid;
    int n;
    int m;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        this.n = grid.length;
        this.m = grid[0].length;
        dp = new int[n][m];
        int i = 0;
        while (i < n) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i >= n || j >= m || grid[i][j] == 1)
            return (0);
        if (i == n - 1 && j == m - 1)
            return (1);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        int left = helper(i + 1, j);
        int bottom = helper(i, j + 1);
        dp[i][j] = left + bottom;
        return (dp[i][j]);
    }
}