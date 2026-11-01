class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];

        int i = 1;
        while (i < n) {
            result[i] = result[i - 1] + nums[i];
            i++;
        }
        return (result);
    }
}