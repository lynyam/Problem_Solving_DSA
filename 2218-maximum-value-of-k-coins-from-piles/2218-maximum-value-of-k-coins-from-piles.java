class Solution {
    List<List<Integer>> piles;
    int n;
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        n = piles.size();
        dp = new int[n][k + 1];
        int i = 0;

        while (i < n) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(0, k));
    }

    public int helper(int i, int k) {
        if (k <= 0 || i >= n)
            return (0);
        if (dp[i][k] != -1)
            return (dp[i][k]);
        int answer = helper(i + 1, k);
        int j = 0;
        int curr = 0;
        while (j < Math.min(piles.get(i).size(), k)) {
            curr += piles.get(i).get(j);
            answer = Math.max(answer, curr + helper(i + 1, k - j - 1));
            j++;
        }
        dp[i][k] = answer;
        return (answer);
    }
}