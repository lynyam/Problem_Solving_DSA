class Solution {
    int[] prices;
    int fee;
    int n;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        this.n = prices.length;
        this.prices = prices;
        this.fee = fee;
        dp = new int[n + 1][2];

        return (helper(n -1));
    }

    public int helper(int i) {
        while (i >= 0) {
            int j = 0;
            while (j < 2) {
                int max = 0;
                max = Math.max(max, dp[i + 1][j]);
                if (j == 0) {
                    max = Math.max(max, -prices[i] + dp[i + 1][1]);
                } else {
                    max = Math.max(max, prices[i] - fee + dp[i + 1][0]);
                }
                dp[i][j] = max;
                j++;
            }
            i--;
        }
        return (dp[0][0]);
    }
}