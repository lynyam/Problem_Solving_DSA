class Solution {
    int[][] matrix;
    int n;
    int m;
    int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.matrix = matrix;
        dp = new int[n][m];
        int i = 0;
        while (i < n) {
            Arrays.fill(dp[i++], Integer.MAX_VALUE);
        }
        i = 0;
        int min = Integer.MAX_VALUE;
        while (i < m) {
            min = Math.min(min, helper(0, i));
            i++;
        }
        return (min);
    }

    public int helper(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return (Integer.MAX_VALUE);
        if (i == n - 1)
            return (matrix[i][j]);
        if (dp[i][j] != Integer.MAX_VALUE)
            return (dp[i][j]);
        int min = Math.min(helper(i + 1, j - 1), Math.min(helper(i + 1, j),
                helper(i + 1, j + 1)));
            min = min == Integer.MAX_VALUE ? 0 : min;
            min += matrix[i][j];
        dp[i][j] = min;
        return (min);
    }
}