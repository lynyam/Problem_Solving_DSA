class Solution {
    int[] dp;
    int[] nums;
    int ans;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n];
        ans = 1;
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(n - 1);
        return (ans);
    }

    public int helper(int i) {
        if (i >= nums.length)
            return (0);
        if (dp[i] != -1)
            return (dp[i]);
        int curr = 1;
        int j  = 0;
        while (j < i) {
            int prev = helper(j);
            curr = Math.max(curr, nums[j] < nums[i] ? prev + 1 : 1);
            j++;
        }
        dp[i] = curr;
        ans = Math.max(ans, curr);
        return (curr);
    }
}