class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        int i = n - 1;
        while (i >= 0) {
            if (i == n - 1)
                dp[i] = questions[i][0];
            else {
                int index = i + questions[i][1] + 1;
                dp[i] = Math.max(questions[i][0] + (index >= n ? dp[n] : dp[index]), dp[i + 1]);
            }
            i--;
        }
        return (dp[0]);
    }
}
/**
    - q[][] = [pi, bi]
    - start q i = 0
        - decision solve or skip each question
    - solv qi --> pi => can't solve bi next qi
    - skip qi decision qi+1
    - ret max point u can earn for the exam

    Solution
    - return max and each decision has impact the next choice => I can use DP
        - return max point Fn(State) / state i index of question i
        - recursive folrmula : Fn(i) = max(pi + Fn(i + qi[1]), Fn(i + 1)) 
        - base case: i >= n return (0)

        3

 */
