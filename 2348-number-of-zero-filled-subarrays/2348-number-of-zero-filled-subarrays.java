class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        long result = 0;
        while (right < n) {
            if (nums[right] != 0) {
                while (left <= right) {
                    left++;
                }
            } 
            result += right - left + 1;
            right++;
        }
        return (result);
    }
}