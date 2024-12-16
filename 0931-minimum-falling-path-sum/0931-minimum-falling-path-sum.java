class Solution {
    int[][] matrix;
    int[][] dp;
    int n;
    int m;
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
        dp= new int[n][m];
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
            return Integer.MAX_VALUE;
        if (dp[i][j] != Integer.MAX_VALUE) {
            return (dp[i][j]);
        }
        if (i == n - 1) {
            dp[i][j] = matrix[i][j];
            return (matrix[i][j]);
        }
        int next = Math.min(helper(i + 1, j - 1), Math.min(helper(i + 1, j), 
            helper(i + 1, j + 1)));
        next = next == Integer.MAX_VALUE ? matrix[i][j] : matrix[i][j] + next;
        dp[i][j] = next;
        return (dp[i][j]);
    }
}