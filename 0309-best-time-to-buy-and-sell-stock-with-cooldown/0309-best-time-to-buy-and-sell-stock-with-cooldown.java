class Solution {
    int[] prices;
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.n = prices.length;
        dp = new int[n + 2][2];
        return (helper(n - 1));
    }

    public int helper(int i) {
        while (i >= 0) {
            int j = 0;
            while (j < 2) {
                int max = dp[i + 1][j];
                if (j == 0)
                    max = Math.max(max, -prices[i] + dp[i + 1][1]);
                else
                    max = Math.max(max, prices[i] + dp[i + 2][0]);
                dp[i][j] = max;
                j++;
            }
            i--;
        }
        return (dp[0][0]);
    }
}