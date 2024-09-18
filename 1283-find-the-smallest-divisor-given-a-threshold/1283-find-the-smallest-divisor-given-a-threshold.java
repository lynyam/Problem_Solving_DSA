class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left  = 1;
        int right = 1;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, threshold))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] nums, int thrf) {
        double sum = 0.0;
        for (int num : nums) {
            sum += Math.ceil(num / (double)mid);
        }
        return (sum <= thrf);
    }
}
/**
    -nums int[] , int thresold
    - choose divisor divise all nums[i] and sum
    - find smallest divisor / result  < thresold
    -7 / 3 = 3
    - left  = 1
    - right = max
    - check(mid) {
        sum = 0
        for (nu:nums)
            sum += Math.ceil(nu / (double)mid)

        sum <= thresoltr
    } 
 */