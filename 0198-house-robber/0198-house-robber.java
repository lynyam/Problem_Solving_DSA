class Solution {
    public int rob(int[] nums) {
//create an array to store result for each step
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return (helper(n - 1, nums, memo));
    }

    public int helper(int index, int[] nums, int[] memo) {
        if (index < 0) return (0);
        if (index == 0) return (nums[0]);
        if (memo[index] != -1) return (memo[index]);
        
        memo[index] = Math.max(nums[index] + helper(index - 2, nums, memo), helper(index - 1, nums, memo));
        return (memo[index]);
    }

}