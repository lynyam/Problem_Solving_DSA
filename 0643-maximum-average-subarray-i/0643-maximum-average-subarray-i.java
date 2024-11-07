class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double average = 0.0;
        double ans = 0.0;
        int i = 0;
        int n = nums.length;

        while (i < k) {
            average += nums[i++];
        }
        ans = average;
        while (i < n) {
            average += (nums[i] - nums[i - k]);
            ans = Math.max(ans, average);
            i++;
        }
        return (ans / k);
    }
}