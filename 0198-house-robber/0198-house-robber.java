class Solution {
    int[] dp;
    int[] nums;
    public int rob(int[] nums) {
        int length = nums.length;
        dp = new int[length];
        this.nums = nums;
        Arrays.fill(dp, -1);
        return (helper(0));
    }

    public  int helper(int house) {
        if (house >= nums.length)
            return (0);
        if (dp[house] != -1)
            return (dp[house]);
        dp[house] = Math.max(nums[house] + helper(house + 2), helper(house + 1));
        return (dp[house]);
    }
}