class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        int[] dp = new int[n];
        int res = 0;
        //dp[n - 1] = 1;

        while (i >= 0) {
            int ans = 1;
            int j = i + 1;
            while (j < n) {
                if (nums[i] < nums[j])
                    ans = Math.max(ans, 1 + dp[j]);
                j++;
            }
            dp[i] = ans;
            res = Math.max(res, dp[i]);
            i--;
        }
        return (res);
    }
}