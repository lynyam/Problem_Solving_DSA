class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return (mid);
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (-1);
    }
}
/**
    - nums in[] sorted acending
    - target int
    - search taget in nums
    - id exist ret index | -1
 */