class Solution {
    int[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        this.coins = coins;
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int answer = helper(amount);
        return (answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public int helper(int amount) {
        if (amount < 0)
            return (Integer.MAX_VALUE);
        if (dp[amount] != -1)
            return (dp[amount]);
        int fewerNumber = Integer.MAX_VALUE;
        for (int coin : coins) {
            fewerNumber = Math.min(fewerNumber, helper(amount - coin));
        }
        if (fewerNumber != Integer.MAX_VALUE)
            fewerNumber++;
        dp[amount] = fewerNumber;
        return (fewerNumber);
    }
}