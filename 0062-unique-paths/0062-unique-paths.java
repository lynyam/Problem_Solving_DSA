class Solution {
    int m, n;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        int i = 0;
        
        while (i < m) {
            Arrays.fill(dp[i], -1);
            i++;
        }
        return(helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i == m || j == n)
            return (0);
        if (i == m - 1 && j == n - 1)
            return (1);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        int ans = helper(i + 1, j) + helper(i, j + 1);
        dp[i][j] = ans;
        return (ans);
    }
}