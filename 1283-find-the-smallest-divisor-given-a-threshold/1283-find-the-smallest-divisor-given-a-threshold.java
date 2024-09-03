class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            right = Math.max(right, nums[i]);
            i++;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, threshold)) {
                left = mid + 1;
            }
            else
                right = mid;
        }
        return (left);
    }

    public boolean check(int mid, int[] nums, int threshold) {
        long sum = 0;
        for (int num : nums) {
            sum += (num % mid == 0 ? num / mid : (num / mid) + 1);
        }
        return (sum > threshold); //6 > 6
    }
}
/**
    - nums, th, sum += nums[i] / div
    - smallest divisor <= th
    - 7/3 = 3 10/2=5
    -  mid grand > res proche de thresolt
        - check > res => left = mid + 1
 */