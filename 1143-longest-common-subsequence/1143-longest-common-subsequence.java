class Solution {
    int n1;
    int n2;
    String s1;
    String s2;
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();
        s1 = text1;
        s2 = text2;
        memo = new int[n1][n2];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return (dp(0, 0));
    }

    public int dp(int i, int j) {
        if (i == n1 || j == n2)
            return (0);
        if (memo[i][j] != -1)
            return  (memo[i][j]);
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j))
            ans = 1 + dp(i + 1, j + 1);
        else {
            ans = Math.max(dp(i + 1, j), dp(i, j + 1));
        }
        memo[i][j] = ans;
        return (ans);
    }
}