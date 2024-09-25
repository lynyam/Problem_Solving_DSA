class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int i = n1 - 1;
        int j = n2 - 1;

        while (i >= 0) {
            j = n2 - 1;
            while (j >= 0) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                j--;
            }
            i--;
        }
        return (dp[0][0]);
    }
}
/**
    - t1, t2, ret length of LCS or 0
    
    Solution
    - return length LCS Fn(State) state i, j index of t1, t2
    - recursive formula : Fn(i, j) = t1[i] == t2[j] ? {Fn(i + 1, j + 1) + 1} : max(Fn(i+1, j), Fn(i, j+1))
    - Base case: i == t1.length || j == t2.length return 0
    - int[][] dp = new int[n1][n2]
 */