class Solution {
    //int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return (0);
        //memo = new int[n + 1];
        //Arrays.fill(memo, -1);
        int i = 0;
        int one;
        int two;
        one = two = 0;
        while (i <= n) {
            if (i < 2) {
                one = two = 0;
                i++;
                continue ;
            }
            int temp = one;
            one = Math.min(one + cost[i - 1], two + cost[i - 2]);
            two = temp;
            //memo[i] = Math.min(memo[i - 1] + cost[i - 1], memo[i - 2] + cost[i - 2]);
            i++; 
        }
        return (one);
    }

    /*public int dp(int i, int[] cost) {
        if (i < 2)
            return (0);
        if (memo[i] != -1)
            return (memo[i]);
        memo[i] = Math.min(dp(i - 1, cost) + cost[i - 1], dp(i - 2, cost) + cost[i - 2]);
        System.out.println(memo[i]);
        return (memo[i]);
    }*/
}