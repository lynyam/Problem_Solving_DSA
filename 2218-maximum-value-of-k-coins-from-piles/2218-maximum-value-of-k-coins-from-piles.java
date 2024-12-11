class Solution {
    int n;
    List<List<Integer>> piles;
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.n = piles.size();
        this.piles = piles;
        dp = new int[n + 1][k + 1];
        //return (helper(0, k));
        return (tabulation(n - 1, k));
    }

    public int helper(int i, int k) {
        if (i == n || k == 0)
            return (0);
        int mvc = 0;
        int curr = 0;
        int j = 0;
        while (j < Math.min(piles.get(i).size(), k)) {
            curr += piles.get(i).get(j);
            mvc = Math.max(mvc, curr + helper(i + 1, k - 1 - j));
            j++;
        }
        mvc = Math.max(mvc, helper(i + 1, k));
        return (mvc);
    }

    public int tabulation(int i, int coins) {
        while (i >= 0) {
            int k = 1;
            while (k <= coins) {
                int mvc = 0;
                int curr = 0;
                int j = 0;
                while (j < Math.min(piles.get(i).size(), k)) {
                    curr += piles.get(i).get(j);
                    mvc = Math.max(mvc, curr + dp[i + 1][k - 1 - j]);
                    j++;
                }
                mvc = Math.max(mvc, dp[i + 1][k]);
                dp[i][k] = mvc;
                k++;
            }
            i--;
        }
        return (dp[0][coins]);
    }

}