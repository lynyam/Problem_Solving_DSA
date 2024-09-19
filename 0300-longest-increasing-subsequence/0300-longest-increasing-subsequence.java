class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int i = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;

        while (i < n) {
            int j = 0;
            int ans = 1;
            while (j < i) {
                if (nums[j] < nums[i]) {
                    ans = Math.max(ans, dp[j] + 1);
                }
                j++;
            }
            dp[i] = ans;
            res = Math.max(res, ans);
            i++;
        }
        return (res);
    }
}

/**class Solution {
    HashMap<Integer, Integer> memo;
    public int lengthOfLIS(int[] nums) {//0(n2)t 0(n)
        memo = new HashMap<>();
        int i = 0;
        int n = nums.length;
        int ans = 1;

        while (i < n) {
            ans = Math.max(ans, dp(i, nums));
            i++;
        }
        return (ans);
    }

    public int dp(int i, int[] nums) {
        if (memo.containsKey(i))
            return (memo.get(i));
        int ans = 1;
        int j = 0;
        while (j < i) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, dp(j, nums) + 1);
            }
            j++;
        }
        memo.put(i, ans);
        return (memo.get(i));
    }
}*/
/**
    - nums int[]
    - ret length of LIS
    Solution
    - return len of LIS Fn(State) index i
    - recurence formula: Fn(i) = Max(F(j) + 1) / j in [0 i[ and nums[j] < nums[i]
    - base case: i = 0 => 1
 */