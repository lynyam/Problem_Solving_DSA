class Solution {
    public int waysToSplitArray(int[] nums) {
        //valid split index i
        /*
        - sum[0..i+1] >= sum[n-(i+1)]
        - 0 <= i <n-1
        - return number of valid splits
        */
        int n = nums.length;
        if (n <= 0) return (0);
        int i = 1;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        while (i < n) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            i++;
        }

        int result = 0;
        i = 0;
        while (i < n - 1) {
            if (2 * prefixSum[i] >= prefixSum[n-1]) result++;
            i++;
        }
        return (result);
    }
}