class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int k = n - 1;
        int[] ans = new int[n];

        while (i <= j) {
            int right = nums[j] * nums[j];
            int left = nums[i] * nums[i];
            if (left >= right) {
                ans[k--] = left;
                i++;
            }
            else {
                ans[k--] = right;
                j--;
            }
        }
        return (ans);
    }
}