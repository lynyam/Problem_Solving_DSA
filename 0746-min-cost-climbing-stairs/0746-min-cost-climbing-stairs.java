class Solution {
    public int  minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return (0);
        Map<Integer, Integer> memo = new HashMap<>();
        return (helper(cost, memo, -1));
    }


    public int helper(int[] cost, Map<Integer, Integer> memo,  int state) {
        if (state >= cost.length)
            return (0);
        if (memo.containsKey(state)) return (memo.get(state));
        int result = 0;
        if (state >= 0) result = cost[state];
        memo.put(state, result + Math.min(helper(cost, memo, state + 1), helper(cost, memo, state + 2)));
        return (memo.get(state));
    }
}
