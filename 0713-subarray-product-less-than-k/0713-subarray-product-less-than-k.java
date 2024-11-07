class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        long prod = 1;

        if (k <= 1)
            return (0);
        while (right < n) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
            right++;
        }
        return (ans);
    }
}