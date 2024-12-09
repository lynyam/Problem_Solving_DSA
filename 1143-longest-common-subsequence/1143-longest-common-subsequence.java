class Solution {
    int n1;
    int n2;
    String text1;
    String text2;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        dp = new int[n1 + 1][n2 + 1];
        int i = 0;
        /*while (i < n1) {
            Arrays.fill(dp[i], -1);
            i++;
        }
        return(helper(0, 0));*/
        return (downUp(n1 - 1, n2 - 1));
    }

    public int helper(int i, int j) {
        if (i == n1 || j == n2)
            return (0);
        if (dp[i][j] != -1)
            return (dp[i][j]);
        int lcs = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            lcs = 1 + helper(i + 1, j + 1);
        } else {
            lcs = Math.max(helper(i + 1, j), helper(i, j + 1));
        }
        dp[i][j] = lcs;
        return (lcs);
    }

    public int downUp(int i, int k) {
        while (i >= 0) {
            int j = k;
            while (j >= 0) {
                int lcs = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    lcs = 1 + dp[i + 1][j + 1];
                } else {
                    lcs = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = lcs;
                j--;
            }
            i--;
        }
        return (dp[0][0]);
    }
}