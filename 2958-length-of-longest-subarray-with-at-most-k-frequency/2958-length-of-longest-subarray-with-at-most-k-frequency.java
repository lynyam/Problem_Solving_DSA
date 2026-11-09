class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int left, right, n, result;
        n = nums.length;
        left = right = 0;
        result = 0;

        while (right < n) {
            int curr = counts.getOrDefault(nums[right], 0);
            counts.put(nums[right], curr + 1);
            while (counts.get(nums[right]) > k) {
                counts.put(nums[left], counts.get(nums[left]) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return (result);
    }
}