class Solution {
    int[] prices;
    int n;
    int fee;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        this.n = prices.length;
        this.prices = prices;
        this.fee = fee;
        dp = new int[n + 1][2];
        int i = 0;

        /*while (i < n) {
            Arrays.fill(dp[i], -1);
            i++;
        }
        return(helper(0, 0));*/
        return(tabulation(n - 1));
    }

    public int helper(int i, int status) {
        if (i == n)
            return (0);
        if (dp[i][status] != -1)
            return (dp[i][status]);
        int max = 0;
        max = helper(i + 1, status);
        if (status == 0) {
            max = Math.max(max, -prices[i] + helper(i + 1, 1));
        } else {
            max = Math.max(max, prices[i] - fee + helper(i + 1, 0));
        }
        dp[i][status] = max;
        return (max);
    }

    public int tabulation(int i) {
        while (i >= 0) {
            int status = 0;
            while (status < 2) {
                int max = 0;
                max = dp[i + 1][status];
                if (status == 0) {
                    max = Math.max(max, -prices[i] + dp[i + 1][1]);
                } else {
                    max = Math.max(max, prices[i] - fee + dp[i + 1][0]);
                }
                dp[i][status] = max;
                status++;
            }
            i--;
        }
        return (dp[0][0]);
    }
}