class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0;
        int i = 0;
        final int SIZE = 2 * k;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int j = 0;
        while (i < n) {
            prefix += nums[i];
            if (i >= SIZE) {
                result[k] = (int)(prefix / (SIZE + 1));
                prefix -= nums[j];
                k++;
                j++;
            }
            i++;
        }
        return (result);
    }
}