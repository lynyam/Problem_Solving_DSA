class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
		int max = Integer.MIN_VALUE;
		if (n <= 1)
			return (0);
		Arrays.sort(nums);
		int i = 0;
		while (i < n - 1) {
			max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
			i++;
		}
        return (max);

    }
}