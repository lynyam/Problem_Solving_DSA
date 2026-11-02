class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int right, left;
        right = left = 0;

        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}