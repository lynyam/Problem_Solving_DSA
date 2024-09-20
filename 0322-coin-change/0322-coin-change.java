class Solution {
    HashMap<Integer, Integer> memo;
    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        int res = dp(coins, amount);
        return (res == Integer.MAX_VALUE ? -1 : res);
    }

    public int dp(int[] coins, int amount) {//3//1
        if (amount == 0)
            return (0);
        if (memo.containsKey(amount))
            return (memo.get(amount));
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {//2//2
            int rest = amount - coin;//1//-1
            if (rest >= 0) {
                min = Math.min(min, dp(coins, rest));//I,-1
            }
        }
        memo.put(amount, min == Integer.MAX_VALUE ? min : min + 1);//{1:I}
        return (memo.get(amount));//-1
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