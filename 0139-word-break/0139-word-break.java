class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int i = n - 1;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        while (i >= 0) {
            for (String str : wordDict) {
                if (i + str.length() <= n  && s.substring(i, i + str.length()).equals(str)) {
                    dp[i] = dp[i + str.length()];
                }
                if (dp[i])
                    break ;
            }
            i--;
        }
        return dp[0];
    }
}