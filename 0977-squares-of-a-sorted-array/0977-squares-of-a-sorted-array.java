class Solution {
    public int[] sortedSquares(int[] nums) {
        int left, right, n;
        left = 0;
        n = nums.length;
        right = n - 1;
        int[] result = new int[n];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[n - 1] = nums[left] * nums[left];
                left++;
            } else {
                result[n - 1] = nums[right] * nums[right];
                right--;
            }
            n--;
        }
        return (result);
    }
}
/*
- n = nums length
    nums -> [sortedSquares] -> result: num square
    - create temp array  0(n) space
    - add square of all num: nums -> temp 0(n) time 0(1) space
    - sort temp -> 0(nlogn) time 
    
    => 0(n) space 0(n(logn + 1)) = 0(nlogn) time
    
    sol2:
    - create temp array  0(n) space
    - find index of min => 0 and index of max => n-1
    - compare square of min and max
        - write the best and increment/decrement its index
    
*/