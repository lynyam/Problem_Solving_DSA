class Solution {
    int[] dp;
    int[] nums;
    int ans;
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        ans = 1;
        dp = new int[length];
        this.nums = nums;
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(length - 1);
        return (ans);
    }

    public int helper(int index) {
        if (index >= nums.length)
            return (0);
        if (dp[index] != -1)
            return (dp[index]);
        int longuest = 1;
        int i = 0;
        while (i < index) {
            int curr = helper(i);
            if (nums[i] < nums[index])
                longuest = Math.max(longuest, curr + 1);
            ans = Math.max(ans, longuest);
            i++;
        }
        dp[index] = longuest;
        return longuest;
    }
}