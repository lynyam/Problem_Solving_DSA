class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, k)) {
                right = mid;
            }
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] nums, int k) {
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                count++;
            }
        }
        return (count + 1 <= k);
    }
}
/**
    - nums[], int k
    - split in  k num-empty subarray
    - largest sum of any sub is minimised
    - ret minized largest sum

    = => right = mid
 */