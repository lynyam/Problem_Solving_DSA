class Solution {
    public int longestOnes(int[] nums, int k) {
        // 1 1 1 0 1 0 0   2
        int right = 0;
        int left = 0;
        int n = nums.length;
        int ans = 0;
        int curr = 0;

        while (right < n) {
            curr += nums[right] == 0 ? 1 : 0;//c = 3
            while (curr > k) {
                curr -= nums[left++] == 0 ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);// ans=6
            right++;
        }
        return (ans);
    }
}