class Solution {
    public int longestOnes(int[] nums, int k) {
        int left, right, n, ans;
        left = right = 0;
        int curr = 0;
        n = nums.length;
        ans = 0;
        while (right < n) {
            if (nums[right] == 0)
                curr++;
            while (curr > k) {
                if (nums[left] == 0)
                    curr--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}