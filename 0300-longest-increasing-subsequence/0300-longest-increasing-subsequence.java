class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return (0);
        int[] dp = new int[n];
        int i = 1;
        dp[0] = 1;
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