class Solution {
    public boolean isMatch(String s, String p) {
        int [][] memo = new int[s.length() + 1][p.length() + 1];
        return (helper(0, 0, s, p, memo));
    }


    public boolean helper(int i, int j, String s, String p, int[][] memo) {
        int n = s.length();
        int m = p.length();
        if (i >= n && j >= m) return (true);
        if (j >= m)
            return (false);
        if (memo[i][j] != 0) return (memo[i][j] == 1);

        boolean match = false;

        if (p.charAt(j) == '*') {
            match = ((i < n && (helper(i+1, j, s, p, memo) || helper(i + 1,  j+1, s, p, memo)))
                 || helper(i, j+1, s, p, memo));
        }
        else {
            if (i < n && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                match = helper(i+1, j+1, s, p, memo);
            }
            else match = false;
        }
        
        memo[i][j] = match == true ? 1 : 2;
        return (match);
    }

}