class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int prefix = nums[0];
        int i = 1;
        ans = nums[0] < 0 ? -1 * nums[0] : 0;

        while (i < nums.length) {
            prefix += nums[i];
            ans = prefix < 0 ? Math.max(ans, -1 * prefix) : ans;
            i++;
        }
        return (ans + 1);
    }
}