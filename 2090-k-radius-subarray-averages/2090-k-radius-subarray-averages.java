class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long prefix = 0;
        int i = 0;

        if (2 * k + 1 > n) return (ans);

        while (i < 2 * k + 1) {
            prefix += nums[i];
            i++;
        }
        int j = k + 1;
        ans[k] = (int)(prefix / (2 * k + 1));
        while (i < n) {
            prefix += nums[i] - nums[i - 2 * k - 1];
            ans[j] = (int)(prefix / (2 * k + 1));
            i++;
            j++;
        }
        return (ans);
    }
}