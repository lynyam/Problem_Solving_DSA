class Solution {
    List<List<Integer>> piles;
    int n;
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        this.n = piles.size();
        dp = new int[n][k + 1];
        int j = 0;

        while (j < n) {
            Arrays.fill(dp[j++], -1);
        }
        return (helper(0, k));
    }

    public int helper(int i, int k) {
        if (i == n || k == 0)
            return (0);
        if (dp[i][k] != -1)
            return (dp[i][k]);
        int max = 0;
        max = helper(i + 1, k);
        int j = 0;
        int curr = 0;
        while (j < Math.min(k, piles.get(i).size())) {
            curr += piles.get(i).get(j);
            max = Math.max(max, curr + helper(i + 1, k - j - 1));
            j++;
        }
        dp[i][k] = max;
        return (max);
    }
}