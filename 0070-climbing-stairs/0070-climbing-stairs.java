class Solution {
    int n, dp[];
    public int climbStairs(int n) {
        this.n = n;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }
        return (helper(n));
    }

    public int helper(int i) {
        if (i > n || i <= 0)
            return (0);
        if (dp[i] != -1)
            return (dp[i]);
        dp[i] = helper(i - 1) + helper(i - 2);
        return (dp[i]);
    }
}