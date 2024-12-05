class Solution {
    int[][] dp;
    String text1;
    String text2;
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        dp = new int[n1 + 1][n2 + 1];
        int i = 0;

        /*while (i < n1) {
            int j = 0;
            while (j < n2) {
                dp[i][j] = -1;
                j++;
            }
            i++;
        }*/
        //return (helper(0, 0));
        return (tabulation(n1 - 1, n2 - 1));
    }

    public int helper(int i, int j) {
        
        if (dp[i][j] != -1) {
            return (dp[i][j]);
        }
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + helper(i + 1, j + 1);
        } else {
            ans = Math.max(helper(i + 1, j), helper(i, j + 1));
        }
        dp[i][j] = ans;
        return (dp[i][j]);
    }

    public int tabulation(int i, int j) {
        while (i >= 0) {
            int n2 = j;
            while (n2 >= 0) {
                if (text1.charAt(i) == text2.charAt(n2)) {
                    dp[i][n2] = 1 + dp[i + 1][n2 + 1];
                }
                else {
                    dp[i][n2] = Math.max(dp[i + 1][n2], dp[i][n2 + 1]);
                }
                n2--;
            }
            i--;
        }
        return (dp[0][0]);
    }


}