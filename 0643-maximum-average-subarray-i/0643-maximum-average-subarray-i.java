class Solution {
	public double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
        int i = 0;
        double sum = 0;
        if (k > n || k <= 0)
            return (0.0);
        while (i < k) {
            sum += nums[i];
            i++;
        }
        double result = sum;
        while (i < n) {
            sum += (nums[i] - nums[i - k]);
            result = Math.max(result,  sum);
            i++;
        }
        return (result / k);
    }
}
