class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, threshold)) {
                right = mid;
            }
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] nums, int th) {
        int sum = 0;
        for (int num : nums) {
            sum += (int)Math.ceil(num / (double)mid);
        }
        return (sum <= th);
    }
}
/**
    - nums[] . int th
    - int div > 0 do sum += nums[i++] / div 
    - find a small divisor / res <= th
    - rounded division
 */