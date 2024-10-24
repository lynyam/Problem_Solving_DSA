class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return (0);
        int n = nums.length;
        int i = 1;
        int max = nums[0];
        int min = nums[0];
        int result = max;

        while (i < n) {
            int temp = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = temp;
            result = Math.max(result, max);
            i++;
        }
        return (result);
    }
}