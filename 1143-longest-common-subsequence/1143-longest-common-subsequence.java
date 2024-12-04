class Solution {
    String text1;
    String text2;
    int len1;
    int len2;
    int ans;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        ans = 0;
        this.text1 = text1;
        this.text2 = text2;
        len1 = text1.length();
        len2 = text2.length();
        dp = new int[len1 + 1][len2 + 1];
        int i = 0;
        /*while (i < len1) {
            Arrays.fill(dp[i], -1);
            i++;
        }*/

        //return(helper(0, 0));
        return (lcs(len1 - 1, len2 - 1));
    }

    public int lcs(int n1, int len) {
        while (n1 >= 0) {
            int n2 = len;
            while (n2 >= 0) {
                if (text1.charAt(n1) == text2.charAt(n2))
                    dp[n1][n2] = 1 + dp[n1 + 1][n2 + 1];
                else {
                    dp[n1][n2] = Math.max(dp[n1 + 1][n2], dp[n1][n2 + 1]);
                }
                n2--;
            }
            n1--;
        }
        return (dp[0][0]);
    }

    public int helper(int i, int j) {
        if (i == len1 || j == len2)
            return (0);
        if (dp[i][j] != -1) {
            return(dp[i][j]);
        }
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + helper(i + 1, j + 1);
        }
        else {
            ans = Math.max(helper(i + 1, j), helper(i, j + 1));
        }
        dp[i][j] = ans;
        return (dp[i][j]);
    }
}