class Solution {
    int n;
    int[] dp;
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return (helper(0));
    }

    public int helper(int i) {
        if (i >= n)
            return (0);
        if (dp[i] != -1)
            return (dp[i]);
        dp[i] = Math.max(nums[i] + helper(i + 2), helper(i + 1));
        return (dp[i]);
    }
}