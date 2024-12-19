class Solution {
    String text1;
    String text2;
    int[][] dp;
    int n, m;
    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        dp = new int[n][m];
        int i = 0;

        while (i < n) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(0, 0));
    }

    public int helper(int i, int j) {
        if (i >= n || j >= m)
            return (0);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        int answer = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            answer = Math.max(answer, 1 + helper(i + 1, j + 1));
        } else {
            answer = Math.max(answer, Math.max(helper(i + 1, j), helper(i, j + 1)));
        }
        dp[i][j] = answer;
        return (dp[i][j]);
    }
}