class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return (0);
        int product = 1;
        int left, right, n, result;
        left = right = n = result = 0;
        n = nums.length;

        while (right < n) {
            product *= nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            result += (right - left + 1);
            right++;
        }
        return result;
    }
}