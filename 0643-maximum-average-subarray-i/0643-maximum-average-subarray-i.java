class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int left, right;
        left = right = 0;
        double result = 0;
        
        while (right < k) {
            sum += nums[right];
            right++;
        }
        result = sum;
        while (right < nums.length) {
            sum += (nums[right] - nums[left]);
            right++;
            left++;
            result = Math.max(result, sum);
        }
        return (result / k);
    }
}