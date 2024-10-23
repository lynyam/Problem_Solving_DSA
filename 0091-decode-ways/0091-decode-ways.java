class Solution {
    public int numDecodings(String s) {
        //int one = 0;
        //int two = 0;
        int n = s.length();
        int i = n;
        int[] dp = new int[n + 1];
        while (i >= 0) {
            if (i > n - 1) {
                dp[i] = 1;
                i--;
                continue ;
            }
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            }
            else 
                dp[i] = dp[i + 1];
            if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) > -1))) {
                dp[i] += dp[i + 2];
            }
            i--;
        }
        return (dp[0]);
    }
    
    /*int[] memo;
    int n;
    public int numDecodings(String s) {
        n = s.length();
        memo = new int[n];
        return (dp(0, s));
    }*/

    /*public int dp(int i, String s) {
        if (i >= n)
            return (1);
        if (memo[i] != 0)
            return memo[i];
        if (s.charAt(i) == '0')
            return (0);
        int ans = dp(i + 1, s);
        if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) > -1))) {
            ans += dp(i + 2, s);
        }
        memo[i] = ans;
        return (memo[i]);
    }*/
}