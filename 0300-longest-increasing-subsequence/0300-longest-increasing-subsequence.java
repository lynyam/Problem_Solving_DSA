class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int i = 1;
        int res = 1;
        int n = nums.length;

        Arrays.fill(dp, 1);
        while (i < n) {
            int j = 0;
            int ans = 1;
            while (j < i) {
                if (nums[j] < nums[i]) {
                    ans = Math.max(ans, dp[j] + 1);
                }
                dp[i] = ans;
                res = Math.max(res, dp[i]);
                j++;
            }
            i++;
        }
        return (res);
    }
}

/**
Solution Top-down
class Solution {
    HashMap<Integer, Integer> memo;
    public int lengthOfLIS(int[] nums) {
        memo = new HashMap<>();
        int ans = 1;
        int i = 0;
        while (i < nums.length) {
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
        return (ans);
    }
}*/
/**
    - nums int[] 
    - ret length of longest strictly increasing subssequence

    Solution DP
        - return longest sub Fn(state) => state = i in [0, n[
        - recurtion formula: Fn(n) = Fn(n-1)
 */