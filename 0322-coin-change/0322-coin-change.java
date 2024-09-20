class Solution {
    //HashMap<Integer, Integer> memo;
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        //memo = new HashMap<>();
        memo = new int[amount + 1];
        int res = dp(coins, amount);
        return (res == Integer.MAX_VALUE ? -1 : res);
    }

    public int dp(int[] coins, int amount) {//11/6/1
        if (amount == 0)
            return (0);
        if (memo[amount] > 0)//
            return (memo[amount]);
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int rest = amount - coin;
            if (rest >= 0) {
                min = Math.min(min, dp(coins, rest));//6/1/
            }
        }
        memo[amount] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;//{1:I}
        return (memo[amount]);//-1
    }
}
/**
    - coins[]
    - integer amount total money
    - fewest number of coins u need to make up that amount.
    - if any comb not -1
    - infinite number of each kind of coin

    Solution
    - return feewest number of coins Fn(State) i, index coins and rest amount
    - recursive formula: Fn(m) = Min(F(m - Ci)) + 1/ i [0, coins.length - 1] 
    - base case : F(0) = 0
 */