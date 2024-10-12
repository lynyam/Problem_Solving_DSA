class Solution {
    //int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        int one, two;
        one = two = 0;
        if (n == 0) return (0);
        int i = 0;
        while (i < n) {
            if (i == 0)
                one = two = nums[0];
            else if (i == 1)
                one = Math.max(nums[0], nums[1]);
            else {
                int temp = one;
                one = Math.max(nums[i] + two, one);
                two = temp;
            }
            i++;
        }
        return (one);
        /*
        memo = new int[n];
        Arrays.fill(memo, -1);
        return (dp(n - 1, nums));*/
    }

    /*public int dp(int i, int[] nums) {
        if (i == 0) return nums[0];
        if (i == 1) return (Math.max(nums[0], nums[1]));
        if (memo[i] != -1) return (memo[i]);
        memo[i] = Math.max(dp(i - 1, nums), dp(i - 2, nums) + nums[i]);
        return (memo[i]);
    }*/
}