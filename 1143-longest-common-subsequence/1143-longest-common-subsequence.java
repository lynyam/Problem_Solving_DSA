class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i;
        int j;
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        i = n1 - 1;
        j = n2 - 1;

        while (i >= 0) {
            j = n2 - 1;
            while (j >= 0) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                j--;
            }
            i--;
        }
        return (dp[0][0]);
    }
}