class Solution {
    public int  minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return (0);
        int n = cost.length;
        if (n == 1) return (cost[0]);
        int[] sol = new int[n + 1];
        sol[0] = cost[0];
        sol[1] = cost[1];
        for (int state = 2; state < n; state++) {
            sol[state] = cost[state] + Math.min(sol[state - 1], sol[state - 2]);
        }
        return Math.min(sol[n - 1], sol[n - 2]);
    }
}
