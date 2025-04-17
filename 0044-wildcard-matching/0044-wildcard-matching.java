class Solution {
    public boolean isMatch(String s, String p) {
        // optimisation du motif : retirer les '**'
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && i > 0 && p.charAt(i - 1) == '*') continue;
            sb.append(p.charAt(i));
        }
        p = sb.toString();

        int m = s.length();
        int n = p.length();

        // dp[i][j] = est-ce que s[0..i-1] match p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Initialiser les cas où p commence par *
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // Remplir le tableau
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                char sc = s.charAt(i - 1);

                if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pc == '?' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
