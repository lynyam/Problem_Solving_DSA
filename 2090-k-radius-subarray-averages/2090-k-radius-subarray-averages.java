class Solution {
	public int[] getAverages (int[] nums, int k) {
		if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
		if (k == 0) return Arrays.copyOf(nums, n);
		long[] prefixSum = new long[n];
		prefixSum[0] = nums[0];
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if (2 * k + 1 > n) return (result);
                for (int i = 1; i < n; i++) {
                    prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
//[7 11 14 23 24 32 37 39 45]
        for (int j = k; j + k < n; j++) {
                result[j] = (int)((prefixSum[j + k] - prefixSum[j - k] + nums[j - k]) / (2 * k + 1));
        }
        return (result);
    }
}
