class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;
        int n = cost.length;
        int i = 2;

        while (i <= n) {
            int temp = one;
            one = Math.min(one + cost[i - 1], two + cost[i - 2]);
            two = temp;
            i++;
        }
        return (one);
    }
}