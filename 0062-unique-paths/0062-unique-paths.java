class Solution {
    int[][] dp;
    int n, m;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        this.n = n;
        this.m = m;
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
        int right = helper(i + 1, j);
        int botom = helper(i, j + 1);
        dp[i][j] = right + botom;
        return (right + botom);
    }
}