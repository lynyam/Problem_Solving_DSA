class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return (0);
        if (n == 1) return (nums[0]);
        if (n == 2) return (Math.max(nums[0], nums[1]));
        if (n == 3) return (Math.max(nums[0], Math.max(nums[1], nums[2])));
        return (Math.max(helper(2, n - 1, Math.max(nums[0], nums[1]), nums[0], nums), 
                            helper(3, n, Math.max(nums[1], nums[2]), nums[1], nums)));
    }

    public int helper(int i, int n, int one, int two, int[] nums) {
        while (i < n) {
                int temp = one;
                one = Math.max(one, two + nums[i]);
                two = temp;
                i++;
            }
        return (one);
    }
}