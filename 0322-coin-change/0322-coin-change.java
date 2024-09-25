class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int i = 0;
        int n = coins.length;
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        while (i <= amount) {
            int j = 0;
            while (j < n) {
                int rest = i - coins[j];
                if (rest >= 0) {
                    dp[i] = Math.min(dp[i], dp[rest] + 1);
                }
                j++;
            }
            i++;
        }
        return (dp[amount] >= amount + 1 ? -1 : dp[amount]);

    }
}
/**
    - coins[] #coins denominations
    - amount --> total amount
    - ret fewest numb of coins u can make or -1
    - infinite number of kind of coins

    Solution
    - In this problem we need to return a fewest numb of coins and we not garantie that solution exist
    - So every decision of coins choice u make have an impact on future choice.
    - I use DP to resolve that point
        - return value is fewest numb of coins for Fn(State) state is i : 0 to amount 
        - recursive formula : Fn(i) = Min(for(Fn(i - ci)))) + 1
        - base case: i <= 0 return 0
 */