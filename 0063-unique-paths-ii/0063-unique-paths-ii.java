class Solution {
    int[][] dp;
    int[][] obstacleGrid;
    int n;
    int m;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        dp = new int[m][n];
        int i = 0;
        while (i < m) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1)
            return (0);
        if (i == m - 1 && j == n - 1)
            return (1);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        dp[i][j] = helper(i + 1, j) + helper(i, j + 1);
        return (dp[i][j]);
    }
}