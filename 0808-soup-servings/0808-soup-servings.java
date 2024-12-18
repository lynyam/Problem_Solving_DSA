class Solution {
    double[][] dp;
    public double soupServings(int n) {
        if (n > 4800)
            return (1.0);
        dp = new double[n + 1][n + 1];
        int i = 0;
        while (i <= n) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(n, n));
    }

    public double helper(int i, int j) {
        if (i <= 0 && j <= 0)
            return (0.5);
        if (i <= 0)
            return (1);
        if (j <= 0)
            return (0);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        double prob = 0.25 * (helper(i - 100, j) + helper(i - 75, j - 25) + 
            helper(i - 50, j - 50) + helper(i - 25, j - 75));
        dp[i][j] = prob;
        return (dp[i][j]);
    }
}