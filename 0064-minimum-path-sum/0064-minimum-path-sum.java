class Solution {
    int[][] grid;
    int m;
    int n;
    int[][] dp;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        dp = new int[m][n];
        int i = 0;

        while (i < m) {
            Arrays.fill(dp[i], -1);
            i++;
        }
        return (helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i >= m || j >= n)
            return (Integer.MAX_VALUE);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        int ans = Math.min(helper(i + 1, j), helper(i, j + 1));
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        dp[i][j] = grid[i][j] + ans;
        return (dp[i][j]);
    }
}