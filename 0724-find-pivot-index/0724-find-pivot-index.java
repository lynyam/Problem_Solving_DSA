class Solution {
    public int pivotIndex(int[] nums) {
        int lSum = 0;
        int i = 0;
        int ans = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        while (i < nums.length) {
            if (sum - lSum - nums[i] == lSum)
                return (i);
            lSum += nums[i];
            i++;
        }
        return (-1);
    }
}