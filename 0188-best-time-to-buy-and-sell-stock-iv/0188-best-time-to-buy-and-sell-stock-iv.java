class Solution {
    int[] prices;
    int n;
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        this.n = prices.length;
        this.prices = prices;
        dp = new int[n + 1][k + 1][2];
        int i = 0;
        /*while (i < n) {
            int j = 0;
            while (j <= k) {
                Arrays.fill(dp[i][j], -1);
                j++;
            }
            i++;
        }*/
        //return (memo(0, k, 0));
        return (tabulation(n - 1, k));
    }
//statue 0 -> u can buy
//status 1 -> u can sell 
    public int memo(int i, int k, int status) {
        if (i == n || k == 0)
            return (0);
        if (dp[i][k][status] != -1)
            return (dp[i][k][status]);
        int max = 0;
        max = memo(i + 1, k, status);
        if (status == 0) {
            max = Math.max(max, -prices[i] + memo(i + 1, k, 1));
        } else {
            max = Math.max(max, prices[i] + memo(i + 1, k - 1, 0));
        }
        dp[i][k][status] = max;
        return (max);
    }

    public int tabulation(int i, int k) {
        while (i >= 0) {
            int j = 1;
            while (j <= k) {
                int l = 0;
                while (l < 2) {
                    int max = dp[i + 1][j][l];
                    if (l == 0) {
                        max = Math.max(max, -prices[i] + dp[i + 1][j][1]);
                    } else {
                        max = Math.max(max, prices[i] + dp[i + 1][j - 1][0]);
                    }
                    dp[i][j][l] = max;
                    l++;
                }
                j++;
            }
            i--;
        }
        return (dp[0][k][0]);
    }
}