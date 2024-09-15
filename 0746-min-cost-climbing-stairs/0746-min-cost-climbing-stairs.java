class Solution {
    HashMap<Integer, Integer> map;
    public int minCostClimbingStairs(int[] cost) {
        map = new HashMap<>();
        return(dp(cost.length, cost));
    }

    public int dp(int i, int[] cost) {
        //step i
         //cost + cost i
         // i + 1 or i + 2
        // i => cost 0 to (i - 1 / i - 2) + cost (i-1/i-2) => min(cost(0))
        if (i <= 1)
            return (0);
        if (map.containsKey(i))
            return (map.get(i));
        map.put(i, Math.min((dp(i - 1, cost) + cost[i - 1]), (dp(i - 2, cost)) + cost[i - 2]));
            return  (map.get(i));
    }
}