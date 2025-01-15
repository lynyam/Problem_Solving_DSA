class Solution {
    int n;
    int cost[], dp[];
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        if (n < 3)
            return (Math.min(cost[0], cost[1]));
        dp = new int[n + 1];
        this.cost = cost;
        
        return (helper(2));
    }

    public int helper(int i) {
        while (i <= n) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
            i++;
        }
        return (dp[n]);
    }
}