class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        int i = 2;

        while (i <= n) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            i++;
        }
        return (dp[n]);
    }
    /**int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return (dp(n, cost));
    }

    public int dp(int i, int[] cost) {
        if (i == 0 || i == 1)
            memo[i] = 0;
        if (memo[i] >= 0)
            return (memo[i]);
        memo[i] = Math.min(dp(i - 1, cost) + cost[i - 1], dp(i - 2, cost) + cost[i - 2]);
        return (memo[i]);
    }*/
}
/**
    - cost[] ith step on staircase
    - pay cost[i]  climb one or two step
    - start 0 1
    - ret minimum cost to reach top of the floor
    Solution
        - return minimum cost Fn(state) i index th staircase
        - rec Formula : Fn(i) = min(Fn(i - 1) + cost(i - 1), Fn(i - 2) + cost(i - 2))
        - base case: Fn(0) = 0 Fn(1) = 0




 */