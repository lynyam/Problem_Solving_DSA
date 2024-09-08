class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int  left = 1;
        int right = 1;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, threshold))
                right = mid;
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int div, int[] nums, int th) {
        long sum = 0;
        for (int num : nums) {
            sum += (long)Math.ceil(num / (double)div);
        }
        return (sum <= th);
    }
}
/**
    - nums[] int[], th int, div >0
    - sum += nums[i] / div
    - find div / sum <= threshold
    7 / 3 = 2,..=> 3
    - div exist x sum = n1+n2+..+n/x
        - if x > sum <
        - sum > th down sum up x => left = mid - 1
        - sum <= th right = mid
    ret left
 */