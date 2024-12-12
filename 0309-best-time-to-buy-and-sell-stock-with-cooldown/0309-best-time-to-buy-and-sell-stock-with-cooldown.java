class Solution {
    int[] prices;
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.n = prices.length;
        dp = new int[n][2];
        int i = 0;

        while(i < n) {
            Arrays.fill(dp[i++], -1);
        }
        return(helper(0, 0));
    }

    public int helper(int i, int status) {
        if (i >= n)
            return (0);
        if (dp[i][status] != -1) {
            return (dp[i][status]);
        }
        int max = helper(i + 1, status);
        if (status == 0) {
            max = Math.max(max, -prices[i] + helper(i + 1, 1));
        } else {
            max = Math.max(max, prices[i] + helper(i + 2, 0));
        }
        dp[i][status] = max;
        return (max);
    }
}