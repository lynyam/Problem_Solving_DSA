class Solution {
    double[][] dp;
    public double soupServings(int n) {
        if (n > 4800) 
        {
            return (1.0);
        }
        int parts = n % 25 != 0 ? 1 + n / 25 : n / 25;
        dp = new double[parts + 1][parts + 1];
        int i = 0;
        while (i <= parts)
            Arrays.fill(dp[i++], -1.0);
        return (helper(parts, parts));
    }

    public double helper(int a, int b) {
        if (a <= 0 && b <= 0)
            return (0.5);
        if (a <= 0)
            return (1.0);
        if (b <= 0)
            return (0.0);
        if (dp[a][b] != -1.0)
            return (dp[a][b]);
        double prob = 0.25 * (helper(a - 4, b) + helper(a - 3, b - 1) +
                    helper(a - 2, b - 2) + helper(a - 1, b - 3));
        dp[a][b] = prob;
        return (prob);
    }
}