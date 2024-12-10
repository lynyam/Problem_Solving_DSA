class Solution {
    int n;
    int[] prices;
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        this.prices = prices;
        dp = new int[n + 1][k + 1][2];
        /*int i = 0;
        while (i < n) {
            int j = 0;
            while (j <= k) {
                Arrays.fill(dp[i][j], -1);
                j++;
            }
            i++;
        }
        return (memo(0, k, 0));*/
        return (tabulation(n - 1, k));
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

    public int tabulation(int i, int k) {
        while (i >= 0) {
            int j = 1;
            while (j <= k) {
                int state = 0;
                while (state < 2) {
                    int max = dp[i + 1][j][state];
                    if (state == 0) {
                        max = Math.max(max, -prices[i] + dp[i + 1][j][1]);
                    }
                    else 
                        max = Math.max(max, prices[i] + dp[i + 1][j - 1][0]);
                    dp[i][j][state] = max;
                    state++;
                }   
                j++;
            }
            i--;
        }
        return(dp[0][k][0]);
    }
}