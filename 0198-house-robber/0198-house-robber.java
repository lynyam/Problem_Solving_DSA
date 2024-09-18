class Solution {
    HashMap<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        if (nums.length == 0)
            return (0);
        return (dp(nums.length - 1, nums));
    }

    public int dp(int i, int[] nums) {
        if (i == 0)
            return (nums[0]);
        if (i == 1)
            return (Math.max(nums[0], nums[1]));
        if (memo.containsKey(i))
            return (memo.get(i));
        memo.put(i, Math.max(dp(i - 1, nums), dp(i - 2, nums) + nums[i]));
        return (memo.get(i));
    }
}
/**
    - two adj houses were broken into on the same night
    - nums[i] amount of money of each house
    - ret max amount of money you can ron tonight without aleting police

    Solution
    - return max amount of money Fn(State) state = i [0, n-1] house
    - Function : Fn(n) = max(F(n-1), F(n-2) + nums[n])
    - base case: F(0) = nums[0], F(1) = max(nums[0], nums[1])
 */