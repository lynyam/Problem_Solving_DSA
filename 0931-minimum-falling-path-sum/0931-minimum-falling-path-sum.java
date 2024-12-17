class Solution {
    int[][] dp;
    int n;
    int m;
    int[][] matrix;
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        this.matrix = matrix;
        dp = new int[n][m];
        int i = 0;
        while (i < n) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            i++;
        }
        i = 0;
        int ans = Integer.MAX_VALUE;
        while (i < m) {
            ans = Math.min(ans, helper(0, i));
            i++;
        }
        return (ans);
    }

    public int helper(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return (Integer.MAX_VALUE);
        if (dp[i][j] != Integer.MAX_VALUE)
            return (dp[i][j]);
        int below = helper(i + 1, j - 1);
        int leftDiag = helper(i + 1, j);
        int rightDiag = helper(i + 1, j + 1);
        int ans = Math.min(below, Math.min(leftDiag, rightDiag));
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        dp[i][j] = matrix[i][j] + ans;
        return (dp[i][j]);
    }
}