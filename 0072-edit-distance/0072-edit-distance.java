class Solution {
    public int minDistance(String word1, String word2) {
        //insert abc(i) abe(j)| 'c'(i=2, j=2) abc -> abce i=2 j=1
        //Delete abc ->  ab | i=1 j=2
        //Replace abc -> abe | i = 1 j = 1
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] memo = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++)
            Arrays.fill(memo[i], -1);
        return (helper(word1.length(), word2.length(), word1, word2, memo));
    }

    public int helper(int n1, int n2, String w1, String w2, int[][] memo) {
        if (n1 == 0) return (n2);
        if (n2 == 0) return (n1);
        if (memo[n1][n2] != -1) return (memo[n1][n2]);
        
        if (w1.charAt(n1 - 1) == w2.charAt(n2 - 1)) {
            memo[n1][n2] = helper(n1 - 1, n2 - 1, w1, w2, memo);
            return (memo[n1][n2]);
        } else {
            //3 case insert delete replace case
            memo[n1][n2] = (1 + Math.min(helper(n1, n2 - 1, w1, w2, memo), 
                Math.min(helper(n1 - 1, n2, w1, w2, memo), 
                helper(n1 - 1, n2 - 1, w1, w2, memo))));
            return (memo[n1][n2]);
        }
    }
}