class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int i = 1;

        while (i <= amount) {
            int ans = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    ans = Math.min(ans, dp[i - coin]);
                }
            }
            dp[i] = ans == Integer.MAX_VALUE ? ans : ans + 1;
            i++;
        }
        return (dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]);
    }
}