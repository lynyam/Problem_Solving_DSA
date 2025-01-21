class Solution {
    int[] coins;
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        this.coins = coins;
        Arrays.fill(dp, -1);
        int answer = helper(amount);
        return (answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public int helper(int amount) {
        if (amount == 0)
            return (0);
        if (amount < 0)
            return (Integer.MAX_VALUE);
        if (dp[amount] != -1)
            return (dp[amount]);
        int number = Integer.MAX_VALUE;
        for (int coin : coins) {
            number = Math.min(number, helper(amount - coin));
        }
        dp[amount] = number == Integer.MAX_VALUE ? Integer.MAX_VALUE : number + 1;
        return (dp[amount]);
    }
}