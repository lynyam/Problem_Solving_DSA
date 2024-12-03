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
        while (i < len1) {
            Arrays.fill(dp[i], -1);
            i++;
        }

        return(helper(0, 0));
    }

    public int helper(int i, int j) {
        if (dp[i][j] != -1) {
            return(dp[i][j]);
        }
        int case1 = helper(i + 1, j);
        int k = j;
        int case2 = 0;
        while (k < len2) {
            if (text1.charAt(i) == text2.charAt(k)) {
                case2 = 1 + helper(i + 1, k + 1);
                break ;
            }
            k++;
        }
        dp[i][j] = Math.max(case1, case2);
        return (dp[i][j]);
    }
}