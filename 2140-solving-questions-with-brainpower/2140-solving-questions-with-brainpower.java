/**class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int i = 0;
        int[] dp = new int[n];
        int res = 0;

        while (i < n) {
            int ans = questions[i][0];
            int j = 0;
            while (j < i) {
                if (i - j - 1 < n && questions[j][1] <= i - j - 1) {
                    ans = Math.max(ans, dp[j] + questions[i][0]);
                }
                j++;
            }
            res = Math.max(res, ans);
            dp[i] = ans;
            i++;
        }
        return (res);
    }
}
*/
class Solution {
    HashMap<Integer, Long> memo;
    int res = 0;
    public long mostPoints(int[][] questions) {
        memo = new HashMap<>();

        return (dp(0, questions));
    }

    public long dp(int i, int[][] questions) {
        if (i >= questions.length)
            return (0);
        if (memo.containsKey(i))
            return (memo.get(i));
        int j = i + questions[i][1] + 1;
        memo.put(i, Math.max(questions[i][0] + dp(j, questions), dp(i + 1, questions)));
        return (memo.get(i));
    }
}

/**
    - qu[i] = [pi, bi]
    - start i = 0, solve or skip each question
    - qi -> pi, but unable to solve bi question
    - skip qi -> decision to nxt qi
        - [[3, 2], [4, 3], [4, 4], [2, 5]]
        - q0 -> p = 3 but unable resolve 2 questions after because bi = 2
    - ret max points u can earn for exam
    Solution
        - return max point can ear = Fn(State) i index of questions
        - recursive Formula: F(i) = Max(F(j)) + q[i][0] / j = 0  to i, q[j][1] == i - j + 1 
        - base case: i = 0 F(i) = q[i][0]
 */