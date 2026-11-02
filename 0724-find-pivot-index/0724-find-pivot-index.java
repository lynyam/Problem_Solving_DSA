class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curr = 0;
        int i = 0;
        while (i < nums.length) {
            if (curr == sum - curr - nums[i]) {
                return (i);
            }
            curr += nums[i];
            i++;
        }
        return (-1);
    }
}