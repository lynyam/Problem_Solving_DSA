class Solution {
    int[][] grid;
    int n;
    int m;
    int[][] dp;
    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        dp = new int[m + 1][n + 1];
        int i = 0;

        while (i <= m) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            i++;
        }
        this.grid = grid;

        return (helper(m - 1, n - 1));
    }

    public int helper(int i, int k) {
        while (i >= 0) {
            int j = k;
            while (j >= 0) {
                int curr = Math.min(dp[i + 1][j], dp[i][j + 1]);
                curr = curr == Integer.MAX_VALUE ? 0 : curr;
                dp[i][j] = grid[i][j] + curr;
                j--;
            }
            i--;
        }
        return (dp[0][0]);
    }
}