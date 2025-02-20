class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int left = 0, right = 1;
        int n = nums.length;
        if (n == 1) return 1;
        int ans = 1;

        while (right < n) {
            if (nums[right - 1] >= nums[right])
                left = right;
            ans = ans > right - left + 1 ? ans : right - left + 1;
            right++;
        }
        return (ans);
    }
}