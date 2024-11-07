class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int i = 1;
        prefix[0] = nums[0];

        while (i < n) {
            prefix[i] = prefix[i - 1] + nums[i];
            i++;
        }
        return (prefix);
    }
}