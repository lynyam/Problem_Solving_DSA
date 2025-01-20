class Solution {
    long[] dp;
    int[][] questions;
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        this.questions = questions;
        Arrays.fill(dp, -1);
        return (helper(0));
    }

    public long helper(int i) {
        if (i >= questions.length)
            return (0);
        if (dp[i] != -1)
            return (dp[i]);
        dp[i] = Math.max(questions[i][0] + helper(i + questions[i][1] + 1), helper(i + 1));
        return (dp[i]);
    }
}