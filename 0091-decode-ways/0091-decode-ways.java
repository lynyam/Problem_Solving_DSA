class Solution {
    int[] memo;
    int n;
    public int numDecodings(String s) {
        n = s.length();
        memo = new int[n];
        return (dp(0, s));
    }

    public int dp(int i, String s) {
        if (i >= n)
            return (1);
        if (memo[i] != 0)
            return memo[i];
        if (s.charAt(i) == '0')
            return (0);
        int ans = dp(i + 1, s);
        if (i + 1 < n && ((s.charAt(i) == '1' && "0123456789".indexOf(s.charAt(i + 1)) > -1)
           ||  (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) > -1))) {
            ans += dp(i + 2, s);
        }
        memo[i] = ans;
        return (memo[i]);
    }
}