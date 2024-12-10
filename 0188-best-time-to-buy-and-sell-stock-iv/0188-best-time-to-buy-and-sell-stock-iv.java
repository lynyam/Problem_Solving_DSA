class Solution {
    int n;
    int[] prices;
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        this.prices = prices;
        dp = new int[n][k + 1][2];
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j <= k) {
                Arrays.fill(dp[i][j], -1);
                j++;
            }
            i++;
        }
        return (memo(0, k, 0));
    }

    public int memo(int i, int k, int state) {
        if (i == n || k == 0) {
            return (0);
        }
        if (dp[i][k][state] != -1)
            return (dp[i][k][state]);
        int max = memo(i + 1, k, state);
        if (state == 0) {
            max = Math.max(max, -prices[i] + memo(i + 1, k, 1));
        }
        else 
            max = Math.max(max, prices[i] + memo(i + 1, k - 1, 0));
        dp[i][k][state] = max;
        return (max);
    }
}