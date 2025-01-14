class Solution {
    int n, cost[], dp[];
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n + 1];
        this.cost = cost;
        if (n < 3)
            return (Math.min(cost[0], cost[1]));
        Arrays.fill(dp, -1);
        return (Math.min(helper(0), helper(1)));
    }

    public int helper(int i) {
        if (i >= n)
            return (0);
        if (dp[i] != -1)
            return (dp[i]);
        dp[i] = cost[i] + Math.min(helper(i + 1), helper(i + 2));
        return (dp[i]);
    }
}