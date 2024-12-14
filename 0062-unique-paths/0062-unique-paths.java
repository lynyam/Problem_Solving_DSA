class Solution {
    int n;
    int m;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.n = n;
        this.m = m;
        dp = new int[m][n];
        int i = 0;

        while (i < m) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i >= m || j >= n)
            return (0);
        if (i == m - 1 && j == n - 1)
            return (1);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        dp[i][j] = helper(i, j + 1) + helper(i + 1, j);
        return (dp[i][j]);
    }
}