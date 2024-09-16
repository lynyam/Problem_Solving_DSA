class Solution {
    HashMap<Integer, Integer> memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new HashMap<>();
        return (dp(cost.length, cost));
    }

    public int dp(int n, int[] cost) {
        if (n <= 1)
            return (0);
        if (memo.containsKey(n)) {
            return (memo.get(n));
        }
        memo.put(n, Math.min(dp(n - 1, cost) + cost[n - 1], dp(n - 2, cost) + cost[n - 2]));
        return (memo.get(n));
    }
}
/**
    - cost[i]  ith step on staircase.
    - climb one or two steps
    - start with index 0 or 1
    - ret minimum cost to reach the top floor
        - 
    - return and state
        - return minimun cost = dp(state)=> state(i, cost);
    - recusrion formula
        - step1->step2 or step3 => pay cost[1]
        - choise minimal
        - Fn(stepi) => min(Fn(stepi-1) + cost(stepi-1) or Fn(stepi-2) + 
            cost(stepi-2))
    - base case:
        - step1 = 0 / step0 = 0
        - Fn(1) = 0 / Fn(0) = 0

    
 */